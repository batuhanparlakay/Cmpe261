#include <iostream>
using namespace std;
#include <string>
#include "train.cpp"
int main(){

    train t1 (1234567891,250,"ankara",123);
    cout<<t1.getconsumerId()<<endl;
   
   train t2 (1452874658,500,"istanbul",321);
   cout<<t2.gettrainRoute()<<endl;

   train t3 (1478541239,1000,"ankara", 541);
   cout<<t3.gettotalPassanger()<<endl;

   train list[] ={t1,t2,t3};

   for(int i=0; i<3; i++){
     for(int j=0; i<3; i++){
       if(list[i].gettrainRoute()==list[j].gettrainRoute())
       cout<<" train is "<<list[i].gettrainId()<<" and train "<<list[j].gettrainId()<<" have the same "<<list[i].gettrainRoute()<<endl;
     }

   }

   

   
   return 0;


};

