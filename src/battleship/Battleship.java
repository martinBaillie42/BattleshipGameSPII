package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 02/02/13
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
public interface Battleship extends Ship {
    String getShipType();

    @Override
    String toString();
}
