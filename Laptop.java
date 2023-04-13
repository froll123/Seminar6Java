package Seminar6Java;

public class Laptop {
    String modelName;
    String colorName;
    int ramSize;
    int ssdSize;
    String osName;

    public void getInfo() {
        System.out.println(this.modelName + ":\n\tЦвет: " + this.colorName + "\n\tОЗУ: " + this.ramSize
                + "\n\tОбъем ЖД: " + this.ssdSize + "\n\tОперационная система: " + this.osName + "\n");
    }

    @Override
    public String toString() {
        return "Laptop [model=" + this.modelName + ", color=" + this.colorName + ", ram=" + this.ramSize + ", rom = "
                + this.ssdSize + ", os=" + this.osName + "]";
    }

    public Laptop() {
        this.modelName = null;
        this.colorName = null;
        this.ramSize = 0;
        this.ssdSize = 0;
        this.osName = null;
    }

    public Laptop(String model, String color, int ram, int rom, String os) {
        this.modelName = model;
        this.colorName = color;
        this.ramSize = ram;
        this.ssdSize = rom;
        this.osName = os;
    }
}