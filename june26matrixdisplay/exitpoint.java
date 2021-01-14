import java.util.*;

public class exitpoint{
    public static void main(String [] args){
        int[][] arr = { { 0, 0, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 1, 0, 0, 1 } };

		int r = 0;
		int c = 0;
		int d = 0;       //0123-eswn
		while (r < arr.length && c < arr[0].length && c >= 0 && r >= 0) {
			d = (arr[r][c] + d) % 4;
		//	d = d > 3 ? 0 : d;
			if (d == 0) {
				c++;
			} else if (d == 1) {
				r++;
			} else if (d == 2) {
				c--;
			} else if (d == 3) {
				r--;
			}
		}
		if (r > arr.length) {
			System.out.println((r - 1) + " " + c);
		} else if(c>arr[0].length){
			System.out.println(r + " " + (c - 1));
		}else if(r<0){
			System.out.println((r+1)+" "+(c));
		}else{
			System.out.println((r)+" "+(c+1));
	
		}
}
}