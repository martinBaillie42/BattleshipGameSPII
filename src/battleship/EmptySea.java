package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public interface EmptySea extends Ship{

    boolean isSunk();

    @Override
    String toString(int row, int column);
}
