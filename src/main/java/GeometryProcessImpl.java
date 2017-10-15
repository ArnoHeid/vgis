import java.util.Collection;
import java.util.List;

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

    public GeometryProcessImpl(Collection<Point> pointCollection){
        this.pointCollection = pointCollection;
    }

    //****************************************
    // GETTER/SETTER
    //****************************************

    //****************************************
    // PUBLIC METHODS
    //****************************************

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
