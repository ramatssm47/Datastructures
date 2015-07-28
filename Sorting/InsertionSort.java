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
public class InsertionSort implements Sorting{
    
    public int[] doSort(int[] arr){
        
        int len = arr.length;
        
        for(int i=1;i<len;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    arr[j] = arr[j-1]+arr[j];
                    arr[j-1] = arr[j] - arr[j-1];
                    arr[j] = arr[j] - arr[j-1];
                }
            }
        }
    return arr;
    }
    
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] arr = {3,6,3,9,5,1,7,2};
        for(int i:is.doSort(arr)){
            System.out.println(i);
        }
        
    }
}
