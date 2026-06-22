class Solution {
    public String chooseSwap(String s) {
        int[] hash = new int[26];

        for (char ch : s.toCharArray()) {
            hash[ch - 'a'] = 1;
        }

        char chng = '-';
        int i = 0;
        int j = 0;

        while (j < s.length()) {

            while (i < 26 && hash[i] == 0) {
                i++;
            }

            char curr = (char) ('a' + i);
           // System.out.println(curr + " " + s.charAt(j));

            if (s.charAt(j) == curr) {
                j++;
                i++;
            } else if (s.charAt(j) > curr) {
                chng = s.charAt(j);
                break;
            } else {
                j++;
            }
        }
        if(chng=='-') return s;

        char small = (char) ('a' + i);

        char[] ch = s.toCharArray();

        for (int k = 0; k < s.length(); k++) {
            if (ch[k] == chng) {
                ch[k] = small;
            } else if (ch[k] == small) {
                ch[k] = chng;
            }
        }

        return new String(ch);
    }
}