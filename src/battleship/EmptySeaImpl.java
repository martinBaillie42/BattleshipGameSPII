package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class EmptySeaImpl implements EmptySea {

    public EmptySeaImpl(){

    }

    @Override
    boolean shootAt(int row, int column) {
        return false;
    }

    @Override
    public boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return ".";
    }

}
