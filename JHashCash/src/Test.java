
import java.security.NoSuchAlgorithmException;
import com.github.ryancwilliams.JHashCash.HashCash;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryanwilliams
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the text you want to secure: ");
        String data = scan.nextLine();
        System.out.println("Enter the target securty level: ");
        int targetLevel = scan.nextInt();
        
        long startTime = System.currentTimeMillis();
        
        HashCash hc = new HashCash();
        
        //System.out.println(hc.getSecurityLevel("test::5ffcgihoARk7xIqu"));
        
        String hashCash = hc.GenerateHashCash(data, targetLevel);
        
        long stopTime = System.currentTimeMillis();
        double timeSec = (double) (stopTime - startTime) / 1000;
        System.out.println(hashCash + " Security Level : " + hc.getSecurityLevel(hashCash) + 
                " in " + timeSec + " seconds");
        
    }
}
