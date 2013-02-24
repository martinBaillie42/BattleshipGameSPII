package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
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
        // calculate the hit/miss display here.
        // toString(x,y,h) + i loop to find display
        System.out.println(getBowRow() + " " + getBowColumn() + " " + row  + " " + column + " " + isHorizontal());

        if(isHorizontal()) {
            if(hit[column - getBowColumn()]) {
                return "x";
            }
        }

        return "b";

        // so...
        // check hit array
        // if not hit display .
        // else display x (or whatever hit is
        // if sunk then display letter (ie b here)
    }
}
