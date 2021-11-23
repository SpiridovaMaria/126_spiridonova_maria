
public class Field {
    private char[][] cells;
    private char floor;



    public Field(char[][] cells, char floor) {
        this.cells = cells;
        this.floor = floor;
    }

    public char getFloor() {
        return floor;
    }
    public char[][] getCells() {
        return cells;
    }

    public boolean isWalkable(int x, int y) {
        return y > 0 && y < cells.length && x > 0 && x < cells[y].length && cells[y][x] == floor;
    }

}
