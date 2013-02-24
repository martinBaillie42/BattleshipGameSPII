package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */
public class PositionImpl implements Position {

    private int colunn;
    private int row;

    // test comment

    /**
     *
     * @param column
     * @param row
     */
    PositionImpl(int row, int colunn){
        this.colunn = colunn;
        this.row = row;
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumn(){
        return colunn;
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
        this.colunn = colunn;
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
