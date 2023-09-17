import java.util.*;
class TicTacToe {
    static char[][] board;

    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }

    void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void dispBoard() {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");

        }
    }

    static void placemark(int row, int col, char mark) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            board[row][col] = mark;
        } else {
            System.out.println("Invalid Position");
        }

    }

    static boolean checkColWin() {
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    static boolean checkRowWin() {
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;

    }

    static boolean CheckDiagWin() {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
                board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        } else {
            return false;
        }
    }

    static boolean checkdraw() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
    abstract class Player {
        String name;
        char mark;

        abstract void makemove();

        boolean isValidMove(int row, int col) {
            if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
                if (TicTacToe.board[row][col] == ' ') {
                    return true;
                }
            }
            return false;
        }

    }


    class HumanPlayer extends Player {

        HumanPlayer(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }

        void makemove() {
            Scanner sc = new Scanner(System.in);
            int row, col;
            do {
                System.out.println("Enter the row and col");
                row = sc.nextInt();
                col = sc.nextInt();
            } while (!isValidMove(row, col));
            TicTacToe.placemark(row, col, mark);
        }

    }

    class AIPlayer extends Player {

        AIPlayer(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }

        void makemove() {
            Scanner sc = new Scanner(System.in);
            int row, col;
            do {
                Random r = new Random();
                row = r.nextInt(3);
                col = r.nextInt(3);
            } while (!isValidMove(row, col));
            TicTacToe.placemark(row, col, mark);
        }
    }


    public class LaunchGame {
        public static void main(String[] args) {
            TicTacToe t = new TicTacToe();
            Scanner sc=new Scanner(System.in);
            System.out.println("Welcome To X & O Showdown");
            System.out.println("Enter 1 If you Don't Have anybody to Play With ");
            System.out.println("Enter 2 If You Want to Play with Your Friend1" +
                    " ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:

                    System.out.println("Player 1 Please Enter Your Name ");
                    String Pl = sc.nextLine();
                    System.out.println("Thank You " + Pl);
                    System.out.println("As I think You Are Alone and U Don't Have Anybody to Play So Don't be Sad . Here is Your Friend A.I . I will be Playing With You ");
                    System.out.println("Lets See Who Wins ");

                    HumanPlayer hp = new HumanPlayer(Pl, 'X');
                    AIPlayer p2 = new AIPlayer("AI", 'O');
                    Player cp;
                    cp = hp;
                    while (true) {
                        System.out.println(cp.name + " turn");
                        cp.makemove();
                        TicTacToe.dispBoard();
                        if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() ||
                                TicTacToe.CheckDiagWin()) {
                            System.out.println("Congratulations " + cp.name + "You Have Won !!!!");
                            break;
                        } else if (TicTacToe.checkdraw()) {
                            System.out.println("OOPS !!!! Its a Slatemate");
                            System.out.println("And The Rivalry has Ended ");
                            System.out.println("So Shake Your Hands ");
                            break;
                        }
                        {
                            if (cp == hp) {
                                cp = p2;
                            } else {
                                cp = hp;
                            }
                        }
                    }
                    break;
                case 2:

                    System.out.println("Player 1 Please Enter Your Name ");
                    String P1 = sc.nextLine();
                    System.out.println("Thank You " + P1);
                    System.out.println("Player 2 Please Enter Your Name ");
                    String P2 = sc.nextLine();
                    System.out.println("Thank You " + P2);
                    System.out.println("Lets Have a Battle Between "+P1+" VS "+P2);
                    System.out.println("Lets See Who Wins ");
                    System.out.println("Best of Luck "+P1+" and "+ P2);
                    HumanPlayer p1 = new HumanPlayer(P1, 'X');
                    HumanPlayer hp2 = new HumanPlayer(P2, 'O');
                    HumanPlayer current_player;
                    current_player = p1;
                    while (true) {
                        System.out.println(current_player.name + " turn");
                        current_player.makemove();
                        TicTacToe.dispBoard();
                        if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() ||
                                TicTacToe.CheckDiagWin()) {
                            System.out.println("Congratulations " + current_player.name + "You Have Won !!!!");
                            System.out.println("Indeed its was a Superbbbbbb Turn !!!!!!!!!");
                                                        break;
                        } else if (TicTacToe.checkdraw()) {
                            System.out.println("Game is Draw");
                            break;
                        }
                        {
                            if (current_player == p1) {
                                current_player = hp2;
                            } else {
                                current_player = p1;
                            }
                        }
                    }
                    break;

                default:

                    System.out.println("Invalid Option !!!!");
            }


        }
    }

