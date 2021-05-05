import javafx.util.Pair;
import java.util.Stack;

public class Exerc1 {
    public static void main(String[] args){


    }

    private static Stack<Pair<Integer, Integer>> nQueenSolve(int size) {
        int[][] board = new int[size][size];
        Pair<Integer, Integer> currentPosition = new Pair<>(0, 0);
        Stack<Pair<Integer, Integer>> battery = new Stack<>();
        return nQueenSolveAux(size, board, currentPosition, battery);
    }

    private static Stack<Pair<Integer, Integer>> nQueenSolveAux(int size, int[][] board, Pair<Integer, Integer> currentPosition, Stack<Pair<Integer, Integer>> battery) {

        return nQueenSolveAux(size, board, currentPosition, battery);
    }

    private static boolean isValid() {

    }
}
