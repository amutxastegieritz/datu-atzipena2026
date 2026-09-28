package paagbi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class EFitxategiaSortu 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Erabiltzaileari galderak:
        System.out.print("Zer zoaz deskribatzera? ");
        String karpetaIzena = scanner.nextLine().trim().toLowerCase(); 

        System.out.print("Zein? ");
        String fitxategiIzena = scanner.nextLine().trim(); 

        System.out.print("Nolakoa da? ");
        String edukia = scanner.nextLine(); 

        // Erabiltzaileak deskribatu nahi duen arabera karpetaren path-a gordetzeko aldagaia
        Path helburuKarpeta = null;
        
        // Erabiltzaileak deskribatu nahi duen araberako kasuak
        switch (karpetaIzena) 
        {
            case "ugaztuna":
            case "ugaztunak":
                helburuKarpeta = Path.of("karpeta_berriak", "animaliak", "ugaztunak");
                break;

            case "arraina":
            case "arrainak":
                helburuKarpeta = Path.of("karpeta_berriak", "animaliak", "arrainak");
                break;

            case "barazkia":
            case "barazkiak":
                helburuKarpeta = Path.of("karpeta_berriak", "elikagaiak", "barazkiak");
                break;

            case "esnekia":
            case "esnekiak":
                helburuKarpeta = Path.of("karpeta_berriak", "elikagaiak", "esnekiak");
                break;

            default:
                System.out.println("Errorea: Ez dago kategoria hori.");
        }

        // helburuKarpetaren balioa aldatu bada
        if (helburuKarpeta != null) 
        {
            try 
            {
                Path fitxategiBerria = helburuKarpeta.resolve(fitxategiIzena + ".txt");
                Files.writeString(fitxategiBerria, edukia); // Fitxategia sortzen du eta edukia idazten du
                
                System.out.println("\nFitxategia ongi sortu da hemen: " + fitxategiBerria.toAbsolutePath());
            }

            // Errorea fitxategia sortzean
            catch (IOException e)
            {
                System.err.println("Errorea fitxategia sortzean: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
