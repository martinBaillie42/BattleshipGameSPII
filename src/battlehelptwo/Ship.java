package battlehelptwo;

import battlehelptwo.Ocean;

public interface Ship {
    // Getters

    int getBowColumn();
    int getBowRow();
    boolean isHorizontal();
    String getShipType();
    int getLength();

    // Setters

    void setBowRow(int bowRow);
    void setBowColumn(int bowColumn);
    void setHorizontal(boolean horizontal);

    // instance methods

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean);
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean);
    boolean shootAt(int row, int column); // should this be abstract?
    boolean isSunk();
}
