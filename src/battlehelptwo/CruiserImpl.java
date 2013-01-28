package battlehelptwo;

/**
 *
 * @author keith
 */
public class CruiserImpl implements Cruiser {

    @Override
    public int getBowColumn() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBowRow() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isHorizontal() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getShipType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getLength() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBowRow(int bowRow) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBowColumn(int bowColumn) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setHorizontal(boolean horizontal) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean shootAt(int row, int column) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isSunk() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
