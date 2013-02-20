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
        return false;
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
                    System.out.println("true " + this.getShipType() + " " + row + " " + column + " " + i);
                    hit[column - bowColumn] = true;
                    System.out.println(Arrays.toString(hit));
                    return true;
                }
            }
        } else if (!horizontal && bowColumn == column) {
            for (int i = bowRow; i < bowRow + length; i++) {
                if(i == row) {
                    System.out.println("true " + this.getShipType() + " " + column + " " + row + " " + i);
                    hit[row - bowRow] = true;
                    System.out.println(Arrays.toString(hit));
                    return true;
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
            if (this.hit[i] == false){
//               System.out.println(this.getShipType() + " " + hit[i] + " " + length);
                return false;
            }
        }
        return true;
    }

}
