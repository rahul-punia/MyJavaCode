#include<iostream>
#include<unordered_map>
#include<cmath>
#include<climits>
#include<unordered_set>
#include<vector>
using namespace std;




// -----------------------FCFS DISK SCHEDULING ALGORITHM------------------------------

void FCFSdiskSchedulingAlgo()
{
   int n=0,head=0;
   cout<<"Enter Number Of Requested Track Numbers : ";
   cin>>n;
   int requestedTracks[n]={0};
   cout<<"Enter The Requested Tracks              : ";
   for(int i=0;i<n;i++)
   {
       cin>>requestedTracks[i];
   }

   cout<<"Enter The Disk Head                     : ";
   cin>>head;
   int seekCount=0,distance=0,currentTrack=0;

   for(int i=0;i<n;i++)
   {
   	 currentTrack = requestedTracks[i];
   	 distance = abs(currentTrack - head);
   	 seekCount = seekCount + distance;
   	 head = currentTrack;
   }

   cout<<"Total Number Of The Seek Operations    : "<<seekCount<<endl;

}



// --------------------------LEAST RECENTLY USED PAGE REPLACEMENT ALGORITHM---------------------------

void LRUpageReplacementAlgo()
{
	int n=0,np=0;

	cout<<"Enter  Number Of Pages Memory Can Hold : ";
	cin>>n;
    cout<<"Enter  Numbers Of Pages To Be Entered  : ";
	cin>>np;

	int pages[np]={0};
	cout<<"Enter no of Pages :----"<<endl;

	for(int i=0;i<np;i++)
	{
        cin>>pages[i];
	}

   int totalPageFaults =0;
   unordered_map<int,int> m;
   unordered_set<int> s;

   for(int i=0;i<np;i++)
   {

	   	 if(s.size()<n)
	   	 {
	   	 	 if(s.find(pages[i])==s.end())
	   	 	 {

	   	 	 	s.insert(pages[i]);
	   	 	 	totalPageFaults++;
	   	 	 }

	   	 	 m[pages[i]] = i;
	   	 }

	   	 else
	   	 {

	        if(s.find(pages[i])==s.end())
	        {
	        	int k=0,leastRecent = INT_MAX;
	            for(auto it=s.begin();it!=s.end();it++)
	            {
	            	if(m[*it] < leastRecent)
	            	{
	            		leastRecent = m[*it];
	            		k = *it;
	            	}

	            }

	        	s.erase(k);
	        	s.insert(pages[i]);
	        	totalPageFaults++;
	        }

	         m[pages[i]] = i;

	   	 }

   }
	cout<<"Total Page Faults Occured       : "<<totalPageFaults<<endl;
}


// ------------------OPTIMAL PAGE REPLACEMENT ALGORITHM----------------------------


bool search(vector<int> v,int toBesearched)
{
	for(int i=0;i<v.size();i++)
	{
		if(v[i]==toBesearched)
		{
			return true;
		}
	}

	return false;
}

int predict(vector<int> v,int pages[],int np,int index)
{
	int k=-1,farthest = index;
	for(int i=0;i<v.size();i++)
	{
		int j=0;
		for(j=index;j<np;j++)
		{
			if(v[i]==pages[j])
			{
				 if(farthest<j)
				 {
				 	farthest=j;
				 	k=i;
				 }
                 break;
			}
		}

		if(j==np)
		{
			return i;
		}
	}

	if(k==-1)
	{
		return 0;
	}
	else
	{
        return k;
	}

}

void OptimalpageReplacementAlgo()
{
    int n=0,np=0;

	cout<<"Enter Number Of Pages Memory Can Hold : ";
	cin>>n;
    cout<<"Enter Numbers Of Pages To Be Entered  : ";
	cin>>np;

	int pages[np]={0};
	cout<<"Enter The Pages :----"<<endl;

	for(int i=0;i<np;i++)
	{
        cin>>pages[i];
	}

    vector<int> v;
    int hits = 0,misses=0;
    for(int i=0;i<np;i++)
    {
    	if(search(v,pages[i]))
    	{
    		hits++;
    		continue;
    	}

    	if(v.size()<n)
    	{
    		v.push_back(pages[i]);
    	}
    	else
    	{
    		int k= predict(v,pages,np,i+1);
    		v[k] = pages[i];
    	}
    } 
    misses = np-hits;
    cout<<"Total Number Of Hits    : "<<hits<<endl;
    cout<<"Total Number Of Misses  : "<<misses<<endl;

}


// ------------------------LEAST FREQUENTLY USED PAGE REPLACEMENT ALGORITHM------------------------------

void LFUpageReplacementAlgo()
 {
        int np=0,n=0,move=0,flag=0,pageFaults=-1,repIndex=0,leastCount=0;
        cout<<"\nEnter Number Of Pages Memory Can Hold : ";
        cin>>n;
        cout<<"Enter Numbers Of Pages To Be Entered  : ";
        cin>>np;

        int pages[np]={0},count[n]={0},frame[n]={0};
        cout<<"Enter The Pages :----"<<endl;

        for(int i=0;i<np;i++)
        {
           cin>>pages[i];
        }

        for(int i=0;i<n;i++)
        {
            frame[i]=-1;
        }

        for(int i=0;i<np;i++)
        {
                flag=0;
                for(int j=0;j<n;j++)
                {
                    if(pages[i]==frame[j])
                    {
                                flag=1;
                                count[j]++;
                                break;
                    }
                }

                if(flag==0&&pageFaults<n)
                {
                    frame[move]=pages[i];
                    count[move]=1;
                    move=(move+1)%n;
                    pageFaults++;

                }
                else if(flag==0)
                {
                    leastCount=count[0];
                    for(int j=1;j<n;j++)
                    {
                        if(count[j]<leastCount)
                        {
                            repIndex=j;
                            leastCount=count[j];
                        }
                    }
                    frame[repIndex]=pages[i];
                    count[repIndex]=1;
                    pageFaults++;
                }
        }
        cout<<"Total Page Faults Occured       : "<<pageFaults<<endl;
}

// ------------------------Main----------------------
int main()
{
    int choice=0;

    cout<<"Select the Option:--\n1.Optimal Page Replacement\n2.Least Recently Used Page Replacement\n3.Least Frequently Used Page Replacement\n4.FCFS Disk Scheduling\n5.Exit"<<endl;

    while(1)
    {
    	cout<<"Enter Your Choice  :  ";
	    cin>>choice;
	    switch(choice)
	    {
	         case 1: OptimalpageReplacementAlgo();
	                 break;
	         case 2: LRUpageReplacementAlgo();
	                 break;
	         case 3: LFUpageReplacementAlgo();
	                 break;
	         case 4: FCFSdiskSchedulingAlgo();
	                 break;
	         case 5: return 0;

	    }

	}
}