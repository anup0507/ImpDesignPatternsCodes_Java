package com.example.anup.threadingNConcurrency.MergeSortUsingCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;
    private ExecutorService executorService;
    public MergeSorter(List<Integer> arrayToSort, ExecutorService executorService){
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        int mid= arrayToSort.size()/2;
        if(arrayToSort.size()<=1){
            return arrayToSort;
        }
        List<Integer> leftarrayToSort = arrayToSort.subList(0,mid);
        List<Integer> rightarrayToSort = arrayToSort.subList(mid,arrayToSort.size());
        Future<List<Integer>> leftSortedArrayFuture=executorService.submit(new MergeSorter(leftarrayToSort,executorService));
        Future<List<Integer>> rightSortedArrayFuture=executorService.submit(new MergeSorter(rightarrayToSort,executorService));
        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();
        List<Integer> mergedArray=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<leftSortedArray.size() && j<rightSortedArray.size()){
            if(leftSortedArray.get(i)<rightSortedArray.get(j)){
                mergedArray.add(leftSortedArray.get(i));
                i++;
            }else{
                mergedArray.add(rightSortedArray.get(j));
                j++;
            }
        }
        while(i<leftSortedArray.size()){
            mergedArray.add(leftSortedArray.get(i));
            i++;
        }
        while(j<rightSortedArray.size()){
            mergedArray.add(rightSortedArray.get(j));
            j++;
        }
        return mergedArray;
    }
}
