package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public class BattleshipImpl extends ShipImpl implements Battleship {

    /**
     *
     */
    public BattleshipImpl() {
        this.setLength(4);
        for (int i = 0; i < 4 ; i++) {
            this.hit[i] = false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getShipType() {
        return "battleship";
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
