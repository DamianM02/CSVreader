package CSVczyt;

import java.io.IOException;
import java.util.Locale;

public class Main {


    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader("with-header.csv",";",true);
        while(reader.next()) {
            int id = 0;
            //System.out.println("xD");
            try {
                id = reader.getInt("id");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String name = null;
            try {
                name = reader.get("nazwisko");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            double nrdomu = 0;
            try {
                nrdomu = reader.getDouble("nrdomu");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            System.out.printf(Locale.US, "%d %s %f\n", id, name, nrdomu);
        }
    }
}