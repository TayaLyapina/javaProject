package lesson6.homework6;

import java.util.Objects;

public class Laptop {
    int id;
    String model;
    int screenDiagonal;
    String screenResolution;
    String cpu;
    int ram;
    String graficsController;
    int volumeSSD;
    String operatingSystem;
    int batteryOperation;
    int weight;
    int price;


    @Override
    public String toString() {
        return String.format
                ("%d %s %d %s %s %d %s %d %s %d %d %d",
                        id, model, screenDiagonal, screenResolution, cpu, ram, graficsController,
                        volumeSSD, operatingSystem, batteryOperation, weight, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop laptop)) return false;
        return getId() == laptop.getId() && screenDiagonal == laptop.screenDiagonal && ram == laptop.ram &&
                volumeSSD == laptop.volumeSSD && batteryOperation == laptop.batteryOperation &&
                weight == laptop.weight && price == laptop.price && model.equals(laptop.model) &&
                screenResolution.equals(laptop.screenResolution) && cpu.equals(laptop.cpu) &&
                graficsController.equals(laptop.graficsController) && operatingSystem.equals(laptop.operatingSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), model, screenDiagonal, screenResolution, cpu, ram,
                graficsController, volumeSSD, operatingSystem, batteryOperation, weight, price);
    }

    public void turnOn() {
        System.out.println("Пилик-пилик! Welcome!");
    }

    public void turnOff() {
        System.out.println("Goodbye! Пилик-пилик!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(int screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getVolumeSSD() {
        return volumeSSD;
    }

    public int getPrice() {
        return price;
    }
}


