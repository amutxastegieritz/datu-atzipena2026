package paagbi;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class App 
{
    static Scanner scanner = new Scanner(System.in); //Static funtzio denetan erabili ahal izateko.
    static Boolean programaMartxan = true;

    public static void menua()
    {
        System.out.println("");
        System.out.println("=========== MENUA ===========");
        System.out.println("===== 1. Karpetak sortu =====");
        System.out.println("=== 2. Fitxategiak sortu ====");
        System.out.println("= 3. Direktorioak baieztatu =");
        System.out.println("=== 4. Edukiak bistaratu ====");
        System.out.println("========= 5. Irten ==========");
        System.out.print("Sartu zure aukera (1-5): ");
        int aukera = scanner.nextInt();
        System.out.println();
        aukerak(aukera); //Funtzioari deitu eta aldagaia bidali.
    }

    public static void aukerak(int ak)
    {
        scanner.nextLine(); //Scanner-a garbitzeko

        switch (ak)
        {
            case 1:
                KarpetakSortu();
                break;

            case 2:
                FitxategiakSortu();
                break;

            case 3:
                DirektorioakBaieztatu();
                break;

            case 4:
                EdukiakBistaratu();
                break;

            case 5:
                Irten();
                break;

            default:
                System.out.println("Aukera ez da zuzena. Saiatu berriro.");
                menua();
                break;

        }
    }

    public static void KarpetakSortu()
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

        menua(); //Programa martxan jarraitzea nahi badugu, menua berriro deitu behar dugu.
    }

    public static void FitxategiakSortu()
    {
        // Erabiltzaileari galderak:
        System.out.print("Zer zoaz deskribatzera? (adib: ugaztuna, arraina, barazkia, esnekia): ");
        String karpetaIzena = scanner.nextLine().trim().toLowerCase(); 

        System.out.print("Zein?: ");
        String fitxategiIzena = scanner.nextLine().trim(); 

        System.out.print("Nolakoa da?: ");
        String edukia = scanner.nextLine(); 

        // Erabiltzaileak deskribatu nahi duen arabera karpetaren path-a gordetzeko aldagaia
        Path helburuKarpeta = null;
        
        // Erabiltzaileak deskribatu nahi duen araberako kasuak
        switch (karpetaIzena) 
        {
            case "ugaztuna":
            case "ugaztunak":
                helburuKarpeta = Path.of("karpetak", "animaliak", "ugaztunak");
                break;

            case "arraina":
            case "arrainak":
                helburuKarpeta = Path.of("karpetak", "animaliak", "arrainak");
                break;

            case "barazkia":
            case "barazkiak":
                helburuKarpeta = Path.of("karpetak", "elikagaiak", "barazkiak");
                break;

            case "esnekia":
            case "esnekiak":
                helburuKarpeta = Path.of("karpetak", "elikagaiak", "esnekiak");
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

        menua();
    }

    public static void DirektorioakBaieztatu()
    {
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

        menua();
    }

    public static void EdukiakBistaratu()
    {
        //Erabiltzaileari eskatzen dio bistaratu nahi duen path-a sartzeko
        System.out.print("Sartu edukia ikusi nahi duzun karpetaren bidea (path): ");
        String sarrera = scanner.nextLine();

        //Aurretik erabiltzaileak sartutako path-a Path objektu bihurtzen dugu
        Path karpeta = Path.of(sarrera);

        //Sartutako path-a existitzen den eta karpeta bat den egiaztatu
        if (Files.isDirectory(karpeta)) 
        {
            System.out.println("\n--- '" + karpeta.getFileName() + "' karpetako azpikarpetak ---"); //Diseinua
            
            // DirectoryStream erabiliz karpetako elementuak irakurtzen ditu eta krp objetuan gordetzen du
            try (DirectoryStream<Path> krp = Files.newDirectoryStream(karpeta)) 
            {
                // Aldagai bat sortzen da, non karpetak aurkitzen diren momentuan "true" izatera pasako den
                boolean karpetakDira = false;
                
                // Bukle bat sortzen da, krp objektuan dauden elementuak irakurtzeko
                for (Path elementua : krp) 
                {
                    // Bukle bakoitzeko duen elementua karpeta bat bada, bistaratu egingo du.
                    if (Files.isDirectory(elementua)) 
                    {
                        System.out.println("- " + elementua.getFileName());
                        karpetakDira = true; // Karpeta bat aurkitu denez "true" izatera pasatzen da
                    }
                }
                
                // Aurreko buklea bukatu eta oindik aldagaia "false" izaten jarraitzen badu
                if (!karpetakDira)
                {
                    System.out.println("Karpeta honek ez du azpikarpetarik (edo hutsik dago).");
                }
                
            } 
            
            // Errorea karpeta irakurtzian
            catch (IOException e) 
            {
                System.err.println("Errorea karpeta irakurtzean: " + e.getMessage());
            }
        } 
        
        // Sartutako path-a existitzen ez bada edo ez bada karpeta bat
        else 
        {
            System.out.println("Errorea: Sartutako bidea ez da existitzen edo ez da karpeta bat.");
        }

        menua();
    }

    public static void Irten()
    {
        programaMartxan = false;
    }

    public static void main( String[] args )
    {
        menua();
    }
}
