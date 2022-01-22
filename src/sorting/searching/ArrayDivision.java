package sorting.searching;
import java.util.Scanner;
public class ArrayDivision {
    public static int findK(int[] arr, long maxSum){
        int subarrayCount = 0;
        long sum = 0;
        for (int val : arr) {
            if (val > maxSum) return -1;
            sum += val;
            if (sum > maxSum) {
                ++subarrayCount;
                sum = val;
            }
        }
        return ++subarrayCount;
    }
    public static void main(String[] args){
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        long total = 0;
        long max_sum;
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
            total += arr[i];
            max = Math.max(arr[i], max);
        }
        if(k == 1)
            max_sum = total;
        else if(k == n)
            max_sum = max;
        else{
            long l = max, r = total, mid;
            while(l < r){
                mid = l + (r-l)/2;
                int kx = findK(arr, mid);
                if(kx == k)
                    r = mid;
                else if(kx == -1)
                        l = mid+1;
                    else if(kx < k)
                        r = mid-1;
                        else
                            l = mid+1;
            }
            max_sum = r;
        }
        System.out.println(max_sum);
    }
}
