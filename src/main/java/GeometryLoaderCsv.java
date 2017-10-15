import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;


public class GeometryLoaderCsv implements GeometryLoader {

    //****************************************
    // CONSTANTS
    //****************************************

    //****************************************
    // VARIABLES
    //****************************************

    private String fileName;

    //****************************************
    // INIT/CONSTRUCTOR
    //****************************************

    public GeometryLoaderCsv(String csvFile) {
        this.fileName = csvFile;
    }

    //****************************************
    // GETTER/SETTER
    //****************************************

    //****************************************
    // PUBLIC METHODS
    //****************************************
    @Override
    public Collection<Point> load() {
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
        Collection<Point> pointCollection = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName), ';', '\'', 1)) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                try {
                    int pointNr = Integer.parseInt(nextLine[0]);
                    String pointName = nextLine[1];
                    Number numberX = nf.parse(nextLine[2]);
                    Number numberY = nf.parse(nextLine[3]);
                    Point point = new Point(pointNr,pointName,numberX.doubleValue(), numberY.doubleValue());
                    pointCollection.add(point);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                System.out.println(nextLine[0] + nextLine[1] + "etc...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pointCollection;
    }

    //****************************************
    // PRIVATE METHODS
    //****************************************

    //****************************************
    // INNER CLASSES
    //****************************************


}
