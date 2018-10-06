abstract class ChessPiece
{
    protected Location position;

    public ChessPiece()
    {
        this.position = new Location(0,0);
    }

    public ChessPiece(int x, int y)
    {
        this.position = new Location(x, y);
    }

    public ChessPiece(ChessPiece other)
    {
        this.position = new Location(other.getPosition().getX(), other.getPosition().getY());
    }

    public abstract ChessPiece copy();

    public Location getPosition()
    {
        return position;
    }

    public String getSymbol()
    {
        return "?";
    }
    
    public boolean canAttack(ChessPiece otherPiece)
    {
        return false;
    }
}