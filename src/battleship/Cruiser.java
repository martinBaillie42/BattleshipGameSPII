package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 02/02/13
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 */
public interface Cruiser extends Ship{
    String getShipType();

    @Override
    String toString();
}
