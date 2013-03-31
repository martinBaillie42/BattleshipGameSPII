package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public interface Ocean {

    /**
     * Places a fleet of ships randomly around the <code>Ocean</code> object.
     * Of the 10 available 'spaces' for ships it creates 1 ship of each kind.
     * Then the remaining siz ships are generated randomly.
     * This ensures that the fleet always contains at least one ship of each kind.
     *
     * TODO This method is too big and should to be broken up into smaller methods.
     */
    void placeAllShipsRandomly();

    /**
     * Confirms if a location is an <code>EmptySea</code> object.
     *
     * @param row                               the y-coordinate of a ships bow
     * @param column                            the x-coordinate of a ships bow
     * @throws ArrayIndexOutOfBoundsException   if coordinates are greater than <code>UPPER</code>
     * @return                                  <code>true</code> if the coordinate is occupied by a ship;
     *                                          <code>false</code> otherwise.
     */
    boolean isOccupied(int row, int column);

    /**
     * Checks if a given location contains a real ship still afloat.
     * In addition, this method updates the number of shots that have been red, and the number of hits.
     * @param row       the y-coordinate of the shot
     * @param column    the x-coordinate of the shot
     * @return          <code>true</code> if the coordinates contain an unsunk ship and an unhit section;
     *                  <code>false</code> otherwise
     */
    boolean shootAt(int row, int column);

    /**
     * Checks if a ship at the given location is sunk
     * @param row       the y-coordinate
     * @param column    the x-coordinate
     * @return          <code>true</code> if ship is sunk;
     *                  <code>false</code> otherwise.
     */
    boolean isShipSunk(int row, int column);

    /**
     * Checks for the name of a ship at the given location
     * @param row       the y-coordinate
     * @param column    the x-coordinate
     * @return          the name of the ship
     */
    String nameOfShip(int row, int column);

    /**
     * Gets the size of this <code>Ocean</code> and the number of ships in the fleet
     * @return the size of this <code>Ocean</code> or the number of ships
     */
    int getUPPER();

    /**
     * Gets the number of shots fired by the user.
     * @return the number of shots fired by the user
     */
    int getShotsFired();

    /**
     * Gets the number of times the user has hit a ship.
     * @return the number of times the user has hit a ship
     */
    int getHitCount();

    /**
     * Gets the number of ships the user has sunk
     * @return the number of ships the user has sunk
     */
    int getShipsSunk();

    /**
     * Calculates if the users game is over.
     * @return  <code>true</code> if the number of ships sunk is equal to the number fo ships in the fleet;
     *          <code>false</code> otherwise.
     */
    boolean isGameOver();

    /**
     * Gets the array that stores the locations of the various ships. Only to be sued for testing.
     * @return  all ships in the current game
     */
    Ship[][] getShipArray();

    /**
     * Creates the 'board' to display to the user.
     * @return a series of lines in the console to represent the board
     */
    @Override
    String toString();
}
