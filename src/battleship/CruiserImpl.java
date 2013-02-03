package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class CruiserImpl extends ShipImpl implements Cruiser {

    /**
     *
     */
    public CruiserImpl() {
        // set length
        // initialise hit array
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
    public String toString() {
        // calculate the hit/miss display here.
        // toString(x,y,h) + i loop to find display
        return "c";
    }
}
