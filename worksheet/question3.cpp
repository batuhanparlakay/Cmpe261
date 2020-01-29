#include <bits/stdc++.h> 
using namespace std; 
  
int main() 
{ 
    int arr[] = { 3,9,5,1,2,4,15 }; 
  
    int n = sizeof(arr) / sizeof(arr[0]); 
  
    cout << "Array: "; 
    for (int i = 0; i < n; i++) 
        cout << arr[i] << " "; 
  
    reverse(arr, arr + n); 

    cout << "\nReverse: "; 
    for (int i = 0; i < n; i++) 
        cout << arr[i] << " "; 
    return 0; 
} 