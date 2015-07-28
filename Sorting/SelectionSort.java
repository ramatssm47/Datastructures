/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author a0120086r
 */
public class SelectionSort implements Sorting{


    public int[] doSort(int[] arr) {
        
        int len = arr.length;
        
        for(int i=0;i<len-1;i++){
            int index = i;
            for (int j = i+1; j < len; j++) {
                if(arr[j]<arr[i]){
                    index = j;
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                }
            }
        }
        
    return arr;    
    }

    public static void main(String[] args) {
        
        SelectionSort ss = new SelectionSort();
        int[] arr = {3,6,3,9,5,1,7,2};
        
        for(int i=0;i<arr.length;i++){
        System.out.println(ss.doSort(arr)[i]);
    }
 
    }   
}
