package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
    private Integer number;
    private Date date;
    private Double totalValue;
    private List<Installment>installment;

    public Contract() {
    }

    public Contract(Integer number, Date date, Double totalValue, List<Installment> installment) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
        this.installment = installment;
    }

    public Contract(Integer number, Date date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;

    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public List<Installment> getInstallment() {
        return installment;
    }

    public void setInstallment() {
        this.installment = installment;
    }

    public void setTotalValue(Double totalValue) {

        this.totalValue = totalValue;
    }



    @Override
    public String toString() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        return  "numero: " + number +
                "\nData (dd/MM/yyyy): " + sdf1.format(date) +
                "\nValor Do Contrato: " + String.format("%.2f",totalValue) +
                 installment;
    }
    public String toString2() {
        return "Contract{" +
                "number=" + number +
                ", date=" + date +
                ", totalValue=" + totalValue +
                '}';
    }
}
