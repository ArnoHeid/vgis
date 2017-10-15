public class App {
    public static void main(String[] args) {
        GeometryLoader gLoader = new GeometryLoaderCsv("_public___poi_.csv");
        GeometryProcess gProcess = new GeometryProcessImpl(gLoader.load());
        Point center = gProcess.getCenter();
        System.out.println("Point: x: " + center.getX() + "|y: " + center.getY());
        System.out.println(gProcess.getSize());
    }
}
