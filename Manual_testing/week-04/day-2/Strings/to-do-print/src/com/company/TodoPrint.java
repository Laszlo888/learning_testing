package com.company;

public class TodoPrint {
    public static void main(String... args) {
        String todoText = " - Buy milk\n";
        // Add hozzá a "My todo:" szöveget a todoText szövege elejéhez.
        // Add hozzá a " - Download games" szöveget a todoText szöveg végéhez.
        // Add hozzá a " - Diablo" szöveget a todoText szöveg végéhez,
        // de behúzással.

        // Várt eredmény:

        // My todo:
        //  - Buy milk
        //  - Download games
        //      - Diablo

        String first = "My todo:\n";
        String second = " - Download games\n";
        String third = "\t - Diablo";
        todoText = first + todoText + second + third;
        System.out.println(todoText);
    }
}