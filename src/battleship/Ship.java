package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
public class Ship {

    private int length;
    private int bowRow;
    private int bowColumn;
    private boolean horizontal;

    protected boolean [] hit = new boolean[4];

    public int getBowRow() {
        return bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public int getLength() {
        return length;
    }

    package void setBowColumn(int column) {
        this.bowColumn = column;
    }

    package void setBowRow(int row) {
        this.bowRow = row;
    }

    package void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {

    }

    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

    }

    public boolean shootAt(int row, int column) {

    }

    public boolean isSunk() {

    }

}
