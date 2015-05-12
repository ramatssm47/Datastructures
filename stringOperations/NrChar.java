/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringOperations;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author a0120086r
 */
public class NrChar {
    
    public char repeatChar(String text){
        
        Map<Character, Integer> counts = new HashMap<>(text.length());
        
        for(char c: text.toCharArray()){
            counts.put(c, counts.containsKey(c)?counts.get(c)+1:1);
        }
        
        for(Entry<Character, Integer> entry:counts.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        throw new RuntimeException("no repeated characters!");
    }
    
    public static void main(String[] args) {
        NrChar nc = new NrChar();
        
        System.out.println(nc.repeatChar("ajdbskdbcslk"));
    }
}
