#include <iostream>
#include <vector> 
using namespace std; 
  
  
int size = 7; 
int disk_size = 200; 
  
void CSCAN_DiskScheduling(int arr[], int head) 
{ 
    int seek_count = 0; 
    int distance, cur_track; 
    vector<int> left, right; 
    vector<int> seek_sequence; 
  
    left.push_back(0); 
    right.push_back(disk_size - 1); 
  
    for (int i = 0; i < size; i++) { 
        if (arr[i] < head)  
            left.push_back(arr[i]);    //left serviced later
        if (arr[i] > head) 
            right.push_back(arr[i]);   //right serviced
    } 
  
    // sorting left and right vectors 
    std::sort(left.begin(), left.end()); 
    std::sort(right.begin(), right.end()); 
  
    for (int i = 0; i < right.size(); i++) { 
        cur_track = right[i]; 
        seek_sequence.push_back(cur_track); 
        distance = abs(cur_track - head); 
        seek_count += distance; 
        head = cur_track; 
    } 
    head = 0; 

    for (int i = 0; i < left.size(); i++) { 
        cur_track = left[i]; 
        seek_sequence.push_back(cur_track); 
        distance = abs(cur_track - head); 
        seek_count += distance; 
        head = cur_track; 
    } 
  
    cout << "Total seek operations required= " 
         << seek_count << endl; 
  
    cout << "Seek Sequence is" << endl; 
  
    for (int i = 0; i < seek_sequence.size(); i++) { 
        cout << seek_sequence[i]<<"    "; 
    } 
    cout<<endl;
} 
  
int main() 
{ 
  
     
    int requestArray[7] = { 169, 89, 44, 70, 
                      102, 21, 35}; 
    int head = 40; 
  
    cout << "Starting position of Disk head: " << head << endl; 
    CSCAN_DiskScheduling(requestArray, head); 
  
    return 0; 
} 