/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.RBT;

/**
 *
 * @author a0120086r
 */
public class RBNode {
    
    RBNode left, right;
    int element;
    int color;

    public RBNode(int element) {
        this(element, null, null);
    }

    public RBNode(int element, RBNode left, RBNode right) {
        left = left;
        right = right;
        element = element;
        color = 1;
    }
    
    
    
}
