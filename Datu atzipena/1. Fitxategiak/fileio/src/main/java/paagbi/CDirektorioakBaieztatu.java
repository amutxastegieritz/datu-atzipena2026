package paagbi;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CDirektorioakBaieztatu
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        //Erabiltzaileari path absolutua sartzeko eskatzen dio, fitxategi edo direktorio batena
        System.out.print("Sartu direktorio baten path absolutoa: ");
        String sarrera = scanner.nextLine();

        Path helb = Path.of(sarrera);

        // Erabiltzaileak sartutako path-a ez bada absolutua
        if (!helb.isAbsolute()) 
        {
            System.out.println("Errorea: Sartu duzun bidea ez da absolutua.");
            System.out.println("Adb: '/fileio/karpetak/animaliak/arrainak'");
        } 
        
        // Absolutua bada
        else 
        {
            // Existitzen bada path-a
            if (Files.exists(helb)) 
            {
                System.out.println("-> Karpeta existitzen da da.");
            }

            //Ez bada existitzen path-a
            else 
            {
                System.out.println("-> Ez dago sartutako baliorik.");
            }
        }

        scanner.close();
    }
}
