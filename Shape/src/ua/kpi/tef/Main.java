package ua.kpi.tef;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Shape shape = new Triangle(new Point(-1,-3),new Point(3,4), new Point(5,-5));
        System.out.println(shape.toString());
    }
}
