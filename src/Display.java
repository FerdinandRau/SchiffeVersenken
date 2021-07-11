import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Display {
    public static void clear(int s)
    {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

}
