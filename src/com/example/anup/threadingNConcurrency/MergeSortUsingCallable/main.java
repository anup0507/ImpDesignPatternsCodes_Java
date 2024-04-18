package com.example.anup.threadingNConcurrency.MergeSortUsingCallable;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(10, 4, 6, 3, 8, 2, 5, 7, 9, 1);
        ExecutorService executorService= Executors.newCachedThreadPool();

        List<Integer> sortedArray=executorService.submit(new MergeSorter(list, executorService)).get();

        for (int i = 0; i < sortedArray.size(); i++) {
            System.out.println(sortedArray.get(i));
        }

    }
}
