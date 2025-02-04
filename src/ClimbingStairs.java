public class ClimbingStairs {
    public static int recursiveClimb(int n) {
        if (n == 0) return 1;

        if (n < 0) return 0;

        return recursiveClimb(n - 1) + recursiveClimb(n - 2);
    }

    public static int iterativeClimb(int n) {
        int firstNumber = 0;
        int secondNumber = 1;
        int fibonacci = 0;

        for (int i = 1; i <= n; i++) {
            fibonacci = firstNumber + secondNumber;

            firstNumber = secondNumber;
            secondNumber = fibonacci;
        }

        return fibonacci;
    }
}
