package com.flyer.generics;

import java.util.LinkedList;
import java.util.List;

/**
 * Demo on how to use wildcard generics.
 *
 * @author Ruifeng Ma
 * @since 2019-Apr-13
 */

public class WildcardGenericDemo {
    private static class Animal {
        public void yellMe() {
            System.out.println("Animal!");
        }
    }

    private static class Rabbit extends Animal {
        @Override
        public void yellMe() {
            System.out.println("Rabbit!");
        }
    }

    /**
     * Works on any list of Animal type and its subtypes because of wildcard generics
     */
    private static void whoAmI(List<? extends Animal> animals) {
        animals.forEach(Animal::yellMe);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Java wildcard generics demo!\n");

        List<Animal> animalList = new LinkedList<>();
        animalList.add(new Animal());

        List<Rabbit> rabbitList = new LinkedList<>();
        rabbitList.add(new Rabbit());

        System.out.println("Who am I?");
        /* same method works on both lists of different type parameter*/
        whoAmI(animalList);
        whoAmI(rabbitList);

        System.out.println("\nEnd of demo.");
    }
}
