#include<stdio.h>
//Switch question 
// Q. Can we use string inside switch statement?
//Ans-No
int main(){
    int arr[] = {2, 3, 4, 1, 6};
    printf("%u, %u, %u\n", arr, &arr[0], &arr);
    return 0;
    
    //Q-0
    printf(5+"Good Morning\n");  //output-Morning
           char suite='3'; 
    //Q-1
        //   switch(suite) 
        //     {
        //         case '3': printf("one\n"); break;
        //         case 3: printf("two\n"); break;
        //         default: printf("four\n"); 
        //     }
        //     printf("Hi rahul");

    //Q-2
    // int a =10;
    // if(a = 5)
    //     printf("hello");
    // else
    //     printf("bye");
    //explanation
    //== must be used for comparison in the expression of if condition, if you use = the expression will always 
    //return true, because it performs assignment not comparison.  

    //Q-3
    // int i;
    // printf("%d", scanf("%d", &i));    // value 10 is given as input here
    //output=1
    // Scanf returns number of items successfully read. Here, 10 is given 
    //as input which should have been scanned successfully. So number of items read is 1.  

    //Q-4
    // switch (2)
    // {
    //     case 1: printf("one");
    //     case 2: printf("two");
    //     case 3: printf("three");
    //     default: printf("four");
    // }
    //O/P-1 2 3 4 5, It isn't necessary to use break after each block, but if you do not use it, all the 
    //consecutive block of codes will get executed after the matching block.

    //Q-4
    // int a = 0;//false
    // if(a) //true
    //     printf("Study");
    // else
    //     printf("tonight");

   //O/P-tonight     
}