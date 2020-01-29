#include<iostream>  
using namespace std;  
int main (){    
    int myarray[10] = { 100,40,30,10,20,50,60,70,50,20};   
      
    cout<<"\nInput list is \n";
    for(int i=0;i<10;i++)  
    {  
        cout <<myarray[i]<<"\t";  
    }    
    for(int k=1; k<10; k++)   
    {  
        int temp = myarray[k];  
        int j= k-1;  
        while(j>=0 && temp <= myarray[j])  
        {  
            myarray[j+1] = myarray[j];   
            j = j-1;  
        }  
        myarray[j+1] = temp;  
    }  
    cout<<"\nSorted list is \n";
    
    for(int i=0;i<10;i++)  
    {  
        cout <<myarray[i]<<"\t";  
    }  
    cout<<"\nThis array has sorted with insertion sort algorithm!\n";
}  