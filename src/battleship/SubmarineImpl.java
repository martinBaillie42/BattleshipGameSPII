package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public class SubmarineImpl extends ShipImpl implements Submarine {

    /**
     * Submarine constructor. Sets the length of the ship and initialises the hit array.
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
