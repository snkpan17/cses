package sorting.searching;
import java.util.Scanner;
public class ArrayDivisionTest {
    public static void main(String[] args){
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        long total = 0;
        long max_sum = 0;
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
            total += arr[i];
            max = Math.max(arr[i], max);
        }
        System.out.println(ArrayDivision.findK(arr, 39142));
        System.out.println(ArrayDivision.findK(arr, 39141));
    }
}
