package prac7;

//import static java.awt.image.ImageObserver.HEIGHT;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import javax.swing.JOptionPane;

/**
 *
 * @author sifiso
 */
public class Prac9FileHandler{

    FileWriter fw;
    BufferedWriter bw;
    
    public void openFile() throws IOException {
        fw = new FileWriter("OutputEmployee.txt");
        bw = new BufferedWriter(fw);
    }

    public void processFile(String output) throws IOException {
       bw.write(output);
    }

    public void closeFile() throws IOException {
        bw.close();
    }
}//End of class 
