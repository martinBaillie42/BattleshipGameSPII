package battleship;

public interface Cruiser extends Ship{
    String getShipType();

    @Override
    String toString(int row, int column);
}
