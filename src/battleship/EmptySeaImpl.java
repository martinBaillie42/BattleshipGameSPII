package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public class EmptySeaImpl extends ShipImpl implements EmptySea {

    /**
     * EmptySea constructor. Sets the length of the <code>EmptySea</code> and initialises the hit array
     */
    public EmptySeaImpl(){
        this.setLength(1);
        this.hit[0] = false;
    }

    @Override
    public boolean shootAt(int row, int column) {
        this.hit[0] = true;
        return false;
    }

    @Override
    public boolean isSunk() {
        return false;
    }

    @Override
    public String toString(int row, int column) {
        if(hit[0]) {
            return "-";
        }

        return ".";
    }

}
