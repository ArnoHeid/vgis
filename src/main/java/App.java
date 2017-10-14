public class App {
    public static void main(String[] args) {
        GeometryLoader gLoader = new GeometryLoaderCsv("C:\\Users\\Arno\\Dropbox\\MA Semester 3\\VGis\\U1 Schnittstelle\\Daten\\_public___poi_.csv");
        gLoader.load();
    }
}
