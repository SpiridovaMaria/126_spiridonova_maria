package Core;

public class DocBook {
    private int docCount;

    private DocBook(){
        docCount=0;
    }

    public void addDoc(String number, String date){
        if(number == null){
            throw new IllegalArgumentException("number cannot be null");
        }
        docCount++;
    }
    public int getDocCount(){
        return docCount;
    }
    public static DocBook create(){
        return new DocBook();
    }
}
