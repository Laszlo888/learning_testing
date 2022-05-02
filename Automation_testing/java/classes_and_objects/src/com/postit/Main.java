package com.postit;

public class Main {
    public static void main(String[] args) {

        // Create a PostIt class that has a backgroundColor represented by a string
        // a text on it, a textColor represented by a string
        // Create a few example post-it objects:
        // an orange with blue text: "Idea 1"
        // a pink with black text: "Awesome"
        // a yellow with green text: "Superb!"

        PostIt pI1 = new PostIt("orange", "Idea1", "blue");
        PostIt pI2 = new PostIt("pink", "Awesome", "black");
        PostIt pI3 = new PostIt("yellow", "Superb!", "green");
    }
}
