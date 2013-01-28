package battlehelptwo;

public interface EmptySea extends Ship {

    @Override
    boolean shootAt(int row, int column);

    @Override
    boolean isSunk();

    @Override
    String toString();
}
