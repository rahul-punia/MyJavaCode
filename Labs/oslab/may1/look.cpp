#include <iostream>
#include<vector>

using namespace std; 
  
// Code by Vikram Chaurasia 
  
// C++ program to demonstrate 
// SCAN Disk Scheduling algorithm 
  
int size = 7; 
int disk_size = 200; 
  
void LOOK_DiskScheduling(int arr[], int head, string direction) 
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
  
    std::sort(left.begin(), left.end()); 
    std::sort(right.begin(), right.end()); 
  
    int count = 2; 
    while (count--) { 
        if (direction == "left") { 
            for (int i = left.size() - 1; i >= 0; i--) { 
                cur_track = left[i]; 
                seek_sequence.push_back(cur_track); 
                distance = abs(cur_track - head); 
                seek_count += distance; 
                head = cur_track; 
            } 
            direction = "right"; 
        } 
        else if (direction == "right") { 
            for (int i = 0; i < right.size(); i++) { 
                cur_track = right[i]; 
                seek_sequence.push_back(cur_track); 
                distance = abs(cur_track - head); 
                seek_count += distance; 
                head = cur_track; 
            } 
            direction = "left"; 
        } 
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
    int requestArray[7] = { 169, 89, 44, 70, 
                      102, 21, 35}; 
    int head = 40; 
    string headDirection = "right"; 
  
    cout << "Starting position of head: " 
         << head << endl; 
  
    LOOK_DiskScheduling(requestArray, head, headDirection); 
  
    return 0; 
} 