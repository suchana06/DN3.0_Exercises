// Computer.java
public class Computer {
    // Required parameters
    private String CPU;
    private String RAM;

    // Optional parameters
    private String storage;
    private String graphicsCard;
    private String powerSupply;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.powerSupply = builder.powerSupply;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + 
               ", storage=" + storage + 
               ", graphicsCard=" + graphicsCard + 
               ", powerSupply=" + powerSupply + "]";
    }
    
    // Getters for the attributes can be added here if needed

    // Builder Class
    public static class Builder {
        // Required parameters
        private String CPU;
        private String RAM;

        // Optional parameters
        private String storage;
        private String graphicsCard;
        private String powerSupply;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
