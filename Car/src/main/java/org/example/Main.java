package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Car car = new Car(2000, 40,
                Car.Category.A, "mark",
                "A-800", "2x32" );

        Driver driver = new Driver(car, "Egor");
        System.out.println(driver);
    }
}
