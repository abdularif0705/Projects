#include <stdio.h>
#include <stdlib.h>
#define MAX 100
/*
 * 1st Student Name: Abdul Arif                , UWin No: 105075345
 * 2nd Student Name: Noah Marentette               , UWin No: 105081869
 */

/*
Purpose: for loops move through each position of matrix and User enters values of matrix
*/
void setMatrixData(int numOfRows, int mat[][numOfRows]){
    for(int i=0; i<numOfRows; i++){
        for(int j=0; j<numOfRows; j++){
            printf("Row %d Column %d:\t", i, j);
            scanf("%d", &mat[i][j]);
        }
    }
}
/*
Purpose: fuction prints the matrix, it goes through the second for loop printing each value in the row
and when it reaches the end of the second for loop a new line will be printed and the first for loop will
continue on to the next row
*/
void printMatrixData(int numOfRows, int mat[][numOfRows]){
    for(int i=0; i<numOfRows; i++){
        for(int j=0; j<numOfRows; j++){
            printf("%d ", mat[i][j]);
        }
        printf("\n");
    }
}
/*
Purpose: Function is checking if the matrix is a Magic square. First the function calculates the sum of
all the values in the matrix. Then it moves to checking the sum of the rows. And if all rows equal to the
diagonal sum then count will be 3 and function will continue. And then function will check if column sums equal
to diagonal sum and if all columns are the same then count will be 6 and the next part will check if any numbers
are negative and if they aren't then matrix is a magic square
*/
int isMagicSquare(int numOfRows, int mat[][numOfRows]){
    int diagonalsum = 0, rowsum=0, colsum=0,count=0;

    //calculates sum of diagonal values of matrix

    for(int i=0; i<numOfRows; i++){
            diagonalsum+=mat[i][i];
        }

    //calculates sum of rows
    for(int i=0; i<numOfRows; i++){
            rowsum = 0;//set it to 0 so loop can go through and calculate sum of next row
        for(int j=0; j<numOfRows; j++){
                rowsum+=mat[i][j];
            //check is every column sum is equal to diagonal sum

            if(rowsum == diagonalsum)
                count++;
        }
    }
    if(count!=3)
        return 0;

    //calculates sum of each column
    for(int i=0; i<numOfRows; i++){
        colsum=0;//set it to 0 so loop can go through and calculate sum of next column
        for(int j=0; j<numOfRows; j++){
            colsum+=mat[j][i];
        //check is every column sum is equal to diagonal sum
        if(colsum == diagonalsum)
                count++;
        }
    }
    if(count!=6)
        return 0;

    for(int i=0; i<numOfRows; i++){
        for(int j=0; j<numOfRows; j++){
            if(mat[i][j]<0)
                return 0;
        }
    }
        return 1; // if the matrix is a magic square
}
/*
Purpose: Function checks if all values of matrix are distinct. It tests the original matrix value
Against every other value of matrix and if it repeats twice then function is done. First it tests
rows and sees if it repeats then it tests every column.
*/
int isDistinctSquare(int numOfRows, int mat[][numOfRows]){
    int original;
    for(int i=0; i<numOfRows; i++){
        for(int j=0; j<numOfRows; j++){
            original= mat[i][j];
            for(int j1=j+1; j1<numOfRows; j1++){
                if(original==mat[i][j1]){
                        //midterm 1 answer
                    mat[i][j]+0.01;
                }
            }
        }
    }
    for(int i=0; i<numOfRows; i++){
        for(int j=0; j<numOfRows; j++){
                original= mat[i][j];
            for(int i1=i+1; i1<numOfRows; i1++){
                if(original==mat[i1][j]){
                    mat[i][j]+0.01;
                }
            }
        }
    }
    return 1; // if the matrix has no duplicates all values are unique
}
//sorts the matrix using row-wise approach
void SortRowWise(int numOfRows, int mat[][numOfRows])
{
  int i, j, k, temp[MAX][MAX];
  for (i=0; i<numOfRows; i++)
  {
    for (j=0; j<numOfRows; j++)
    {
      for (k=j+1; k<numOfRows; k++)
      {
        if (mat[i][j] > mat[i][k])
        {
          temp[i][j] = mat[i][j];
          mat[i][j] = mat[i][k];
          mat[i][k] = temp[i][j];
        }
      }
    }
  }

  printf("The sorted matrix is: \n");
  for (i=0; i<numOfRows; i++)
  {
    for (j=0; j<numOfRows; j++)
    {
      printf("%d ", mat[i][j]);
    }
    printf("\n");
  }
}
/*
Purpose: Function prints transpose out.
*/
void GetTranspose(int numOfRows, int mat[][numOfRows]){
    for(int i=0; i<numOfRows; i++){
        for (int j=0; j<numOfRows; j++){
                printf("%d ", mat[j][i]);
        }
        printf("\n");
    }
}

int main()
{
    int matrix[MAX][MAX];
    int numOfRows;

    printf("Enter matrix size \n");
    scanf("%d",&numOfRows);

    printf("Enter Matrix Values \n");
    setMatrixData(numOfRows, matrix);

    printf("Displaying Matrix \n");
    printMatrixData(numOfRows, matrix);

    if(isMagicSquare(numOfRows, matrix) == 1)
        printf("the matrix is a magic square \n");
    else
         printf("the matrix is not a magic square \n");

    if(isDistinctSquare(numOfRows, matrix) == 1)
        printf("Matrix is a distinct square \n");
    else{
        printf("Matrix is not a distinct square \n");
    }

    SortRowWise(numOfRows, matrix);

    printf("Displaying transpose matrix \n");
    GetTranspose(numOfRows, matrix);

    return 0;
}
