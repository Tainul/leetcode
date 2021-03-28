import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.evaluate("(name)is(age)yearsold",
                Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"))));
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                i++;
                StringBuilder temp = new StringBuilder();
                while (i < s.length() && s.charAt(i) != ')') {
                    temp.append(s.charAt(i++));
                }
                sb.append(map.get(temp.toString()));

            } else {
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }
}
