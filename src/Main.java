import java.util.*;

public class Main {

    public static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
            "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";


    public static void main(String[] args) {
        String li = loremIpsum.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < li.length(); i++) {

            if (Character.isLetter(li.charAt(i))) {
                if (!map.containsKey(li.charAt(i))) {
                    map.put(li.charAt(i), 1);
                } else {
                    int times = map.get(li.charAt(i));
                    times++;
                    map.put(li.charAt(i), times);
                }
            }
        }


        List<Character> mostUsed = new ArrayList<>();
        for (Map.Entry<Character, Integer> kv: map.entrySet()) {
            if (kv.getValue() == getMax(map)) {
                mostUsed.add(kv.getKey());
            }
        }

        List<Character> leastUsed = new ArrayList<>();
        for (Map.Entry<Character, Integer> kv: map.entrySet()) {
            if (kv.getValue() == getMin(map)) {
                leastUsed.add(kv.getKey());
            }
        }

        System.out.println("Most used letters:\n" + mostUsed + " used " + getMax(map)  + " times.");
        System.out.println("Least used letters:\n" + leastUsed + " used " + getMin(map)  + " times.");
    }

    private static Integer getMin(Map<Character, Integer> map) {
        Integer minValue = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> kv: map.entrySet()) {
            if (kv.getValue() < minValue){
                minValue = kv.getValue();
            }

        }
        return minValue;

    }

    private static Integer getMax(Map<Character, Integer> map) {
        Integer maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() > maxValue) {
                maxValue = kv.getValue();
            }

        }
        return maxValue;
    }

}
