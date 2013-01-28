package battlehelptwo;

/**
 *
 * @author keith
 */
public class BattleShipImpl extends ShipImpl implements BattleShip {
    public BattleShipImpl() {
        this.setLength(4);
    }

    @Override
    public int getLength() {
//        access length
        return 0;
    }

    /**
     * @return one of the strings "battleship", "cruiser", "destroyer",
     * or "submarine", as appropriate.
     */
    @Override
    public String getShipType() {
        return "battleship";
    }

    /**
     *
     * @return a single-character String to use in the Ocean's print method
     */
    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean shootAt(int row, int column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
