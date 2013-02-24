package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class EmptySeaImpl extends ShipImpl implements EmptySea {

    public EmptySeaImpl(){
        this.setLength(1);
        for (int i = 0; i < 1 ; i++) {
            this.hit[i] = false;
        }

    }

    /**
     *
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean shootAt(int row, int column) {
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isSunk() {
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(int row, int column) {
        return ".";
    }

}
