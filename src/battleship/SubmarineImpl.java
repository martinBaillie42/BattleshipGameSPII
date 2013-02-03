package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */
public class SubmarineImpl extends ShipImpl implements Submarine {

    /**
     *
     */
    public SubmarineImpl() {
        // set length
        // initialise hit array
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
    public String toString() {
        // calculate the hit/miss display here.
        // toString(x,y,h) + i loop to find display
        return "s";
    }
}
