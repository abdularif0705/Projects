#include <stdio.h>
#include <string.h>

// when given a pointer to a word,
// it turns all uppercase letters to lowecase
void ToLowerCase(char *pStr){
  while (*pStr != '\0'){
    if(*pStr >= 'A' && *pStr <= 'Z'){
      *pStr = *pStr + 32;
    }
    if(*pStr >= 'a' && *pStr <= 'z'){
      *pStr = *pStr - 32;
    }
    *pStr++;
  }
  return;
}


// used to check if a letter is a volew
int isVowel(char c){
    return(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
           c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' );
}

// when given a pointer to a word
// it reverses the vouls
void ReverseVowels(char *pStr){
    int len = strlen(pStr); // length of the string
    int counter1 = 0, counter2 = len - 1 ; // the postion of the vowels,

    //below are just checks
    int foundFirstVowel = 0, foundSecondVowel = 0;
    char temp;


    while(counter1 < counter2){

      //looping through eevry letter until we find vowels
      //foundFirstVowel and foundSecondVowel are used to know if we should continue looking for another vowel
        if(isVowel(*(pStr + counter1)) && !foundFirstVowel){
            foundFirstVowel = 1;

        } else if (!foundFirstVowel){
            ++counter1;
        }

        if(isVowel(*(pStr + counter2)) && !foundSecondVowel){
            foundSecondVowel = 1;

        } else if(!foundSecondVowel){
            --counter2;
        }

        //if we find 2 vowels then swap their positons
        if(foundFirstVowel && foundSecondVowel){
            //swap the vowels

            temp = *(pStr + counter1);
            *(pStr + counter1) = *(pStr + counter2);
            *(pStr + counter2) = temp;

            //adjust the postion of the found varibles so that when we look for new ones
            // we dont reuse the old ones
            ++counter1, --counter2;

            // reset the found vowel checkers
            foundFirstVowel=0, foundSecondVowel=0;
        }
    }
}

int main(){
  char test[150];

  printf("Please enter a string of characters: ");
  scanf("%[^\n]s", test);

  ToLowerCase(test);
  printf("The lowercase version is = %s \n", test);

  ReverseVowels(test);
  printf("The reversed version is = %s \n", test);

  printf("%s \n", test);
}
