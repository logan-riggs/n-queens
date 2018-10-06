class Location
{
    
    private int posX;
    private int posY;

    public Location(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }

    public int getX()
    {
        return posX;
    }

    public int getY()
    {
        return posY;
    }

    @Override
    public boolean equals(Object other)
    {

        if (this == other)
        {
            return true;
        }

        if (other == null || getClass() != other.getClass())
        {
            return false;
        }


        Location otherLocation = (Location) other;

        return posX == otherLocation.posX && posY == otherLocation.posY;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.posX;
        hash = 53 * hash + this.posY;
        return hash;
    }
}
