package battleship;

import java.util.Arrays;
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

        // constrain fleet to at least one of each type

        fleet[0] = new BattleshipImpl();
        fleet[1] = new CruiserImpl();
        fleet[2] = new DestroyerImpl();
        fleet[3] = new SubmarineImpl();

        final int NO_OF_SHIP_TYPES = 4;
        final int MAX_BATTLESHIPS = 2;
        final int MAX_CRUISERS = 3;
        final int MAX_DESTROYERS= 4;
        final int MAX_SUBMARINES = 5;

        int count = 4;
        int countBattleships = 1;
        int countCruiser = 1;
        int countDestroyer = 1;
        int countSubmarine = 1;

//        TODO requires random seed
//        randomly select fleet
        do {
            int shipNo = r.nextInt(NO_OF_SHIP_TYPES);
            if (shipNo == 0 && countBattleships < MAX_BATTLESHIPS) {
                fleet[count] = new BattleshipImpl();
                count++;
                countBattleships++;
            }
            if (shipNo == 1 && countCruiser < MAX_CRUISERS) {
                fleet[count] = new CruiserImpl();
                count++;
                countCruiser++;
            }
            if (shipNo == 2 && countDestroyer < MAX_DESTROYERS) {
                fleet[count] = new DestroyerImpl();
                count++;
                countDestroyer++;
            }
            if (shipNo == 3 && countSubmarine < MAX_SUBMARINES) {
                fleet[count] = new SubmarineImpl();
                count++;
                countSubmarine++;
            }
        } while(count < UPPER);

        // order fleet battleship to submarine
/*        TODO to avoid any nasty inheritance issues I could pass the fleet
        array into a 'spare' class that inherits - no that wouldn't work, it works on object level. Bum */
        Arrays.sort(fleet);

        int row;
        int column;
        boolean horizontal;
        // TODO more random seeding here?
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
        // increment the number of shots fired regardless of result
        // use of accessor so that internal representation can change without effecting usage
        // (accessor taken out for the moment (set))
        // TODO add accessors to all parts that make changes to class level variables
        shotsFired = getShotsFired() + 1;

        // check for a ship
        if (isOccupied(row, column)) {  // okay - this is a ship
            // get the ship

            if(isShipSunk(row,column)) {
                return false;
            }

            if (ships[row][column].shootAt(row, column)) {
                hitCount = getHitCount() + 1; // accessor taken out (set)
                if(ships[row][column].isSunk()){
                    shipsSunk = getShipsSunk() + 1;
                }
                return true;
            } else {
                return false;
            }

        } else {
            ships[row][column].shootAt(row, column);
            return false;
        }

    }

    @Override
    public boolean isShipSunk(int row, int column) {
        return ships[row][column].isSunk();
    }


    @Override
    public String nameOfShip(int row, int column) {
        return ships[row][column].getShipType();
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
        return getShipsSunk() == getUPPER();
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
                buffer.append(ships[i][j].toString(i,j));
            }
            buffer.append("\n");
        }

        return buffer.toString();
    }
}
