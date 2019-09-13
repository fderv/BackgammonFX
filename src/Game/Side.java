package Game;

public enum Side {
    WHITE(1, true, 15), BROWN(-1, false, 15);

    final int moveDir;

    int checkerLeftOnBoard;
    boolean isToPlay;

    Side(int i, boolean b, int n) {moveDir = i; isToPlay = b; checkerLeftOnBoard = n; }
}