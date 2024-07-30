public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card Payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "12/25", "123");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(100.0);

        // Use PayPal Payment
        PaymentStrategy payPalPayment = new PayPalPayment("johndoe@example.com", "password123");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(200.0);
    }
}
