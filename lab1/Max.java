public class Max {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int Max = 0;
        for (int j : m) {
            if (j > Max) {
                Max = j;
            }
        }
        return Max;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }
}
