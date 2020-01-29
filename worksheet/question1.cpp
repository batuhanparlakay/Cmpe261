#include <bits/stdc++.h> 

void thirdValue(int arr[], int arr_size) { 
	
	if (arr_size < 7) { 
		printf(" Input "); 
		return; 
	} 

	int first = arr[0]; 
	for (int i = 1; i < arr_size ; i++) 
		if (arr[i] > first) 
			first = arr[i]; 

	int second = INT_MIN; 
	for (int i = 0; i < arr_size ; i++) 
		if (arr[i] > second && arr[i] < first) 
			second = arr[i]; 

	int third = INT_MIN; 
	for (int i = 0; i < arr_size ; i++) 
		if (arr[i] > third && arr[i] < second) 
			third = arr[i]; 

	printf(" Third Largest element is %d\n", third); 
} 


int main() { 
	int arr[] = {11, 12, 13, 14, 15, 16, 17, 18}; 
	int n = sizeof(arr)/sizeof(arr[0]); 
	thirdValue(arr, n); 
	return 0; 
} 