import java.util.Scanner;

public class CowsAndBulls {
    private int randomFourDigitNumber;
    String number;
    boolean playingOrFinished;
    int counterGuesses;

    public CowsAndBulls() {
        randomFourDigitNumber = (int) (Math.random() * 9000) + 1000;
        number = "" + randomFourDigitNumber;
        playingOrFinished = true;
        counterGuesses = 0;
    }

    public int getRandomFourDigitNumber() {
        return randomFourDigitNumber;
    }

    public String getNumber() {
        return number;
    }

    public boolean isPlayingOrFinished() {
        return playingOrFinished;
    }

    public int getCounterGuesses() {
        return counterGuesses;
    }

    public static String guess() {
        CowsAndBulls cAb = new CowsAndBulls();
        int temp = 0;
        //System.out.println(cAb.number);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Please type a four digit number (for example: 3456): ");
            String input = scanner.nextLine();
            //input must be length = 4
            if (input.length() != 4) {
            } else {
                int cow = 0;
                int bull = 0;
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == cAb.number.charAt(i)) {
                        cow++;
                    } else {
                        for (int j = 0; j < cAb.number.length(); j++) {
                            if (input.charAt(i) == cAb.number.charAt(j) && i != j) {
                                bull++;
                            }
                        }
                    }
                }
                temp = cow;
                if (cow == 4) {
                    break;
                } else {
                    cAb.counterGuesses++;
                    System.out.println(cAb.counterGuesses + ". attempt       " + cow + " cow, " + bull + " bull");
                }
            }
        } while (temp != 4);
        cAb.playingOrFinished = false;
        return "You catched it!";
    }
}
