package battleship;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 02/02/13
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public interface Position {
    int getColumn();

    int getRow();

    void setColumn(int column);

    void setRow(int row);
}
