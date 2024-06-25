public class TaxCalc {
    private double income;
    private double deduction;
    private double taxRate;

    public TaxCalc(double income, double deduction, double taxRate) {
        this.income = income;
        this.deduction = deduction;
        this.taxRate = taxRate;
    }

    double getNetIncome(){
        double deductedIncome=income-deduction;
        return deductedIncome-(deductedIncome*taxRate);
    }

    public static void main(String[] args) {
        TaxCalc t1 = new TaxCalc(12000,1000,0.05);
        System.out.println(t1.getNetIncome());
    }
}
