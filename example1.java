import java.util.ArrayList;

public class example1 {

    // -s space separated 
    // -r reverse order 
    public static void main(String[] args) { 
        ArrayList<String> remainingArgs = new ArrayList<>(); 
        boolean space = false; 
        boolean reverse = false; 
        for (String arg : args) { 
            if (arg.equals("-s")) { 
                space = true; 
            } else if (arg.equals("-r")) { 
                reverse = true; 
            } else { 
                remainingArgs.add(arg); 
            } 
        } 
        if (reverse) { 
            for (int i = remainingArgs.size() - 1; i >= 0; i--) { 
                if (space) { 
                    System.out.print(remainingArgs.get(i) + " "); 
                } else { 
                    System.out.print(remainingArgs.get(i)); 
                } 
            } 
        } else { 
            for (String value : remainingArgs) { 
                if (space) { 
                    System.out.print(value + " "); 
                } else { 
                    System.out.print(value); 
                }
            }
        }
    }
} 