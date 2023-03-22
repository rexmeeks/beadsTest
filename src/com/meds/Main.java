package com.meds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.stream(args).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(takeBeads(numbers).toString());
    }

    private static List<Integer> takeBeads(List<Integer> numbers) {
        if(numbers.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> conjugateList = new ArrayList<>();

        int length = numbers.size();
        ArrayList<Integer> newList = new ArrayList<>(numbers.subList(0, length - 1));
        int number = numbers.get(length - 1);
        for(int i = 0; i < number; i++) {
            conjugateList.add(length);
        }
        for(int i = 0; i < newList.size(); i++) {
            newList.set(i, newList.get(i)-number);
        }
        conjugateList.addAll(takeBeads(newList));
        return conjugateList;
    }
}
