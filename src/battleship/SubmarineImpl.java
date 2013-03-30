package battleship;

public class SubmarineImpl extends ShipImpl implements Submarine {

    /**
     *
     */
    public SubmarineImpl() {
        this.setLength(1);
        for (int i = 0; i < 1 ; i++) {
            this.hit[i] = false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getShipType() {
        return "submarine";
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(int row, int column) {

        if (this.isSunk()) {
            return "x";
        }

        if(isHorizontal()) {
            if(hit[column - getBowColumn()]) {
                return "S";
            }
        } else {
            if(hit[row - getBowRow()]) {
                return "S";
            }
        }

        return ".";
    }
}
