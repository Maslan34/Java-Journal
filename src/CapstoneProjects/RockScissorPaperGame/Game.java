package CapstoneProjects.RockScissorPaperGame;

class Game {
    static boolean isOver;
    Player player1;
    Player player2;

    void add(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    void start() {
        while(!isOver){
            player1.autoMove();
            player2.autoMove();
            processMovement();
            isOver = (Player.turn == 100);
        }
        Player.sc.close();
        displayScores(player1);
        displayScores(player2);
    }


    private void processMovement() {
        if (player1.sign == player2.sign)
        {
            System.out.println("draws!");
            Player.draws++;
        }

        else if(player1.sign == HandSign.PAPER && player2.sign == HandSign.ROCK){
            System.out.println(player1.name + " wins!");
            player1.wins++;
        }
        else if(player1.sign == HandSign.ROCK && player2.sign == HandSign.SCISSOR){
            System.out.println(player1.name + " wins!");
            player1.wins++;
        }

        else if(player1.sign == HandSign.SCISSOR && player2.sign == HandSign.PAPER){
            System.out.println(player1.name + " wins!");
            player1.wins++;
        }
        else{
            System.out.println(player2.name + " wins!");
            player2.wins++;
        }
        Player.turn++;
    }

    private void displayScores(Player player) {
        String info = String.format("Name: %s Wins: %d trials : %d Draws %d ",
                player.name, player.wins, Player.turn, Player.draws);
        System.out.println(info);
    }

}
