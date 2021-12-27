package Core;

public class DocBook {
    private int docCount;

    private DocBook(){
        docCount=0;
    }

    public void addDoc(String number, String date){
        StringBuilder error = new StringBuilder();

        if(number == null){
            error.append("Number cannot be null\n");
        }
        if(date == null){
            error.append("Date cannot be null\n");
        }
        if(!error.isEmpty()){
            throw new IllegalArgumentException(error.toString());
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
