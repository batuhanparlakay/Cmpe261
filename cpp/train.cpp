#include <iostream>
using namespace std;
#include <string>

class train{
private:

int consumerId;
int totalPassanger;
string trainRoute;
int trainId;

public:
train(int consumerId , int totalPassanger , string trainRoute , int trainId  ){

    this-> consumerId = consumerId;
    this-> totalPassanger = totalPassanger;
    this-> trainRoute = trainRoute;
    this-> trainId = trainId;

}

train(){

}

 int getconsumerId(){
   return consumerId;
 }
 
 int gettotalPassanger(){
   return totalPassanger;  
 }

 string gettrainRoute(){
   return trainRoute;
 }

int gettrainId(){
   return trainId;
 }

 void setconsumerId(int consumerId) {
	this->consumerId=consumerId;
 }

 void settotalPassanger(int totalPassanger) {
	this->totalPassanger=totalPassanger;
 }

 void settrainRoute(int trainRoute) {
	this->trainRoute=trainRoute;
 }

 void settrainId(int trainId) {
	this->trainId=trainId;
 }


 void toString(){
    cout << " my train consumerId is " << train::getconsumerId() << " and total passanger is " << train::gettotalPassanger() << " and trainRoute is  "<< train::gettrainRoute()<< " and trainId " << train::gettrainId() ;

  }
};
   
 






