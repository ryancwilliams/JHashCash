
import java.security.NoSuchAlgorithmException;
import com.github.ryancwilliams.JHashCash.HashCash;

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
        HashCash hc = new HashCash();
        
        System.out.println(hc.getSecurityLevel("test::AvTP4OWRLMXzhYFT"));
        
        //hc.GenerateHashCash("test", 15);
    }
}
