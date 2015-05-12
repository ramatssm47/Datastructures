/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

/**
 *
 * @author a0120086r
 */
public class Node {
    
    Node next;
    Object data;
    
    public void Node(Object _data){
        next = null;
        data = _data;
    }
    
    public void Node(Node _next, Object _data){
        next = _next;
        data = _data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
}
