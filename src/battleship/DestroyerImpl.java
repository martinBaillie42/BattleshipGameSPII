package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public class DestroyerImpl extends ShipImpl implements Destroyer {

    /**
     *
     */
    public DestroyerImpl() {
        this.setLength(2);
        for (int i = 0; i < 2 ; i++) {
            this.hit[i] = false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getShipType() {
        return "destroyer";
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
