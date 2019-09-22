package Game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static Game.App.CHECKER_RADIUS;

public class Checker extends Circle {

    private Side side;
    public Side getSide() {
        return side;
    }

    private BGPoint point;
    public BGPoint getPoint() { return point; }

    private BGBar bar;
    public BGBar getBar() { return bar; }

    private double mouseX, mouseY;
    private double oldX, oldY;
    public double getOldX() {
        return oldX;
    }
    public double getOldY() {
        return oldY;
    }

    public Checker(Side side, BGPoint point) {
        this.side = side;
        setRadius(CHECKER_RADIUS);
        setFill(side == Side.WHITE ? (Color.WHITE) : (Color.BROWN));
        setStroke(Color.BLACK);
        setStrokeWidth(0.5);
        moveToPoint(point);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });
        setOnMouseDragged(e -> {
            if (this.point == null && this.bar != null) {
                relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
            }
            else if (this.point != null && this.point.getChecker() == this && this.point.getPointOrder() != 25 && this.point.getPointOrder() != 0) {
                relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
            }
        });
    }

    public void moveToPoint(BGPoint point) {
        BGPoint oldPoint = null;
        if (this.point != null) {
            oldPoint = this.point;
            this.point.removeChecker();
        }
        if (this.bar != null) {
            this.bar.removeChecker();
            this.bar = null;
        }

        this.point = point;
        int x = (int) point.getLayoutX() + 1;
        int y;
        int radiusMultiplier = App.CHECKER_RADIUS * 2;

        if (point.getCheckerCount() >= 5) {
            radiusMultiplier = 160 / (point.getCheckerCount());
            this.point.rearrangeCheckerPositions(false);
        }
        if (oldPoint != null && oldPoint.getCheckerCount() >= 5) {
            oldPoint.rearrangeCheckerPositions(true);
        }
        if (point.getPointOrder() < 13) {
            y = (int) (point.getLayoutY() + point.getCheckerCount() * radiusMultiplier);
        } else {
            y =  410 - (int)(point.getCheckerCount() * radiusMultiplier);
        }
        point.putChecker(this);
        move(x, y);
        this.toFront();
    }

    public void moveToBar(BGBar bar) {
        this.point.removeChecker();
        this.point = null;
        int x = (int) bar.getLayoutX();
        int y = (int) bar.getLayoutY();
        bar.putChecker(this);
        this.bar = bar;
        move(x, y);
        this.toFront();
    }

    public void move(int x, int y) {
        oldX = x;
        oldY = y;
        relocate(oldX, oldY);
    }

    public void abortMove() {
        relocate(oldX, oldY);
    }

    public boolean isFirstCheckerOnPointOrBar() {
        if (this.point == null && this.bar != null)
            return this.bar.getChecker() == this;

        return this.point.getChecker() == this;
    }
}