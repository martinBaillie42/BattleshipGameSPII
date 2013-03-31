package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public class PositionImpl implements Position {

    /** the x-coordinate */
    private int column;
    /** the y-coordinate */
    private int row;

    /**
     * Position constructor.
     * @param column    the supplied x-coordinate
     * @param row       the supplied y-coordinate
     */
    PositionImpl(int row, int column){
        this.column = column;
        this.row = row;
    }

    @Override
    public int getColumn(){
        return column;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

}
