package MainProject;

import Entities.Contract;
import Entities.Installment;
import Service.ContractService;
import Service.OnlinePaymentService;
import Service.PayPalService;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        System.out.println("Entre os dados do contrato:");
        System.out.print("Numero: ");
        Integer numero = sc.nextInt();
        System.out.println("Valor do contrato: ");
        Double valor = sc.nextDouble();
        System.out.println("Entre com o numero de parcelas: ");
        Integer parcelas = sc.nextInt();
        System.out.print("Data (dd/mm/yyyy):");
        try {
            data = sdf1.parse(sc.next());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Contract mike = new Contract(numero, data, valor,new ArrayList<Installment>());
        ContractService service = new ContractService(new PayPalService());
        service.processContract(mike,parcelas);
        System.out.println(mike.toString());

        sc.close();
    }
}
