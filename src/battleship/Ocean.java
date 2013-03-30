package battleship;

public interface Ocean {
    void placeAllShipsRandomly();

    boolean isOccupied(int row, int column);

    boolean shootAt(int row, int column);

    boolean isShipSunk(int row, int column);

    String nameOfShip(int row, int column);

    int getUPPER();

    int getShotsFired();

    int getHitCount();

    int getShipsSunk();

    boolean isGameOver();

    Ship[][] getShipArray();

    @Override
    String toString();
}
