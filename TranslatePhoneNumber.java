import java.util.Scanner;
public class TranslatePhoneNumber
{
    public static void main(String[] args){
        System.out.println("Enter a phone number to translate, enter 'exit' to end program");
        Scanner kb = new Scanner(System.in);
        String number = kb.nextLine();
        while (!number.equalsIgnoreCase("exit")){ //this will loop again for another input
            int textLength = number.length();
            int l;
            number = number.toUpperCase(); 
            for (l=0; l<textLength; l++){ //this loops to grab the next letter
                char c = number.charAt(l);
                switch (c){ //translates into number
                    case 'A':
                    case 'B':
                    case 'C':
                    System.out.print("2");
                    break;
                    case 'D':
                    case 'E':
                    case 'F':
                    System.out.print("3");
                    break;
                    case 'G':
                    case 'H':
                    case 'I':
                    System.out.print("4");
                    break;
                    case 'J':
                    case 'K':
                    case 'L':
                    System.out.print("5");
                    break;
                    case 'M':
                    case 'N':
                    case 'O':
                    System.out.print("6");
                    break;
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'S':
                    System.out.print("7");
                    break;
                    case 'T':
                    case 'U':
                    case 'V':
                    System.out.print("8");
                    break;
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                    System.out.print("9");
                    break;
                    default: System.out.print(c); //1, #, *, and 0 don't need to be translated, print as is

                }
            }
            System.out.println( ); //this is for formatting, when the user makes another input, it doesn't print right beside output
            number = kb.nextLine();
        }
        System.out.println("**End of Program**");
    }
}