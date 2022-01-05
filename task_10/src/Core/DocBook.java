package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DocBook {

    private HashMap<String, Document> data;

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
            data.put(number, new Document(date));
        }

    }
    public int getDocCount(){
        return data.size();
    }
    public static DocBook create(){
        return new DocBook();
    }
    public HashMap<String, Document> getDocs(){
        return data;
    }
    public void registerPaymentDoc(int sum, int paymentDocNumber, String docNumber,TypeOfPaymentDoc type, String date) {
        StringBuilder error = new StringBuilder();
        if(sum<0){
            error.append("sum is a positive number\n");
        }
        if(paymentDocNumber<0){
            error.append("number of payment document is a positive number\n");
        }
        if(!error.isEmpty()){
            throw new IllegalArgumentException(error.toString());
        }
        data.get(docNumber).registerPaymentDoc(sum,paymentDocNumber,type, date);
    }
    public List<Integer> getAllPayments() {
        List<Integer> payments = new ArrayList();
        for(Document document: data.values()){
            for(PaymentDoc paymentDoc : document.getPaymentDocuments().values())
                payments.add(paymentDoc.getSum());
        }

        return payments;
    }

    public void deletePayment(String docNumber, int paymentDocNumber, String paymentDocDate) {
        data.get(docNumber).getPaymentDocuments().remove(paymentDocNumber);
    }

}
