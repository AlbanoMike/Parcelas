package Service;

public class PayPalService implements OnlinePaymentService{

    @Override
    public Double interest(Double amount, Integer months) {
        //amount = amount/months;
        amount += amount * months/100;
        return amount;
    }
    @Override
    public Double paymentFee(Double amount) {
        amount += amount*2/100;
        return  amount;
    }
}
