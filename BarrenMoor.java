import java.util.Scanner;

/*my game mostly works, there are a couple of bugs I'm not happy with - and had I done something more advanced/used more classes or inheritance I probably could
 have got the input options to run in a more complex way, as it stands they are very simple but I struggled with the inheritance this morning and
 would rather have a simple code that mostly runs* so I instead chose to put everything in its own method and call them sequentially in order to run the game*/

public class BarrenMoor {

    //I put the scanner in my class so I didn't have to keep rewriting the scanner in every method
    Scanner reader = new Scanner(System.in);

    public static void main(String[] args) { //main method

        //the strings I used in the code are declared up here
        String north;
        String east;
        String west;
        String south;
        String yes;
        String no;


        //call the other methods used in the program
        BarrenMoor y = new BarrenMoor();
        y.barrenMoor();
        BarrenMoor z = new BarrenMoor();
        z.setUserinput();
        BarrenMoor b = new BarrenMoor();
        b.whichDirection();
        BarrenMoor c = new BarrenMoor();
        c.userInputTwo();
        BarrenMoor d = new BarrenMoor();
        d.boxOpts();

    }


    //the first method, this is where the first dialogue/options of the game will be
    public void barrenMoor() {
        String look;

        //the first line the user will see
        System.out.println("You awaken to find yourself in a barren moor.");


        //input scanner - so that the user can input data into the console
        Scanner reader = new Scanner(System.in);


        //first user input option
        System.out.println("Try 'look' ");
        look = reader.next();


        //more game output lines that expand the premise
        System.out.println("Grey foggy clouds float oppressively close to you, reflected in the murky grey water which reaches up your shins.");
        System.out.println("Some black plants barely poke out of the shallow water.");
        System.out.println("You notice a small watch like device in your left hand.");
        System.out.println("It has hands like a watch, but the hands don't seem to tell time.");

        //input options - the following code is where statements will return depending on what option the user inputs
        System.out.println("Try 'north', 'south', 'east' or 'west'");
    }

    //a method for the inital user direction input that gives the first set of options/consequences
    private void setUserinput() {

        //this is used to specify what java will search for when the user inputs a direction
        String userinput = reader.next();

        //if else statement that will print the line corresponding with the user input

        if (userinput.equals("north")) {
            System.out.println("Looks like you're heading into a nettle bush, maybe not the best choice");
            //calling the method that the user input will lead to. I have used this throughout the program but I won't note it every time
            whichDirection();
        } else if (userinput.equals("east")) {
            System.out.println("You're heading deeper into the swamp, the water is now waist deep");
            whichDirection();
        } else if (userinput.equals("west")) {
            System.out.println("In the distance you see something glimmering. Maybe you should head toward it!");
            whichDirection();
        } else if (userinput.equals("south")) {
            System.out.println("Looks like a waterfall, but you don't have a boat!");
            whichDirection();


        }
    }

    //the method for continuation of the game. I had a problem with this looping but it was because I needed to put the user input into its own method
    //However, my new problem is that System.out in the barrenMoorCont prints the line twice and I am not sure why.
    private void whichDirection() {
        System.out.println("Which direction would you like to try next?");
    }


    //the second set of input options continuing on once the user has chosen their first direction
    private void userInputTwo() {

        String useropts = reader.next();

        if (useropts.equals("north")) {
            System.out.println("You've been stung badly by nettles!");
            endingTwo();
        } else if (useropts.equals("east")) {
            System.out.println("You try to swim further into the swamp, it's very deep now!");
            endingThree();
        } else if (useropts.equals("west")) {
            System.out.println("You run forwards toward the glimmer, which turns out to be a box. Could this be what it looks like?");
            box();
        } else if (useropts.equals("south")) {
            System.out.println("You keep going toward the waterfall and decide it doesn't look too high, so you can probably jump off.");
            endingFour();
        }

    }

    //There are different ending choices depending on the choices the user picks in the barrenMoorCont method.
    private void box() {
        System.out.println("You arrive at the box, and find that it's locked. Would you like to pick the lock?");
    }

    //the options once the player arrives at the treasure box
    private void boxOpts() {
        String boxinput = reader.next();
        if (boxinput.equals("yes")) {
            System.out.println("Congratulations, you found the treasure!");
            win();
            endingFive();

        } else if (boxinput.equals("no")) {
            System.out.println("You decide that after all of this, you don't even want to open the box. What's wrong with you? Let's go back and try again!");
            barrenMoor(); //this loops back to barrenmoor method but then ends the process when you type 'look' - not sure why and unable to fix!
        }
    }

    //winning ending
    private void win() {
        System.out.println("You will be heralded forever as the finder of the lost treasure of madeupland! Now, return to your realm to be treated like the royalty you are!");
    }


    //the following endings correspond with the choices the player has made in the game leading up to this point
    //if the player chooses north consistently
    private void endingTwo() {
        System.out.println("You have been stung a lot and have an allergic reaction, now you're dead.");
        endingFive();
    }

    //if the player chooses east consistently
    private void endingThree() {
        System.out.println("You can't swim! Why would you try to swim when you can't swim? Now you're dead.");
        endingFive();
    }

    //if the player chooses south consistently
    private void endingFour() {
        System.out.println("You jumped off the waterfall, maybe you thought you could fly. Alas, it turns out you don't have superpowers and now you're dead.");
        endingFive();
    }

    //this ends the process
    private void endingFive() {
        System.out.println("Game Over");
    }


    }



 //BELOW IS SOME OF THE CODE FROM THE DIFFERENT METHODS I TRIED TO USE

//        int direction = 3;
//
//        switch (direction) {
//            case 1:
//                System.out.println("no");
//
//            case 2:
//                System.out.println("no");
//
//            case 3:
//                System.out.println("yes");
//
//            case 4:
//                System.out.println("no");
//    }




//        north = input.next();
//        System.out.println("You ran into a bush of stinging nettles!");
//        east = input.next();
//        System.out.println("You are running deeper into the swamp!");
//        west = input.next();
//        System.out.println("compass reads 5 m");
//        south = input.next();
//        System.out.println("Through the fog, you can see a high wall. Looks like this is the wrong direction!");
//        north = input.next();
//        System.out.println("You are surrounded by nettles, seemingly for miles further north, it may be best to go back");
//        east = input.next();
//        System.out.println("You are now waist deep in the swampy water. Not bad if you feel like going for a swim, but this doesn't seem to be the right direction");
//        west = input.next();
//        System.out.println("Compass reads 1m");
//        south = input.next();
//        System.out.println("You approach the wall, looks like it's unclimbable.");



//        int iNorth = Integer.parseInt(north);
//        int iEast = Integer.parseInt(east);
//        int iWest = Integer.parseInt(west);
//        int iSouth = Integer.parseInt(south);
//
//        int[] arrayOfInts = {iNorth, iEast, iSouth, iWest};
//
//        System.out.println(iNorth);
//        System.out.println(iEast);
//        System.out.println(iWest);
//        System.out.println(iSouth);

//
//        for (iNorth = 0; <arrayOfInts.length; i++;)



//I TRIED ADDING EXTRA METHODS TO SEE IF I COULD STOP THE BARRENCONT METHOD LOOPING TWICE BUT THIS DID NOT WORK SO I DISCARDED THE CODE AS IT WAS UNNECESSARY COMPLICATION
//    private void backOrForwardOne() {
//        System.out.println("Would you like to go back, or continue forward?");
//        String backorforward = reader.next();
//
//        if (backorforward.equals("foward")) {
//            endingTwo();
//        } else {
//        if (backorforward.equals("back")) {
//            barrenMoorCont();
//        }
//        }
//    }
//    private void backOrForwardTwo() {
//        System.out.println("Would you like to go back, or continue forward?");
//        String backorforwardtwo = reader.next();
//
//        if (backorforwardtwo.equals("foward")) {
//            endingThree();
//        } else {
//            if (backorforwardtwo.equals("back")) {
//                barrenMoorCont();
//            }
//        }
//    }
//
//    private void backOrForwardThree() {
//        System.out.println("Would you like to go back, or continue forward?");
//        String backorforwardthree = reader.next();
//
//        if (backorforwardthree.equals("foward")) {
//            endingFour();
//        } else {
//            if (backorforwardthree.equals("back")) {
//                barrenMoorCont();
//            }
//        }
//    }