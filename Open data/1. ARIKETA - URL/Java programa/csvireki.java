import java.net.URI;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/* 
OPEN DATA PROIEKTUA

Programa honen bitartez CSV fitxategi bat irakurtzen da 
Internetetik eta bertan dauden datuak kontsolan 
bistaratzen dira.
 */

public class csvireki 
{
    public static void main(String[] args) 
    {
        String linka = "https://data.renfe.com/dataset/0356d125-ddd2-4db2-9f10-3083c91f3e2a/resource/3254a1ed-a2b7-4fd1-9e9e-23eefe35f162/download/listado-estaciones-cercanias-bilbao.csv";

        try 
        {
            URL url = URI.create(linka).toURL();

            InputStream inputStream = url.openStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            String linea;
            System.out.println("Datuak irakurtzen...\n");

            while ((linea = reader.readLine()) != null) 
                {
                System.out.println(linea);
            }

            reader.close();
            System.out.println("\n--- Irakurketa amaituta ---");

        } 
        
        catch (Exception e) 
        {
            System.err.println("Errorea gertatu da linka irakurtzerakoan:");
            e.printStackTrace();
        }
    }
}