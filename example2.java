import java.util.Scanner; 
 
public class example2 { 
    public static String reverse(String str) { 
        String result = ""; 
        for ( int i = str.length() -1; i >=0; i--) { 
            result += str.substring(i, i+1); 
        } 
        return result; 
    } 
    public static void main(String[] args) { 
        if ( args.length <= 0) { 
            System.out.println("Usage: java Process [-r] [-u]"); 
            System.exit( -1); 
        } 
        boolean reverse = false; 
        boolean upperCase = false; 
        for ( String str : args) { 
            switch ( str) { 
                case "-r": reverse = true; 
                break; 
                case "-u" : upperCase = true; 
                break; 
            } 
        } 
        Scanner input = new Scanner(System.in); 
        while ( input.hasNextLine()) { 
            String line = input.nextLine(); 
            if ( reverse) line = reverse(line); 
            if ( upperCase) line = line.toUpperCase(); 
            System.out.println( line); 
        } 
  
    } 
} 
 