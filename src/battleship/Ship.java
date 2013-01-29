package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
public class Ship {
    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal;
    boolean [] hit = new boolean[4];

    public Ship() {

    }

    int getBowRow() {
        return bowRow;
    }

    int getBowColumn() {
        return bowColumn;
    }

    boolean isHorizontal() {
        return horizontal;
    }

    String getShipType() {
        return "x";
    }

    void setBowRow(int row) {
        this.bowRow = row;
    }

    void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        return false;
    }

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.setBowRow(row);
    }

    boolean shootAt(int row, int column) {
        return false;
    }

    boolean isSunk() {
        return false;
    }


}
