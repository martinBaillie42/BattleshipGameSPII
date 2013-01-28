package battlehelptwo;

/**
 *
 * @author keith
 */
public abstract class ShipImpl implements Ship {

    /**
     * the row (0 to 9) which contains the bow (front) of the ship.
     */
    private int bowRow;
    /**
     * the column (0 to 9) which contains the bow (front) of the ship.
     */
    private int bowColumn;
    /**
     * the number of squares occupied by the ship. An "empty sea" location has length 1.
     */
    private int length;
    /**
     * true if the ship occupies a single row, false otherwise.
     */
    private boolean horizontal;
    /**
     * an array of booleans telling whether that part of the ship has been hit.
     * Only battleships use all four locations;
     * cruisers use the first three;
     * destroyers 2;
     * submarines 1; and
     * "empty sea" either one or none.
     */
    private boolean[] hit = new boolean[4];

    /**
     *
     * @return
     */
    @Override
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     *
     * @param bowColumn
     */
    @Override
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    /**
     * @return bowRow // be more descriptive
     */
    @Override
    public int getBowRow() {
        return bowRow;
    }

    /**
     *
     * @param bowRow
     */
    @Override
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Sets the value of the instance variable horizontal.
     * @param horizontal ???
     */
    @Override
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
    
    /**
     * @return the length of this particular ship.
     */
    @Override
    public int getLength(){
        return length;
    }

    /**
     *
     * @return the type of this ship.
     */
    protected void setLength(int length){
        this.length = length;
    }

    /**
     * The ship must not overlap another ship, or touch another ship
     * (vertically, horizontally, or diagonally), and it must not "stick out"
     * beyond the array.
     *
     * Does not actually change either the ship or the Ocean,
     * just says whether it is legal to do so.
     *
     * @param row blah blah blah
     * @param column
     * @param horizontal
     * @param ocean
     * @return true if it is okay to put a ship of this length with its
     * bow in this location, with the given orientation,
     * and returns false otherwise.
     */
    @Override
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
        //ocean.isOccupied(row, column);
        // if it's horizontal increment column
        // otherwise increment row
        // and check again
        return false;
    }

    /**
     * "Puts" the ship in the ocean.
     * This involves giving values to the bowRow, bowColumn, and horizontal
     * instance variables in the ship, and it also involves putting a reference
     * to the ship in each of 1 or more locations (up to 4)
     * in the ships array in the Ocean object.
     * (Note: This will be as many as four identical references;
     * you can't refer to a "part" of a ship, only to the whole ship.)
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     */
    @Override
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
        this.bowRow = row;
        // .. and so on
    }

    /**
     *
     * @return true if every part of the ship has been hit, false otherwise.
     */
    @Override
    public boolean isSunk(){
//        for (Boolean b : hit){ // this is wrong - why? - enhanced = no
//            if (!b) return false;
//        }
        for (int i=0; i < length; i++)
            if (!hit[i]) return false;
        return true;
    }

    /**
     * clears the array indicating whether that part of the "Ship" has been hit
     */
    protected void clearHit(){
        for (Boolean b: hit)
            b = false;
    }

}