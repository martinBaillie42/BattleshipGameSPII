package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 02/02/13
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
public interface Ocean {
    void placeAllShipsRandomly();

    boolean isOccupied(int row, int column);

    boolean shootAt(int row, int column);

    int getUPPER();

    int getShotsFired();

    int getHitCount();

    int getShipsSunk();

    boolean isGameOver();

    Ship[][] getShipArray();

    @Override
    String toString();
}
