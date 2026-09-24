package paagbi;

// Programa honek fitxategi batetik karaktereak irakurtzen ditu eta beste fitxategi batean idazten ditu, 
// baina karaktere bakoitza tamaina aldatuz: letra minuskulak maiuskulak bihurtzen ditu eta letra maiuskulak 
// minuskulak bihurtzen ditu. Beste karaktere guztiak bere horretan uzten dira.

public class CopyCharactersTamainaAldatu 
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
                if (c >= 'a' && c <= 'z') 
                {
                    c = c - 32;
                    writer.write(c);
                }

                else if (c >= 'A' && c <= 'Z') 
                {
                    c = c + 32;
                    writer.write(c);
                } 
                
                else 
                {
                    writer.write(c);
                }
            }
        } 
        catch (java.io.IOException e) 
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }    
}
