class Solution {
    public static String caseSort(String s) {
        int n = s.length();

        List<Character> lower = new ArrayList<>();  // to hold all lowercase letters
        List<Character> upper = new ArrayList<>();  // to hold all uppercase letters

        // 1) Partition into lowercase and uppercase lists
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(ch);
            }
        }

        // 2) Sort both lists independently
        Collections.sort(lower);
        Collections.sort(upper);

        // 3) Reconstruct result by consuming from sorted lists
        StringBuilder result = new StringBuilder(n);
        int           l      = 0; // index for lowercase list
        int           u      = 0; // index for uppercase list

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result.append(lower.get(l++));  // place next sorted lowercase
            } else {
                result.append(upper.get(u++));  // place next sorted uppercase
            }
        }

        return result.toString();
    }
}