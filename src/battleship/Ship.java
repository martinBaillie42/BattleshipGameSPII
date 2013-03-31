package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public interface Ship extends Comparable<Ship> {

    /**
     * Gets the position of this ships bow in the vertical axis.
     *
     * @return the y-coordinate location of this ships bow
     */
    int getBowRow();

    /**
     * Gets the position of this ships bow in the horizontal axis.
     *
     * @return the x-coordinate location of this ships bow
     */
    int getBowColumn();

    /**
     * Gets the orientation of this ship.
     *
     * @return <code>true</code> if this ship is horizontal; <code>false</code> otherwise.
     */
    boolean isHorizontal();

    /**
     * Returns the name of the ship Currently there are four ship types:
     * 'battleship', 'cruiser', 'destroyer' and 'submarine'.
     * @return the name of the ship
     */
    String getShipType();

    /**
     * Gets the length of this ship.
     *
     * @return the length of the ship from bow to aft, measured in coordinates.
     */
    int getLength();

    /**
     * Sets the position of this ships bow in the horizontal axis.
     *
     * @param column the x-coordinate location of this ships bow
     */
    void setBowColumn(int column);

    /**
     * Sets the position of this ships bow in the vertical axis.
     *
     * @param row the y-coordinate location of this ships bow
     */
    void setBowRow(int row);

    /**
     * Sets the orientation of this ship.
     *
     * @param horizontal <code>true</code> horizontal; <code>false</code> otherwise.
     */
    void setHorizontal(boolean horizontal);

    /**
     * Confirms that this ship can be placed at these coordinates.
     *
     * @param row           the y-coordinate of this ships bow
     * @param column        the x-coordinate of this ships bow
     * @param horizontal    the orientation of this ship
     * @param ocean         reference to the instance of the Ocean class
     * @return              <code>true</code> if this ship can be placed at these coordinates
     *                      <code>false</code> otherwise.
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean);

    /**
     * Places this ship at these coordinates in the ocean. Adapted from code provided during help session.
     *
     * @param row           the y-coordinate of this ships bow
     * @param column        the x-coordinate of this ships bow
     * @param horizontal    the orientation of this ship
     * @param ocean         reference to the instance of the Ocean class
     */
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean);

    /**
     * Checks if a part of this ship occupies the given row and column. If it does and that part of this ship
     * has not already been hit it updates the hit array for that section to <code>true</code> and returns
     * <code>true</code>.
     *
     * @param row       the y-coordinate of the shot
     * @param column    the x-coordinate of the shot
     * @return          <code>true</code> if shot hits a section of unsunk ship; <code>false</code> otherwise
     */
    boolean shootAt(int row, int column);

    /**
     * Checks this ships hit array to determine if it has been sunk.
     *
     * @return <code>true</code> if this ship has been sunk; <code>false</code> otherwise.
     */
    boolean isSunk();

    /**
     * Orders the ships in the Ocean class' ship array in reverse order by length.
     * Adapted from p390 Java for Everyone (Horstmann)
     * @param ship  a ship object
     * @return      <code>1</code> if this ship is shorter than the ship;
     *              <code>-1</code> if this ship is longer the ship;
     *              <code>0</code> if they are of the same length
     */
    int compareTo(Ship ship);

    /**
     * Checks the given coordinate to see if it has been hit, or if the ship has been sunk.
     *
     * @param row       the vertical coordinate provided by the <code>Ocean</code> class
     * @param column    the horizontal coordinate provided by the <code>Ocean</code> class
     * @return          an 'x' if this ship is sunk;
     *                  an 'S' if the section at the coordinates specified has been hit;
     *                  a '.' if the section at the coordinates specified has not been hit.
     */
    String toString(int row, int column);
}
