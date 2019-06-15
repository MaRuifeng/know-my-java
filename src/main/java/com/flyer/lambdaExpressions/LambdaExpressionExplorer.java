package com.flyer.lambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Record of useful Java 8 functional interface & lambda expression examples
 *
 * @author Ruifeng Ma
 * @since 2019-Apr-06
 */

public class LambdaExpressionExplorer {

    @FunctionalInterface
    private interface Foo {
        String bar(String input);
    }

    private static void simpleLamda() {
        String confess =  Foo.class.getCanonicalName() + " loves      ";
        Foo fooConcat = param -> param.concat("bar");
        System.out.println(fooConcat.bar(confess));

        Foo fooTrim = param -> param.trim() + "[END]";
        System.out.println(fooTrim.bar(confess));
    }

    /**
     * How it works?
     * <p>1. {@code chars()} returns an {@code IntStream} of the characters</p>
     * <p>2. call the {@code mapToObj()} function with a lambda expression of type casting</p>
     * <p>3. type cast is enough as during invocation Java automatically box {@code char} to {@code Character}</p>
     * <p>4. call the {@code toArray()} method with a method reference to the array constructor of {@code Character[]}</p>
     */
    private static Character[] convertStringToCharacterArray(String str) {
        return str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
    }

    /**
     * How it works?
     * <p>1. {@code chars()} returns an {@code IntStream} of the characters</p>
     * <p>2. call the {@code mapToObj()} function with a lambda expression of type casting</p>
     * <p>3. type cast is enough as during invocation Java automatically box {@code char} to {@code Character}</p>
     * <p>4. call the {@code mapToInt()} function with a method reference to {@code getNumericValue} of the {@code Character} class</p>
     * <p>5. convert stream to array</p>
     */
    private static int[] convertNumberStringToIntArray(String str) {
        return str.chars().mapToObj(c ->(char)c).mapToInt(Character::getNumericValue).toArray();
    }

    /**
     * <p>Often a stream of values needs to be reduced to a resultant value.</p>
     * <p>The {@code recude()} method of the {@code Stream} class applies a binary operator
     * to each element in the stream where the first argument is the result from performing
     * the previous operation and the second element is the current stream element.
     * </p>
     * <p>Common reduce operations include sum, min, max, count and average etc.</p>
     */
    private static int sumUpViaStreamReduce(int[] arr) {
        return Arrays.stream(arr).reduce(0, (a, b) -> a + b);
    }

    /**
     * Convert a list of objects to a map with the object hashcode as the key, and itself as the value.
     */
    private static <T> Map<Integer, Object> convertListToMap(List<T> list) {
        return list.stream().collect(Collectors.toMap(Object::hashCode, object -> object));
    }

    public static void main(String[] args) {
        System.out.println(">>> 1. Simple functional interface instantiation via lambda expression");
        simpleLamda();

        System.out.println(">>> 2. Convert a string to an array of Character objects");
        String str = "FunctionalLambda";
        System.out.println("Input string: " + str);
        Character[] charArray = convertStringToCharacterArray(str);
        for (Character character: charArray) System.out.println(character.getClass().getCanonicalName() + ": " + character);

        System.out.println(">>> 3. Convert a string of number digits to an integer array");
        String numStr = "24587369479";
        System.out.println("Input string: " + numStr);
        for (int i: convertNumberStringToIntArray(numStr)) System.out.println(i);

        System.out.println(">>> 4. Sum up a number array via stream reduce");
        int[] arr = new int[10];
        Arrays.fill(arr, 1);
        System.out.println("Sum: " + sumUpViaStreamReduce(arr));

        System.out.println(">>> 4. Convert a list to map");
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");
        System.out.println("Map: " + convertListToMap(list));

        System.out.println("\nEnd of rabbit hole.");
    }
}
