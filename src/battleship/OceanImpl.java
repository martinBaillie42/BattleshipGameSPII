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

    public OceanImpl(){

    }

    @Override
    public void placeAllShipsRandomly() {

    }

    @Override
    public boolean isOccupied(int row, int column) {

    }

    @Override
    public boolean shootAt(int row, int column) {

    }

    @Override
    public int getShotsFired() {
        return shotsFired;
    }

    @Override
    public int getHitCount() {
        return hitCount;
    }

    @Override
    public int getShipsSunk() {
        return shipsSunk;
    }

    @Override
    public boolean isGameOver() {

    }

    @Override
    public Ship[][] getShipArray() {
        return ships;
    }

    @Override
    public String toString() {

    }
}
