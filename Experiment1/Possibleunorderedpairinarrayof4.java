import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class DAA2 {

        public static List<String> generatePairs(int[] numbers) {
            List<String> pairs = new ArrayList<>();
            int n = numbers.length;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    pairs.add(numbers[i] + "," + numbers[j]);
                }
            }

            return pairs;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] numbers = new int[4];

            // Prompting the user to input four integers
            System.out.println("Enter four integers:");
            for (int i = 0; i < 4; i++) {
                numbers[i] = scanner.nextInt();
            }

            // Generate and display the pairs
            List<String> result = generatePairs(numbers);

            System.out.println("The possible unordered pairs are:");
            for (String pair : result) {
                System.out.println("(" + pair + ")");
            }

            scanner.close();
        }
    }

//time complexity o(n^2)
