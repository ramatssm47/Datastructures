package jp.co.worksap.global;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class ImmutableQueue<E> {

	private Queue<E> queueList;
	public ImmutableQueue(){
		queueList = new LinkedList<>();
	}
	
	public ImmutableQueue(Collection<E> c){
		queueList = new LinkedList<>(c);
	}
	public ImmutableQueue<E> enqueue(E e){
		if(e== null){
			throw new IllegalArgumentException();
		}
		Queue<E> tempQueueList = new LinkedList<>(queueList);
		tempQueueList.add(e);
		return new ImmutableQueue<>(tempQueueList);
		
	}
	
	public ImmutableQueue<E> dequeue(){
		Queue<E> tempQueueList = new LinkedList<>(queueList);
		tempQueueList.remove();
		return new ImmutableQueue<>(tempQueueList);
		
	}
	
	public E peek(){
		return queueList.element();
	}
	
	public int size(){
		return queueList.size();
	}
	
	public String toString(){
		return queueList.toString();
	}
}
