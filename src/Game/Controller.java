package Game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

import static Game.Side.WHITE;
import static Game.Side.BROWN;
import static Game.App.BAR_X;
import static Game.App.WHITEBAR_Y;
import static Game.App.BROWNBAR_Y;

public class Controller implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //rollDices();
        rollDiceButton.setOnMouseClicked(e -> rollDices());

        rightPane.getChildren().addAll(whiteBar, brownBar);
        rightPane.getChildren().addAll(pointGroup, checkerGroup);
        drawPoints();
        drawCheckers();
        fillTheFreakyCircle();
    }

    private boolean dicesRolled = false;

    private ArrayList<Integer> diceNumbers = new ArrayList<>();
    private int diceNumberCount;

    private Dice leftDice, rightDice;
    private Image leftDiceImage, rightDiceImage;
    private void rollDices() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        switch (randomNum) {
            case 1: {
                leftDice = Dice.ONE;
                break;
            }
            case 2: {
                leftDice = Dice.TWO;
                break;
            }
            case 3: {
                leftDice = Dice.THREE;
                break;
            }
            case 4: {
                leftDice = Dice.FOUR;
                break;
            }
            case 5: {
                leftDice = Dice.FIVE;
                break;
            }
            case 6: {
                leftDice = Dice.SIX;
                break;
            }
        }
        randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        switch (randomNum) {
            case 1: {
                rightDice = Dice.ONE;
                break;
            }
            case 2: {
                rightDice = Dice.TWO;
                break;
            }
            case 3: {
                rightDice = Dice.THREE;
                break;
            }
            case 4: {
                rightDice = Dice.FOUR;
                break;
            }
            case 5: {
                rightDice = Dice.FIVE;
                break;
            }
            case 6: {
                rightDice = Dice.SIX;
                break;
            }
        }

        try {
            leftDiceImage = new Image(leftDice.getPath());
            rightDiceImage = new Image(rightDice.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        leftDiceIV.setImage(leftDiceImage);
        rightDiceIV.setImage(rightDiceImage);

        dicesRolled = true;
        rollDiceButton.setVisible(false);
        int leftDiceNumber = leftDice.getNumber();
        int rightDiceNumber = rightDice.getNumber();

        if (leftDiceNumber == rightDiceNumber) {
            for (int i = 0; i < 4; i++)
                diceNumbers.add(leftDiceNumber);
        } else {
            diceNumbers.add(leftDiceNumber);
            diceNumbers.add(rightDiceNumber);
        }
        diceNumberCount = diceNumbers.size();
    }

    @FXML
    private Button rollDiceButton;

    @FXML
    private ImageView leftDiceIV, rightDiceIV;

    @FXML
    private Pane rightPane;

    @FXML
    private Circle freakyCircle;

    private Group pointGroup = new Group();
    private Group checkerGroup = new Group();
    private List<BGPoint> pointList = new ArrayList<>();

    private BGBar brownBar = new BGBar(BAR_X, BROWNBAR_Y);
    private BGBar whiteBar = new BGBar(BAR_X, WHITEBAR_Y);
    private void drawPoints() {

        BGPoint bgPoint = new BGPoint(Color.LIGHTGRAY, 630, 0, 0);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 581, 0, 1);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 532, 0, 2);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 483, 0, 3);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 434, 0, 4);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 385, 0, 5);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 336, 0, 6);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 252, 0, 7);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 203, 0, 8);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 154, 0, 9);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 105, 0, 10);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 56, 0, 11);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 7, 0, 12);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 7, 250, 13);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 56, 250, 14);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 105, 250, 15);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 154, 250, 16);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 203, 250, 17);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 252, 250, 18);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 336, 250, 19);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 385, 250, 20);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 434, 250, 21);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 483, 250, 22);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#d79800"), 532, 250, 23);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.valueOf("#f29800"), 581, 250, 24);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

        bgPoint = new BGPoint(Color.LIGHTGRAY, 630, 250, 25);
        pointGroup.getChildren().add(bgPoint);
        pointList.add(bgPoint);

    }

    private void drawCheckers() {
        BGPoint point = pointList.get(1);
        for (int i = 0; i < 2; i++) {
            initializeChecker(point, WHITE);
        }

        point = pointList.get(6);
        for (int i = 0; i < 5; i++) {
            initializeChecker(point, BROWN);
        }

        point = pointList.get(8);
        for (int i = 0; i < 3; i++) {
            initializeChecker(point, BROWN);
        }

        point = pointList.get(12);
        for (int i = 0; i < 5; i++) {
            initializeChecker(point, WHITE);
        }

        point = pointList.get(13);
        for (int i = 0; i < 5; i++) {
            initializeChecker(point, BROWN);
        }

        point = pointList.get(17);
        for (int i = 0; i < 3; i++) {
            initializeChecker(point, WHITE);
        }

        point = pointList.get(19);
        for (int i = 0; i < 5; i++) {
            initializeChecker(point, WHITE);
        }

        point = pointList.get(24);
        for (int i = 0; i < 2; i++) {
            initializeChecker(point, BROWN);
        }
    }

    private void initializeChecker(BGPoint point, Side side) {
        Checker checker = new Checker(side, point);
        checker.setOnMouseReleased(e -> {
            if (checker.isFirstCheckerOnPointOrBar()) {
                try {
                    int newPointIndex = toBoard(checker.getLayoutX(), checker.getLayoutY());

                    BGPoint newPoint = pointList.get(newPointIndex);
                    MoveResult result = tryMove(checker, newPoint);

                    switch (result.getMoveType()) {
                        case NONE:
                            checker.abortMove();
                            break;
                        case NORMAL:
                            checker.moveToPoint(newPoint);
                            if (--diceNumberCount == 0)
                                otherPlayersTurn();
                            break;
                        case KILL:
                            Checker checkerToBeKilled = result.getChecker();
                            checkerToBeKilled.moveToBar(checkerToBeKilled.getSide() == WHITE ? (whiteBar) : (brownBar));
                            checker.moveToPoint(newPoint);
                            if (--diceNumberCount == 0)
                                otherPlayersTurn();
                            break;
                    }
                } catch (Exception ex) {
                    checker.abortMove();
                    ex.printStackTrace();
                }
            }
            if (diceNumberCount > 0 && !checkForNextMoveAvailable()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No moves");
                alert.setHeaderText(null);
                alert.setContentText("You cannot play, you pass");
                alert.showAndWait();
                otherPlayersTurn();
                diceNumbers.clear();
            }
        });
        checkerGroup.getChildren().add(checker);
    }

    private MoveResult tryMove(Checker checker, BGPoint newPoint) {

        BGBar checkersBar = (checker.getSide() == BROWN) ? (brownBar) : (whiteBar);

        HashMap<BGPoint, Integer> pointsAllowed = getPlayableMoves(checker);

        if (pointsAllowed.isEmpty()) {
            return new MoveResult(MoveType.NONE);
        }

        if (checker.getSide().isToPlay && dicesRolled && checker.getPoint() != newPoint) {
            if (pointsAllowed.containsKey(newPoint)) {
                if (checkersBar.isEmpty()) {
                    if ((newPoint.getPointOrder() == 25 || newPoint.getPointOrder() == 0) && canGoToSafe(checker.getSide())) {
                        diceNumbers.remove(Integer.valueOf(pointsAllowed.get(newPoint)));
                        return new MoveResult(MoveType.NORMAL);
                    }
                    else if (newPoint.isEmpty() || newPoint.getChecker().getSide() == checker.getSide()) {
                        diceNumbers.remove(Integer.valueOf(pointsAllowed.get(newPoint)));
                        return new MoveResult(MoveType.NORMAL);
                    }
                    else if (newPoint.getCheckerCount() == 1 && newPoint.getChecker().getSide() != checker.getSide()) {
                        diceNumbers.remove(Integer.valueOf(pointsAllowed.get(newPoint)));
                        return new MoveResult(MoveType.KILL, newPoint.getChecker());
                    } else {
                        return new MoveResult(MoveType.NONE);
                    }
                }
                else {
                    if (checker.getBar() != null) {
                        if (newPoint.isEmpty() || newPoint.getChecker().getSide() == checker.getSide()) {
                            diceNumbers.remove(Integer.valueOf(pointsAllowed.get(newPoint)));
                            return new MoveResult(MoveType.NORMAL);
                        }
                        else if (newPoint.getCheckerCount() == 1 && newPoint.getChecker().getSide() != checker.getSide()) {
                            diceNumbers.remove(Integer.valueOf(pointsAllowed.get(newPoint)));
                            return new MoveResult(MoveType.KILL, newPoint.getChecker());
                        } else {
                            return new MoveResult(MoveType.NONE);
                        }
                    }
                    else {
                        return new MoveResult(MoveType.NONE);
                    }
                }
            }
        }
        return new MoveResult(MoveType.NONE);
/*
        if (checker.getSide().isToPlay && (checkersBar.isEmpty() || checker.getBar() != null)) {

            if ((newPoint.isEmpty() || newPoint.getChecker().getSide() == checker.getSide()) && newPoint != checker.getPoint()) {

                if ((newPoint.getPointOrder() == 25 || newPoint.getPointOrder() == 0) && (canGoToSafe(checker.getSide()))) {
                    checker.getSide().checkerLeftOnBoard--;
                    return new MoveResult(MoveType.NORMAL);
                } else if (newPoint.getPointOrder() != 25 && newPoint.getPointOrder() != 0) {
                    return new MoveResult(MoveType.NORMAL);
                } else {
                    return new MoveResult(MoveType.NONE);
                }
            }

            else if (newPoint.getCheckerCount() == 1 && newPoint.getChecker().getSide() != checker.getSide()) {
                return new MoveResult(MoveType.KILL, newPoint.getChecker());
            }
        }
        return new MoveResult(MoveType.NONE);*/
    }

    private HashMap<BGPoint, Integer> getPlayableMoves(Checker checker) {
        HashMap<BGPoint, Integer> pointsAllowed = new HashMap<>();
        for (int i : diceNumbers) {
            int n;
            if (checker.getBar() != null) {
                int starting = (checker.getSide() == whiteSide) ? (0) : (25);
                n = starting + (checker.getSide().moveDir * i);
            } else {
                n = checker.getPoint().getPointOrder() + (checker.getSide().moveDir * i);
            }
            if (n > 25 && canGoToSafe(checker.getSide())) {
                n = 25;
                BGPoint p = pointList.get(n);
                pointsAllowed.put(p, i);
            }
            else if (n < 0 && canGoToSafe(checker.getSide())) {
                n = 0;
                BGPoint p = pointList.get(n);
                pointsAllowed.put(p, i);
            }
            else if (n > 0 && n < 25){
                BGPoint p = pointList.get(n);
                if (p.getCheckerList().size() < 2 || p.getChecker().getSide() == checker.getSide()) {
                    pointsAllowed.put(p, i);
                }
            }
        }
        return pointsAllowed;
    }

    private boolean checkForNextMoveAvailable() {
        Side side = (whiteSide.isToPlay) ? (WHITE) : (BROWN);
        BGBar bar = (side == WHITE) ? (whiteBar) : (brownBar);
        if (!bar.isEmpty()) {
            if (getPlayableMoves(bar.getChecker()).isEmpty()) {
                return false;
            }
        }

        for (BGPoint bgp : pointList) {
            if (!bgp.isEmpty() && bgp.getChecker().getSide() == side) {
                if (!getPlayableMoves(bgp.getChecker()).isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canGoToSafe(Side side) {
        List<BGPoint> list;
        if (side == WHITE) {
            list = pointList.subList(1, 7);
        } else {
            list = pointList.subList(19, 25);
        }
        int count = 0;
        for (BGPoint p : list) {
            if (p.getChecker() != null && p.getChecker().getSide() == side) {
                for (Checker c : p.getCheckerList()) {
                    count++;
                }
            }
        }

        if (count == side.checkerLeftOnBoard)
            return true;
        return false;
    }

    Side whiteSide = WHITE;
    Side brownSide = BROWN;
    private void otherPlayersTurn() {
        whiteSide.isToPlay = !whiteSide.isToPlay;
        brownSide.isToPlay = !brownSide.isToPlay;

        dicesRolled = false;
        rollDiceButton.setVisible(true);
        fillTheFreakyCircle();
    }

    private void fillTheFreakyCircle() {
        Color color;
        if (whiteSide.isToPlay) {
            color = Color.WHITE;
        } else {
            color = Color.BROWN;
        }
        freakyCircle.setFill(color);
    }

    private int toBoard(double x, double y) throws Exception {
        int pointNumber = -1;
        if (y >= 0 && y <= 200) {
            if (x >= 7 && x <= 49) {
                pointNumber = 12;
            } else
            if (x >= 56 && x <= 98) {
                pointNumber = 11;
            } else
            if (x >= 105 && x <= 147) {
                pointNumber = 10;
            } else
            if (x >= 154 && x <= 196) {
                pointNumber = 9;
            } else
            if (x >= 203 && x <= 245) {
                pointNumber = 8;
            } else
            if (x >= 252 && x <= 294) {
                pointNumber = 7;
            } else
            if (x >= 336 && x <= 378) {
                pointNumber = 6;
            } else
            if (x >= 385 && x <= 427) {
                pointNumber = 5;
            } else
            if (x >= 434 && x <= 476) {
                pointNumber = 4;
            } else
            if (x >= 483 && x <= 525) {
                pointNumber = 3;
            } else
            if (x >= 532 && x <= 574) {
                pointNumber = 2;
            } else
            if (x >= 581 && x <= 623) {
                pointNumber = 1;
            }
            if (x >= 630 && x <= 672) {
                pointNumber = 0;
            }
        } else
        if (y >= 250 && y <= 450) {
            if (x >= 7 && x <= 49) {
                pointNumber = 13;
            } else
            if (x >= 56 && x <= 98) {
                pointNumber = 14;
            } else
            if (x >= 105 && x <= 147) {
                pointNumber = 15;
            } else
            if (x >= 154 && x <= 196) {
                pointNumber = 16;
            } else
            if (x >= 203 && x <= 245) {
                pointNumber = 17;
            } else
            if (x >= 252 && x <= 294) {
                pointNumber = 18;
            } else
            if (x >= 336 && x <= 378) {
                pointNumber = 19;
            } else
            if (x >= 385 && x <= 427) {
                pointNumber = 20;
            } else
            if (x >= 434 && x <= 476) {
                pointNumber = 21;
            } else
            if (x >= 483 && x <= 525) {
                pointNumber = 22;
            } else
            if (x >= 532 && x <= 574) {
                pointNumber = 23;
            } else
            if (x >= 581 && x <= 623) {
                pointNumber = 24;
            } else
            if (x >= 630 && x <= 672) {
                pointNumber = 25;
            }
        }
        if (pointNumber == -1) throw new Exception("Out of bounds");
        return pointNumber;
    }
}