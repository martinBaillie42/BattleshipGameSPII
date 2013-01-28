package battlehelptwo;

/**
 * @author keith
 */
public class EmptySeaImpl extends ShipImpl implements EmptySea {

    /**
     * blah blah blah
     */
    public EmptySeaImpl() {
        this.setLength(1);
    }

    /**
     * @return
     */
    @Override
    public int getLength() {
        return super.getLength();
    }

    /**
     * @return
     */
    @Override
    public String getShipType() {
        return "sea";
    }

    /**
     * overrides shootAt(int row, int column) that is inherited from Ship
     *
     * @param row
     * @param column
     * @return false to indicate that nothing was hit.
     */

    @Override
    public boolean shootAt(int row, int column) {
        return false;
    }

    /**
     * @return a single-character String to use in the Ocean's print method
     */
    @Override
    public String toString() {
        return ".";
    }

    /**
     * This method overrides isSunk() that is inherited from Ship,
     * and always returns false to indicate that you didn't sink anything.
     *
     * @return
     */
    @Override
    public boolean isSunk() {
        return false;
    }

}
