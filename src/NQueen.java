import java.util.ArrayList;
import java.util.List;

public class NQueen {
    private final int nRainhas;

    public NQueen(int rainhas) {
        this.nRainhas = rainhas;
    }

    public void solve() {

        int[][] tabuleiro = createBoard();
        List<String> solutions = new ArrayList<>();

        if (!solve(tabuleiro, 0, solutions)) {
            System.out.print("nenhuma solução encontrada");
            return;
        }
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("solução: " + i + "\n");
            System.out.println(solutions.get(i));
            System.out.println();
        }
    }

    private int[][] createBoard() {
        int[][] tabuleiro = new int[nRainhas][nRainhas];
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = 0;
            }
        }
        return tabuleiro;
    }

    private boolean solve(int[][] tabuleiro, int col, List<String> solutions) {
        if (col >= nRainhas) {
            solutions.add(printSolution(tabuleiro));
            return true;
        }
        for (int i = 0; i < nRainhas; i++) {
            if (isSafe(tabuleiro, i, col)) {
                tabuleiro[i][col] = 1;
                solve(tabuleiro, col + 1, solutions);
                tabuleiro[i][col] = 0;
            }
        }
        return solutions.size() > 0;
    }

    private boolean isSafe(int[][] tabuleiro, int linha, int col) {
        int i, j;

        for (i = 0; i < col; i++)
            if (tabuleiro[linha][i] == 1)
                return false;

        for (i = linha, j = col; i >= 0 && j >= 0; i--, j--)
            if (tabuleiro[i][j] == 1)
                return false;

        for (i = linha, j = col; j >= 0 && i < nRainhas; i++, j--)
            if (tabuleiro[i][j] == 1)
                return false;

        return true;
    }

    private String printSolution(int[][] tabuleiro) {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < nRainhas; i++) {
            for (int j = 0; j < nRainhas; j++)
                msg.append(" " + tabuleiro[i][j] + " ");
            msg.append("\n");
        }
        return msg.toString();
    }
}
