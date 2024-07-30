public class Main {
    public static void main(String[] args) {
        // Create a light receiver
        Light light = new Light();

        // Create command objects
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create invoker
        RemoteControl remoteControl = new RemoteControl();

        // Turn the light on
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        // Turn the light off
        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
    }
}
