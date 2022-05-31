package io.felines;
import java.util.Random;//class used to create random numbers
import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;
import java.text.DecimalFormat;
public class CatDice {

    //example of making a double fir into a type of format

    private static final DecimalFormat df = new DecimalFormat("0.00");
    Random rand = new Random(); //instance of random class
    int ageUpperBound = 17;
    double hungerUpperBound = 10.0; //higher the hunger the more they're hungry so feeding is needing to decrement, but increment energy
    double thirstUpperBound = 10.0; //same with thirst, decrement thirst when drinking, up energy
    double energyUpperBound = 10.0; // same with energy
    double contentUpperBoundForRandomization = 4.0;
    double overalMinimum = 1.0;
    double catEnergyLevelMinimum = 3.0;
    public int randomCatAge(){
        //generate random values from 0-24
        int int_random = rand.nextInt(ageUpperBound);
        if (int_random == 0){
            int_random = 1;
        }
        return int_random;
    }

    public double catHungerLvl(){
        double randNum = Math.random()*(hungerUpperBound-overalMinimum+1)+overalMinimum;
//        double random_int = Math.random()*(max-min+1)+min;
//        the structure to finding that min and max within a bound
        return  formatNumber(randNum);
    }

    public double catThirstLvl(){
        double randNum = Math.random()*(thirstUpperBound-overalMinimum+1)+overalMinimum;
        return  formatNumber(randNum);
    }
    public double catEnergyLvl(){
        double randNum = Math.random()*(energyUpperBound-catEnergyLevelMinimum+1)+catEnergyLevelMinimum;
        return  formatNumber(randNum);
    }
    public double catContentLevel(){
        double randNum = Math.random()*(contentUpperBoundForRandomization-catEnergyLevelMinimum+1)+catEnergyLevelMinimum;
        return  formatNumber(randNum);
    }


    double formatNumber(double input){

        Double d= Double.parseDouble(df.format(input));

//        if (d instanceof Double){
//            System.out.println("DAMN");
//        }
        return d;
    }

}