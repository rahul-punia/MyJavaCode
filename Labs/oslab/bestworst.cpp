#include<iostream>
using namespace std;


void bestFitMemory(int np,int prs[],int nb,int bs[])
{
	int bestBlockNo[np]={0};

	for(int i=0;i<np;i++)
	{
		bestBlockNo[i] = -1;
	}

	for(int i=0;i<np;i++)
	{
		int best = -1;
		for(int j=0;j<nb;j++)
		{
			if(prs[i]<=bs[j])
			{
				if(best == -1)
				{
					best=j;
				}
				else if(bs[j]<bs[best])
				{
					best = j;
				}
			}
		}

		if(best!=-1)
		{
			bestBlockNo[i] = best;
			bs[best] = bs[best]-prs[i];
		}
	}

	cout<<"Process    Process Size     BlockNo"<<endl;

	for(int i=0;i<np;i++)
	{
		cout<<"  "<<i+1<<"\t\t"<<prs[i];
		if(bestBlockNo[i]!= -1)
		{
			cout<<"\t\t"<<bestBlockNo[i]+1<<endl;
		}
		else
		{
			cout<<"\t\tMemory Not occupied"<<endl;
		}
	}
	cout<<endl;
}

void worstFitMemory(int np,int prs[],int nb,int bs[])
{
	int worstBlockNo[np]={0};

	for(int i=0;i<np;i++)
	{
		worstBlockNo[i] = -1;
	}

	for(int i=0;i<np;i++)
	{
		int worst = -1;
		for(int j=0;j<nb;j++)
		{
			if(prs[i]<=bs[j])
			{
				if(worst == -1)
				{
					worst = j;
				}
				else if(bs[j]>bs[worst])
				{
					worst = j;
				}
			}
		}

		if(worst!=-1)
		{
			worstBlockNo[i] = worst;
			bs[worst] = bs[worst]-prs[i];
		}

	}


	cout<<"Process    Process Size     Block No"<<endl;

	for(int i=0;i<np;i++)
	{
		cout<<"  "<<i+1<<"\t\t"<<prs[i];
		if(worstBlockNo[i]!= -1)
		{
			cout<<"\t\t"<<worstBlockNo[i]+1<<endl;
		}
		else
		{
			cout<<"\t\tMemory Not Allocated"<<endl;
		}
	}

	cout<<endl;
}


int main()
{
    int np=0,nb=0,n=0;
    cout<<"Options :--- \n1.Best Fit Memory Allocation \n2.Worst Fit Memory Allocation  \n\nChoose Operation : ";
    cin>>n;

    cout<<"Enter The Number of Processes : ";
    cin>>np;
    int prs[np]={0};                               // prs process sizes
    cout<<"Enter Process Sizes      :---"<<endl;
    for(int i=0;i<np;i++)
    {
    	cin>>prs[i];
    }
    cout<<"Enter The Number of Blocks    : ";
    cin>>nb;
    int bs[nb]={0};                               // bs block sizes
    cout<<"Enter Memory Block Sizes :---"<<endl;
    for(int i=0;i<nb;i++)
    {
    	cin>>bs[i];
    }

    if(n==1)
    {
        cout<<"\n\n----Best Memory Allocation----\n"<<endl;
        bestFitMemory(np,prs,nb,bs);
    }
    else if(n==2)
    {
       cout<<"\n\n----Worst Memory Allocation----\n"<<endl;
       worstFitMemory(np,prs,nb,bs);
    }

	return 0;
}
