package prac7;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author sifiso
 */
public class Employee {
    
    
    private String title;
    private String firstName;
    private String lastName;
    private String empType;

    public Employee() {
        title = "";
        firstName = "";
        lastName = "";
        empType = "";

    }

    public Employee(String title, String firstName, String lastName, String empType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.empType = empType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }
    
    @Override
    public String toString(){
        return title + " # " + firstName + " # " + lastName + " # " + empType + "\n";
    }
    
    public void writeToFile(String text){
        try{
            Prac9FileHandler file = new Prac9FileHandler();
            file.openFile();
            file.processFile(text);
            file.closeFile();
        }
        
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error occured");
        }
    }
}//End of class
