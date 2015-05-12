/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.AVL;

/**
 *
 * @author a0120086r
 */
public class AVLNode {
    
    AVLNode left, right;
    int data;
    int height;

    public AVLNode() {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }
    
    public AVLNode(int n){
        left = null;
        right = null;
        data = n;
        height = 0;
    }
    
}
