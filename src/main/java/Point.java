public class Point {


    //****************************************
    // CONSTANTS
    //****************************************

    //****************************************
    // VARIABLES
    //****************************************

    private int pointNr;
    private String pointName;
    private double x;
    private double y;

    //****************************************
    // INIT/CONSTRUCTOR
    //****************************************

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point(int pointNr, String pointName, double x, double y){
        this.pointName =pointName;
        this.pointNr=pointNr;
        this.x = x;
        this.y = y;
    }

    //****************************************
    // GETTER/SETTER
    //****************************************

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //****************************************
    // PUBLIC METHODS
    //****************************************

    public Point sumUp(Point point) {
        this.x +=point.x;
        this.y +=point.y;
        return this;
    }

    public Point multiply(double scalar){
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }
    //****************************************
    // PRIVATE METHODS
    //****************************************

    //****************************************
    // INNER CLASSES
    //****************************************

}
