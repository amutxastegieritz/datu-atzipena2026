package paagbi;

// Programa honek fitxategi batetik karaktereak irakurtzen ditu eta beste fitxategi batean idazten ditu, 
// baina a karaktereak o karaktereekin ordezkatzen ditu. Beste karaktere guztiak bere horretan uzten dira.

public class CopyCharactersOrdezkatu 
{
    public static void main(String[] args) 
    {
        String inputFile = "xanadu.txt";
        String outputFile = "outagain.txt";

        try (java.io.FileReader reader = new java.io.FileReader(inputFile);
            java.io.FileWriter writer = new java.io.FileWriter(outputFile)) 
        {
            int c;
            while ((c = reader.read()) != -1) 
            {
                if (c == 'a') 
                {
                    c = 'o';
                }
                writer.write(c);
            }
        } 
        catch (java.io.IOException e) 
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }    
}
