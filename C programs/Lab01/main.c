// Abdulrehman Arif 105075345 Jan 22 2018
//Lab 01

#include <stdio.h>
#include <stdlib.h>

int fun1(int n);
int fun2(int n);
int fibonacci(int n);
int GCD(int x, int y);
int power(int a, int b);
int print(int n, int m);
int drawTriangle(int n);
void drawLine(int n);

int fun1i(int n);
int fun2i(int n);
int fibonaccii(int n);
int GCDi(int x, int y);
int poweri(int a, int b);
int printi(int n, int m);
int drawTrianglei(int n);

int main(){
    int c, a, b, n, m, x, y;
    printf("Please Enter \n 1 for fun1 \n 2 for fun2\n 3 for fibonacci \n 4 for GCD\n 5 for power\n 6 for print \n 7 for drawTriangle\n 8 for non-recursive fun1 \n 9 for non-recursive fun2\n 10 for non-recursive fibonacci \n 11 for non-recursive GCD\n 12 for non-recursive power\n 13 for non-recursive print \n 14 for non-recursive drawTriangle");
    scanf("%d", &c);
    switch (c){

        case 1:
            printf("Please enter an integer value\n");
            scanf("%d", &n);
            printf("%d\n", fun1(n));
            break;

        case 2:
            printf("Please enter an integer value\n");
            scanf("%d", &n);
            printf("%d\n", fun2(n));
            break;

        case 3:
            printf("Please enter an integer value\n");
            scanf("%d", &n);
            printf("%d", fibonacci(n));
            break;

        case 4:
            printf("Please enter two integer values\n");
            scanf("%d %d" ,&x ,&y);
            printf("%d", GCD(x, y));
            break;

        case 5:
            printf("Please enter two values for the power function\n");
            scanf("%d %d", &a, &b);
            printf("%d\n", power(a, b));
            break;

        case 6:
            printf("Please enter two values where the second value is less than the first\n");
            scanf("%d%d", &n, &m);
            print(n, m);
            break;

        case 7:
            printf("Please enter an integer value\n");
            scanf("%d", &n);
            drawTriangle(n);
            break;

        case 8:
            printf("Please enter an integer value\n");
            scanf("%d", &n);
            printf("%d\n", fun1i(n));
            break;

        case 9:
            printf("Please enter an integer value\n");
            scanf("%d", &n);
            printf("%d\n", fun2i(n));
            break;

        case 10:
            printf("Please enter an integer value\n");
            scanf("%d", &n);
            printf("%d", fibonaccii(n));
            break;

        case 11:
            printf("Please enter two integer values\n");
            scanf("%d %d" ,&x ,&y);
            printf("%d", GCDi(x, y));
            break;

        case 12:
            printf("Please enter two values for the power function\n");
            scanf("%d %d", &a, &b);
            printf("%d\n", poweri(a, b));
            break;

        case 13:
            printf("Please enter two values where the second value is less than the first\n");
            scanf("%d%d", &n, &m);
            printi(n, m);
            break;

        case 14:
            printf("Please enter an integer value\n");
            scanf("%d", &n);
            drawTrianglei(n);
            break;
    }
    return 0;
}
/*
Purpose: adding consecutive numbers from 1 to n using recursion
n = final number you want to go to
Returns the answer as an integer
*/

int fun1(int n){ //This function adds all numbers up to n
    //base case
    if(n==1)
        return 1;
        //recursive case
    else{
        return n + fun1(n-1);
    }
}
/*
Purpose: adding consecutive numbers from 1 to n using iteration
n = final number you want to go to
Returns sum as an integer
*/

int fun1i(int n){ //This function adds all numbers up to n
    int i;  //must have an input of an integer number
    int sum = 0;
    for(i=1; i<=n; i++){
        sum = sum + i;
    }
    return sum; //It will return the added together values
}
/*
Purpose: summates numbers i = 1 to n using formula (i + 1)^2 using recursion
n = final number you want to go to
Returns the answer as an integer
*/
int fun2(int n){ //This function adds one to each value and then squares the value and adds it to the previous value up to n
    //base case
    if(n==0)
        return 1;
        //recursive case
    else if(n==1){
        return 4;
    }
    else{
        return (n+1)*(n+1)+fun2(n-1);
    }
}
/*
Purpose: summates numbers i = 1 to n using formula (i + 1)^2 using iteration
n = final number you want to go to
Returns the answer as an integer
*/

int fun2i(int n){//This function adds one to each value and then squares the value and adds it to the previous value up to n

    int i, sum = 0;//it requires one input parameter to create a stop for the for loop
    for (i = 1; i <= n; i++) {
        sum+=((i + 1) * (i + 1));
    }
    return sum;//It will return the powers added together
}
/*
Purpose: finds the nth fibonacci value using recursion
n = the nth value in the fibonacci sequence
Returns the answer as an integer
*/

int fibonacci(int n){
    //base case
    if(n==0)
        return 0;
        //recursive case
    else if(n==1 || n==2){
        return 1;
    }
    return fibonacci(n-1) + fibonacci(n-2);
}
/*
Purpose: finds the nth fibonacci value using iteration
n = the nth value
Returns the answer as an integer
*/

int fibonaccii(int n){//fibonacci sequence the term is the sum of the two previous terms
    int i, term0 = 0, term1 = 1, nextTerm;
    if(n==0){ //term 1
        return 0;
    }
    else if(n==1 || n==2){ //term 2
        return 1;
    }
    for(i=1; i<n; i++){
        nextTerm = term0 + term1;
        term0 = term1;
        term1 = nextTerm;
    }
    return nextTerm;
}
/*
Purpose: Finds the greatest common demoninator using recursion
x = number 1 to test with, y = number 2 to test with
Will output the greatest common demoninator
*/

int GCD(int x, int y){
    if (y == 0){ // base case
        return x;
    }

    return GCD(y, x % y); // recursive case
}
/*int GCDi(int x, int y);{
if (y==0){
        return x;
    }
    for (;y>0; y--){
        if(x % y == 0){
            return y;
        }
    }
    return 1;
}*/
/*
Purpose: Finds the greatest common demoninator using iteration
x = number 1 to test with, y = number 2 to test with
Will output the greatest common demoninator
*/

int GCDi(int x,int y){ // functions finds the greatest common denominator(factor)
    int n=0; //temporarily holds value of the new y before exchange
    while(y!=0){
        n=x%y;//Using Euclid's algorithm
        x=y;
        y=n;
    }
    return x;
}
/*
Purpose: raises basae a to power b using recursion
a = base, b = exponent
returns a^b as an integer
*/

int power(int a, int b){
    if (b==1){ // base case
        return a;
    }

    return a * power(a,b-1); // recursive case
}
/*
Purpose: raises basae a to power b using iteration
a = base, b = exponent
returns a^b as an integer
*/
int poweri(int a, int b){
    int i;
    int product = a;
    for(i=1; i<b; i++){
        product*= a;
    }
    return product;
}
/*
Purpose: displays all the positive integers
that are less than the value of n and divdisable by m, where m < n
using recursion
n = dividend, m = a possible divisor
prints out all the divisors as less then n as a integer
*/

int print(int n, int m){
    if(n == 0){ // base case
        printf("\n");
    }
    else if (n%m == 0) {//if remainder of n/m = 0 then that number is a divisible by m and is printed
        printf("%d\n", n);
        print(n-1, m);  // recursive case
    }
    else {//otherwise we run function again and keep reducing n unti we get another number divisible by m
        print(n-1, m); // recursive case
    }
	return 0;
    /*//base case
    if(m>n*x){
        printf("%d\n", n*x);
        print(n, m, x+1);
    }*/

}
/*
Purpose: displays all the positive integers
that are less than the value of n and divdisable by m, where m < n
using iteration
n = dividend, m = a possible divisor
prints out all the divisors as less then n as a integer
*/
int printi(int n, int m){
    for (; n>0; n--){
        if (n % m == 0){//if remainder of n/m = 0 then that number is a divisible by m and is printed
            printf("%d \n", n);
        }
    }
    return 0;
}
/*
Purpose: prints out a row of *'s using recursion, used in rDrawTriangle
m = number of * in a row
prints to the screen a row of *'s
*/
void drawLine(int n) {
	if(n == 0) {
		return;
	}
	else {
		printf("*");
		drawLine(n - 1);
	}
}

int drawTriangle(int n){
    if (n==0)
        return 0;
    else{
        drawTriangle(n-1);
		drawLine(n);
		printf("\n");
        }
return 0;
}
/*
Purpose: prints out a triangle made of *'s using iteration
n = triangle height
prints to the screen a triangle
*/

int drawTrianglei(int n){//Creates a triangle n lines long and each line has the same length of the numbered line that it is on
    for(int i=0; i<n; i++){
        for (int j=0; j<=i; j++)
            printf("*");//creates the stars
        printf("\n"); //creates a the triangle
    }
return 0;
}
