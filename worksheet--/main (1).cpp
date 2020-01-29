#include <iostream>
#include <string>
#include "employee.cpp"
using namespace std;

int main(){
employee objE(123578,"BATUHAN","PARLAKAY","CMPE", 10);
cout<<objE.geteDepartment()<<endl;
cout<<objE.geteId()<<endl;

objE.show();


return 0;
};
