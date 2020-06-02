package Java;

public class Loops_Week_2 {
    public static void main(String[] args) {

        boolean over100 = false;
        int index = 0;
        while(!over100){
            System.out.println("Current number: " + index);
            index += 2;
            if(index > 100) over100 = true;
        }

        boolean under0 = false;
        index = 100;
        while(!under0){
            System.out.println("Current number: " + index);
            index -= 3;
            if(index < 0) under0 = true;
        }

        for(int i = 1; i < 101; i += 2){
            System.out.println("Current number: " + i);
        }

        for(int i = 1; i < 101; i++){
            if(i % 3 == 0 && i % 5 != 0) System.out.println("Hello");
            else if(i % 5 == 0 && i % 3 != 0) System.out.println("World");
            else if(i % 3 == 0 && i % 5 == 0) System.out.println("Hello World");
            else System.out.println("Current number: " + i);
        }
    }
}
