package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public class CruiserImpl extends ShipImpl implements Cruiser {

    /**
     * Cruiser constructor. Sets the length of the ship and initialises the hit array
     */
    public CruiserImpl() {
        this.setLength(3);
        for (int i = 0; i < 3 ; i++) {
            this.hit[i] = false;
        }
    }

    @Override
    public String getShipType() {
        return "cruiser";
    }

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
