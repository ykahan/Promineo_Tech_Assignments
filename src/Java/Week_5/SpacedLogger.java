package Java.Week_5;

import java.util.ArrayList;

public class SpacedLogger implements Logger {
    public void Log(String str){
        ArrayList<Character> al = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            al.add(str.charAt(i));
        }

        for(int i = 0; i < al.size(); i += 2){
            al.add(i + 1, ' ');
        }

        String output = getString(al);

        output = output.trim();

        System.out.println(output);
    }

    public void Error(String str){
        System.out.print("Error: ");
        Log(str);

    }

    public static void main(String[] args) {
        SpacedLogger sl = new SpacedLogger();
        sl.Error("Snoopy come home!");
    }

    public String getString(ArrayList<Character> al){
        String output = "";
        for(int i = 0; i < al.size(); i++){
            output += al.get(i);
        }
        return output;
    }
}
