import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class a2022510158_2022510022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the number of judges: ");
        int numJudges = scanner.nextInt();

        System.out.print("Please enter the cost of problem type changing: ");
        int changeCost = scanner.nextInt();

        ArrayList<String> problemTypes = ReadInputFile("input.txt");


        int totalCost = AssignProblems(numJudges, changeCost, problemTypes);

        System.out.println("Total cost: " + totalCost);
    }

    //    Time Complexity: O(n)
//    Worst-case scenario: Reading all lines from the file where n is the number of lines.
    private static ArrayList<String> ReadInputFile(String filename) {
        ArrayList<String> problemTypes = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                problemTypes.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return problemTypes;
    }


    //    Time Complexity: O(1)
//    Worst-case scenario: Comparing two non-null strings.
    private static boolean AreTheyEquals(String str1, String str2) {

        if (str1 == null || str2 == null) {
            return false;
        } else {
            return str1.equals(str2);
        }
    }

    //    Time Complexity: O(m * (n + k))
//    Worst-case scenario: Iterating through m problem types, where each iteration involves a potential
//    worst-case cost of DecideBestOption (O(n + k)) due to removal from the problem list and the checks
//    for best index assignment.
    private static int AssignProblems(int numJudges, int changeCost, ArrayList<String> problemTypes) {
        int totalCost = 0;
        String[] judgesCurrProblem = new String[numJudges];

        int problemCount = problemTypes.size();
        for (int i = 0; i < problemCount; i++) {
            String problemType = problemTypes.remove(0);
            int indexOfProblem = DecideBestOption(judgesCurrProblem, problemType, problemTypes);

            if (!AreTheyEquals(judgesCurrProblem[indexOfProblem], problemType)) {
                totalCost += changeCost;
            }
            judgesCurrProblem[indexOfProblem] = problemType;
        }
        return totalCost;
    }

    //    Time Complexity: O(n * k)
//    Worst-case scenario: Looping through n judges' current problems and finding the index in the list of size k for each judge.
    private static int DecideBestOption(String[] judgesCurrProblem, String problemType, ArrayList<String> problemTypes) {
        int indexOfSameProblem = -1;
        int indexOfNullProblem = -1;

        for (int i = 0; i < judgesCurrProblem.length; i++) {
            if (AreTheyEquals(judgesCurrProblem[i], problemType)) {
                indexOfSameProblem = i;
            } else if (judgesCurrProblem[i] == null) {
                indexOfNullProblem = i;
            }
        }
        if (indexOfSameProblem != -1)
            return indexOfSameProblem;
        else {
            if (indexOfNullProblem != -1)
                return indexOfNullProblem;
            else {
                int[] indexArray = new int[judgesCurrProblem.length];
                for (int i = 0; i < judgesCurrProblem.length; i++)
                    indexArray[i] = problemTypes.indexOf(judgesCurrProblem[i]);

                return findIndex(indexArray);
            }
        }
    }


    //    Time Complexity: O(n)
//    Worst-case scenario: Finding the index with the maximum value in the array of size n.
    public static int findIndex(int[] array) {
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                return i;
            }
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}