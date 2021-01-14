#include<iostream>
#include<queue>
#include<unordered_set>
using namespace std;

int FIFOpageReplacement(int pages[],int npe,int npm)
{

   int PageFaults =0;
   queue<int> q;
   unordered_set<int> s;

   for(int i=0;i<npe;i++)
   {

   	 if(s.size()<npm)
   	 {
   	 	 if(s.find(pages[i])==s.end())
   	 	 {

   	 	 	s.insert(pages[i]);
   	 	 	q.push(pages[i]);
   	 	 	PageFaults++;
   	 	 }
   	 }

   	 else
   	 {

        if(s.find(pages[i])==s.end())
        {
        	int toBeRemoved = q.front();
        	q.pop();
        	s.erase(toBeRemoved);
        	s.insert(pages[i]);
        	q.push(pages[i]);
        	PageFaults++;
        }

   	 }

   }

   return PageFaults;
}

int main()
{
	int npm=0,npe=0;

	cout<<"Enter Number Of Pages Memory Can Hold : ";
	cin>>npm;
    cout<<"Enter Numbers Of Pages To Be Entered  : ";
	cin>>npe;

	int pages[npe]={0};
	cout<<"Enter The Pages :----"<<endl;

	for(int i=0;i<npe;i++)
	{
       cin>>pages[i];
	}

	int totalPageFaults = FIFOpageReplacement(pages,npe,npm);
	cout<<"Total Number Of Page Faults Exits       : "<<totalPageFaults<<endl;
	return 0;
}