package domain.model;

public class Grid {
    private final int width;
    private final int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0
                && x <= width
                && y <= height;
    }
}
