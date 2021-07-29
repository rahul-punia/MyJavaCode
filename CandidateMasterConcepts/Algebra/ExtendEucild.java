import java.util.*;

public class ExtendEucild {
    //Solve Eqn-   ax+by=c
    //where a, b, c are given integers, and x, y are unknown integers
    //https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/
    public static class ref_var{
        public long num;
        public ref_var(long num){
            this.num=num;
        }
    }

    public static long gcd(int a,int b,ref_var x,ref_var y){
        if(b==0){x.num=1; y.num=0; return a;}

        ref_var x1=new ref_var(0),y1=new ref_var(0);
        long d=gcd(b, a%b, x1, y1);

        x.num=y1.num;
        y.num=x1.num-((y1.num)*(a/b));

        return d;
    }    

    public static boolean find_any_solution(int a, int b, int c, ref_var x0, ref_var y0, ref_var g) {
        g.num = gcd(Math.abs(a), Math.abs(b), x0, y0);

        if ((c%g.num)!=0) {
            return false;
        }
    
        x0.num *= (c / g.num);
        y0.num *= (c / g.num);
        if (a < 0) x0.num = -x0.num;
        if (b < 0) y0.num = -y0.num;
        return true;
    }

    public static void main(String[] args) {
        // ref_var x=new ref_var(0);
        // ref_var y=new ref_var(0);
        // gcd(55, 80,x,y);

        // System.out.println(x.num+" "+y.num);

        //Solve Equation
        // Scanner scn=new Scanner(System.in);
        ref_var x0=new ref_var(0);
        ref_var y0=new ref_var(0);
        ref_var g=new ref_var(1);
        
        boolean res=find_any_solution(220, 221,1, x0, y0, g);
        System.out.println(res);
        System.out.println(x0.num+" "+y0.num);
    }
}
