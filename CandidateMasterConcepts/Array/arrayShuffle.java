import java.util.*;
import java.lang.*;
import java.io.*;

//https://www.journaldev.com/32661/shuffle-array-java
//Comments
// I also noticed that issue… implementation 1  i.e Wrongshuffle1 will not give a uniform shuffle. The random index for the swap should be picked in the range of already shuffled items only.
// The second one is wrong. It will end up to non uniform distribution.
// Your second implementation is not uniformly random (for example, the sequence 7,1,2,3,4,5,6 is abnormally unlikely to be generated) use the Fisher-Yates algorithm instead

////In Java Sometimes Arrays.sort(arr). Take   O(n^2). Time for already sorted array bcz  Arrays.sort uses Quicksort
public class arrayShuffle {

     //Right Way
     public static void Rightshuffle1(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) Math.random() * n;
			int temp = arr[i];  arr[i] = arr[idx]; arr[idx] = temp;  //swap
		}
        System.out.println(Arrays.toString(arr));
		// Arrays.sort(arr);
	}   

    //Wrong Way
    public static void Wrongshuffle1(int[] array){  //Space-o(1)  //Donot Use this 
        Random rand = new Random();
		
        for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = rand.nextInt(array.length); 
			int temp = array[randomIndexToSwap];   array[randomIndexToSwap] = array[i];  array[i] = temp;
		}
		System.out.println(Arrays.toString(array));
    }

   

   //For ArrayList directly use collections.shuffle(list);
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7 };
        Wrongshuffle1(array);
        Rightshuffle1(array);
        // Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7 };
        // shuffle2(intArray);
    }

    //Donot use this.
    public static void shuffle2(Integer[] intArray){  //Space-o(n)
        List<Integer> intList = Arrays.asList(intArray);

		Collections.shuffle(intList);

		intList.toArray(intArray);

		System.out.println(Arrays.toString(intArray));
    }
}
