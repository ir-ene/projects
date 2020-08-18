import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class FormatPhoneNumber
{
    public static void main(String[] args)
    throws FileNotFoundException
    {
        Scanner s = new Scanner(new File("SampleText.txt"));
        boolean valid = true;
        while (s.hasNext()){
            String n = s.next();
            valid = true; //reset back to true for new number
            if (n.length() == 10){ //Format XXXXXXXXXX
                for (int i=0; i<n.length()-1; i++){
                    char c = n.charAt(i);
                    if (!(Character.isDigit(c))) valid=false;
                }
            }
            else if (n.length()==12){ //Format XXX-XXX-XXXX or XXX.XXX.XXXX
                for (int i=0; i<3; i++){
                    char c = n.charAt(i);
                    if ((!Character.isDigit(c))) valid = false;

                }
                if (valid) {
                    if (!(n.charAt(3)=='-' || n.charAt(3)=='.'))valid = false;
                    else{
                        for (int i=4; i<7; i++){
                            char c = n.charAt(i);
                            if (!(Character.isDigit(c))) valid=false;
                        }  
                        if (valid) {
                            if (!(n.charAt(7)=='-' || n.charAt(7)=='.'))valid = false; 
                            else{
                                for (int i=8; i<n.length(); i++){
                                    char c = n.charAt(i);
                                    if (!(Character.isDigit(c))) valid=false;
                                }    
                            }
                        }

                    }
                }
            }
            else if (n.length()==13){ // Format (XXX)XXX-XXXX
                if (!(n.charAt(0)=='(')) valid=false;
                else{
                    if (valid){
                        for (int i=1;i>4;i++){
                            char c = n.charAt(i);
                            if (!(Character.isDigit(c))) valid=false;
                        }
                        if (valid){
                            if (!(n.charAt(4)==')')) valid=false;
                            else {
                                for (int i=5;i>8;i++){
                                    char c = n.charAt(i);
                                    if (!(Character.isDigit(c))) valid=false;
                                }
                                if (valid) {
                                    if (!(n.charAt(8)=='-')) valid=false;
                                    else {
                                        for (int i=9;i>n.length();i++){
                                            char c = n.charAt(i);
                                            if (!(Character.isDigit(c))) valid=false;
                                        }   
                                    }
                                }
                            }
                        }
                    }
                }

            }
            else valid = false;
            String formatted = formatPhoneNumber(n, valid);
            if (valid == true) System.out.println(formatted);
        }
    }

    public static String formatPhoneNumber(String n, boolean valid){
        String formatted = "";
        if (valid == true) {
            if (n.length() == 10){
                formatted = "("+n.substring(0,3)+")"+n.substring(3,6)+"-"+n.substring(6);
            }
            if (n.length()==12){
                formatted ="("+n.substring(0,3)+")"+n.substring(4,7)+"-"+n.substring(8); 
            }
            if (n.length()==13){ //already in correct format
                formatted = n;   
            }
        }
        return formatted;
    }
}
