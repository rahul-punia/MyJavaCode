import java.util.*;

public class petrolpump{
    public static void startingpetrolpump(int[] oil,int[] dist){

        int i=0;
        int j=0;
        int spoil=0;

        while(true){
            if(spoil+oil[j]>=dist[j]){
                spoil=spoil+oil[j]-dist[j];
                j=(j+1)%oil.length;
                if(i==j){
                    System.out.println("starting petrolpump index-"+i);
                    return;
                }
            }else{
                spoil=0;
                i=(j+1)%oil.length;
                j=i;
            }
        }
}
public static void main(String[] args){
    int [] oil = {5,3,2,2,3,2,6,7,5};//{6,7,2,9,1,2,1,7,8,2,1,2};
    int [] dis= {3,4,3,3,3,1,4,10,4};//{4,5,3,6,4,5,2,7,5,3,2,2};
    startingpetrolpump(oil, dis);
		
} 
}