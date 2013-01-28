package battlehelptwo;

import java.util.Random;

/**
 * @author keith
 */
public class OceanImpl implements Ocean {

    private static final int TEN;
    /**
     * Used to quickly determine which ship is in any given location.
     */
    private Ship[][] ships;
    /**
     * The total number of shots fired by the user.
     */
    private int shotsFired;
    /**
     * The number of times a shot hit a ship.
     * If the user shoots the same part of a ship more than once,
     * every hit is counted, even though the additional "hits"
     * don't do the user any good.
     */
    private int hitCount;
    /**
     * The number of ships sunk (10 ships in all).
     */
    private int shipsSunk;

    static {
        TEN = 10;
    }

    {
        ships = new ShipImpl[TEN][TEN];
    }


    /**
     * Creates an "empty" ocean (fills the ships array with EmptySeas).
     * Also initialises any game variables, such as how many shots have been fired.
     */
    public OceanImpl() {
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[0].length; j++) {
                ships[i][j] = new EmptySeaImpl();
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int getHitCount() {
        return hitCount;
    }

    @Override
    public int getShipsSunk() {
        return shipsSunk;
    }

    @Override
    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * Place all ten ships randomly on the (initially empty) ocean.
     * Place larger ships before smaller ones, or you may end up with
     * no legal place to put a large ship.
     * You will want to use the Random class in the java.util package,
     * so look that up in the Java API.
     */
    @Override
    public void placeAllShipsRandomly() {
        // This is ugly - anyway to improve this?
        Ship[] fleet = new Ship[3]; // this will be 10
        fleet[0] = new BattleShipImpl();
        fleet[1] = new CruiserImpl();
        fleet[2] = new CruiserImpl();
        // etc.

        // the array happens to be sorted by size - what if it wasn't
        // can we sort on size?

        Random m = new Random();
        int x, y;
        boolean b;
        for (Ship s : fleet) {
            do {
                x = m.nextInt(10);
                y = m.nextInt(10);
                b = m.nextInt(2) == 1; // 1 is true; 0 is false;
                System.out.println("x = " + x + " y = " + y + " horizontal = " + b);
            } while (!s.okToPlaceShipAt(x, y, b, this));
            // what if we never find a position for the ship?
            // if we've got this far then it is safe to place the ship
            s.placeShipAt(x, y, b, this);
        }
    }

    /**
     *
     * @return true if all ships have been sunk, otherwise false.
     */
    @Override
    public boolean isGameOver() {
        return false; // TODO
    }

    /**
     * Prints the ocean.
     * To aid the user, row numbers should be displayed along the left edge
     * of the array, and column numbers should be displayed along the top.
     * Numbers should be 0 to 9, not 1 to 10.
     * The top left corner square should be 0, 0.
     * Use 'S' to indicate a location that you have fired upon and hit a (real)
     * ship, '-' to indicate a location that you have fired upon and found
     * nothing there, 'x' to indication location containing a sunken ship,
     * and '.' to indicate a location that you have never fired upon.
     */
    @Override
    public void print() {
        final String SPACES = "  ";

        System.out.print(" ");
        for (int i = 0; i < ships[0].length; i++) {
            System.out.print(SPACES + i);
        }
        System.out.println();

        for (int i = 0; i < ships.length; i++) {
            System.out.print(i);
            for (int j = 0; j < ships[0].length; j++) {
                System.out.print(SPACES + ships[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * @param row
     * @param column
     * @return true if the given location contains a ship, false if it does not.
     */
    @Override
    public boolean isOccupied(int row, int column) {
        return !ships[row][column].getShipType().equals("sea");
    }

    /**
     * The methods in the Ship class that take an Ocean parameter really need
     * to be able to look at the contents of this array; the placeShipAt
     * method even needs to modify it.
     * While it is undesirable to allow methods in one class to directly
     * access instance variables in another class, sometimes there is just no good alternative.
     * // should the above be a javadoc comment or an internal comment?
     * @return the 10x10 array of ships
     */
    @Override
    public Ship[][] getShipArray() {
        return ships;
    }

    @Override
    public boolean shootAt(int row, int column){
        return false;
    }
}
