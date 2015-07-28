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
public class AVLTree {
    
    private AVLNode root;

    public AVLTree() {
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void makeEmpty(){
        root = null;
    }
    
    public void insert(int data){
        root = insert(root, data);
    }
    
    public int height(AVLNode n){
        return n == null ? -1:n.height;
    }
    
    public int max(int lhs, int rhs){
        return lhs>rhs ? lhs:rhs;
    }
    
    private AVLNode insert(AVLNode t, int x){
        
        if(t == null)
            t = new AVLNode(x);
        
        else if(x < t.data){
            
            t.left = insert(t.left, x);
            if(height(t.left) - height(t.right) == 2){
                if(x < t.left.data)
                    t = rotateWithLeftChild(t);
                else
                    t= doubleWithLeftChild(t);
            }
        }
        else if(x > t.data){
            
            t.right = insert(t.right, x);
            if(height(t.right) - height(t.left) == 2){
                if(x > t.right.data)
                    t = rotateWithRightChild(t);
                else
                    t = doubleWithRightChild(t);
            }
        }
        else
            ;
        t.height = max(height(t.left), height(t.right));
        return t;
    }
    
    private AVLNode rotateWithLeftChild(AVLNode k3){
        
        AVLNode k1 = k3.left;
        k3.left = k1.right;
        k1.right = k3;
        
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k3.height = max(height(k3.right), k1.height) + 1;
        
        return k1;
    }
    
    private AVLNode doubleWithLeftChild(AVLNode k3){
        
        k3.left = rotateWithLeftChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    
    private AVLNode rotateWithRightChild(AVLNode k1){
        
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        
        return k2;
    }
    
    private AVLNode doubleWithRightChild(AVLNode k1){
        
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
        
    }
    
    public int countNodes(){
        
        return countNodes(root);
        
    }
    
    private int countNodes(AVLNode r){
        
        if(r == null){
            return 0;
        }else{
            int l = 1;
            
            l += countNodes(r.left);
            l += countNodes(r.right);
            
            return l;
        }
    }
    
    public boolean search(int val){
        return search(root, val);
    }
    
    private boolean search(AVLNode n, int val){
        
        boolean found = false;
        while((n != null) && (!found)){
            if(val < n.data)
                n = n.left;
            else if(val > n.data)
                n = n.right;
            else{
                found = true;
                break;
            }
            found = search(n,val);
        }
        return found;
    }
    
    public void inorder()
     {
         inorder(root);
     }
     private void inorder(AVLNode r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.data +" ");
             inorder(r.right);
         }
     }
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(AVLNode r)
     {
         if (r != null)
         {
             System.out.print(r.data +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(AVLNode r)
     {
         if (r != null)
         {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.data +" ");
         }
     }     
}
