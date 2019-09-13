package Game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static Game.App.BAR_SIDE;

public class BGBar extends Rectangle {

    private List<Checker> checkerList = new ArrayList<>();
    public List<Checker> getCheckerList() { return checkerList; }

    public boolean isEmpty() { return checkerList.isEmpty(); }

    public Checker getChecker() { return checkerList.get(checkerList.size()-1); }

    public void putChecker(Checker checker) {
        checkerList.add(checker);
    }

    public int getCheckerCount() { return checkerList.size(); }

    public void removeChecker() { checkerList.remove(checkerList.size()-1); }

    public BGBar(double x, double y) {
        setWidth(BAR_SIDE);
        setHeight(BAR_SIDE);
        setLayoutX(x);
        setLayoutY(y);
        setFill(Color.LIGHTGRAY);
    }
}
