/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.JHashCash.utils;

import java.util.Random;

/**
 *
 * @author ryanwilliams
 */
public class StringUtils {

    private static final char[] randomSymbols = new char[62];

    static {
        for (int idx = 0; idx < 10; ++idx) {
            randomSymbols[idx] = (char) ('0' + idx);
        }
        for (int idx = 10; idx < 36; ++idx) {
            randomSymbols[idx] = (char) ('a' + idx - 10);
        }
        for (int idx = 36; idx < 62; ++idx) {
            randomSymbols[idx] = (char) ('A' + idx - 36);
        }
    }
    
    private static Random rng = new Random();

    public static String toHex(byte input[]) {
        StringBuilder strBuf = new StringBuilder(input.length * 2);

        for (byte item : input) {
            String itemHex = Integer.toHexString(0xff & item);
            if (itemHex.length() == 1) {
                //append 0 to output if hex string is smaller than 2 chars.
                strBuf.append('0');
            }
            strBuf.append(itemHex);
        }

        return strBuf.toString();
    }

    public static String randomString(int length) {
        char strBuf[] = new char[length];
        
        for (int i = 0;i < strBuf.length; i++) {
            strBuf[i] = randomSymbols[rng.nextInt(randomSymbols.length)];
        }
        
        return new String(strBuf);
    }
}
