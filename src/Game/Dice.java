package Game;

public enum Dice {
    ONE(1, "file:res/img/dice/1.jpg"),
    TWO(2, "file:res/img/dice/2.jpg"),
    THREE(3, "file:res/img/dice/3.jpg"),
    FOUR(4, "file:res/img/dice/4.jpg"),
    FIVE(5, "file:res/img/dice/5.jpg"),
    SIX(6, "file:res/img/dice/6.jpg");

    private final int number;
private final String path;

    public int getNumber() {
        return number;
    }
    public String getPath() {
        return path;
    }

    Dice(int number, String path) {
        this.number = number;
        this.path = path;
    }
}
