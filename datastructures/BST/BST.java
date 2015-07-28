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
public class BST {

    private Node root;

    public BST() {
        root = null;
    }
    
    public Node getRoot(){
        return root;
    }
        
    public boolean isEmpty(){
        return root == null;
    }
    
    public void insert(int data){
        root = insert(root,data);
    }

    public Node insert(Node n, int data){
        if(n == null){
            n = new Node(data);
        }
        else{
            if(data <= n.getNode())
                n.left = insert(n.left, data);
            else
                n.right = insert(n.right, data);
        }
        return n;
        }
    
    public void delete(int data){
        if(isEmpty()){
            System.out.println("Tree is empty, Cannot delete!");
        }
        else if(search(data) == false){
            System.out.println("Node cannot be found!");
        }
        else{
            root = delete(root,data);
            System.out.println(data+" deleted from the tree!");
        }
    }
    
    public Node delete(Node root, int data){
        
        Node pl, pr, n;
        
        if(root.getNode() == data){
            Node lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if((lt == null)&&(rt == null)){
                return null;
            }else if(lt == null){
                pl = rt;
                return pl;
            }else if(rt == null){
                pl = lt;
                return pl;
            }else{
                pl = rt;
                pr = rt;
                while(pl.getLeft()!=null)
                    pl = pl.getLeft();
                pl.setLeft(lt);
                return pr;
            }
        }
        if(data < root.getNode()){
            n = delete(root.getLeft(), data);
        }
        else{
            n = delete(root.getRight(),data);
        }
        return root;
    }
    
    public boolean search(int data){
        return search(root,data);
    }
    
    public boolean search(Node root, int data){
        boolean found = false;
        while((root != null) && (!found)){
            int rVal = root.getNode();
            if(data < rVal)
                root = root.getLeft();
            else if(data > rVal)
                root = root.getRight();
            else
            {
                found = true;
                break;
            }
        found = search(root, data);
        }
        return found;
    }
    
    public int countNodes(){
        return countNodes(root);
    }
    
    public int countNodes(Node root){
        if(root == null){
            return 0;
        }
        else{
            int l = 1;
            l += countNodes(root.getLeft());
            l += countNodes(root.getRight());
            return l;
        }
    }
    
    public void preorder(){
        preorder(root);
    }
    
    public void preorder(Node root){
        if(root != null){
            System.out.print(root.getNode()+" ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }
    
    public void postorder(){
        postorder(root);
    }
    
    public void postorder(Node root){
        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.print(root.getNode()+" ");
    }
}


