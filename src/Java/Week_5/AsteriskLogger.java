package Java.Week_5;

public class AsteriskLogger implements Logger {

    public void Log(String str){
        System.out.println("***" + str + "***");
    }

    public void Error(String str){
        String asts = "";
        for(int i = 0; i < str.length(); i++){
            asts += "*";
        }

        Log(asts);
        Log(str);
        Log(asts);
    }

    public static void main(String[] args) {
        AsteriskLogger al = new AsteriskLogger();
        al.Error("There can be only three; one to embody power, one to crave it, and one to play World of Warcraft");
    }
}
