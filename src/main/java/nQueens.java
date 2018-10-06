 import java.util.ArrayList;

class NQueens
{
    public static void solve(Board board, int k, ArrayList<Board> solutions)
    {
        //For now just return the first solution.
        if (solutions.size() > 0)
        {
            return;
        }

        int n = board.numberOfRows();
        if (k == n)
        {
            solutions.add(board);
        }
        else
        {
            for (int i = 0; i < n; i++)
            {
                Queen q = new Queen(i,k);
                if (board.canSafelyPlacePiece(q))
                {
                    Board nextBoard = new Board(board);
                    nextBoard.addPiece(q);
                    {
                        solve(nextBoard, k+1, solutions);
                    }
                }
            }
        }
    }

    public static void solve(int queens)
    {
        Board board = new SquareBoard(queens);
        ArrayList<Board> solutions = new ArrayList<Board>(1);
        solve(board, 0, solutions);
        if (solutions.size() > 0)
        {
            System.out.println("Placed all queens.");
            solutions.get(0).printBoard();
        }
        else
        {
            System.out.println("Could not place all queens.");
        }
    }
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Must pass the number of queens as an argument.");
            System.exit(1);
        }
        
        int queens = 0;
        try
        {
		    queens = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Could not parse input.");
            System.exit(1);    
        }
        System.out.println("Solving for " + queens + " queens.");
        
        solve(queens);

    }
}