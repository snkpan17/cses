//package sorting.searching;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SubarraySums1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int arr[] = new int[n];
        Map<Long, Integer> prefixSumFrequency = new HashMap<Long, Integer>();
        prefixSumFrequency.put(0L, 1);
        for(int i = 0; i < n; ++i){
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        long count = 0;
        for(int i = 0; i < n; ++i){
            sum += arr[i];
            //check no of subarray ending at index i has sum x
            if(prefixSumFrequency.containsKey(sum-x)){
                count += prefixSumFrequency.get(sum-x);
            }
            prefixSumFrequency.put(sum, prefixSumFrequency.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
