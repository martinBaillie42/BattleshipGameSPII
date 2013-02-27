package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 02/02/13
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
public interface Destroyer extends Ship{
    String getShipType();

    @Override
    String toString(int row, int column);
}
