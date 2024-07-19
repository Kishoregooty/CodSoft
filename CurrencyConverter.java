import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Mock exchange rates for demonstration
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("GBP", 0.75);
        // Add more currencies and their exchange rates here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base currency (e.g., USD, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (e.g., USD, EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid currency code. Please try again.");
            scanner.close();
            return;
        }

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);

        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);

        scanner.close();
    }

    public static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        // Convert amount to USD as the intermediary step and then to target currency
        return amount / baseRate * targetRate;
    }
}

