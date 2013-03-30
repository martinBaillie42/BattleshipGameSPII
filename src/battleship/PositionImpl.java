package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public class PositionImpl implements Position {

    /**
     *
     */
    private int column;
    /**
     *
     */
    private int row;

    /**
     *
     * @param column
     * @param row
     */
    PositionImpl(int row, int column){
        this.column = column;
        this.row = row;
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumn(){
        return column;
    }

    /**
     *
     * @return
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     *
     * @param colunn
     */
    @Override
    public void setColumn(int colunn) {
        this.column = colunn;
    }

    /**
     *
     * @param row
     */
    @Override
    public void setRow(int row) {
        this.row = row;
    }

}
