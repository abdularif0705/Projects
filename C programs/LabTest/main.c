#include <stdio.h>
#include <stdlib.h>

#define max 20
void rotaterows(int n,int mat[][n]);
void rotate(int n,int mat[][n],int);
void Read2DArray(int n,int mat[][n]);
void Print2DArray(int n, int mat[][n]);
int main ()
{

    int A[max][max];
    int n;
    printf("enter a integer: ");
    scanf("%d",&n );
    Read2DArray(n,A);
    Print2DArray(n,A);
    rotaterows(n,A);
    Print2DArray(n,A);
}
void Read2DArray(int n,int mat[][n]){

	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			printf("please input value at mat[%d][%d]: ",i,j);
			scanf("%d",&mat[i][j]);
		}
	}
}
void Print2DArray(int n, int a[][n]){
	for(int i=0;i<n;i++){printf("\n");
		for(int j=0;j<n;j++){
			printf("%d\t",a[i][j]);
		}
	}
	printf("\n");printf("\n");
}
void rotaterows(int n , int a[][n])
{
    for ( int i =0 ; i<n; i++)
    {
        int k = i+1;
        while (k>0)  // this will determine how many shift will be done
                     // 1 cycle of right shift must swap every element
        {
            int temp = a[i][n-1];       // assign the last element to a temp
            for ( int j = n-1; j>=0 ; j--)
            {
                a[i][j]=a[i][j-1];      // assign current element to its precessor value
            }
            a[i][0]=temp;               // after the loop done, first element take value of the temp NOT the last element fromt shift
            k--;  // keep repeat the cycle depends on K + row index value
        }
    }
}
