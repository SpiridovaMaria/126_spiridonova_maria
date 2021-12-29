package Core;

import java.util.HashMap;

public class Document {
    private String date;
    private HashMap<Integer, PaymentDoc> paymentDocs;

    public Document(String date){
        this.date = date;
        paymentDocs = new HashMap<>();
    }
    public void registerPaymentDoc(int summ, int number, TypeOfPaymentDoc type, String date){
        paymentDocs.put(number,new PaymentDoc(summ,type,date));
    }

    public int getPaymentDocCount() {
        return paymentDocs.size();
    }

}
