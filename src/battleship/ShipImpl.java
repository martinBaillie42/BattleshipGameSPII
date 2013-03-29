package battleship;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
public class ShipImpl implements Ship {

    private int length;
    private int bowRow;
    private int bowColumn;
    private boolean horizontal;

    protected boolean [] hit = new boolean[4];

    /**
     *
     * @return
     */
    @Override
    public int getBowRow() {
        return bowRow;
    }

    /**
     *
     * @return
     */
    @Override
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     *
     * @return
     */
    @Override
    public String getShipType() {
        return "";
    }

    /**
     *
     * @return
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     *
     * @param column
     */
    @Override
    public void setBowColumn(int column) {
        this.bowColumn = column;
    }

    /**
     *
     * @param row
     */
    @Override
    public void setBowRow(int row) {
        this.bowRow = row;
    }

    /**
     *
     * @param horizontal
     */
    @Override
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     *
     * @return the type of this ship.
     */
    protected void setLength(int length){
        this.length = length;
    }

    private boolean isAShipAlreadyHere(int row, int column, boolean horizontal, Ocean ocean) {
        int coordinate;
        coordinate = (horizontal) ? column : row;

        for(int i = coordinate; i < coordinate + length; i++) {
            if (ocean.isOccupied(row,i)) {
                return true;
            }
        }

        return false;
    }


    private boolean isShipsAftOutOfBounds(int row, int column, boolean horizontal, Ocean ocean) {
        int coordinate;
        coordinate = (horizontal) ? column : row;

        for(int i = coordinate; i < coordinate + length; i++) {
            if (i == ocean.getUPPER()) {
                return true;
            }
        }
        return false;
    }


    /**
     *
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     * @return
     */
    @Override
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
    // do an if coordinates = 0,0 only check for aft and starboard
    // if 0,9 only check other things
    // have corners in the checks too.
    // or maybe some clever or xor and ing to check for the borders

        if(isAShipAlreadyHere(row, column, horizontal, ocean)) {
            return false;
        }

        if(isShipsAftOutOfBounds(row, column, horizontal, ocean)) {
            return false;
        }

        // check if there is a ship on the bow
        if (horizontal) {
            int preBowColumn = column - 1;
            int preBowRow = row - 1;
            for (int i = preBowRow; i < preBowRow + 3; i++){
                if (ocean.isOccupied(i,preBowColumn)) {
                    return false;
                }
            }
        } else {
            int preBowColumn = column - 1;
            int preBowRow = row - 1;
            for (int i = preBowColumn; i < preBowColumn + 3; i++){
                if (ocean.isOccupied(preBowRow,i)) {
                    return false;
                }
            }
        }

        // check if there is ship to starboard (right)
        if (horizontal) {
            int starboardRow = row - 1;
            for (int i = column; i < column + length; i++){
                if (ocean.isOccupied(starboardRow,i)) {
                    return false;
                }
            }
        } else {
            int starboardColumn = column + 1;
            for (int i = row; i < row + length; i++){
                if (ocean.isOccupied(i,starboardColumn)) {
                    return false;
                }
            }
        }

        // check if there is a ship on the stern
        if (horizontal) {
            int postSternColumn = column + length;
            int postSternRow = row - 1;
            for (int i = postSternRow; i < postSternRow + 3; i++){

                if (ocean.isOccupied(i,postSternColumn)) {
                    return false;
                }
            }
        } else {
            int postSternColumn = column - 1;
            int postSternRow = row + length;
            for (int i = postSternColumn; i < postSternColumn + 3; i++){

                if (ocean.isOccupied(postSternRow,i)) {
                    return false;
                }
            }
        }

        // check if there is a ship to port (left)
        if (horizontal) {
            int starboardRow = row + 1;
            for (int i = column; i < column + length; i++){
                if (ocean.isOccupied(starboardRow,i)) {
                    return false;
                }
            }
        } else {
            int starboardColumn = column - 1;
            for (int i = row; i < row + length; i++){
                if (ocean.isOccupied(i,starboardColumn)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     *
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     */
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

    /**
     *
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean shootAt(int row, int column) {
        if (horizontal && bowRow == row) {
            for (int i = bowColumn; i < bowColumn + length; i++) {
                if(i == column) {
//                    if(hit[column - bowColumn] == false) {
                        hit[column - bowColumn] = true;
                        return true;
//                    }
                }
            }
        } else if (!horizontal && bowColumn == column) {
            for (int i = bowRow; i < bowRow + length; i++) {
                if(i == row) {
//                    if(hit[row - bowRow] == false) {
                        hit[row - bowRow] = true;
                        return true;
//                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isSunk() {
        for (int i = 0; i < length; i++) {
            if(hit[i] == false){
                return false;
            }
        }
        return true;
    }

    // adapted from p390 Java for Everyone (Horstmann)
    @Override
    public int compareTo(Ship other) {
        if (length < other.getLength())
            return 1;
        if (length > other.getLength())
            return -1;
        return 0;
    }

    @Override
    public String toString(int i, int j) {
        return "";
    }

}
