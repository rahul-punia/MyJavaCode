#include<iostream>
#include<fstream>
using namespace std;
int main()
{
string choice="1",sourceFile ="",destinationFile = "";
cout<<"Choose a file operation to perform by press 1 or 2:->\n1.Copy  File \n2.Move  File \nEnter Your Choice : ";
getline(cin,choice);
 cout<<"Enter Source File Name : ";
 getline(cin,sourceFile);
 cout<<"Enter Destination File Name : ";
 getline(cin,destinationFile);
 ifstream fin;
 fin.open(sourceFile,ios::in);
 ofstream fout;
 fout.open(destinationFile,ios::out|ios::trunc);
 if(!fin)
{
 cout<<"Source File Could Not Opened!";
 return 0;
}
 if(!fout)
 {
cout<<"Destination File Could Not Be Opened!";
 return 0;
 }
 string word="";
 while(fin)
 {
 getline(fin,word);
 fout<<word;
 }
 fin.close();
 fout.close();
 if(choice=="1")
 {
 cout<<"\nFile Contents Of \'"<<sourceFile<<"\' Are COPIED To\'"<<destinationFile <<" Successfully \'"<<endl;
 }
 else if(choice=="2")
 {
 fin.close();
 fin.open(sourceFile,ios::trunc|ios::out);
 fin.close();
 cout<<"\nFile Contents Of \'"<<sourceFile<<"\' Are MOVED To\'"<<destinationFile<<" Successfully \'"<<endl;
 }
 return 0;
}