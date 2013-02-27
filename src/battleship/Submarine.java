package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 02/02/13
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public interface Submarine extends Ship{
    String getShipType();

    @Override
    String toString(int row, int column);
}
