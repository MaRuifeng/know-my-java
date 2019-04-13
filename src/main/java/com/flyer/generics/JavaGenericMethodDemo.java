package com.flyer.generics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Demo on how to declare and use Java generic methods.
 *
 * @author Ruifeng Ma
 * @since 2019-Apr-13
 */

public class JavaGenericMethodDemo {

    /**
     * Array to list conversion with single type parameter
     */
    private static <T> List<T> arrayToList(T[] arr) {
        return Arrays.stream(arr).collect(Collectors.toList());
    }

    /**
     * Array to list conversion with multiple type parameters
     */
    private static <T, G> List<G> arrayToList(T[] arr, Function<T, G> mapperFunction) { // functional interface
        return Arrays.stream(arr).map(mapperFunction).collect(Collectors.toList());
    }

    /**
     * Array to list conversion with bounded type parameter
     * <T extends Number> : upper bound
     * <T super Number>   : lower bound
     */
    private static <T extends Number & Comparable> List<T> arrayToListWithBoundedTypeParam(T[] arr) {
        return Arrays.stream(arr).collect(Collectors.toList());
    }

    private static void echoItOut(List list) {
        System.out.println("List type parameter: " + list.get(0).getClass().getName());
        System.out.println("List values: " + list + "\n");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Java generic methods demo!\n");
        Integer[] integerArr = {1, 2, 3, 4, 5};

        System.out.println("===== Single type parameter list =====");
        echoItOut(arrayToList(integerArr));

        System.out.println("===== Multiple type parameter list =====");
        echoItOut(arrayToList(integerArr, Object::toString));

        System.out.println("===== Bounded type parameter list =====");
        String[] stringArr = {"1", "2", "3", "4", "5"};
        // echoItOut(arrayToListWithBoundedTypeParam(stringArr));  // compilation error

        System.out.println("\nEnd of demo.");
    }
}
