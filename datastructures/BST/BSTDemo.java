/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.BST;

import datastructures.BST.BST;

/**
 *
 * @author a0120086r
 */
public class BSTDemo {
    
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(12);
        bst.insert(11);
        bst.insert(13);
        System.out.println(bst.getRoot().right.node);
    }
    
}
