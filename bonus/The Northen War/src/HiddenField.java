public class HiddenField {
    private char[][] cells;
    private char right;
    private char wrong;

    public HiddenField(char[][] cells, char wrong, char right) {
        this.cells = cells;
        this.wrong = wrong;
        this.right = right;
    }

    public char getRight() {
        return right;
    }
    public char getWrong() {
        return wrong;
    }
    public char[][] getCells() {
        return cells;
    }

    public boolean isWalkable(int x, int y) {
        return y > 0 && y < cells.length && x > 0 && x < cells[y].length && (cells[y][x] == right || cells[y][x] == wrong);
    }
}
