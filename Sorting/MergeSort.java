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
public class MergeSort implements Sorting{

    private int[] inArr;
    private int[] tempArr;
    private int len;
    public int[] doSort(int[] arr) {
        
        this.len = arr.length;
        this.inArr = arr;
        this.tempArr = new int[len];
        
        doMergeSort(0,len-1);
        
    return arr;
    }
    
    public void doMergeSort(int lowerIndex, int higherIndex){
        
        if(lowerIndex < higherIndex){
            int middle = lowerIndex + (higherIndex - lowerIndex)/2;
            
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    
    public void mergeParts(int lowerIndex, int middle, int higherIndex){
        
        for(int i = 0; i <= higherIndex; i++){
            tempArr[i] = inArr[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        
        while(i <= middle && j <= higherIndex){
            if(tempArr[i] <= tempArr[j]){
                inArr[k] = tempArr[i];
                i++;
            }else{
                inArr[k] = tempArr[j];
                j++;
            }
            k++;
        }
        while(i <= middle){
            inArr[k] = tempArr[i];
            i++;
            k++;
        }
    }
    
    public static void main(String[] args) {
        
        MergeSort ms = new MergeSort();
        
        int[] arr = {3,6,3,9,5,1,7,2};
        for(int i:ms.doSort(arr)){
            System.out.println(i);
        }
    }    
}
    

