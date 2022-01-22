//package sorting.searching;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class SubarrayDistinctValues {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i)
			arr[i] = sc.nextInt();
		long count = 0;
		int l = 0, r = 0;
		Map<Integer, Integer> set = new HashMap<>();
		set.put(arr[0], 1);
		// [l,r] is the window
		// [0,0] satisfies invariant
		while(l <= r){
			// add new no in window
			++r;
			if(r == n)
				break;
			set.put(arr[r], set.getOrDefault(arr[r], 0)+1);
			// check [l,r] satisfies invariant
			while(set.size() > k){
				count += r-l;
				set.put(arr[l], set.get(arr[l])-1);
				if(set.get(arr[l]) == 0){                       // [1]
					set.remove(arr[l]);							// [2]  [3]
				}
				++l;
			}
		}
		//System.out.println("l : " + l + ", r: " + r);
		int lastWindowSize = r-l;
		count += ((long) lastWindowSize * ((long)lastWindowSize+1))/2;
		System.out.println(count);
    }
}
