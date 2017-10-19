import java.util.Collection;

public interface GeometryProcess {
    void setCollection(Collection<Point> points);
    Point getCenter();
    int getSize();
}
