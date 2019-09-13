package Game;

public class MoveResult {

    private MoveType moveType;
    public MoveType getMoveType() {
        return moveType;
    }

    private Checker checker;
    public Checker getChecker() {
        return checker;
    }

    public MoveResult(MoveType moveType) {
        this(moveType, null);
    }

    public MoveResult(MoveType moveType, Checker checker) {
        this.moveType = moveType;
        this.checker = checker;
    }
}
