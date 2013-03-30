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

    private boolean isThereAShipUnderThisOne (int y, int x, boolean horizontal, Ocean ocean){
        int traverseLength;

        traverseLength = length;

        return isAreaOccupied(y, x, horizontal, ocean, traverseLength);
    }

    private boolean isThereAShipBeforeTheBow(int y, int x, boolean horizontal, Ocean ocean){

        int traverseLength;
        boolean traverseHorizontally;

        y--;
        x--;
        traverseLength = 3;
        traverseHorizontally = !horizontal;

        return isAreaOccupied(y, x, traverseHorizontally, ocean, traverseLength);
    }

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

    private boolean isAftOutsideTheOcean(int y, int x, boolean horizontal, Ocean ocean) {
        if (horizontal) {
            if (x + length >= ocean.getUPPER()) {
                return true;
            }
        } else {
            if (y + length >= ocean.getUPPER()) {
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
