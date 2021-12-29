package Core;

public class PaymentDoc {
    private int summ;
    private String date;

    public PaymentDoc(int summ, String date) {
        this.summ = summ;
        this.date = date;
    }

    public int getSum(){
        return summ;
    }
}
