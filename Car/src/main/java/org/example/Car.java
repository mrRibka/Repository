package org.example;

public class Car implements ForRefueler, ForDriver, ForEngineer{
    private int size;
    private int tankVolume;
    private Category category;
    private String mark;
    private String engine;
    private String characteristic;
    public enum Category { A , B, C };

    Car(int size, int tankVolume, Category category, String mark, String engine, String characteristic){
        this.size = size;
        this.tankVolume = tankVolume;
        this.category = category;
        this.mark = mark;
        this.engine = engine;
        this.characteristic = characteristic;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public Category category() {
        return category;
    }

    @Override
    public String characteristic() {
        return null;
    }

    @Override
    public String engine() {
        return null;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public int tankVolume() {
        return tankVolume;
    }

    @Override
    public String toString(){
        return "Mark: " + mark + " category: " + category
                + " tank volume: " + tankVolume + " Engine: " + engine;
    }
}
