package paagbi.twr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytesRes {
    public static void main(String[] args) throws IOException
    {
        System.out.println("Ruta erlatiboen jatorria: " +  new File ("").getAbsolutePath());
        try (
            FileInputStream in = new FileInputStream("xanadu.txt");
            FileOutputStream out = new FileOutputStream("outagain.txt")
        ) 
        {
            int c;

            while ((c = in.read()) != -1) 
            {
                out.write(c);
            }
        } 
    }
}