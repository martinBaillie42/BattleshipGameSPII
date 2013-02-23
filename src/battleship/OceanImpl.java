package battleship;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
public class OceanImpl implements Ocean {

    private static final int UPPER;
    private final Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    static {
        UPPER = 10;
    }

    /**
     *
     */
    public OceanImpl(){
        ships = new ShipImpl[UPPER][UPPER];

        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                ships[i][j] = new EmptySeaImpl();
            }
        }

        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
    }

    /**
     *
     */
    @Override
    public void placeAllShipsRandomly() {

        Random r = new Random();

        Ship[] fleet = new Ship[UPPER];

        final int NO_OF_SHIP_TYPES = 4;

        fleet[0] = new SubmarineImpl();
        fleet[1] = new DestroyerImpl();
        fleet[2] = new CruiserImpl();
        fleet[3] = new BattleshipImpl();

        for (int i = 4; i < UPPER; i++){ // move to setNO_OF_SHIP_TYPES or woteva?
            int shipNo = r.nextInt(NO_OF_SHIP_TYPES);
            if (shipNo == 0){
                fleet[i] = new BattleshipImpl();
            } else if (shipNo == 1) {
                fleet[i] = new CruiserImpl();
            } else if (shipNo == 2) {
                fleet[i] = new DestroyerImpl();
            } else {
                fleet[i] = new SubmarineImpl();
            }
        }

        // constrain fleet to at least one of each type
        // order fleet in size order (Battleship first)


        int row;
        int column;
        boolean horizontal;

        for (Ship ship : fleet) {
            do {
                row = r.nextInt(UPPER);
                column = r.nextInt(UPPER);
                horizontal = r.nextInt(2) == 1;

            } while (!ship.okToPlaceShipAt(row, column, horizontal, this));
            ship.placeShipAt(row, column, horizontal, this);
        }
    }

    /**
     *
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean isOccupied(int row, int column) {
        try {
            return !(ships[row][column] instanceof EmptySea);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     *
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean shootAt(int row, int column) {
        return false;
    }

    public int getUPPER(){
        return UPPER;
    }
    /**
     *
     * @return
     */
    @Override
    public int getShotsFired() {
        return shotsFired;
    }

    /**
     *
     * @return
     */
    @Override
    public int getHitCount() {
        return hitCount;
    }

    /**
     *
     * @return
     */
    @Override
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isGameOver() {
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public Ship[][] getShipArray() {
        return ships;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        final String SPACE = " ";
        StringBuilder buffer = new StringBuilder();

        buffer.append(" ");
        for (int i = 0; i < ships[0].length; i++) {
            buffer.append(SPACE);
            buffer.append(i);
        }
        buffer.append("\n");

        for (int i = 0; i < ships.length; i++) {
            buffer.append(i);
            for (int j = 0; j < ships[0].length; j++) {
                buffer.append(SPACE);
                buffer.append(ships[i][j]);
            }
            buffer.append("\n");
        }

        return buffer.toString();
    }
}
