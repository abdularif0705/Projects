#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#define COL 20
#define ROW 20
//Description: Prints the matrix to the user in the console gets A, rowsize, colsize, from user
void PopulateArray2DUnique(int A[][COL], unsigned int rowsize,unsigned int colsize, int min , int max){
    int i, j;
    for(i=0; i<rowsize; i++)
        for(j=0; j<colsize; j++)
            A[i][j] = min + rand() % (max - min+1);


}

void DisplayArray(int A[][COL] , unsigned int rowsize , unsigned int colsize){
    int i, j;
    for(i=0; i<rowsize; i++){
        for(j=0;j<colsize; j++){
            printf("%d  ",A[i][j]);
        }
        printf("\n");
    }
}

int FindLargest(int A[][COL] , unsigned int rowsize , unsigned int colsize){
    int max=0;
    for(int i=0; i<rowsize; i++){
        for(int j=0; j<colsize; j++){
            if(A[i][j] > max)
                max = A[i][j];
        }
    }
    return max;
}

int FindColumnSum(int A[][COL] , unsigned int rowsize , unsigned int colsize, unsigned int col_to_sum){
    int Col_sum = 0;
    for(int i=0; i<rowsize; i++){
            Col_sum+=A[i][col_to_sum];
    }
    return Col_sum;
}

int Sort2DArray(int A[][COL] , unsigned int rowsize , unsigned int colsize, unsigned int Order){
    int n = colsize;
    int temp[n*n];
    int k = 0;
    if(Order == 1){
        for(int i=0; i<rowsize; i++){
            for(int j=0; j<colsize; j++){
                for(int k=0; k<rowsize; k++){
                    for(int p=0; p<colsize; p++){
                        if(A[i][j]<A[k][p]){   // key point
                            int t=A[i][j];
                            A[i][j]=A[k][p];
                            A[k][p]=t;
                        }
                    }
                }
            }
        }
    }
    else{
        for (int i=0; i<rowsize; i++){
            for (int j=0; j<colsize; j++){
                int tmp = A[i][j];
                int l = j+1;
                for (k=i; k<rowsize; k++){
                    while (l<colsize){
                        if (tmp < A[k][l]){
                            tmp = A[k][l];
                            A[k][l] = A[i][j];
                            A[i][j] = tmp;
                        }
                        l++;
                    }
                    l=0;
                }
            }
        }

    }
}

void CopyArray2D(int A[][COL] ,int B[][COL] ,unsigned int rowsize , unsigned int colsize){
    for (int i=0; i<rowsize; i++){
        for (int j=0; j<colsize; j++){
            B[i][j] = A[i][j];
        }
    }
}

int CopyArray2DSpiral(int A[][COL] ,int B[][COL] ,unsigned int rowsize , unsigned int colsize){
    int i, k=0, l=0;
    while (k<rowsize && l<colsize){
        /* Print the first row from the remaining rows */
        for (i=l; i<colsize; ++i){
            B[l][colsize] = A[k][i];
        }
        k++;

        /* Print the last column from the remaining columns */
        for (i=k; i<rowsize; ++i){
            B[k][rowsize]=A[i][colsize-1];
        }
        colsize--;

        /* Print the last row from the remaining rows */
        if(k<rowsize){
            for(i=colsize-1; i>=l; --i){
                B[colsize-1][l] = A[rowsize-1][i];
            }
            rowsize--;
        }

        /* Print the first column from the remaining columns */
        if(l<colsize){
            for(i=rowsize-1; i>=k; --i){
                B[rowsize-1][k] = A[i][l];
            }
            l++;
        }
    }
}

int main()
{
    srand(time(NULL));
    int rows, cols, max, min;

    printf("Please enter the number of rows and the number of columns in the matrix:");
    scanf("%d%d", &rows, &cols);

    int array[ROW][COL],ArrayB[ROW][COL];

    printf("Enter max number that the values in the array can be then enter the smallest value it can be.\n");
    scanf("%d %d", &max, &min);


    PopulateArray2DUnique(array,rows,cols,max,min);

    DisplayArray(array,rows,cols);

    int largest = FindLargest(array,rows,cols);

    printf(" Largest Element is : %d ",largest);

    int sum = FindColumnSum(array,rows,cols,1);

    printf(" Sum of the column is : %d ",sum);

    CopyArray2D(array,ArrayB,rows,cols);

    Sort2DArray(array,rows,cols,1);

    printf(" Displaying after sorting in ascending order \n");

    DisplayArray(array,rows,cols);

    Sort2DArray(array,rows,cols,2);

    printf(" Displaying after sorting in Descending order \n");

    DisplayArray(array,rows,cols);

    CopyArray2DSpiral(array,ArrayB,rows,cols);

    printf(" New Matrix after 2DSpiral Copy \n");

    DisplayArray(ArrayB,rows,cols);
}
