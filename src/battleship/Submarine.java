package battleship;

public interface Submarine extends Ship{
    String getShipType();

    @Override
    String toString(int row, int column);
}
