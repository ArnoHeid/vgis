import java.util.Collection;

public class GeometryProcessImpl implements GeometryProcess {

    //****************************************
    // CONSTANTS
    //****************************************

    private Collection<Point> pointCollection;


    //****************************************
    // VARIABLES
    //****************************************

    //****************************************
    // INIT/CONSTRUCTOR
    //****************************************

    //****************************************
    // GETTER/SETTER
    //****************************************

    //****************************************
    // PUBLIC METHODS
    //****************************************


    @Override
    public void setCollection(Collection<Point> pointCollection) {
        this.pointCollection = pointCollection;
    }

    @Override
    public Point getCenter() {
        Point center = new Point(0,0);
        for (Point point:pointCollection) {
            center.sumUp(point);
        }
        return center.multiply(1.0/this.pointCollection.size());
    }

    @Override
    public int getSize() {
        return this.pointCollection.size();
    }

    //****************************************
    // PRIVATE METHODS
    //****************************************

    //****************************************
    // INNER CLASSES
    //****************************************

}
