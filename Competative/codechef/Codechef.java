import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    
    
public static long second(int[] arr,long n,long e,long h,long a,long b,long c){
    long ti=0;    long ans=0; long mp=0;  //int oi=0,msi=0,cci=0;   int i=0; 
    long oans=Long.MAX_VALUE;//My Bigest Mistake    long oans=Integer.MAX_VALUE;   
     long ft=arr[0],sd=arr[1],td=arr[2];
       

    if(ft==a){
        mp=(e/2);  e=e%2;  ans=(long)(Math.min(n,mp))*(long)ft;
        if(mp>=n)return ans;
        long oe=e,oh=h;
        
        for(int j=0;j<=mp;j++){
            long rem=n-(mp-j);    e=oe; h=oh; 
            ti=mp-j;  ans=(long)ti*(long)ft;
            long ne=e+(j*2);   //1
            
            long cmin=Math.min(ne, h);
            if((ti+cmin+((h-cmin)/3))<n){continue;}  
            
            long min=0;  long oe2=ne,oh2=h;   long orem=rem;  long oa=ans;
            if(sd==c){
                 min=Math.min(ne, h);  // ne-=min;  h-=min;
            }else if(sd==b){
                min=h/3; // h=h%3;
            }
            // System.out.println(rem+"=aa="+ans);
            for(int k=(int)Math.min(orem,min);k>=0;k--){  //loop 2
                ne=oe2; h=oh2;    rem=orem; ans=oa;
                if(sd==c){
                    ne-=k;  h-=k;
               }else if(sd==b){
                   h=h-(k*3);
               }    

            if(k>=rem){
                ans+=(long)rem*(long)sd;    rem=0; //2
            }else{
                ans+=(long)k*(long)sd;     rem-=k; // ti+=k;
            }
           
            // System.out.println(rem+"=aa1="+ans);
            if(sd==c && (h/3)>=rem && rem>=0){
                ans+=(long)rem*(long)td;   //  break;
                oans=Math.min(ans, oans);
            }else if(sd==b && (Math.min(ne, h))>=rem && rem>=0){
                ans+=(long)rem*(long)td;   //  break;
                oans=Math.min(ans, oans);  
            }
            if(rem==0){return oans;}
        }
            // System.out.println(rem+"=aa1="+ans+"  oans= "+oans);
        }

    }else if(ft==b){
        mp=h/3; h=h%3;      ans=(long)(Math.min(n,mp))*(long)ft;
        if(mp>=n)return ans;
        long oe=e,oh=h;

        for(int j=0;j<=mp;j++){
            long rem=n-(mp-j);    ti=mp-j;  ans=(long)ti*(long)ft;  e=oe; h=oh; 
            long nh=h+(j*3);
            
            // System.out.println(ans);
            long cmin=Math.min(e, nh);
            if((ti+cmin+((e-cmin)/2))<n){continue;}
            
            long min=0;   long oe2=e,oh2=nh;  long orem=rem;  long oa=ans;
            if(sd==a){
                min=e/2;   // e=e%2;  
            }else if(sd==c){
                 min=Math.min(e, nh);  
            }
           for(int k=(int)Math.min(orem,min);k>=0;k--){  //loop 2
            e=oe2; nh=oh2;  rem=orem; ans=oa;
            if(sd==a){   //if k>rem
                 e=e-(k*2);  
            }else if(sd==c){
                 e=e-k; nh-=k; 
            }

         
            if(k>=rem){
                ans+=(long)rem*(long)sd;    rem=0; //2
            }else{
                ans+=(long)k*(long)sd;     rem-=k; // ti+=k;
            }
           
    
            if(sd==c && (e/2)>=rem && rem>=0){
                ans+=(long)rem*(long)td;   //  break;
                oans=Math.min(ans, oans);  
            }else if(sd==a && (Math.min(e, nh))>=rem && rem>=0){
                ans+=(long)rem*(long)td;   //  break;
                oans=Math.min(ans, oans);
            }
            if(rem==0){return oans;}
            // System.out.println(rem+" ans1="+ans+"  oans="+oans+"  mp="+mp+" j="+j+"   min="+min+" k "+k);
           }
        }
    }else if(ft==c){
        mp=Math.min(e, h);   e-=mp; h-=mp;   ans=(long)(Math.min(n,mp))*(long)ft;
        if(mp>=n)return ans;
        long oe=e,oh=h;

        for(int j=0;j<=mp;j++){
            long rem=n-(mp-j);    ti=mp-j;  ans=(long)ti*(long)ft;  e=oe; h=oh; 
            long nh=h+(j);  long ne=e+j;
            
            if((ti+(nh/3)+((ne)/2))<n){continue;}
            
            long min=0;   long oe2=ne,oh2=nh;    long orem=rem;  long oa=ans;
            if(sd==a){
                min=ne/2;  //ne=ne%2;
            }else if(sd==b){
                min=nh/3;   //nh=nh%2;
            }
          
            for(int k=(int)Math.min(orem,min);k>=0;k--){  //loop 2
                ne=oe2; nh=oh2;    rem=orem; ans=oa;

                if(sd==a){
                      ne=ne-(k*2);
                }else if(sd==b){
                      nh=nh-(k*3);
                }
                if(k>=rem){
                    ans+=(long)rem*(long)sd;    rem=0; //2
                }else{
                    ans+=(long)k*(long)sd;     rem-=k; // ti+=k;
                }
               
        
                if(sd==b && (e/2)>=rem && rem>=0){
                    ans+=(long)rem*(long)td;   //  break;
                    oans=Math.min(ans, oans);
                }else if(sd==a && (h/3)>=rem && rem>=0){
                    ans+=(long)rem*(long)td;   //  break;
                    oans=Math.min(ans, oans);
                }
                if(rem==0){return oans;}  //if two mincost make 'n' item
            } 
            
        }
    } 

    return oans;
}
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
     InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t= Integer.parseInt(br.readLine());

    while(t-->0){
    //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
        String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),e=Integer.parseInt(strs[1]),h=Integer.parseInt(strs[2]);
        int a=Integer.parseInt(strs[3]),b=Integer.parseInt(strs[4]),c=Integer.parseInt(strs[5]);
        // String str=(br.readLine()).trim();
        
        int[] arr=new int[3];
        arr[0]=a;  arr[1]=b;  arr[2]=c;
        // arr[0][0]=a;  arr[0][1]=2;   arr[0][2]=0;
        // arr[1][0]=b;  arr[1][1]=0;   arr[1][2]=3;
        // arr[2][0]=c;  arr[2][1]=1;   arr[2][2]=1; 

        // Arrays.sort(arr,(a1,a2)->a1[0]-a2[0]);
         
         Arrays.sort(arr);
        // System.out.println(arr[0][0]+" st  "+arr[1][0]);
        int mm=Math.min(e, h);
        int max=mm+((e-mm)/2) +((h-mm)/3);
        
        if(max<n){System.out.println(-1);  continue;}  //right-100% sure
        
        if(a==b && b==c){
            long equal=(long)n*(long)a;
            System.out.println(equal);  continue; 
        }
        
            long mans=second(arr,n, e, h,a,b,c);
            System.out.println(t+" testcase ans  "+mans);
        }
     
	}
}
