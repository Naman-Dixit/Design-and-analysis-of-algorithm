import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ActivitySelection {

    // Function to perform activity selection
    public static void activitySelection(int[] start, int[] end) {
        // Create an array of activities
        int n = start.length;
        Activity[] activities = new Activity[n];

        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], end[i]);
        }

        // Sort activities by their finish time
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

        // The first activity is always selected
        System.out.println("Selected activities:");
        System.out.print("Activity " + 0 + " (Start: " + activities[0].start + ", End: " + activities[0].end + ")");
        int lastSelected = 0;

        // Iterate through the sorted activities
        for (int i = 1; i < n; i++) {
            // If the start time of the current activity is greater than or equal
            // to the finish time of the last selected activity
            if (activities[i].start >= activities[lastSelected].end) {
                System.out.print(", Activity " + i + " (Start: " + activities[i].start + ", End: " + activities[i].end + ")");
                lastSelected = i;
            }
        }
        System.out.println(); // For a new line after output
    }

    // Activity class to store start and end times
    static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take number of activities as input
        System.out.print("Enter the number of activities: ");
        int n = scanner.nextInt();

        // Create arrays to store start and end times
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        // Input start and end times
        for (int i = 0; i < n; i++) {
            System.out.print("Enter start time for activity " + (i + 1) + ": ");
            startTimes[i] = scanner.nextInt();
            System.out.print("Enter end time for activity " + (i + 1) + ": ");
            endTimes[i] = scanner.nextInt();
        }

        // Call the activity selection function
        activitySelection(startTimes, endTimes);

        // Close the scanner
        scanner.close();
    }
}
