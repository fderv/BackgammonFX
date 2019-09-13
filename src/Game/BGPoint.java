package Game;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Game.App.POINT_HEIGHT;
import static Game.App.POINT_WIDTH;

public class BGPoint extends Rectangle {


    private int pointOrder;
    public int getPointOrder() {
        return pointOrder;
    }

    private List<Checker> checkerList = new ArrayList<>();
    public List<Checker> getCheckerList() { return checkerList; }

    public boolean isEmpty() { return checkerList.isEmpty(); }

    public Checker getChecker() {
        if (isEmpty()) return null;
        return checkerList.get(checkerList.size()-1);
    }

    public void putChecker(Checker checker) {
        checkerList.add(checker);
    }

    public int getCheckerCount() { return checkerList.size(); }

    public void removeChecker() { checkerList.remove(checkerList.size()-1); }

    public BGPoint(Color color, int x, int y, int order) {
        setHeight(POINT_HEIGHT);
        setWidth(POINT_WIDTH);
        setFill(color);
        this.pointOrder = order;
        relocate(x, y);
    }

    public void rearrangeCheckerPositions(boolean implementToOldPoint) {
        int multiplier = App.CHECKER_RADIUS * 2;

        if (!implementToOldPoint && getCheckerCount() >= 5) {
            multiplier = 160 / getCheckerCount();
        } else
        if (implementToOldPoint && getCheckerCount() > 5) {
            multiplier = 160 / (getCheckerCount()-1);
        }

        int checkerCount = this.getCheckerCount();
        for (int i = 0; i < checkerCount; i++) {
            Checker checker = this.getCheckerList().get(i);
            int x = (int) this.getLayoutX() + 1;
            int y;
            if (this.getPointOrder() < 13) {
                y = (int) (this.getLayoutY() + i * multiplier);
            } else {
                y =  410 - (int)(i * multiplier);
            }
            checker.move(x, y);
        }
    }
}