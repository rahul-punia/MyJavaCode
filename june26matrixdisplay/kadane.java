import java.util.*;

public class  kadane{
    public static void main(String [] args){
       // int [] arr={2,4,3,-6,-4,1,7,-2,6,4,-3,2,3,-9,-6,-4,4,8};
       int[] arr = { -2, -4, -5, -9, -1 };
        int csm=arr[0];//current sum
       int  cst=0;  //current sum start
        int ce=0;    //current sum end

        int bsm=arr[0];   //best sum 
        int bss=0;        //best sum start
        int bse=0;        //best sum end

        for(int i=1;i<arr.length;i++){
            if(csm<0){
                csm=arr[i];
                cst=i;
                ce=i;

            }else{
                
                    csm+=arr[i];
                    ce++;
            }
            if(bsm<csm){
                bsm=csm;
                bss=cst;
                bse=ce;
               }

        }
        for(int i=bss;i<=bse;i++){
            System.out.print(arr[i]+" ");
        }
       	//sir code
		// int[] arr = { 2, 4, 3, -6, -4, 1, 7, -2, 6, 4, -3, 2, 3, -9, -6, -4, 4, 8 };
				// int[] arr = { -2, -4, -5, -9, -1 };
				// int cs = arr[0];//current sum
				// int ci = 0;      //current start
				// int cj = 0;      //current end

				// int bs = arr[0];      //best sum
				// int bi = 0;           //best start
				// int bj = 0;           //best end 

				// for (int i = 0; i < arr.length; i++) {
				// 	if (cs > 0) {
				// 		cj++;
				// 		cs = cs + arr[i];
				// 	} else {
				// 		cs = arr[i];
				// 		ci = i;
				// 		cj = i;
				// 	}
				// 	if (bs < cs) {
				// 		bs = cs;
				// 		bi = ci;
				// 		bj = cj;
				// 	}
				// }
				// for (int i = bi; i <= bj; i++) {
				// 	System.out.print(arr[i] + " ");
				// }
 

    }
}