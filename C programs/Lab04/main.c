//Abdul Arif 105075345 02/25/2019
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void Reverse(char Buffer3[]){//Reverses string so hello becomes o11eh
    int end = strlen(Buffer3)-1;//subtract 1 at end so it doesn't count the \0 as part of string when it counts the length of string
    for(int i=0; i<end; i++){//Reverses string so hello becomes o11eh
        char temp = Buffer3[i];
        Buffer3[i] = Buffer3[end];
        Buffer3[end] = temp;
        end--; //so for loop stops halfway
    }
}

void RecursiveReverse(char Buffer3[], int end, int start){
    if(start<end){//Recursively Reverses string so hello becomes o11eh
        char temp = Buffer3[start];
        Buffer3[start] = Buffer3[end];
        Buffer3[end] = temp;
        RecursiveReverse(Buffer3, end-1,start+1);//recursive step
    }
}

int main()
{
    char Buffer1[] = {'t','h','i','s',' ','i','s',' ','t','h','e',' ','f','i','r','s','t',' ','b','u','f','f','e','r','\0'};
    char Buffer2[] = "this is the second buffer";
    char Buffer3[80];

    printf("Enter in string value for Buffer3");
    scanf("%[^\n]s", Buffer3);//Includes white spaces in array

    printf("%s\n%s\n%s\n", Buffer1, Buffer2, Buffer3);

    char * pBuffer = Buffer3;
    while(*pBuffer != '\0'){//keeps printing every character in string until it reaches the last character \0
        printf("%c" ,*pBuffer);
        pBuffer++;
    }
    pBuffer = Buffer3;
    printf("\n%s", pBuffer);

    printf("\nBefore Reverse function %s\n", Buffer3);
    Reverse(Buffer3);
    printf("After Reverse function %s\n", Buffer3);
    Reverse(Buffer3);
    printf("Before RecusiveReverse function %s\n", Buffer3);
    RecursiveReverse(Buffer3, strlen(Buffer3)-1, 0);
    printf("After RecusiveReverse function %s\n", Buffer3);

    return 0;
}
