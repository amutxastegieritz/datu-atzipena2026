package paagbi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/* Karpeten egitura sortzeko klasea */

public class DirektorioakSortu 
{
    public static void main( String[] args )
    {
        System.out.println("Karpeten egitura sortzen...");

        try 
        {
            // Path.of ruta zehazteko
            // Files.createDirectories falta diren karpetak sortzen ditu.
            
            // Animalien karpeta
            Files.createDirectories(Path.of("karpetak", "animaliak", "arrainak"));
            Files.createDirectories(Path.of("karpetak", "animaliak", "ugaztunak"));

            // Elikagaien karpeta
            Files.createDirectories(Path.of("karpetak", "elikagaiak", "barazkiak"));
            Files.createDirectories(Path.of("karpetak", "elikagaiak", "esnekiak"));
            
            System.out.println("Egitura sortu da."); //Baieztatzeko karpetak behar bezela sortu direla.
            
        } 
        
        catch (IOException e) 
        {
            System.err.println("Errorea karpetak sortzerakoan: " + e.getMessage()); //Errore mezua pantailaratuko du.
        }
    }
}
