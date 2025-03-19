import java.util.*;
public class WinnerTree {
    private int[] tree;
    private int[] players;
    private int numPlayers;

    public WinnerTree(int[] players) {
        this.players = players;
        this.numPlayers = players.length;
        int treeSize = 2 * numPlayers - 1;
        this.tree = new int[treeSize];
        buildWinnerTree();
    }

    private void buildWinnerTree() {
        for (int i = numPlayers - 1; i < tree.length; i++) {
            tree[i] = i - (numPlayers - 1);
        }

        for (int i = numPlayers - 2; i >= 0; i--) {
            int left = tree[2 * i + 1];
            int right = tree[2 * i + 2];

            tree[i] = (players[left] > players[right]) ? left : right;
        }
    }

    public int getWinner() {
        return players[tree[0]];
    }

    public static void main(String[] args) {
        int[] players = {3, 7, 1, 9, 4, 2, 8, 5};
        WinnerTree winnerTree = new WinnerTree(players);
        System.out.println("The winner is: " + winnerTree.getWinner());
        Arrays.sort(players);
        System.out.println(players[0]);
    }
}