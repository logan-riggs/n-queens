import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

class Board
{
    
    private ArrayList<ChessPiece> pieces;
    private int sizeX;
    private int sizeY;
    
    public Board(int height, int width)
    {
        this.sizeX = width;
        this.sizeY = height;

        this.pieces = new ArrayList<ChessPiece>();
    }

    public Board(Board other)
    {
        this.sizeX = other.sizeX;
        this.sizeY = other.sizeY;

        this.pieces = new ArrayList<ChessPiece>();
        for (ChessPiece p : other.pieces)
        {
            ChessPiece myPiece = p.copy();
            this.pieces.add(myPiece);
        }
    }
    
    public void printBoard()
    {
        System.out.println("Board:");
        for (int j = 0; j < sizeY; j++)
        {
            String row = "";
            for (int i = 0; i < sizeX; i++)    
            {
                boolean found = false;
                for (ChessPiece piece : this.pieces)
                {
                    if (piece.getPosition().getX() == i && piece.getPosition().getY() == j)
                    {
                        row += piece.getSymbol();
                        found = true;
                        break;
                    }
                }

                if (!found)
                {
                    row += "*";
                }
            }
            System.out.println(row);
        }
        System.out.println("");
    }

    public void addPiece(ChessPiece piece)
    {
        this.pieces.add(piece);
    }

    public int numberOfRows()
    {
        return sizeY;
    }

    public int numberOfColumns()
    {
        return sizeX;
    }

    public boolean canSafelyPlacePiece(Queen q)
    {
        if (q.getPosition().getX() >= this.sizeX || q.getPosition().getY() >= this.sizeY || q.getPosition().getX() < 0 || q.getPosition().getY() < 0)
        {
            return false;
        }

        for (ChessPiece p : pieces)
        {
            if (p.canAttack(q))
            {
                return false;
            }
        }

        //Check for three pieces in a straight line which means they have the same slope relative to this queen.
        HashMap<BigDecimal, Integer> slopeMap = new HashMap<BigDecimal, Integer>();
        for (ChessPiece otherPiece : pieces)
        {
            BigDecimal y = new BigDecimal(Math.abs(q.position.getY() - otherPiece.getPosition().getY()));
            BigDecimal x = new BigDecimal(Math.abs(q.position.getX() - otherPiece.getPosition().getX()));
            BigDecimal slope = y.divide(x, 10, RoundingMode.HALF_UP);
            if (slopeMap.containsKey(slope))
            {
                Integer val = slopeMap.get(slope);
                val++;
                slopeMap.put(slope, val);
            }
            else
            {
                slopeMap.put(slope, 1);
            }

            if (slopeMap.get(slope) >= 2)
            {
                return false;
            }
        }

        return true;
    }
}