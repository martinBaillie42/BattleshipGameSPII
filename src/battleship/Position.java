package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public interface Position {

    /**
     * Get the x-coordinate
     * @return the x-coordinate
     */
    int getColumn();

    /**
     * Get the y-coordinate
     * @return the y-coordinate
     */
    int getRow();

    /**
     * Set the x-coordinate
     * @param column the x-coordinate
     */
    void setColumn(int column);

    /**
     * Set the y-coordinate
     * @param row the y-coordinate
     */
    void setRow(int row);
}
