import java.util.Scanner;

public class RabinKarp {
    static final int d = 256; // number of characters in input alphabet
    static final int q = 101; // a prime number

    static void rabinKarpSearch(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        int i, j;
        int patternHash = 0; // hash value for pattern
        int textHash = 0; // hash value for text
        int h = 1;

        // The value of h would be "pow(d, m-1)%q"
        for (i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < m; i++) {
            patternHash = (d * patternHash + pattern.charAt(i)) % q;
            textHash = (d * textHash + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++) {
            // Check the hash values of current window of text and pattern. If the hash values match, then only check for characters one by one
            if (patternHash == textHash) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash value for next window of text: Remove leading digit, add trailing digit
            if (i < n - m) {
                textHash = (d * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (textHash < 0) {
                    textHash = textHash + q;
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
        rabinKarpSearch(text, pattern);
        long endTime = System.nanoTime();
        System.out.println("Rabin-Karp executed in: " + (endTime - startTime) + " nanoseconds.");
    }
}
