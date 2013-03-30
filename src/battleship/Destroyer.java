package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public interface Destroyer extends Ship{
    String getShipType();

    @Override
    String toString(int row, int column);
}
