package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DocBook {


    private HashMap<String, Document> data;

    public DocBook(){
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
            System.out.println("Документ зарегистрирован");
            run();
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
        else {
            data.get(docNumber).registerPaymentDoc(sum, paymentDocNumber, type, date);
            System.out.println("Платежный документ создан успешно!");
            run();
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
        data.get(docNumber).getPaymentDocuments().remove(paymentDocNumber);
    }
     public void run(){
         System.out.println("1 - добавление договора");
         System.out.println("2 - добавление платежного документа");
         System.out.println("3 - вычисление суммы всех платежей по договору с заданным номером");
         System.out.println("4 - ");
         System.out.println("5 - ");
         System.out.println("6 - ");
         System.out.println("7 - ");
         System.out.println("8 - ");

         DocBook.create();

         Scanner sc = new Scanner(System.in);
         String command = sc.nextLine();
         switch (command) {
             case "1":
                 System.out.println("Введите номер документа");
                 String number = sc.nextLine();
                 System.out.println("Введите дату");
                 String date = sc.nextLine();
                 addDoc(number, date);
             case "2":
                 System.out.println("Введите номер договора");
                 String numberDoc = sc.nextLine();

                 System.out.println("Введите дату");
                 String datePay = sc.nextLine();

                 System.out.println("Введите cумму");
                 int sum = sc.nextInt();

                 System.out.println("Введите номер");
                 int numberPay = sc.nextInt();


                 System.out.println("Какого типа платежный договор(введите 1, если банковский ордер, введите 2 - если платежное поручение) ");
                 int type = sc.nextInt();




                 if(type==1) registerPaymentDoc(sum, numberPay, numberDoc, TypeOfPaymentDoc.BankOrder, datePay);
                 else if(type==2)  registerPaymentDoc(sum, numberPay, numberDoc, TypeOfPaymentDoc.PaymentOrder,  datePay);
                 else System.out.println("неправильно введен тип платежного документа");
             case "3":
                 System.out.println("Введите номер договора");
                 String docNumber = sc.nextLine();
                 getDocs().get(docNumber).getSumOfPayments();
             default:
                 System.out.println("Неправильно введена команда!");
         }
     }
}
