package prova_1.capitulo_3.exercicios.reforco;

/*
 * Created by Jasiel on 28/08/2017.
 */
/*R-3.4 A classe TicTacToe do trecho de código 3.9 e 3.10 (págs. 120 e 121) possui uma falha,
na qual permite um jogador colocar uma marca mesmo depois do jogo já ter sido vencido por alguém.
Modifique a classe de modo que o método putMark dispare uma exceção IllegalStateException para esse caso.
*/
public class R34_TicTacToe {

    public static final int X = 1, O = -1; // players
    public static final int EMPTY = 0; // empty cell
    private int board[][] = new int[3][3]; // game board
    private int player; // current player

    public R34_TicTacToe() {
        clearBoard();
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = EMPTY; // every cell should be empty
        player = X; // the first player is 'X'
    }

    public void putMark(int i, int j) throws IllegalArgumentException {
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2))
            throw new IllegalArgumentException("Invalid board position");
        if (board[i][j] != EMPTY)
            throw new IllegalArgumentException("Board position occupied");
        board[i][j] = player; // place the mark for the current player
        player = -player; // switch players (uses fact that O = - X)
    }

    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3) // row 0
                || (board[1][0] + board[1][1] + board[1][2] == mark * 3) // row 1
                || (board[2][0] + board[2][1] + board[2][2] == mark * 3) // row 2
                || (board[0][0] + board[1][0] + board[2][0] == mark * 3) // column 0
                || (board[0][1] + board[1][1] + board[2][1] == mark * 3) // column 1
                || (board[0][2] + board[1][2] + board[2][2] == mark * 3) // column 2
                || (board[0][0] + board[1][1] + board[2][2] == mark * 3) // diagonal
                || (board[2][0] + board[1][1] + board[0][2] == mark * 3)); // rev diag
    }

    public int winner() {
        if (isWin(X))
            return (X);
        else if (isWin(O))
            return (O);
        else
            return (0);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X:
                        sb.append("X");
                        break;
                    case O:
                        sb.append("O");
                        break;
                    case EMPTY:
                        sb.append(" ");
                        break;
                }
                if (j < 2) sb.append("|"); // column boundary
            }
            if (i < 2) sb.append("\n-----\n"); // row boundary
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        R34_TicTacToe game = new R34_TicTacToe();

        game.putMark(1, 1);
        game.putMark(0, 2);
        game.putMark(2, 2);
        game.putMark(0, 0);
        game.putMark(0, 1);
        game.putMark(2, 1);
        game.putMark(1, 2);
        game.putMark(1, 0);
        game.putMark(2, 0);
        System.out.println(game);
        int winningPlayer = game.winner();
        String[] outcome = {"O wins", "Tie", "X wins"}; // rely on ordering
        System.out.println(outcome[1 + winningPlayer]);
    }
}
