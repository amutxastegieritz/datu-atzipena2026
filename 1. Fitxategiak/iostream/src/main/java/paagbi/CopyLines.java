package paagbi;

public class CopyLines 
{
    public static void main(String[] args) 
    {
        String inputFile = "xanadu.txt";
        String outputFile = "outagain.txt";

        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(inputFile));
            java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(outputFile))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                writer.write(line);
                writer.newLine();
            }
        } 
        catch (java.io.IOException e) 
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
