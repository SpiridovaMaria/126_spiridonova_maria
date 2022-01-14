package Core;

import java.util.*;

public class DocBook {

    private HashMap<String, Document> data;


    public DocBook(){
        data = new HashMap<>();
    }

    public static DocBook create(){
        return new DocBook();
    }

    public void addDoc(String number, String date){
        StringBuilder error = new StringBuilder();

        if(number == null){
            error.append("Number cannot be null\n");
        }
        if(date == null){
            error.append("Date cannot be null\n");
        }
        if(data.containsKey(number)){
            error.append("this document exists\n");
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
        if(docNumber == null){
            error.append("Number of Document cannot be null\n");
        }
        if(date == null){
            error.append("Date cannot be null\n");
        }
        if(data.get(docNumber)==null){
            error.append("This document does not exist\n");
        }
        if(data.get(docNumber).getPaymentDocuments().containsKey(paymentDocNumber)){
            error.append("this number of payment document exists\n");
        }
        if(!error.isEmpty()){
            throw new IllegalArgumentException(error.toString());
        }
        else {
            data.get(docNumber).registerPaymentDoc(sum, paymentDocNumber, type, date);
        }
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
        StringBuilder error = new StringBuilder();
        if(docNumber == null){
            error.append("Number of Document cannot be null\n");
        }
        if(paymentDocDate == null){
            error.append("Date cannot be null\n");
        }
        if(data.get(docNumber).getPaymentDocuments().get(paymentDocNumber)==null){
            error.append("Payment document does not exist\n");
        }
        if(!error.isEmpty()){
            throw new IllegalArgumentException(error.toString());
        }

        else {
            data.get(docNumber).getPaymentDocuments().remove(paymentDocNumber);
        }

    }

    public HashMap<String, Integer> getListOfAllDocsWithPayments(){
        HashMap<String, Integer> list = new HashMap();
        for (Map.Entry<String, Document> entry: data.entrySet()){
            list.put(entry.getKey(), entry.getValue().getSumOfPayments());
        }
        return list;
    }

}
