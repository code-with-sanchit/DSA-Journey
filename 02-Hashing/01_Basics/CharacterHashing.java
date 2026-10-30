import java.util.Scanner; 

public class CharacterHashing {

    static int[][] precomputeFrequency(String s) {
        int[] lower = new int[26]; 
        int[] upper = new int[26]; 

        for (char c: s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower[c-'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                upper[c-'A']++;
            }
        }

        return new int[][] {lower,upper};
    }
    /*
     * Time Complexity: O(N) to precompute frequencies, O(1) per query
     * Space Complexity: O(1) since frequency arrays have fixed size of 26
     */

    public static void main(String[] args) {
        String s = "Hashing in Java"; 

        int[][] hash = precomputeFrequency(s); 
        int[] lower = hash[0]; 
        int[] upper = hash[1]; 

        System.out.println("a: " + lower['a' - 'a']);
        System.out.println("H: " + upper['H' - 'A']);
        System.out.println("n: " + lower['n' - 'a']);
        System.out.println("J: " + upper['J' - 'A']);
    }
}
