package battleship;

public interface EmptySea extends Ship{

    boolean isSunk();

    @Override
    String toString(int row, int column);
}
