import java.io.FileNotFoundException;

/**
 * Created by EoinH on 15/05/2017.
 */
public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        ConstituencyReader reader = new ConstituencyReader("Data/ConstDetails");

        reader.printAll();
    }
}
