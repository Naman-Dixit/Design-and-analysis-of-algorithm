import java.util.Scanner;

public class NaiveStringMatching {
    static void naiveSearch(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                System.out.println("Pattern found at index " + i);
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
        naiveSearch(text, pattern);
        long endTime = System.nanoTime();
        System.out.println("Naive String Matching executed in: " + (endTime - startTime) + " nanoseconds.");
    }
}
