package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */
public class PositionImpl implements Position {

    private int x;
    private int y;

    PositionImpl(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX(){
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(x) {
        this.x = x;
    }

    @Override
    public void setY(y) {
        this.y = y;
    }
}
