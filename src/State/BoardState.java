package State;

/**
 * This class represents a location on a @D Grid Map
 */
public class BoardState extends AbstractState{
    private int x;//The x coordinates
    private int y;//The x coordinates

    /**
     * The constructor of the class
     * @param x - The x coordinates
     * @param y - The y coordinates
     */
    public BoardState(int x, int y)
    {
        super();
        this.x = x;
        this.y =y;

    }

    /**
     * This function will return the y coordinates of the state
     * @return - The y coordinates of the state
     */
    public int getY() {
        return y;
    }


    /**
     * This function will return the x coordinates of the state
     * @return - The x coordinates of the state
     */
    public int getX() {
        return x;
    }
}
