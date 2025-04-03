package debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DebugTask10 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        Iterator it = names.iterator();
        while (it.hasNext()) {
            String name = (String) it.next();
            if (name.startsWith("A")) {
                it.remove();
            }
        }
    }
}
