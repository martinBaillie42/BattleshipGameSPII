package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public interface Ship extends Comparable<Ship> {

    int getBowRow();

    int getBowColumn();

    boolean isHorizontal();

    String getShipType();

    int getLength();

    void setBowColumn(int column);

    void setBowRow(int row);

    void setHorizontal(boolean horizontal);

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean);

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean);

    boolean shootAt(int row, int column);

    boolean isSunk();

    int compareTo(Ship other);

    String toString(int i, int j);
}
