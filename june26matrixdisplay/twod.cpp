#include<iostream>

using namespace std;
int** takeinput(int r,int c){
    int** arr=new int*[r];
    for(int i=0;i<r;i++){
         arr[i]=new int[c];
        for(int j=0;j<c;j++){
            cout<<"enter cell value for cell ["<<i<<" "<<j<<"]";
            cin>>arr[i][j];

        }
    }
    return arr;
}
void display(int** arr,int r,int c){
  for(int i=0;i<r;i++){
      for(int j=0;j<c;j++){
          cout<<arr[i][j]<<" ";
      }
      cout<<endl;
  }
}

int main(int argc,char** argv){
    int r=0;
    int c=0;

    cout<<"Enter value for row";
    cin>>r;

     cout<<"Enter value for column";
    cin>>c;
    int** arr=takeinput(r,c);
    display(arr,r,c);

}