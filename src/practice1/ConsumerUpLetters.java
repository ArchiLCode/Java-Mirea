package practice1;

import java.util.function.Consumer;

public class ConsumerUpLetters implements Consumer {

    @Override
    public void accept(Object o) {
        String string = o.toString();
        for (int i = 2; i < string.length(); i += 3) {
            string = string.substring(0, i) + string.substring(i, i+1).toUpperCase() + string.substring(i+1);
        }
        System.out.println(string);
    }
}
