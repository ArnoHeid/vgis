import java.util.ArrayList;
import java.util.Collection;
import java.sql.*;
import java.util.Properties;

public class GeometryLoaderPostgre implements GeometryLoader{

    //****************************************
    // CONSTANTS
    //****************************************

    //****************************************
    // VARIABLES
    //****************************************

    private String url;
    private Properties props;

    //****************************************
    // INIT/CONSTRUCTOR
    //****************************************
    public GeometryLoaderPostgre(String url, Properties props) {
        this.props = props;
        this.url = url;
    }
    //****************************************
    // GETTER/SETTER
    //****************************************

    //****************************************
    // PUBLIC METHODS
    //****************************************

    @Override
    public Collection<Point> load() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Collection<Point> points = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, props)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM poi");
            while (rs.next()) {
                int pointNr = rs.getInt(1);
                String pointName  = rs.getString(2);
                double x = rs.getDouble(3);
                double y = rs.getDouble(4);
                points.add(new Point(pointNr,pointName,x,y));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return points;
    }

    //****************************************
    // PRIVATE METHODS
    //****************************************

    //****************************************
    // INNER CLASSES
    //****************************************

}
