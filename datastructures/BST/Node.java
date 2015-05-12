/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.BST;

/**
 *
 * @author a0120086r
 */
public class Node {

    int node;
    Node left;
    Node right;

    public Node() {
        node = 0;
        left = null;
        right = null;
    }
    
    public Node(int node) {
        this.node = node;
        this.left = null;
        this.right = null;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

 

    
}
