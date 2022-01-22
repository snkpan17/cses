//package sorting.searching;

import java.util.Scanner;

public class SubarrayDivisibility {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int no;
        long prefixSum = 0;
        long count = 0;
        int prefixSumMod[] = new int[n];
        prefixSumMod[0] = 1;
        for(int i = 0; i < n; ++i){
            no = sc.nextInt();
            /*if(no == 0)
                count++;*/
            prefixSum += no;
            long key = prefixSum % n;
            key = (key + n) % n;
            count += prefixSumMod[(int) key];
            prefixSumMod[(int) key] += 1;
        }
        /*for(int i = 1; i < n; ++i){
            if(prefixSumMod[i] > 1){
                count += (prefixSumMod[i] * (prefixSumMod[i]-1))/2;
            }
        }
        count += prefixSumMod[0];*/
        System.out.println(count);
    }
}
