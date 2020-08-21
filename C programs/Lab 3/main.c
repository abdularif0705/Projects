  /*
Part 1.1
Question 1 & 2

#include <stdio.h>
int main()
{
  int a = 7; int *aPtr; aPtr = &a;
  printf("stat 01: %d \n", a);
  // Guess: print the value of a
  // This statement will print the value of a

  printf("stat 02: %p \n", &a);
  // Guess: print the address of variable a
  // This statement will print the address of variable a

  printf("stat 03: %p \n", aPtr);
  // Guess: print the value of the pointer aPtr
  // This statement will print the value of pointer aPtr

  printf("stat 04: %p \n", &aPtr);
  // Guess: print the address of pointer aPtr
  // This statement will print the address of pointer aPtr

  printf("stat 05: %d \n", a);
  // Guess: print value of a
  // This statement will print the value of a

  printf("stat 06: %d \n", *aPtr);
  // Guess: print the value of address aPtr
  // This statement will print the value on address aPtr

  printf("stat 07: %p \n", *&aPtr);
  // Guess: print the pointer of address aPtr
  // This statement will print the value on the pointer of address aPtr

  printf("stat 08: %p \n", &*aPtr);
  // Guess: print the address on on value on pointer aPtr
  // This statement will print the address on value on pointer aPtr

  printf("stat 09: %d \n", *&a);
  // Guess: print the value on address of a
  // This statement will print the value on address of a

  return 0;
}

Part 1.2

#include <stdio.h>
int main()
{
  float b = 3.7f;
  float * bPtr;

  // This statement will print ............
  printf("stat 01: value of b = %f \n", b);
  // This statement will print the unsigned int presentation of the address
  // that bPtr pointing at in memory
  printf("stat 02: %u \n", bPtr);

  // let bPtr point to the address of variable b in memory
  bPtr = &b;

  // Write down the value you will get from this print statement, call it var1
  printf("stat 03: %u \n", bPtr);

  // this statement will print the address of variable b
  printf("stat 04: %u \n", &b);

  printf("stat 05: currently bPtr store the address of variable b which is %u in unsigned int format or %p in hexadecimal format \n", bPtr, bPtr);
  // this statement will print the address of variable b

  printf("stat 06: the size of b in memory is: %d \n", sizeof(b));
  // this statement is going to 4, every pointer is 4 bytes

  bPtr++;

  // Write down the value you will get from this print statement, call it var2
  // Write the value - address will be icremented by 4 bytes/size of integer - address + 4
  printf("stat 07: %u \n", bPtr);

  return 0;
}

*/
//Part 2.1
#include <stdio.h>
void ArrayInfo(int size, int array[]);
void SelectionSort(int a, int b[]);
void ReverseArray(int size, int *ptr2Array);

/*
Original
void PrintArray(int size, float array[])
{

  for (int i = 0; i < size; i++)
  {

    printf("%p %f\n", &array[i],array[i]);

  }

  printf("\n");

}
*/
//Part 2.2

//Description: prints the the array position, value and pointer location
//Inputs: int size, int array[]
//Outputs: n/a
void PrintArray(int size, int array[])
{
  int i;
  for(i = 0; i < size; i++)
    printf("Array[%d] = %d, Address: %p\n", i, array[i], &array[i]);
}

//Description: Swaps two values position in the array
//Inputs: int * var1, int * var2
//Outputs: n/a
void swap(int * var1, int * var2)
{
    //swapping *var1 and *var2 and that changes the array outside because of pointers
  int temp;
  temp = *var1;
  *var1 = *var2;
  *var2 = temp;
}

//Description: sorts the array from smallest to largest
//Inputs: int size, int array[]
//Outputs: n/a
void SelectionSort(int size, int array[])
{
    int i, j;
    for(i=0; i<size-1; i++)
    {
        int min = i;
        for(j=i+1; j<size; j++)
        {
            if (array[j] < array[min])
            min = j;
        }
        //when u send an array with integers you use the &ampersand symbol
        swap(&array[min], &array[i]);//sending array[i] bc we set min = j
    }
}

//Part 2.3
//Description:  Determines information about the array. Find the minimum value, the max value, the sum of all values and the average of all array values
//Inputs: int size, int array[]
//Outputs: n/a
void ArrayInfo(int size, int array [])
{
  int sum = 0, i;
  int min = array[0];
  int max = array[0];
  for (i=0; i<size; i++)
  {
    if(max < array[i])
    {
      max = array[i];
    }
    if(min > array[i])
    {
      min = array[i];
    }
    sum += array[i];
  }
  printf("\nArray Info:\n");
  printf("Sum: %d\n", sum);
  printf("Min: %d\n", min);
  printf("Avg: %f\n", ((double)sum) / size);
}

//2.4
//Description: Reverses the order of the array
//Inputs: int size, int *ptr2Array
//Outputs: n/a
void ReverseArray(int size, int *ptr2Array)
{
  int i, j;
  for(i = 0; i < size; i++)
  {
    int max = i;
    for(j = i + 1; j < size; j++)
    {
      if(ptr2Array[j] > ptr2Array[max])
        max = j;
    }
    swap(&ptr2Array[max], &ptr2Array[i]);
  }
}


int main()
{
  int data [] = {2, 7, 8, -8, 1, 9, 3, 5};
  SelectionSort(sizeof(data) / sizeof(int), data);
  printf("Sorted Array:\n");
  PrintArray(sizeof(data) / sizeof(int), data);
  ReverseArray(sizeof(data)/sizeof(int), data);
  printf("\nReversed Array:\n");
  PrintArray(sizeof(data) / sizeof(int), data);
  ArrayInfo(sizeof(data)/sizeof(int), data);
  return 0;
}
