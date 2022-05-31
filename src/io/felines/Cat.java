package io.felines;

import java.sql.SQLOutput;

/**
 * creating a business model for the io.felines.Cat Class, which does not have a main method
 */
//it could be possible to change this into an interface, and have certain cats extend that, like make it a catbreed, and then each breed has a certain amount of
public class Cat {
    /**
     * CLASS LEVEL variables
     * create min and max age for cats
     */

    public static final int MIN_AGE = 1;
    public static final int MAX_AGE = 13;
    public static final double CAT_TOO_HUNGRY = 10.0;
    public static final double CAT_IS_FULL = 1.0;
    public static final double CAT_DE_HYDRATED = 10.0;
    public static final double CAT_IS_HYDRATED = 1.0;
    public static final double CAT_ENERGETIC = 10.0;
    public static final double CAT_IS_WORKED = 2.0;
    public static final double ENTRY_STAT_DOUBLE = 5.0;

    public static final String[] VALID_TOYS = { "wand", "mouse", "ball", "hand", "twig", "string"};

    //PROPERTIES
    private String name;
    private int age = 1;
    private double thirstLvl = 5.0;
    private double hungerLvl = 5.0; //the hunger level should be capped at 10, as are any other levels that will be made in the future
    private double energyLvl = 5.0;
    private double contentLvl = 1.5;
    private boolean areClawsTrimmed; //gonna leave it with the default value, because the default of a boolean is false.
    private FurColor furColor; //this will be a string hve this be the enums
    private String speedAdverb;
    private String faveToy;
    //field that is cat emotions, happy, hungry, tired.

    // CONSTRUCTORS - special methods that get call when the client says "new"
    public Cat(){
        //no-op
    }

    public Cat(String name){
        setName(name);
    }

    public Cat(String name, int age, boolean areClawsTrimmed, double hungerLvl, FurColor furColor, String speedAdverb){
        this(name);
        setAge(age);
        setAreClawsTrimmed(areClawsTrimmed);
        setHungerLvl(hungerLvl);
        setFurColor(furColor);
        setSpeedAdverb(speedAdverb);
    }

    // business METHODS

    public void growled(){ //creating a method that lets you know when the cat growls
        System.out.println("your cat, " + getName() + " just let out a growl...");
    }

    public void showBelly(){//creating a method that shows that the cat rolls over, would be interesting for a later method that determines whether that cat is comfortable and what they do when they are or are not
        System.out.println("your cat, " + getName() + " rolled over and decided to show their " + getFurColor() + " belly.");
    }

    public void sleep(){
        System.out.println(getName() + " just yawned and laid down to take a nap.");
    }

    public void runAround(){
        System.out.println(getName() + " ran around " + getSpeedAdverb() + ".");
    }

    public void giveCatToy(CatToys toy){
        //there will probably be logiv in here like is favorite toy or something
        boolean canTheyPlay = canCatPlay(getEnergyLvl());

        if(canTheyPlay){

            double energyLeft = 0;
            if (toy == CatToys.MOUSE){
                energyLeft += (getEnergyLvl() - 0.4);
            }else if (toy == CatToys.BALL){
                energyLeft = (getEnergyLvl() - 0.8);
            }else if (toy == CatToys.STRING){
                energyLeft += (getEnergyLvl() - 1.4);
            }else{
                energyLeft += (getEnergyLvl() - 0.2);
            }
            System.out.println(" cat's energy left to play before beng set with setter function:" + energyLeft+"\n");
            setEnergyLvl(energyLeft);
            System.out.println("supposedly the energy level after using the setter function "+getEnergyLvl()+"\n");
            System.out.printf("you gave %s their %s...oh, they loves it.  they have %f energy\n", getName(), toy, getEnergyLvl());
        }else{
            System.out.println("the damn cat is too damn tired to play \n");
        }

    }

    //validation methods

    public boolean canCatPlay(double energy){
        boolean ans = false;
        if (energy >= CAT_IS_WORKED && energy <= CAT_ENERGETIC){
            ans = true;
        }
        return ans;
    }

    //accessor methods


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if( MIN_AGE <= age && age <= MAX_AGE){
            this.age = age;
        }else{
            System.out.println(age + " is not a proper age, must be between " + MAX_AGE + " and " + MIN_AGE + ".");
        }

    }

    public double getThirstLvl() {
        return thirstLvl;
    }

    public void setThirstLvl(double thirstLvl) {
        this.thirstLvl = thirstLvl;
    }

    public double getEnergyLvl() {
        return this.energyLvl;
    }

    public void setEnergyLvl(double energy) {
        if (energy <= CAT_IS_WORKED){
            this.energyLvl = 2.0;
        }else {
            this.energyLvl = energyLvl;
        }
    }

    public double getContentLvl() {
        return contentLvl;
    }

    public void setContentLvl(double contentLvl) {
        this.contentLvl = contentLvl;
    }

    public boolean getAreClawsTrimmed() {
        return areClawsTrimmed;
    }

    public void setAreClawsTrimmed(boolean areClawsTrimmed) {
        this.areClawsTrimmed = areClawsTrimmed;
    }

    public double getHungerLvl() {
        return hungerLvl;
    }

    public void setHungerLvl(double hungerLvl) {
        this.hungerLvl = hungerLvl;
    }

    public FurColor getFurColor() {
        return furColor;
    }

    public void setFurColor(FurColor furColor) {
        this.furColor = furColor;
    }
    //get set for speed
    public String getSpeedAdverb() {
        return speedAdverb;
    }

    public void setSpeedAdverb(String speedAdverb) {
        this.speedAdverb = speedAdverb;
    }
    //get set for toy


    public String getFaveToy() {
        return faveToy;
    }

    public void setFaveToy(String faveToy) {
        boolean isValid = false;
        for(String validToy : VALID_TOYS){
            if(faveToy.equals(validToy)){
                isValid = true;
                break;
            }
        }
        if(isValid){
            this.faveToy = faveToy;
        }else{
            System.out.println(faveToy + " is not right; must be either " + validToyString());//change it from hard coding to accessing fields so VALID_TOYS[1], VALID_TOYS[0], etc
        }
    }

    private String validToyString(){
        String response = "";

        for (int i = 0; i < VALID_TOYS.length; i++) {
            if (i == (VALID_TOYS.length-1)){
                response += ( "and " + VALID_TOYS[i] + ".");
                System.out.println(VALID_TOYS[i]);
            }else{
                response += (VALID_TOYS[i] + ", ");
                System.out.println(VALID_TOYS[i]);
            }


        }

        System.out.println(response);

        return response;

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", thirstLvl=" + getThirstLvl() +
                ", hungerLvl=" + hungerLvl +
                ", energyLvl=" + getEnergyLvl() +
                ", contentLvl=" + contentLvl +
                ", areClawsTrimmed=" + areClawsTrimmed +
                ", furColor=" + furColor +
                ", speedAdverb='" + speedAdverb + '\'' +
                ", faveToy='" + faveToy + '\'' +
                '}';
    }

    //to string is having an issue with rendering the information. it won't render the new information
}