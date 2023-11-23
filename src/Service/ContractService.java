package Service;

import Entities.Contract;
import Entities.Installment;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ContractService extends PayPalService {
    public void processContract(Contract contrato, Integer months) throws ParseException {
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < months; i++) {
            cal.setTime(contrato.getDate());
            cal.add(Calendar.MONTH, 1);
            contrato.setDate(cal.getTime());
            Double temp = contrato.getTotalValue();
            contrato.setTotalValue(interest(contrato.getTotalValue()/months, (i+1)));
            contrato.setTotalValue(paymentFee(contrato.getTotalValue()));
            contrato.getInstallment().add(new Installment(contrato.getDate(), contrato.getTotalValue()));
            contrato.setTotalValue(temp);
        }

    }
}
