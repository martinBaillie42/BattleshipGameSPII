package battleship;

public class CruiserImpl extends ShipImpl implements Cruiser {

    /**
     *
     */
    public CruiserImpl() {
        this.setLength(3);
        for (int i = 0; i < 3 ; i++) {
            this.hit[i] = false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getShipType() {
        return "cruiser";
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

//        return "c";
        return "c";
    }
}
