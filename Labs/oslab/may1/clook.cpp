#include <iostream> 
#include <vector>
using namespace std; 
int size = 7; 
int disk_size = 200; 
  
void CLOOK_Disk_Scheduling(int arr[], int head) 
{ 
    int seek_count = 0; 
    int distance, cur_track; 
    vector<int> left, right; 
    vector<int> seek_sequence; 
  
    for (int i = 0; i < size; i++) { 
        if (arr[i] < head) 
            left.push_back(arr[i]); 
        if (arr[i] > head) 
            right.push_back(arr[i]); 
    } 
  
    sort(left.begin(), left.end()); 
    sort(right.begin(), right.end()); 
  
    for (int i = 0; i < right.size(); i++) { 
        cur_track = right[i]; 
        seek_sequence.push_back(cur_track); 
        distance = abs(cur_track - head); 
        seek_count += distance; 
        head = cur_track; 
    } 
  
    seek_count += abs(head - left[0]); 
    head = left[0]; 
  
    for (int i = 0; i < left.size(); i++) { 
        cur_track = left[i]; 
        seek_sequence.push_back(cur_track); 
        distance = abs(cur_track - head); 
        seek_count += distance; 
        head = cur_track; 
    } 
  
    cout << "Total seek operations Required= "
         << seek_count << endl; 
  
    cout << "Seek Sequence is" << endl; 
  
    for (int i = 0; i < seek_sequence.size(); i++) { 
        cout << seek_sequence[i] <<"   "; 
    } 
    cout<<endl;
} 
  
int main() 
{ 
    int RequestArray[7] ={ 169, 89, 44, 70, 
                      102, 21, 35};
    int head = 40; 
  
    cout << "Starting position of head: " << head << endl; 
  
    CLOOK_Disk_Scheduling(RequestArray, head); 
  
    return 0; 
} 