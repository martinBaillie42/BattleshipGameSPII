package battleship;

public interface Destroyer extends Ship{
    String getShipType();

    @Override
    String toString(int row, int column);
}
