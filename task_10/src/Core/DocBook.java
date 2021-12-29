package Core;

import java.util.HashMap;

public class DocBook {

    private HashMap<String, String> data;

    private DocBook(){
        data = new HashMap<>();
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
        if(!data.containsKey(number)){
            data.put(number, date);
        }

    }
    public int getDocCount(){
        return data.size();
    }
    public static DocBook create(){
        return new DocBook();
    }
}
