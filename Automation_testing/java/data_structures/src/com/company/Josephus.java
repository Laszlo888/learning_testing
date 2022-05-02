package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        // next alive item always killed in a circle
        // which item stay alive
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type number of participants in josephus game: ");
        System.out.println();
        int pcp = scanner.nextInt();
        System.out.println(josephus(pcp));
    }

    private static String josephus(int participantsNumber) {
        ArrayList<Integer> participants = new ArrayList<>();
        ArrayList<Integer> participants2 = new ArrayList<>();
        for (int i = 1; i < participantsNumber + 1; i++) {
            participants.add(i);
            participants2.add(i);
        }

        // count how many null(killed) are in arraylist
        int countKilled;
        int winningSeat = 0;

        do {
            int killed = 0;
            for (int k = 0; k < participants.size(); k++) {
                if (participants.get(k) == null) {
                    killed++;
                }}
                countKilled = killed;

                // if 1 participant left we finish
                if (participantsNumber - killed == 1) {
                    for (int i = 0; i < participants.size(); i++) {
                        if (participants.get(i) != null) {
                            winningSeat = i + 1;
                        }
                    }
                    break;
                } else {
                    for (int i = 0; i < participants.size(); i++) {
                        if (participants.get(i) != null) {
                            // are there any number in the rest of array or everything is null
                            int sum = 0;
                            for(int g=i+1;g<participants.size();g++){
                                if(participants.get(g)!=null){
                                sum += participants.get(g);
                                break;}
                            }
                            if (sum>0) {
                                for (int j = i + 1; j < participants.size(); j++) {
                                    if (participants.get(j) != null) {
                                        participants.set(j, null);
                                        participants2.set(j, null);
                                        break;
                                    }
                                }
                            } else {
                                for (int j = 0; j < participants2.size(); j++) {
                                    if (participants2.get(j) != null) {
                                        participants2.set(j, null);
                                        participants.set(j, null);
                                        break;
                                    }
                                }

                            }
                        }
                    }
                }
            } while (countKilled < participants.size()) ;

            return "Wining seat is: " + winningSeat;
        }
    }

