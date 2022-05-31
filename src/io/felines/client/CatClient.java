package io.felines.client;

import io.felines.Cat;
import io.felines.CatDice;
import io.felines.CatToys;
import io.felines.FurColor;

/**
 * this is a client model with the main() method to get the project started
 */

//quick note, I decided to play around with arrays for the field of favorite toy. yes it could have been an enum, but I'm still playing around with it, so please don't take that into account.

class CatClient {
    public static void main(String[] args) {
        CatDice dice = new CatDice();
        Cat stella = new Cat("Stella", 8, false, 5, FurColor.RED, "clumsily" );
        Cat randoCat = new Cat("rando");

        String status = randoCat.toString();

//        for (int i = 0; i < Cat.VALID_TOYS.length; i++) {
//            CatToys.
//        }
        CatToys[] days = CatToys.values();
        System.out.println("Contents of the enum are: ");
        //Iterating enum using the for loop
        for(CatToys day: days) {
            System.out.println(day + " here");
        }
        randoCat.giveCatToy(CatToys.BALL);
        System.out.println("1st time: " + status);
        randoCat.giveCatToy(CatToys.MOUSE);
        System.out.println("2nd time: " + status);
        randoCat.giveCatToy(CatToys.STRING);
        System.out.println("3rd time: " + status);
//        randoCat.giveCatToy(CatToys.STRING);
//        System.out.println("4th time: " + status);
//        randoCat.giveCatToy(CatToys.STRING);
//        System.out.println("5th time: " + status);
//        randoCat.giveCatToy(CatToys.STRING);
//        System.out.println("6thth time: " + status);
//        randoCat.setFaveToy("marquee");
//        System.out.println();

        /** testing out some cat creations
         * Cat stella = new Cat("Stella", 8, false, 5, FurColor.RED, "clumsily" );
         * \
        stella.growled();
        stella.showBelly();
        stella.sleep();
        stella.setFaveToy("mouse");
        stella.giveCatToy();
        System.out.println();
        System.out.println(stella);
        System.out.println("lets introduce a new cat!");

        Cat race = new Cat("Race", 1, true, 8.9, FurColor.BROWN, "intensely");

        race.showBelly();
        race.runAround();
        race.setFaveToy("wand");
        race.giveCatToy();
        System.out.println(race);
        System.out.println("lets introduce a new cat!");


        Cat jumo = new Cat( "Jumo-ke", 1, false, 10.0, FurColor.BLACK, "slyly");

        jumo.setFaveToy("ball");
        jumo.runAround();
        jumo.giveCatToy();
        jumo.showBelly();
        jumo.sleep();
        System.out.println(jumo);

        System.out.printf("%s and %s love playing with the %s.", jumo.getName(), stella.getName(), Cat.VALID_TOYS[1]);
         **/

    }
}