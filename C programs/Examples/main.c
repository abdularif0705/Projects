#include <stdio.h>
#include <stdlib.h>
/*
int function1(int a){
    a+=10;
    return a;
}
int main()
{
    int a=10;
    function1(a);
    printf("%d %d",a, function1(a));
    return 0;
}
*/
int main(){

    int intarray[5] = {31, 54, 77, 52, 93};

    for(int j=0; j<5; j++){
        printf("%d\n", *(intarray+j));
    }
    return 0;
}
