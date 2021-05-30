public class NQueen {
    private final int nRainhas;

    public NQueen(int rainhas) {
        this.nRainhas = rainhas;
    }

    public void solve(){
        int[][] tabuleiro = new int [nRainhas][nRainhas];
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = 0;
            }
        }
        if (!solve(tabuleiro, 0)) {
            System.out.print("Solução não encontrada");
            return;
        }
        printSolution(tabuleiro);
    }

    private boolean solve(int[][] tabuleiro, int col){
        if (col >= nRainhas)
            return true;
        for (int i = 0; i < nRainhas; i++) {
            if (isSafe(tabuleiro, i, col)) {
                tabuleiro[i][col] = 1;
                if (solve(tabuleiro, col + 1))
                    return true;
                tabuleiro[i][col] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int[][] tabuleiro, int linha, int col){
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

    private void printSolution(int[][] tabuleiro){
        for (int i = 0; i < nRainhas; i++) {
            for (int j = 0; j < nRainhas; j++)
                System.out.print(" " + tabuleiro[i][j] + " ");
            System.out.println();
        }
    }
}
