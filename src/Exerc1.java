import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Exerc1 {
    public static void main(String[] args){


    }

    private static Stack<Pair<Integer, Integer>> nQueenSolve(int size) {
        int[][] board = new int[size][size];
        Pair<Integer, Integer> currentPosition = new Pair<>(0, 0);
        List<Pair<Integer, Integer>> battery = new ArrayList<>();
        return nQueenSolveAux(size, board, currentPosition, battery);
    }

    private static Stack<Pair<Integer, Integer>> nQueenSolveAux(int size, int[][] board, Pair<Integer, Integer> currentPosition, List<Pair<Integer, Integer>> battery) {
        if(isValid(currentPosition, battery, size)) {
            battery.add(currentPosition);
        }
        return nQueenSolveAux(size, board, currentPosition, battery);
    }

    private static boolean isValid(Pair<Integer, Integer> currentPosition, List<Pair<Integer, Integer>> battery, int size) {
        int lineIndex = currentPosition.getKey();
        int columnIndex = currentPosition.getValue();
        for(Pair<Integer, Integer> pair : battery) {
            if(pair.getKey() == lineIndex || pair.getValue() == columnIndex) {
                return false;
            }
        }
        for(int i = 1; i < size; i++) {
            Pair<Integer, Integer> NE, NW, SE, SW;
            NE = new Pair<>(currentPosition.getKey() - i, currentPosition.getValue() + i);
            NW = new Pair<>(currentPosition.getKey() - i, currentPosition.getValue() - i);
            SE = new Pair<>(currentPosition.getKey() + i, currentPosition.getValue() + i);
            SW = new Pair<>(currentPosition.getKey() + i, currentPosition.getValue() - i);
            if(NE.getKey() >= 0 && NE.getValue() < size) {
                if(battery.contains(NE)) return false;
            }
            if(NW.getKey() >= 0 && NW.getValue() >= 0) {
                if(battery.contains(NW)) return false;
            }
            if(SE.getKey() < size && SE.getValue() < size) {
                if(battery.contains(SE)) return false;
            }
            if(SW.getKey() < size && SW.getValue() >= 0) {
                if(battery.contains(SW)) return false;
            }
        }
        return true;
    }

    private static List<Pair<Integer, Integer>> generateNextPosition(Pair<Integer, Integer> currentPosition) {

    }
}
