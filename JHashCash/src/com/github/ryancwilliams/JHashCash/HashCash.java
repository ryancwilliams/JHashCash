/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.JHashCash;

import com.sun.corba.se.impl.logging.UtilSystemException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import sun.text.normalizer.UTF16;

/**
 *
 * @author ryanwilliams
 */
public class HashCash {

    private final MessageDigest hashGenerator;

    public HashCash() throws NoSuchAlgorithmException {
        this("SHA-256");
    }

    public HashCash(String algorithm) throws NoSuchAlgorithmException {

        //Create hash generator
        this.hashGenerator = MessageDigest.getInstance(algorithm);

    }

    public String GenerateHashCash(String data, int targetLevel) {
        //Number of attempts
        int hashCount = 0;
        
        //Current Level
        int currentLevel = 0;
        //Current Hash
        String currentHashCash = "";

        //Chech if curent hashCash is at target
        while (currentLevel < targetLevel) {
            //Add 1 to hash counter
            hashCount++;

            //Generate Random Key
            String key = com.github.ryancwilliams.JHashCash.utils.StringUtils.randomString(16);

            //Create HashCash
            String hashCash = createHashCash(data, key);

            System.out.println(hashCash);

            //Test HashCash
            int level = getSecurityLevel(hashCash);
            //Check if HashCash is better than best HashCash
            if (level > currentLevel) {
                //If beter save HashCash
                currentHashCash = hashCash;
                currentLevel = level;
            }

            System.out.println(level);

        }
        return currentHashCash;
    }

    public int getSecurityLevel(String hashCash) {

        hashGenerator.update(hashCash.getBytes());

        byte hash[] = hashGenerator.digest();

        for (byte item : hash) {
            int value = item;
            if (value < 0) {
                value += 256;
            }
            System.out.print(value + " : ");
        }
        System.out.println();

        int level = 0;

        for (int i = 0; i < hash.length; i++) {
            int localLevel = com.github.ryancwilliams.JHashCash.utils.ByteUtils.countLeadingZeros(hash[i]);
            level += localLevel;
            if (localLevel < 8) {
                i = 10000;
            }
        }

        return level;
    }

    private String createHashCash(String data, String key) {
        String output = data + "::" + key;
        return output;
    }
}
