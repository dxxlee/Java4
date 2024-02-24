import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarketImpl();

        StockObserver investor1 = new Investor("Maksat");
        StockObserver investor2 = new Investor("Nursultan");
        StockObserver investor3 = new Investor("Amir");

        stockMarket.registerObserver(investor1);
        stockMarket.registerObserver(investor2);
        stockMarket.registerObserver(investor3);

        stockMarket.setStockPrice("NVDA", 788.0); // NVIDIA corp
        stockMarket.setStockPrice("SSNLF", 40.0); // Samsung Electronics Co.Ltd
        stockMarket.setStockPrice("MSFT", 410.34); // Only investor2 receives the update

        getUserInput(stockMarket);
    }
    public static void getUserInput(StockMarket stockMarket) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter stock symbol (type 'exit' to quit): ");
            String symbol = scanner.next();
            if (symbol.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Enter stock price: ");
            double price = scanner.nextDouble();
            stockMarket.setStockPrice(symbol, price);
        }
        scanner.close();
    }
}