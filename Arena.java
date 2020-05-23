import java.util.ArrayList;

/**
 * @brief This class holds the game play arena for all of the game entities.  It exposes
 * methods for adding entities, moving the hero, and for retrieving the status of entities
 * it contains.
 *
 * @author Benjamin Taylor A02021288
 */
public class Arena {
    // These are left private because only Arena will need to use them
    private ArrayList<Entity[]> grid;
    private Hero hero = null;
    private int heroCount; // will control how many heros can be created within an arena object

    /**
     * Uses a for loop to dynamically add new Entity array objects to each row, or y. It also initializes herocount to 0
     * @param sizeX the width of the grid
     * @param sizeY the height of the grid
     */
    public Arena(int sizeX, int sizeY) {
        grid = new ArrayList<Entity[]>();
        for (int i = 0; i < sizeY; i++) {
            grid.add(new Entity[sizeX]);
        }

        heroCount = 0;
    }

    /**
     *
     * @return the ArrayList grid made with the sent dimensions
     */
    public ArrayList<Entity[]> getGrid() {
            return this.grid;
        }

    /**
     * @brief Used to add a new entity to the arena.  The entity is stored at the location indicated
     * by the entity position.  If an entity is already in that position, the new one isn't added and
     * false is returned to indicate this.  When the hero is added, the reference to the hero (on the class)
     * is set at that time, in addition being added to the arena.
     */
    public boolean add(Entity e) {
        // Makes for simplifying so only a single letter needs used for indexes
        int x = e.position.x;
        int y = e.position.y;
        // Grabs the row
        Entity[] row = grid.get(y);
        // Finds out if that spot on the grid is taken and adds it if not
        if(row[x] == null) {
            // If it is a Hero object and no other heros have been added it assigns the hero reference to it, then
            // assigns that grid spot to it, prints a message and returns true
            if (e instanceof Hero && heroCount < 1) {
                hero = (Hero)e;
                heroCount++;
                row[x] = e;
                System.out.printf("Successfully added '%s' to the game arena\n", e.toString());
                return true;
            }
            // If there was already a hero object sent then it returns false and prints a message to the console
            else if(e instanceof Hero && heroCount > 0){
                System.out.printf("Could not add '%s' because there is already a hero in the arena.\n", e.toString());
                return false;
            }
            // This adds the object to the grid if it is any other object that isn't Hero and prints a succesful message
            row[x] = e;
            System.out.printf("Successfully added '%s' to the game arena\n", e.toString());
            return true;
        }
        // Prevents from object being put on a grid spot that already has an object
        else {
            System.out.printf("Could not add '%s' because another entity is already there.\n", e.toString());
            return false;
        }
    }

    /**
     * This takes an x and y coordinate and moves the hero to that spot and makes sure the former position of the hero is
     * made null. If there is an object at the new position it attacks and replaces that object with the hero
     *
     * @param x desired x grid coordinate
     * @param y desired y grid coordinate
     */
    public void moveHero(int x, int y) {
        // only allows hero movement if it isn't null
        if (hero != null) {
            // creates x and y so that the former position can be placed to null
            int formerX = hero.position.x;
            int formerY = hero.position.y;
            //Sets the hero's new position
            hero.position.x = x;
            hero.position.y = y;
            // Finds the new row the hero will move to and checks whether anything is there, if not it sets it to hero
            // if there is it attacks, takes the treasure if any, and then sets the position to hero
            Entity[] row = grid.get(y);
            if (row[x] == null) {
                row[x] = hero;
            }
            else {
                hero.attack(row[x]);
                row[x] = hero;
            }
            // Sets the hero's last spot to null and then prints a movement message to the console
            Entity[] rowFormer = grid.get(formerY);
            rowFormer[formerX] = null;
            System.out.printf("%s moved to (%d, %d)\n", hero.getName(), x, y);
        }
    }

    /**
     * Calls the hero's report method which is used in the driver
     */
    public void reportHero() {
        this.hero.report();
    }

    /**
     * @brief Public methods exposed primarily for unit testing purposes, but these could
     * reasonably be expected in a "real" application.
     */
    public Hero getHero() {
        return this.hero;
    }

    /**
     * @brief This counts how many entity objects are in the grid by going through each row and then each column to check
     * whether an Entity object is contained that isn't null
     *
     * @return the count of how many entities are in the grid
     */
    public int getEntityCount() {
        // Counter
        int entityCount = 0;
        // For loop and then a nested foreach loop to go through every element of the grid
        for (int i = 0; i < grid.size(); i++) {
            Entity[] rowY = grid.get(i);

            for (Entity x : rowY) {
                if(x != null) {
                    entityCount++;
                }
            }
        }

        return entityCount;
    }

    /**
     * @brief This counts how many dragon objects are in the grid by going through each row and then each column to check
     * whether the entity object contained is a dragon object and then adds if so
     *
     * @return the count of how many dragons are in the grid
     */
    public int getDragonCount() {
        // counter
        int dragonCount = 0;
        // Nested for and foreach loop to go through each element and then check if the object is an instance of Dragon
        for (int i = 0; i < grid.size(); i++) {
            Entity[] rowY = grid.get(i);

            for (Entity y : rowY) {
                if(y instanceof Dragon) {
                    dragonCount++;
                }
            }
        }
        return dragonCount;
    }

    /**
     * @brief This counts how many crate objects are in the grid by going through each row and then each column to check
     * whether an Entity object contains a crate and then adds one because all crates have treasures
     *
     * @return the count of how many crates (or treasures contained in crates) are in the grid
     */
    public int getTreasureCount(Treasure type) {
        // counter
        int treasureCount = 0;
        // Nested loops to go thru each element
        for (int i = 0; i < grid.size(); i++) {
            Entity[] rowY = grid.get(i);

            for (Entity y : rowY) {
                if((y instanceof Crate) && (y.getTreasure() == type)) {
                    treasureCount++;
                }
            }
        }
        return treasureCount;
    }

}
