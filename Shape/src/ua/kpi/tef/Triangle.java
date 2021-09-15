package ua.kpi.tef;

public class Triangle extends Shape{
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;


    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    Triangle(Point firstPoint, Point secondPoint, Point thirdPoint){
        this.firstPoint = new Point(firstPoint.getX(), firstPoint.getY());
        this.secondPoint = new Point(secondPoint.getX(), secondPoint.getY());
        this.thirdPoint = new Point(thirdPoint.getX(), thirdPoint.getY());
    }

    @Override
    public double square() {
        double firstSide = Math.sqrt(Math.pow(firstPoint.getX() - secondPoint.getX(), 2) +
                Math.pow(firstPoint.getY() - secondPoint.getY(), 2));
        double secondSide = Math.sqrt(Math.pow(thirdPoint.getX() - secondPoint.getX(), 2) +
                Math.pow(thirdPoint.getY() - secondPoint.getY(), 2));
        double thirdSide = Math.sqrt(Math.pow(firstPoint.getX() - thirdPoint.getX(), 2) +
                Math.pow(firstPoint.getY() - thirdPoint.getY(), 2));
        double p = 0.5 * (firstSide + secondSide + thirdSide) ;
        return Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
    }

    @Override
    public double perimeter() {

        return Math.sqrt(Math.pow(firstPoint.getX() - secondPoint.getX(), 2) +
                Math.pow(firstPoint.getY() - secondPoint.getY(), 2)) +
                Math.sqrt(Math.pow(thirdPoint.getX() - secondPoint.getX(), 2) +
                        Math.pow(thirdPoint.getY() - secondPoint.getY(), 2)) +
                Math.sqrt(Math.pow(firstPoint.getX() - thirdPoint.getX(), 2) +
                        Math.pow(firstPoint.getY() - thirdPoint.getY(), 2));
    }

    @Override
    public void move(double dx, double dy){
        firstPoint.setX(firstPoint.getX() + dx);
        firstPoint.setY(firstPoint.getY() + dy);
        secondPoint.setX(firstPoint.getX() + dx);
        secondPoint.setY(firstPoint.getY() + dy);
        thirdPoint.setX(firstPoint.getX() + dx);
        thirdPoint.setY(firstPoint.getY() + dy);
    }
    @Override
    public String toString() {
        return "Triangle{" +
                "first point=" + firstPoint +
                ", second point=" + secondPoint +
                ", third point=" + thirdPoint + ",\n" +
                super.toString() +
                '}';
    }
}
