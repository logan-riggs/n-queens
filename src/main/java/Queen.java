class Queen extends ChessPiece
{
    public Queen(int x, int y)
    {
        super(x, y);
    }

    public Queen(ChessPiece other)
    {
        this.position = new Location(other.getPosition().getX(), other.getPosition().getY());
    }

    public String getSymbol()
    {
        return "Q";
    }

    public ChessPiece copy()
    {
        //This makes sure we get the right sublcass when copying the abstract class reference.
        Queen q = new Queen(this);
        return q;
    }

    public boolean canAttack(ChessPiece otherPiece)
    {
        //Rows and columns.
        if (this.position.getX() == otherPiece.getPosition().getX() ||
            this.position.getY() == otherPiece.getPosition().getY())
        {
            return true;
        }
        
        //Diagonals.
        if (Math.abs(this.position.getX() - otherPiece.getPosition().getX()) ==
            Math.abs(this.position.getY() - otherPiece.getPosition().getY()))
        {
            return true;
        }

        return false;
    }    
}