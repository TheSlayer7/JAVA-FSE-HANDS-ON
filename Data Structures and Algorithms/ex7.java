public class ex7 {

    public static double predictFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return (1 + growthRate) * predictFutureValue(presentValue, growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000.0;
        double annualGrowthRate = 0.05; 
        int years = 10;

        double futureValue = predictFutureValue(initialInvestment, annualGrowthRate, years);

        System.out.printf("Initial Investment: $%.2f%n", initialInvestment);
        System.out.printf("Growth Rate: %.1f%%%n", annualGrowthRate * 100);
        System.out.printf("Future Value after %d years: $%.2f%n", years, futureValue);
    }
}