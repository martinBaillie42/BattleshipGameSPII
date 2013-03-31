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

}
