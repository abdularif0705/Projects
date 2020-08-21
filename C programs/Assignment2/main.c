//Assignment 2
//Abdul Arif 105075345 02/26/2019
/*
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int anagramGroupCount = 0;
//function to sort the words in alphabetical order from z-a
void SortWords(char str[][21], int num){
    for (int i=1; i<=num; i++){
        char temp[strlen(str[i])];
        for(int j=i+1; j<=num; j++){
            if (strcmp(str[i], str[j]) > 0){//compares words in the string
                strcpy(temp, str[i]); //copies string to temporary value
                strcpy(str[i], str[j]);
                strcpy(str[j], temp);
            }
        }
    }
}
//function tests whether a word is an anagram
int isAnagram(char wordList[100][21], int num1, int num2){

    char word1[21];
    char word2[21];

    strcpy(word1, wordList[num1]);
    strcpy(word2, wordList[num2]);

   int first[26] = {0}, second[26] = {0}, c = 0;

   while (word1[c] != '\0')
   {
      first[word1[c]-'a']++;
      c++;
   }
   c = 0;

   while (word1[c] != '\0')
   {
      second[word2[c]-'a']++;
      c++;
   }

   for (c = 0; c < 26; c++)
   {
      if (first[c] != second[c])
         return 0;
   }

   return 1;
}

//Function to assign each anagram to an anagram group
void AssignGroup(char wordList[101][21], int wordCount, int anagramGroup[101][101]){
    int word1 = wordCount;
    int i = 1;

    if (anagramGroupCount == 0){
        anagramGroup[i][0] = wordCount;
        anagramGroupCount = 1;
        return;
    }

    while(i <= anagramGroupCount){
        int word2 = anagramGroup[i][0];
        if (isAnagram(wordList, word1, word2) == 1)
        {
            int openElement = 1;
            while(anagramGroup[i][openElement] != 0)
                openElement++;

            anagramGroup[i][openElement] = wordCount;
            return;
        }
        i++;
    }
    anagramGroupCount++;
    anagramGroup[anagramGroupCount][0] = wordCount;
}
//function to get the top five groups from the groups of anagrams
void CalculateTopFiveGroups(int anagramGroup[101][101], int topFiveGroups[5][2]){
    //declares variables that are to be used in the sort
    int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;
    int top1 = 0, top2 = 0, top3 = 0, top4 = 0, top5 = 0;
    int i;
    for(i = 1; i <= anagramGroupCount; i++){
        int count = 1;
        while(anagramGroup[i][count] != '\0'){
            count++;
        }
        if(count >= count1){
            count5 = count4;
            count4 = count3;
            count3 = count2;
            count2 = count1;
            count1 = count;
            top5 = top4;
            top4 = top3;
            top3 = top2;
            top2 = top1;
            top1 = i;
        }
        else if(count >= count2){
            count5 = count4;
            count4 = count3;
            count3 = count2;
            count2 = count;
            top5 = top4;
            top4 = top3;
            top3 = top2;
            top2 = i;
        }
        else if(count >= count3){
            count5 = count4;
            count4 = count3;
            count3 = count;
            top5 = top4;
            top4 = top3;
            top3 = i;
        }
        else if(count >= count4){
            count5 = count4;
            count4 = count;
            top5 = top4;
            top4 = i;
        }
        else if(count >= count5){
            count5 = count;
            top5 = i;
        }
    }
    topFiveGroups[0][0] = count1;
    topFiveGroups[1][0] = count2;
    topFiveGroups[2][0] = count3;
    topFiveGroups[3][0] = count4;
    topFiveGroups[4][0] = count5;
    topFiveGroups[4][1] = top5;
    topFiveGroups[3][1] = top4;
    topFiveGroups[2][1] = top3;
    topFiveGroups[1][1] = top2;
    topFiveGroups[0][1] = top1;
}

int main(){
    char WordList[101][21];
    int wordCount = 0;
    int tempWordCount = 0;
    char tempWordList[101][21];
    int AnagramGroup[101][101];
    int topFiveGroups[5][2] ={0};

    printf("Please enter a list of words type STOP when finished list\n");
    char str[21]; //string to hold the words
    while(1){
        scanf("%s", str);
        if((strcmp(str, "STOP") == 0) || wordCount > 99){  //if statement to check if STOP is entered or max words is reached
            break;
        }
        tempWordCount++;
        strcpy(tempWordList[tempWordCount], str);
    }
    SortWords(tempWordList, tempWordCount);

    for(int i=1; i<=tempWordCount; i++){
        if(strcmp(tempWordList[i], tempWordList[i+1]) != 0){
            wordCount++;
            strcpy(WordList[wordCount], tempWordList[i]);
            AssignGroup(WordList, wordCount, AnagramGroup);
        }
    }

    CalculateTopFiveGroups(AnagramGroup, topFiveGroups);

    for(int i=0; i<5; i++){
        if (topFiveGroups[i][0] > 0){
            printf("\n");
            printf("Group of size %d:", topFiveGroups[i][0]);
            for(int j=0; j<topFiveGroups[i][0]; j++)
                printf(" %s ", WordList[AnagramGroup[topFiveGroups[i][1]][j]]);
        }
    }
    printf("\n");
        return 0;
}

*/

void ReadWord(char [21]);
void SortWord(char [21]);
void AssignAnagramGroup(int);
void SortWordList();
void CalculateTopFiveGroups();
int isAnagram(char [21], char [21]);

char wordlist[100][21];  //stores list of words
int anagramgroup[100];  //for each word, store the group id it belongs to
int anagramgroupcount=1; //how many groups do we have
int anagramgroupsize[101];  //for each anagramgroup, we store size
int wordcount=0; //how many words were in the list
int largestfive[5]={0}; //stores top 5 anagramgroups
int groupsizeorder[100]; //array to hold the groupsize in corresponding word placement
int main ()
{
 char word[21];
 int done = 0;
 int i, j, k;
 int x=1;
 do
 {
    ReadWord(word);
        if (strcmp(word, "STOP")==0 || wordcount > 99)
            break;

    strcpy(wordlist[wordcount++], word);
    AssignAnagramGroup(wordcount-1);

}while(1);

for (i=0; i<wordcount; i++){
    printf ("ReadWord: Wordlist[%d]=\"%s\"      AnagramGroup=%d\n", i, wordlist[i], anagramgroup[i]);}
    printf ("WordList size=%d words\n", wordcount);
    for (i=1; i<=5; i++)
        if (anagramgroupsize[i]!=0)
            printf ("Anagram Group %d of size %d\n", i, anagramgroupsize[i]);
    printf ("\n");

    SortWordList();
    CalculateTopFiveGroups();

for (i=0; i<wordcount; i++){
    printf ("Wordlist[%d]=\"%s\"   Gid=%d   Gsize=%d\n", i, wordlist[i], anagramgroup[i], groupsizeorder[i]);}
 //THIS IS WHAT NEEDS CHANGING****
 for (i=0; i<5 && largestfive[i+1]!=0; i++){
    printf("Group size of: %d ", largestfive[i+1]);
    printf("\n");
 }

 return 0;
}

void ReadWord(char word [])
{
 scanf ("%s", word);
}

void AssignAnagramGroup (int wordcount)
{
 int j;
    if (wordcount==0)
    {
        anagramgroup[0]=1;
        anagramgroupsize[1]=1;
    }
    else
    {
        for (j=0; j<wordcount; j++)
        {
            if (isAnagram(wordlist[wordcount],  wordlist[j]) ==1)
            {
                anagramgroup[wordcount]=anagramgroup[j];
                anagramgroupsize[anagramgroup[j]]+=1;
                break;
            }
        }

        if (j==wordcount){
                anagramgroup[wordcount]=++anagramgroupcount;
            anagramgroupsize[anagramgroup[j]]+=1;
        }
 }
    return;
}

int isAnagram (char word1[],char word2[])
{
   int first[26] = {0}, second[26] = {0}, c = 0;

   while (word1[c] != '\0')
   {
      first[word1[c]-'a']++;
      c++;
   }
   c = 0;

   while (word1[c] != '\0')
   {
      second[word2[c]-'a']++;
      c++;
   }

   for (c = 0; c < 26; c++)
   {
      if (first[c] != second[c])
         return 0;
   }

   return 1;
}

void SortWordList()
{
 int i, j, k, temp;
 char tempchar[21];
    for (i=0; i<wordcount; i++) {
        for (j=0; j<wordcount-1; j++) {
            if (strcmp(wordlist[j], wordlist[j+1])>0){
                strcpy(tempchar, wordlist[j]);
                strcpy(wordlist[j], wordlist[j+1]);
                strcpy(wordlist[j+1], tempchar);

                temp=anagramgroup[j];
                anagramgroup[j]=anagramgroup[j+1];
                anagramgroup[j+1]=temp;
            }
        }
    }

 for (i=0; i<wordcount; i++)
    groupsizeorder[i]=anagramgroupsize[anagramgroup[i]];
 return;
}

void CalculateTopFiveGroups()
{
 int i, j, temp;
 int anagramtemp[101]={0};
 for (i=1; i<=anagramgroupcount; i++){
    anagramtemp[i]=anagramgroupsize[i];
 }

    for (i=0; i<anagramgroupcount; i++) {
        for (j=0; j<anagramgroupcount-i; j++) {
            if (anagramtemp[j+1]<anagramtemp[j+2]){
                temp=anagramtemp[j+1];
                anagramtemp[j+1]=anagramtemp[j+2];
                anagramtemp[j+2]=temp;
            }
        }
    }
 for (i=1; i<=5; i++){
    largestfive[i]=anagramtemp[i];
 }
return;
}
