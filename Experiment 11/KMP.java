import java.util.Scanner;

public class KMP {
    static void KMPSearch(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        int[] lps = new int[m];

        // Preprocess the pattern (calculate lps array)
        computeLPSArray(pattern, m, lps);

        int i = 0, j = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    static void computeLPSArray(String pattern, int m, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = sc.nextLine();
        System.out.println("Enter the pattern: ");
        String pattern = sc.nextLine();

        long startTime = System.nanoTime();
        KMPSearch(text, pattern);
        long endTime = System.nanoTime();
        System.out.println("KMP Algorithm executed in: " + (endTime - startTime) + " nanoseconds.");
    }
}
