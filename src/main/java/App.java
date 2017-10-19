import java.util.Properties;

public class App {
    public static void main(String[] args) {

        //****************************************
        // CONFIGURATION
        //****************************************

        //GeometryLoader gLoader = new GeometryLoaderCsv("_public___poi_.csv");

        String url = "jdbc:postgresql://localhost/coords";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","Arno1234");

        GeometryLoader gLoader = new GeometryLoaderPostgre(url, props);
        GeometryProcess gProcess = new GeometryProcessImpl();

        //****************************************
        // Implementation
        //****************************************

        gProcess.setCollection(gLoader.load());
        Point center = gProcess.getCenter();
        System.out.println("Point: x: " + center.getX() + "|y: " + center.getY());
        System.out.println("Size: " + gProcess.getSize());
    }
}
