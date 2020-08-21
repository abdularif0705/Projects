//Abdul Arif 105075345 Mar 7 2019
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void ParseSentence(char str[]);

int main()
{
    char str[80];

    printf("Enter a string to split and list in alphabetical order.");
    scanf("%[^\n]s", str);

    ParseSentence(str);
    return 0;
}

void ParseSentence(char str[]){
    //storing the pointers of the string in a array
    char *tokenptr;
    char *list[100];
    int i=0;
    tokenptr = strtok(str, " ,.-");
    while(tokenptr != NULL)
    {
        list[i] = tokenptr;
        tokenptr = strtok(NULL, " ,.-");
        i++;
    }

    //sorting in alphabbetical order using bubble sort
    int size = i;

    for (int i=0; i<size; i++){
        for(int j=0 ; j<size-i-1; j++){
           if (strcmp(list[j], list[j+1]) > 0){
                char *temp = list[j+1];
                list[j+1] = list[j];
                list[j]=temp;
           }
        }
    }
    //printing the final array in alphabetical order
    for (int i=0; i<size; i++){
        printf("%s\n", list[i]);
    }
}
