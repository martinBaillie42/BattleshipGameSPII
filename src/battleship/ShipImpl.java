package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public class ShipImpl implements Ship {

    /** the length of a ship measured in coordinates */
    private int length;
    /** the location of a ships bow in the ocean on the vertical axis */
    private int bowRow;
    /** the location of a ships bow in the ocean on the horizontal axis */
    private int bowColumn;
    /**
     * the orientation of a ship. A ship can either be horizontal <code>true</code>,
     * or vertical <code>false</code>.
     */
    private boolean horizontal;
    /** the number of times a ship has been hit by a shot. A ship can only be hit
     *  once at each point along it's length.
     */
    protected boolean [] hit = new boolean[4];

    @Override
    public int getBowRow() {
        return bowRow;
    }

    @Override
    public int getBowColumn() {
        return bowColumn;
    }

    @Override
    public boolean isHorizontal() {
        return horizontal;
    }

    @Override
    public String getShipType() {
        return "";
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setBowColumn(int column) {
        this.bowColumn = column;
    }

    @Override
    public void setBowRow(int row) {
        this.bowRow = row;
    }

    @Override
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Sets the length of this ship.
     *
     * @param length the length of the ship from bow to aft, measured in coordinates.
     */
    protected void setLength(int length){
        this.length = length;
    }

    /**
     * Checks if the area under this ship is occupied by another ship.
     *
     * @param y             the y-coordinate of this ships bow
     * @param x             the x-coordinate of this ships bow
     * @param horizontal    the orientation of this ship
     * @param ocean         reference to the instance of the Ocean class
     * @return              <code>true</code> if there is a ship under this ship; <code>false</code> otherwise.
     */
    private boolean isThereAShipUnderThisOne (int y, int x, boolean horizontal, Ocean ocean){
        int traverseLength;

        traverseLength = length;

        return isAreaOccupied(y, x, horizontal, ocean, traverseLength);
    }

    /**
     * Checks if the area in front of this ships bow is occupied by another ship.
     *
     * @param y             the y-coordinate of this ships bow
     * @param x             the x-coordinate of this ships bow
     * @param horizontal    the orientation of this ship
     * @param ocean         reference to the instance of the Ocean class
     * @return              <code>true</code> if there is a ship in front of this ships bow;
     *                      <code>false</code> otherwise.
     */
    private boolean isThereAShipBeforeTheBow(int y, int x, boolean horizontal, Ocean ocean){

        int traverseLength;
        boolean traverseHorizontally;

        y--;
        x--;
        traverseLength = 3;
        traverseHorizontally = !horizontal;

        return isAreaOccupied(y, x, traverseHorizontally, ocean, traverseLength);
    }

    /**
     * Checks if the area to starboard of this ship is occupied by another ship.
     *
     * @param y             the y-coordinate of this ships bow
     * @param x             the x-coordinate of this ships bow
     * @param horizontal    the orientation of this ship
     * @param ocean         reference to the instance of the Ocean class
     * @return              <code>true</code> if there is a ship to starboard; <code>false</code> otherwise.
     */
    private boolean isThereAShipToStarboard(int y, int x, boolean horizontal, Ocean ocean){
        int traverseLength;

        traverseLength = length;

        if(horizontal) {
            y--;
        } else {
            x++;
        }

        return isAreaOccupied(y, x, horizontal, ocean, traverseLength);
    }


    /**
     * Checks if the area behind this ships stern is occupied by another ship.
     *
     * @param y             the y-coordinate of this ships bow
     * @param x             the x-coordinate of this ships bow
     * @param horizontal    the orientation of this ship
     * @param ocean         reference to the instance of the  Ocean class
     * @return              <code>true</code> if there is a ship behind this ships aft; <code>false</code> otherwise.
     */
    private boolean isThereAShipBehindTheStern(int y, int x, boolean horizontal, Ocean ocean){
        int traverseLength;
        boolean traverseHorizontally;

        if (horizontal) {
            x+= length;
            y--;
        } else {
            x--;
            y+= length;
        }

        traverseLength = 3;
        traverseHorizontally = !horizontal;

        return isAreaOccupied(y, x, traverseHorizontally, ocean, traverseLength);

    }

    /**
     * Checks if the area to port of this ships is occupied by another ship.
     *
     * @param y             the y-coordinate of this ships bow
     * @param x             the x-coordinate of this ships bow
     * @param horizontal    the orientation of this ship
     * @param ocean         reference to the instance of the Ocean class
     * @return              <code>true</code> if there is a ship to port; <code>false</code> otherwise.
     */
    private boolean isThereAShipToPort(int y, int x, boolean horizontal, Ocean ocean){
        int traverseLength;

        traverseLength = length;

        if(horizontal) {
            y++;
        } else {
            x--;
        }

        return isAreaOccupied(y, x, horizontal, ocean, traverseLength);
    }

    /**
     * Sweeps a series of coordinates to check if a ship is present.
     *
     * @param y                     the point on the vertical axis where the check originates
     * @param x                     the point on the horizontal axis where the check originates
     * @param ocean                 reference to the instance of the Ocean class
     * @param traverseHorizontally  if <code>true</code> traverse the x axis;
     *                              if <code>false</code> traverse the y axis.
     * @param traverseLength        the number of points from the originating point that are checked for
     *                              the presence of a ship
     * @return                      <code>true</code> if there is a ship present; <code>false</code> otherwise.
     */
    private boolean isAreaOccupied(int y, int x, boolean traverseHorizontally, Ocean ocean, int traverseLength) {
        if (traverseHorizontally) {
            for (int i = x; i < x + traverseLength; i++){
                if (ocean.isOccupied(y,i)) {
                    return true;
                }
            }
        } else {
            for (int i = y; i < y + traverseLength; i++){
                if (ocean.isOccupied(i,x)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if this ships aft falls outside the ocean
     *
     * @param y             the y-coordinate of this ships bow
     * @param x             the x-coordinate of this ships bow
     * @param horizontal    the orientation of this ship
     * @param ocean         reference to the instance of the Ocean class
     * @return              <code>true</code> if this ships aft falls outside the ocean;
     *                      <code>false</code> otherwise.
     */
    private boolean isAftOutsideTheOcean(int y, int x, boolean horizontal, Ocean ocean) {
        if (horizontal) {
            if (x + length > ocean.getUPPER()) {
                return true;
            }
        } else {
            if (y + length > ocean.getUPPER()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        if(isAftOutsideTheOcean(row, column, horizontal, ocean))
            return false;

        if(isThereAShipUnderThisOne(row, column, horizontal, ocean))
            return false;

        if (isThereAShipBeforeTheBow(row, column, horizontal, ocean))
            return false;

        if (isThereAShipToStarboard(row, column, horizontal, ocean))
            return false;

        if(isThereAShipBehindTheStern(row, column, horizontal, ocean))
            return false;

        if (isThereAShipToPort(row, column, horizontal, ocean))
            return false;

        return true;
    }

    @Override
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.setBowRow(row);
        this.setBowColumn(column);
        this.setHorizontal(horizontal);

        Ship ships[][] = ocean.getShipArray();

        for (int i = 0; i < length; i++) {
            ships[row][column] = this;
            if (horizontal) {
                column ++;
            } else {
                row++;
            }
        }
    }

    @Override
    public boolean shootAt(int row, int column) {
        if (horizontal && bowRow == row) {
            for (int i = bowColumn; i < bowColumn + length; i++) {
                if(i == column) {
                    hit[column - bowColumn] = true;
                    return true;
                }
            }
        } else if (!horizontal && bowColumn == column) {
            for (int i = bowRow; i < bowRow + length; i++) {
                if(i == row) {
                    hit[row - bowRow] = true;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isSunk() {
        for (int i = 0; i < length; i++) {
            if(!hit[i]){
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Ship ship) {
        if (length < ship.getLength())
            return 1;
        if (length > ship.getLength())
            return -1;
        return 0;
    }

    @Override
    public String toString(int row, int column) {
        if (this.isSunk()) {
            return "x";
        }

        if(isHorizontal()) {
            if(hit[column - getBowColumn()]) {
                return "S";
            }
        } else {
            if(hit[row - getBowRow()]) {
                return "S";
            }
        }

        return ".";
    }

}
