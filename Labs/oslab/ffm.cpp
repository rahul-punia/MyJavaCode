#include<iostream>

using namespace std;


void ffMemory(int np,int ps[],int nb,int bs[])
{
	int allocation[np]={0};

	for(int i=0;i<np;i++)
	{
		allocation[i] = -1;
	}

	for(int i=0;i<np;i++)
	{
		for(int j=0;j<nb;j++)
		{
			if(ps[i]<=bs[j])
			{
				allocation[i]=j;
				bs[j] = bs[j]-ps[i];
				break;
			}
		}
	}

	cout<<"Process    Process Size     BlockNumber"<<endl;

	for(int i=0;i<np;i++)
	{
		cout<<"  "<<i+1<<"\t\t"<<ps[i];
		if(allocation[i]!= -1)
		{
			cout<<"\t\t"<<allocation[i]+1<<endl;
		}
		else
		{
			cout<<"\t\tBlock Not assigned"<<endl;;
		}
	}
}



int main()
{
    int np=0,nb=0;
    cout<<"Enter Number of Processes: ";
    cin>>np;
    int ps[np]={0};                               // ps process sizes array             
    for(int i=0;i<np;i++)
    {
    cout<<"Enter "<<i<<"Process Sizes="<<endl;
    	cin>>ps[i];
    }
    cout<<"Enter The Number of Blocks: ";
    cin>>nb;
    int bs[nb]={0};                               // bs block sizes array
    for(int i=0;i<nb;i++)
    {
    cout<<"Enter "<<i<<" Memory Block Sizes :--"<<endl;
    	cin>>bs[i];
    }
    ffMemory(np,ps,nb,bs);
	return 0;
}