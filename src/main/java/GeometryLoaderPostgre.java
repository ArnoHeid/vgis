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
        try(Connection conn = DriverManager.getConnection(url, props);
            //Statement st = conn.createStatement();
            PreparedStatement ps = creatprepStatement(conn);
            ResultSet rs = ps.executeQuery()
            ) {
            while (rs.next()) {
                int pointNr = rs.getInt(1);
                String pointName  = rs.getString(2);
                double x = rs.getDouble(3);
                double y = rs.getDouble(4);
                points.add(new Point(pointNr,pointName,x,y));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return points;
    }

    //****************************************
    // PRIVATE METHODS
    //****************************************
    private PreparedStatement creatprepStatement(Connection con) throws SQLException {
        String sql = "SELECT * FROM poi";
        PreparedStatement ps = con.prepareStatement(sql);
        //ps.setInt(1,1);
        return ps;
    }
    //****************************************
    // INNER CLASSES
    //****************************************

}
