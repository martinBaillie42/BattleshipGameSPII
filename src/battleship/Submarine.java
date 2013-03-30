package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public interface Submarine extends Ship{
    String getShipType();

    @Override
    String toString(int row, int column);
}
