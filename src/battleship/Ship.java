package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 02/02/13
 * Time: 18:47
 * To change this template use File | Settings | File Templates.
 */
public interface Ship {
    int getBowRow();

    int getBowColumn();

    boolean isHorizontal();

    int getLength();

    public void setBowColumn(int column);


    public void setBowRow(int row);

    public void setHorizontal(boolean horizontal);

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean);

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean);

    boolean shootAt(int row, int column);

    boolean isSunk();
}
