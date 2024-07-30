import java.util.Scanner;

public class Exercise7_Solution {
    
    public static double forecastValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return forecastValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double currentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int years = scanner.nextInt();

        double forecastedValue = forecastValue(currentValue, growthRate, years);
        System.out.printf("The forecasted value after %d years is: %.2f\n", years, forecastedValue);
    }
}
