package battleship;

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

    @Override
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {

    }

    @Override
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

    }

    @Override
    public boolean shootAt(int row, int column) {

    }

    @Override
    public boolean isSunk() {

    }

}
