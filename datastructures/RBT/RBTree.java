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
public class RBTree {

     private RBNode current;
     private RBNode parent;
     private RBNode grand;
     private RBNode great;
     private RBNode header;    
     private static RBNode nullNode;
     /* static initializer for nullNode */
     static 
     {
         nullNode = new RBNode(0);
         nullNode.left = nullNode;
         nullNode.right = nullNode;
     }
     /* Black - 1  RED - 0 */
     static final int BLACK = 1;    
     static final int RED   = 0;
 
     /* Constructor */
     public RBTree(int negInf)
     {
         header = new RBNode(negInf);
         header.left = nullNode;
         header.right = nullNode;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return header.right == nullNode;
     }
     /* Make the tree logically empty */
     public void makeEmpty()
     {
         header.right = nullNode;
     }
     /* Function to insert item */
     public void insert(int item )
     {
         current = parent = grand = header;
         nullNode.element = item;
         while (current.element != item)
         {            
             great = grand; 
             grand = parent; 
             parent = current;
             current = item < current.element ? current.left : current.right;
             // Check if two red children and fix if so            
             if (current.left.color == RED && current.right.color == RED)
                 handleReorient( item );
         }
         // Insertion fails if already present
         if (current != nullNode)
             return;
         current = new RBNode(item, nullNode, nullNode);
         // Attach to parent
         if (item < parent.element)
             parent.left = current;
         else
             parent.right = current;        
         handleReorient( item );
     }
     private void handleReorient(int item)
     {
         // Do the color flip
         current.color = RED;
         current.left.color = BLACK;
         current.right.color = BLACK;
 
         if (parent.color == RED)   
         {
             // Have to rotate
             grand.color = RED;
             if (item < grand.element != item < parent.element)
                 parent = rotate( item, grand );  // Start dbl rotate
             current = rotate(item, great );
             current.color = BLACK;
         }
         // Make root black
         header.right.color = BLACK; 
     }      
     private RBNode rotate(int item, RBNode parent)
     {
         if(item < parent.element)
             return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
         else
             return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
     }
     /* Rotate binary tree node with left child */
     private RBNode rotateWithLeftChild(RBNode k2)
     {
         RBNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         return k1;
     }
     /* Rotate binary tree node with right child */
     private RBNode rotateWithRightChild(RBNode k1)
     {
         RBNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         return k2;
     }
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(header.right);
     }
     private int countNodes(RBNode r)
     {
         if (r == nullNode)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Functions to search for an element */
     public boolean search(int val)
     {
         return search(header.right, val);
     }
     private boolean search(RBNode r, int val)
     {
         boolean found = false;
         while ((r != nullNode) && !found)
         {
             int rval = r.element;
             if (val < rval)
                 r = r.left;
             else if (val > rval)
                 r = r.right;
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     /* Function for inorder traversal */ 
     public void inorder()
     {
         inorder(header.right);
     }
     private void inorder(RBNode r)
     {
         if (r != nullNode)
         {
             inorder(r.left);
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
             inorder(r.right);
         }
     }
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(header.right);
     }
     private void preorder(RBNode r)
     {
         if (r != nullNode)
         {
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(header.right);
     }
     private void postorder(RBNode r)
     {
         if (r != nullNode)
         {
             postorder(r.left);             
             postorder(r.right);
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
         }
     }     
}