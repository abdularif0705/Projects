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
void PrintArray(int size, int array[]){

}
//Description: Swaps two values position in the array
//Inputs: int * var1, int * var2
//Outputs: n/a
void swap(int * var1, int * var2)


//Description: sorts the array from smallest to largest
//Inputs: int size, int array[]
//Outputs: n/a
void SelectionSort(int size, int array[])
{
  int i, j;

//Part 2.3
//Description:  Determines information about the array. Find the minimum value, the max value, the sum of all values and the average of all array values
//Inputs: int size, int array[]
//Outputs: n/a
void ArrayInfo(int size, int array [])
{

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
