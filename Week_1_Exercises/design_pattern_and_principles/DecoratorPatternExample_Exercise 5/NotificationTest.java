// NotificationTest.java
public class NotificationTest {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        
        // Sending email notification
        notifier.send("Hello via Email");

        // Adding SMS notification functionality
        notifier = new SMSNotifierDecorator(notifier);
        notifier.send("Hello via Email and SMS");

        // Adding Slack notification functionality
        notifier = new SlackNotifierDecorator(notifier);
        notifier.send("Hello via Email, SMS, and Slack");
    }
}
