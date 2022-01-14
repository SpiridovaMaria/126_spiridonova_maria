package Core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Console {
    DocBook docBook;
    Scanner sc;

    public Console(){
        docBook = DocBook.create();
         sc = new Scanner(System.in);
    }
    public void run(){
        printCommands();
        while(inProcess()){
            commands();
        }
    }
    public void printCommands(){
        System.out.println("1 - Добавить договор");
        System.out.println("2 - Добавить платёжный документ");
        System.out.println("3 - Найти все платежи по договору");
        System.out.println("4 - Вычислить сумму всех платежей по договору");
        System.out.println("5 - Удалить платёжр договора");
        System.out.println("6 - Получить список всех договоров с их суммарными суммами платежей");
        System.out.println("7 - Получить список всех платежей");
        System.out.println("Введите номер команды");
    }
    public boolean inProcess(){
        return true;
    }
    public void commands(){

        String command = sc.nextLine();

        try {
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

                    if(type==1) { registerPaymentDoc(sum, numberPay, numberDoc, TypeOfPaymentDoc.BankOrder, datePay); }
                    else if(type==2) { registerPaymentDoc(sum, numberPay, numberDoc, TypeOfPaymentDoc.PaymentOrder,  datePay); }
                    else { System.out.println("неправильно введен тип платежного документа");}


                case "3":
                    System.out.println("Введите номер договора");
                    String docNumber = sc.nextLine();
                    getAllPaymentsOfTheDoc(docNumber);

                case "4":
                    System.out.println("Введите номер договора");
                    String docNumber4 = sc.nextLine();

                    getSumOfTheDoc(docNumber4);

                case "5":
                    System.out.println("Введите номер договора");
                    String docNumber5 = sc.nextLine();

                    System.out.println("Введите номер");
                    int numberPay5 = sc.nextInt();

                    System.out.println("Введите дату");
                    String datePay5 = sc.nextLine();

                    deletePaymentDoc(docNumber5, numberPay5, datePay5);

                case "6":
                    getAllDocsWithTheirPayments();

                case "7":
                    getAllPayments();

                default : System.out.println("Неправильно введена команда!");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addDoc(String number, String date){
        docBook.addDoc(number, date);
    }
    public void registerPaymentDoc(int sum, int numberPay, String numberDoc, TypeOfPaymentDoc type, String datePay){
        docBook.registerPaymentDoc(sum, numberPay, numberDoc, type, datePay);
    }
    public void getAllPaymentsOfTheDoc(String number){
        docBook.getDocs().get(number).getListOfPayments().forEach(System.out::println);
    }
    public void getSumOfTheDoc(String docNumber){
        System.out.println(docBook.getDocs().get(docNumber).getSumOfPayments());
    }
    public void  deletePaymentDoc(String docNumber, int numberPay, String datePay){
        docBook.deletePayment(docNumber, numberPay, datePay);
    }
    public void getAllDocsWithTheirPayments(){
        HashMap<String,Integer> docsWithSums = docBook.getListOfAllDocsWithPayments();
        for(Map.Entry<String,Integer> doc: docsWithSums.entrySet()){
            System.out.println("Договор: " + doc.getKey() + " Сумма: " + doc.getValue());
        }
    }
    public void getAllPayments(){
        docBook.getAllPayments().forEach(System.out::println);
    }

}
