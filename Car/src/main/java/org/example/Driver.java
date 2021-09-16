package org.example;

public class Driver{
    public ForDriver forDriver;
    private String name;

    Driver(ForDriver forDriver, String name){
        this.forDriver = forDriver;
        this.name= name;
    }

    @Override
    public String toString(){
        return "Name: " + name + "\nCar: " + forDriver;
    }
}
