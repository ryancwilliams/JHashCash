/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.JHashCash.multicore;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ryanwilliams
 */
public class ThreadedHashCashGenerator extends Thread {
    
    public final String algorithm;
    public final String data;
    
    public ThreadedHashCashGenerator(String data) throws NoSuchAlgorithmException {
        this(data,"SHA-256");
    }
    
    public ThreadedHashCashGenerator(String data, String algorithm) throws NoSuchAlgorithmException {
        //Check if algorithm is good will cause exception if bad
        MessageDigest.getInstance(algorithm);
        
        //Store algorithm
        this.algorithm = algorithm;
        
        //Store data
        this.data = data;
        
    }
    
    @Override
    public void run() {
        
    }
}
