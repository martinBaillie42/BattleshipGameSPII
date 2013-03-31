package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public class BattleshipImpl extends ShipImpl implements Battleship {

    /**
     * Battleship constructor. Sets the length of the ship and initialises the hit array
     */
    public BattleshipImpl() {
        this.setLength(4);
        for (int i = 0; i < 4 ; i++) {
            this.hit[i] = false;
        }
    }

    @Override
    public String getShipType() {
        return "battleship";
    }

}
