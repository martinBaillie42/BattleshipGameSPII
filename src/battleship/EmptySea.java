package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public interface EmptySea extends Ship{

    /**
     * Checks if a part of this <code>EmptySea</code> occupies the given row and column. If it does this <code>EmptySea</code>
     * has not already been hit it updates the hit array for that section to <code>true</code> and returns
     * <code>false</code>.
     *
     * @param row       the y-coordinate of the shot
     * @param column    the x-coordinate of the shot
     * @return          <code>false</code>
     */
    boolean shootAt(int row, int column);

    /**
     * Always returns false - an <code>EmptySea</code> cannot be sunk.
     * @return <code>false</code>
     */
    boolean isSunk();

    /**
     * Checks the given coordinate to see if this has been fired at.
     *
     * @param row       the vertical coordinate provided by the <code>Ocean</code> class
     * @param column    the horizontal coordinate provided by the <code>Ocean</code> class
     * @return          a '-' if this <code>EmptySea</code> has been fired at;
     *                  a '.' if this <code>EmptySea</code> has not been fired at.
     */
    @Override
    String toString(int row, int column);
}
