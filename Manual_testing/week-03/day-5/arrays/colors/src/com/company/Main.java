package com.company;

public class Main {

    public static void main(String[] args) {
        // - Készíts egy kétdimenziós tömböt
//   ami megadott színek különböző árnyalatait tartalmazza
// - A `colors[0]` a zöld árnyalatait tárolja:
//   `"lime", "forest green", "olive", "pale green", "spring green"`
// - A `colors[1]` a piros árnyalatait:
//   `"orange red", "red", "tomato"`
// - A `colors[2]` pedig a pink árnyalatait:
//   `"orchid", "violet", "pink", "hot pink"


        String[][] colors = new String[3][5];
        colors[0] = new String[]{"lime", "forest green", "olive", "pale green", "spring green"};
        colors[1] = new String[]{"orange red", "red", "tomato"};
        colors[2] = new String[]{"orchid", "violet", "pink", "hot pink"};

        for (int j = 0; j < colors.length; j++) {
            for (int k = 0; k < colors[j].length; k++) {

                System.out.print(colors[j][k] + ", ");
            }
            System.out.println();
        }

    }
}
