package io.felines.test;

import io.felines.Cat;

/**
 * we are basically creating a validation test to see if the conditional logic for age works.
 *
 */

public class CatValidationTest {
    public static void main(String[] args) {
        Cat michael = new Cat();

        michael.setAge(Cat.MIN_AGE); //should stick
        System.out.println("michael's age is; " + michael.getAge());

        michael.setAge(0); //should throw error
        michael.setAge(20);//should throw error

        michael.setAge(Cat.MAX_AGE); //should stick
        System.out.println("michael's age is; " + michael.getAge());

    }
}
