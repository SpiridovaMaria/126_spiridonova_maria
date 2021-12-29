package Core;

public class PaymentDoc {
    private int summ;
    private String date;
    private TypeOfPaymentDoc type;

    public PaymentDoc(int summ, TypeOfPaymentDoc type, String date) {
        this.summ = summ;
        this.type=type;
        this.date = date;
    }

}
