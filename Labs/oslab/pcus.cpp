#include<iostream>

using namespace std;
 
int mutex=1;
int full=0;
int empty=3;
int x=0;

int wait(int y)
{	return --y;
}

int signal(int y)
{	return ++y;
}
 
void producer()
{
	mutex=wait(mutex);
	full=signal(full);
	empty=wait(empty);
	x++;
	cout<<"Producer Produces Item   : "<<x<<endl;
	mutex=signal(mutex);
}
 
void consumer()
{
	mutex=wait(mutex);
	full=wait(full);
	empty=signal(empty);
	cout<<"Consumer Consumes Item   : "<<x<<endl;
	x--;
	mutex=signal(mutex);
}
int main()
{	
              int n=0;
	cout<<"Select :---\n1.Producer\n2.Consumer\n3.Exit"<<endl;
	while(1)
	{
		cout<<"Enter Option Number      : ";
		cin>>n;
		switch(n)
		{
			case 1:	 if( mutex==1 && empty!=0 )
			               {          producer();           }
			               else
				 {        cout<<"Buffer is Full!"<<endl;       }
				break;
			case 2:	if( mutex==1 && full!=0 )
				{         consumer();      }
				else
				{         cout<<"Buffer is Empty!"<<endl; }
				break;
			case 3: return 0;
		}
	}
  return 0;
}
