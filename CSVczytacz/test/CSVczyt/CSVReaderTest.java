package CSVczyt;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {
    @Test
    void pisz() throws IOException {
        CSVReader reader = new CSVReader("with-header.csv",";",true);
        for(String i: reader.columnLabels) System.out.printf(Locale.US, i + " ");
        System.out.println();


        while(reader.next()) {
            for( String i:reader.current) System.out.printf(Locale.US, i + " ");
            System.out.println();
        }
    }

    @Test
    void piszintdouble() throws Exception {
        CSVReader reader = new CSVReader("with-header.csv",";",true);
        System.out.printf(Locale.US,  reader.columnLabels.get(0) );
        System.out.println();


        while(reader.next()) {
            System.out.print(reader.getInt(0) +" ");
            System.out.print(reader.getInt("id") + " ");
            System.out.print(reader.getDouble(0) +" ");
            System.out.print(reader.getDouble("id")+" ");
            System.out.print(reader.getLong(0)+" ");
            System.out.print(reader.getLong(0)+" ");
            System.out.println();
        }
    }






    @Test
    void niewłasciwakolumna() throws IOException {
        CSVReader reader = new CSVReader("with-header.csv",";",true);

        try{
            reader.get(15);
            fail();
        }catch (Exception e){

        }

        try{
            reader.get("nieistnieje");
            fail();
        }catch (Exception e){

        }

        try{
            reader.getInt(15);
            fail();
        }catch (Exception e){

        }

        try{
            reader.getInt("nieistnieje");
            fail();
        }catch (Exception e){

        }


        try{
            reader.getDouble(15);
            fail();
        }catch (Exception e){

        }

        try{
            reader.getDouble("nieistnieje");
            fail();
        }catch (Exception e){

        }



        try{
            reader.getLong(15);
            fail();
        }catch (Exception e){

        }

        try{
            reader.getLong("nieistnieje");
            fail();
        }catch (Exception e){

        }
    }


    @Test
    void nieplik() throws IOException {
        String text = "a,b,c\n123.4,567.8,91011.12";
        CSVReader reader = new CSVReader(new StringReader(text),",",true);

        for(String i: reader.columnLabels) System.out.printf(Locale.US, i + " ");
        System.out.println();

        while(reader.next()) {
            for( String i:reader.current) System.out.printf(Locale.US, i + " ");
            System.out.println();
        }
    }

}