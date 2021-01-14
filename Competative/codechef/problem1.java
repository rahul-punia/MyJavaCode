import java.util.*;

public class problem1{

    // public static void fun(double x,double y){
    //    if(x>y){
    //        System.out.println("Not sufficient amount");
    //    }else{
    //        y=y-(x+0.5);
    //        System.out.println(y);
    //    }
    // }

    static void check(int n,int m,int[] order){
        int[] cats=new int[n];
        for(int i=0;i<order.length;i++){
            cats[order[i]-1]=cats[order[i]-1]+1;
            for(int j=0;j<cats.length;j++){
                for(int k=j+1;k<cats.length;k++){
             if((cats[j]-cats[k])>1 ||(cats[j]-cats[k])<-1){
                 System.out.println("NO");
                 return;
             }
            }   
            }
        }
        System.out.println("YES");
    }
    static void check2(int ns1,int ns2,int rt,int max){
	    if(rt==1 || ns1==ns2){
            System.out.println("YES");
            return;
        }else{
          if(ns1<max ||ns2<max){
            System.out.println("YES");
            return; 
          }
        }
        System.out.println("NO");
  }
  

  public static int smallestString(String s,String t){
    int tl=t.length(),sl=s.length();

    if(sl%tl!=0)return -1;

    int freq=sl/tl;
    String str="";
    for(int i=0;i<freq;i++){
      str+=t;
    }
    if(!str.equals(s))return -1;
    int[] arr1=new int[26];
    int[] arr2=new int[26];
    for(int i=0;i<tl;i++){
      arr1[t.charAt(i)-'a']++;
    }

    for(int l=1;l<=tl;l++){
      arr2[t.charAt(l-1)-'a']++;
      if(tl%l==0){
        boolean flag=true;

        for(int i=0;i<26;i++){
          if(arr1[i]>0 && arr2[i]==0){flag=false; break;}
          else if(arr1[i]>0 && arr2[i]>0 && arr1[i]%arr2[i]!=0){flag=false; break;}
        }

        if(flag)return l;
      }
    }

    return -1;
  }

public static void main(String[] args){
      int[] arr={3,3,2,1,4};

      int slow=arr[0],fast=arr[0];

      do{
        slow=arr[slow]; fast=arr[arr[fast]];  
      }while(slow!=fast);

      int ptr1=arr[0],ptr2=slow;

      while(ptr1!=ptr2){
        ptr1=arr[ptr1]; ptr2=arr[ptr2];
      }

      System.out.println(ptr1);

  Scanner scn=new Scanner(System.in);
		
  int t=scn.nextInt();
  
  while(t-->0){
      int n=scn.nextInt();
      int k=scn.nextInt(); 
      
      int[] ans=new int[n];
      // Arrays.fill(ans,1);
      int sum=0;
      
      for(int i=0;i<n;i++){
        if((sum-(i+1))<0 && (n-i)>k){
          ans[i]=-(i+1);
        }else if(k>0){
          k--;
          ans[i]=i+1;
        }
        // ans[i]=i+1;
        sum+=ans[i];
      }
     
      for(int val:ans){
          System.out.print(val+" ");
      }
      System.out.println();
     }
    }
  } 


//   Scanner scn=new Scanner(System.in);
		
//   int t=scn.nextInt();
  
//   while(t-->0){
//       int n=scn.nextInt();
//       int d=scn.nextInt(); 
     
//      int risk=0,nrisk=0;
//      for(int i=0;i<n;i++){
//          int age=scn.nextInt();
//          if(age<=9 || age>=80){
//              risk++;
//          }else{ nrisk++;}
//      }

//     //  System.out.println(risk+" "+nrisk);
//     int ans=(int)(Math.ceil((risk*1.0)/d)+Math.ceil((nrisk*1.0)/d));
    
//     System.out.println(ans);
//     }
//   }
// }

  //  for(int i=0;i<args.length;i++){
  //    System.out.println(args[i]);
  //  }

  //  ArrayList<Integer> list1=new ArrayList<>(List.of(1,2,3,8,5,6));
  //  ArrayList<Integer> list2=new ArrayList<>(List.of(9,2,3,8,5,6));
   
  //  for(int i=0;i<list1.size();i++){

  //   if(list1.get(i).equals(list2.get(i))){
  //     System.out.println(i);
  //   }else{
  //     System.out.println(" UE ");
  //   }
  //  }


  // Scanner scn=new Scanner(System.in);
	// 	int t=scn.nextInt();
	// 	int mod=1000000007;
		
	// 	for(int i=0;i<t;i++){
	// 	    int a=scn.nextInt(),b=scn.nextInt();
		    
	// 	    int o1=(int)Math.ceil(a/2.0);
	// 	    int e1=a/2;
		    
	// 	    int o2=(int)Math.ceil(b/2.0);
	// 	    int e2=b/2;
		    
	// 	    long ans=(o1*o2)%mod+(e1*e2)%mod;
	// 	    System.out.println(ans%mod);
  // 	}
  
//    }
// }
  // System.out.println(smallestString("abcddbcaabcddbcaabcddbcaabcddbca", "abcddbcaabcddbca"));
    // Scanner scn=new Scanner(System.in);
    // Scanner scn=new Scanner(System.in);
		
		// int d1=scn.nextInt();
		// int v1=scn.nextInt();
		// int d2=scn.nextInt(),v2=scn.nextInt();
		// int p=scn.nextInt();
		//  int ans=0;
		// if(d1!=d2){
		//      ans=0;
    //      if(d1<d2){ 
    //       ans=(d1-1)+(d2-d1);
    //       p-=(d2-d1)*v1;
    //   }else{ 
    //       ans=(d2-1)+(d1-d2);
    //       p-=(d1-d2)*v2;
    //   }
		//     // System.out.println(ans+" "+p);
		//     ans+=(int)Math.ceil(p/(1.0*(v1+v2)));
		// }else{
		//      ans=(d1-1)+(int)Math.ceil(p/(1.0*(v1+v2)));
		// }
    //     System.out.println(ans);
    //   }
    // }
    // double x=0;
    // double y=0;
    // System.out.println("Enter the amount to withdraw");
    // x=scn.nextDouble();
    // System.out.println("Enter initial account balance");
    // y=scn.nextDouble();
    // if(x%5==0){
    //     fun(x, y);
    // }else{
    //     System.out.println("Incorrect Withdrawl Amount");
    // }

  // int t=scn.nextInt();
  // for(int i=0;i<t;i++){
  //      int n=scn.nextInt();
  //      int max=0;
  //      for(int j=0;j<n;j++){
  //          int rt=scn.nextInt();
  //          int ns1=scn.nextInt();
  //          int ns2=scn.nextInt();
           
  //          check2(ns1, ns2, rt,max);
  //          max=Math.max(ns1,ns2);
  //      }
  // }
//     for(int j=0;j<t;j++){
// 		int n=scn.nextInt();
// 	//	System.out.println("Enter No of cans");
// 		int m=scn.nextInt();
// 		int[] order=new int[m];
		
// 		for(int i=0;i<m;i++){
// 		    order[i]=scn.nextInt();
// 		}
// 	  check(n,m,order);
// 	}
// 	System.exit(0);
//  }
// }
