package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 02/02/13
 * Time: 18:58
 * To change this template use File | Settings | File Templates.
 */
public interface EmptySea extends Ship{
    boolean isSunk();

    @Override
    String toString(int row, int column);
}
