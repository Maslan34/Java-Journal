package CapstoneProjects.RockScissorPaperGame;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("player-1");
        Player player2 = new Player("player-2");

        Game game = new Game();
        game.add(player1, player2);
        game.start();
    }
}
