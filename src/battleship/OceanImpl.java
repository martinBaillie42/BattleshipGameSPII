package battleship;

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

    {
        ships = new ShipImpl[UPPER][UPPER];
    }

    /**
     *
     */
    public OceanImpl(){

    }

    /**
     *
     */
    @Override
    public void placeAllShipsRandomly() {

    }

    /**
     *
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean isOccupied(int row, int column) {
        return true;
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
        return false;
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
        return "";
    }
}
