package paagbi;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class DEdukiaBistaratu
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

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

        scanner.close();
    }
}
