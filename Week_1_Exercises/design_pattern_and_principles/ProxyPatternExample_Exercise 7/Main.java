public class Main {
    public static void main(String[] args) {
        // Create a stock market
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Change stock price
        stockMarket.setStockPrice(100.0);

        // Deregister an observer
        stockMarket.deregisterObserver(webApp);

        // Change stock price again
        stockMarket.setStockPrice(200.0);
    }
}
