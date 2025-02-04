import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int solution(String s) {
        //key-value list of roman symbols
        Map<String, Integer> romanList = new HashMap<>();
        romanList.put("I", 1);
        romanList.put("V", 5);
        romanList.put("X", 10);
        romanList.put("L", 50);
        romanList.put("C", 100);
        romanList.put("D", 500);
        romanList.put("M", 1000);
        int counter = 0;

        if (s.length() == 1) return romanList.get(s);

        //Validate invalid pointer positions of string parameter
        for (int i = 0; i < s.length(); i++) {
            String currentKey = String.valueOf(s.charAt(i));

            if (i + 1 < s.length() &&
                    romanList.get(currentKey) < romanList.get(String.valueOf(s.charAt(i + 1)))) {
                counter += romanList.get(String.valueOf(s.charAt(i + 1))) - romanList.get(currentKey);
                i+=1;
            } else counter += romanList.get(currentKey);

        }
        return counter;
    }
}
