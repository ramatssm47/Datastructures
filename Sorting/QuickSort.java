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
public class QuickSort implements Sorting{
    
        private int[] arr;
        private int len;
    
    public int[] doSort(int[] arr){
               
        if(arr == null || arr.length == 0){
            return null;
        }
        this.arr = arr;
        len = arr.length;
        quickSort(0,len-1);
    
    return arr;
    }

    private void quickSort(int lowerindex, int higherIndex) {
        
        int i = lowerindex;
        int j = higherIndex;
        
        int pivot = arr[lowerindex+(higherIndex-lowerindex)/2];
        
        while(i <= j){
            
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            
            if(i <= j){
                exchangeNos(i,j);
                i++;
                j--;
            }
        }
        if(lowerindex < j)
            quickSort(lowerindex, j);
        if(i < higherIndex)
            quickSort(i, higherIndex);
    }
    private void exchangeNos(int i, int j){
        
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        
        int[] arr = {3,6,3,9,5,1,7,2};
        
        for(int i=0;i<arr.length;i++){
        System.out.println(qs.doSort(arr)[i]);
        }
    }
}
