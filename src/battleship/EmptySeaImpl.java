package battleship;

public class EmptySeaImpl extends ShipImpl implements EmptySea {

    /**
     *
     */
    public EmptySeaImpl(){
        this.setLength(1);
        this.hit[0] = false;
    }

    /**
     *
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean shootAt(int row, int column) {
        this.hit[0] = true;
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
        if(hit[0]) {
            return "-";
        }

        return ".";
    }

}
