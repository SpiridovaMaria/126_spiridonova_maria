package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public HashMap<Integer, PaymentDoc> getPaymentDocuments(){
        return paymentDocs;
    }


    public int getSumOfPayments() {
       int sum=0;
        for(PaymentDoc doc : paymentDocs.values()){
            sum += doc.getSum();
        }
        return sum;
    }
}
