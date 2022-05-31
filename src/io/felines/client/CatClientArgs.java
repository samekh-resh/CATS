package io.felines.client;

import io.felines.Cat;
import io.felines.FurColor;

import java.util.Arrays;

class CatClientArgs {

    public static void main(String[] args) {
        //first we need to check the presence of the required arguments, which are 6

        if (args.length < 6){
            String usage = "usage: when entering information it must be <name> <age> <areClawsTrimmed> <hunger level> <io.felines.FurColor> <speedAdverb>";
            String example = "Example: java io.felines.client.CatClientArgs Stella 8 true 7.5 red clumsily";
            String note = "supported colors WHITE, BLACK, RED, BLUE, GREY, CREAM, BROWN, CINNAMON, FAWN;";
            System.out.println(usage);
            System.out.println(example);
            System.out.println(note);
            return;//return from the main()

        }

        System.out.println("You provided " + args.length + " arguments");
        System.out.println();
        //this is the part where I take the args, and convert them to their necessary types
        System.out.println(Arrays.toString(args));
        String clientCatName = args[0];
        System.out.println(clientCatName);
        int clientCatAge = Integer.parseInt(args[1]);
        boolean clientAreClawsTrimmed = Boolean.parseBoolean(args[2]);
        double clientCatHungerLvl = Double.parseDouble(args[3]);
        FurColor clientFurColor = FurColor.valueOf(args[4].toUpperCase());
        String clientCatSpeedAdverb = args[5];

       Cat race = new Cat(clientCatName, clientCatAge, clientAreClawsTrimmed, clientCatHungerLvl, clientFurColor, clientCatSpeedAdverb);

       race.growled();
       race.showBelly();
       race.runAround();

        System.out.println(race);

    }
}
