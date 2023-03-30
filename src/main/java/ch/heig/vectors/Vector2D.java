package ch.heig.vectors;

/**
 * Represents a position in two dimensions.
 *
 * @version 1.0 - 30.03.2023
 */
public class Vector2D {
    private int x;
    private int y;

    /**
     * Creates a new vector with the given coordinates.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the coordinates of this vector.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the x coordinate of this vector.
     *
     * @param x The x coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate of this vector.
     *
     * @param y The y coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the x coordinate of this vector.
     *
     * @return The x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of this vector.
     *
     * @return The y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Return the string representation of this vector.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return "Vector2D[" + x + ", " + y + "]";
    }
}
