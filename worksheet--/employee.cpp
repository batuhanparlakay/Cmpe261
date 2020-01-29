#include <iostream>
using namespace std;
#include <string>

class employee{
private:
  int eId;
  string eName;
  string eLastName;
  string eDepartment;
  int eHourlyWage;

  public:
  // initializing the employee
  employee(int eId, string eName, string eLastName, string eDepartment,int eHourlyWage){
    this ->  eId =  eId;
    this -> eName = eName;
    this -> eLastName = eLastName;
    this -> eDepartment = eDepartment;
    this -> eHourlyWage = eHourlyWage;
 }
//set and get method
  int geteId(){
   return eId;

  }
   string geteName(){
    return eName;
  }

  string geteLastName(){
    return eLastName;
  }

  string geteDepartment(){
    return eDepartment;
  }

 int geteHourlyWage(){
    return eHourlyWage;
  }

// tostring method
 void toString(){
    cout << " my id is " << employee::geteId() << " my name is " << employee::geteName() << " and surname  "<< employee::geteLastName()<< "department is" << employee::geteDepartment() << " hourlywage " << employee::geteHourlyWage();

  }
   
  };