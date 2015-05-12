/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.simple;

import java.util.Stack;

/**
 *
 * @author a0120086r
 */
public class StackTest {

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(new Character('c'));
        s.push(new Character('s'));
        s.push(new Character('b'));
        System.out.println(s.peek());
        System.out.println();
    }
    
    
}
