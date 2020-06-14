package Java.Week_6;

public class Messages {
    public static void print(String str){
        System.out.println(str);
    }

    public static String winner(Player player){
        return player.getName() + " Wins!";
    }

    public static String draw(){
        return "Draw";
    }

    public static String finalScore(Player player1, Player player2){
        StringBuilder sb = new StringBuilder();
        sb.append("Final Score:\n");
        sb.append(player1.getName() + ": " + player1.getScore() + "\n");
        sb.append(player2.getName() + ": " + player2.getScore() + "\n");
        return sb.toString();
    }

    public static String numGames(){
        return "How many games?";
    }
}
