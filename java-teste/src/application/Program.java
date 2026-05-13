package application;

public class Program {
    public static void main (String[] args) {
        int x = 0;
        int y = 0;
        while (x < 5) {
            if (y < 5) {
                x++;
                if (x < 3) {
                    x--;
                }
            }
            y += 2;
            IO.print(x + "" + y + " ");
            x++;        }
    }
}
