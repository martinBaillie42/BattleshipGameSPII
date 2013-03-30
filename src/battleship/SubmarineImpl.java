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

//        return "s";
        return "s";
    }
}
