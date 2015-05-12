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
public class BubbleSort implements Sorting{
    
    public int[] doSort(int[] arr){
        
        int len = arr.length;
        for(int m=len;m>=0;m--){
        for(int l=0;l<len-1;l++){
            int k = l+1;
            if(arr[l]>arr[k]){
                arr[k] = arr[l]+arr[k];
                arr[l] = arr[k] - arr[l];
                arr[k] = arr[k] - arr[l];
            }
        }
        }
    return arr;
    }
    
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] arr = {3,6,3,9,5,1,7,2};
        for(int i=0;i<arr.length;i++){
        System.out.println(bs.doSort(arr)[i]);
        }
    }
}
