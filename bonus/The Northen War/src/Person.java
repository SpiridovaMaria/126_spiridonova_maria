public class Person {
    private int moveNumber;
    private int rightNumber;
    private char visualR;
    private char visualW;

    private HiddenField hiddenField;
    private Field field;

    private int xPrint;
    private int yPrint;



    public Person(int moveNumber, int rightNumber, char visualR, char visualW, Field field, HiddenField hiddenField) {
        this.moveNumber=moveNumber;
        this.rightNumber = rightNumber;
        this.visualR = visualR;
        this.visualW = visualW;
        this.field = field;
        this.hiddenField = hiddenField;

    }

    public int getMoveNumber(){return moveNumber;}
    public int getRightNumber(){return rightNumber;}
    public char getVisualR() { return visualR; }
    public char getVisualW() { return visualW; }
    public Field getField() {
        return field;
    }
    public HiddenField getHiddenField() {
        return hiddenField;
    }
    public int getX(){ return xPrint;}
    public int getY(){ return yPrint;}

    public void reduceMoves(){
        moveNumber--;
    }
    public void reduceRightMoves(){
        rightNumber--;
    }

    public int setR(int x, int y) {

        if(field.isWalkable(x, y) && hiddenField.getCells()[y][x]=='1') {
            xPrint =x;
            yPrint =y;
            return 1;
        }
        else if(field.isWalkable(x, y) && hiddenField.getCells()[y][x]=='0'){
            xPrint =x;
            yPrint =y;
            return 0;
        }

        else{
            return 2;
        }

    }




}
