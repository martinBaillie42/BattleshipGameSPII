package battleship;

public interface Battleship extends Ship {
    String getShipType();

    @Override
    String toString(int row, int column);
}
