package dominoes;

import java.util.ArrayList;
import java.util.List;

public class Dominoes {
    public static void main(String[] args) {
        List<Domino> dominoes = initializeDominoes();
        // You have the list of Dominoes
        // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
        // eg: [2, 4], [4, 3], [3, 5] ...

        for (int i = 0; i < dominoes.size() - 1; i++) {
            int right = dominoes.get(i).getRightSide();
            for (int j = i + 1; j < dominoes.size(); j++) {
                if (dominoes.get(j).getLeftSide() == right) {
                    Domino temp = dominoes.get(i + 1);
                    dominoes.set(i + 1, dominoes.get(j));
                    dominoes.set(j, temp);
                    break;
                }
            }
        }
        System.out.println(dominoes);
    }

    static List<Domino> initializeDominoes() {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));
        return dominoes;
    }
}
