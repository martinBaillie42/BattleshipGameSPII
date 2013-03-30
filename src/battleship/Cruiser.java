package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public interface Cruiser extends Ship{
    String getShipType();

    @Override
    String toString(int row, int column);
}
