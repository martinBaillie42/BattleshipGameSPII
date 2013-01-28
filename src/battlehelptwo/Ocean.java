package battlehelptwo;

public interface Ocean {
    void placeAllShipsRandomly();
    boolean isOccupied(int row, int column);
    boolean shootAt(int row, int column);
    int getShotsFired();
    int getHitCount();
    int getShipsSunk();
    boolean isGameOver();
    Ship[][] getShipArray();
    void print();
}
