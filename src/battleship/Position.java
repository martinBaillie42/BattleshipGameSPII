package battleship;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public interface Position {
    int getColumn();

    int getRow();

    void setColumn(int column);

    void setRow(int row);
}
