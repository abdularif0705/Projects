//Assignment 4
//Noah Marentette
//105081869

#include<stdio.h>
#include<string.h>
#include<stdlib.h>


typedef struct event//Event Structure
{
    int hour;//hours set as integer
    int min;//Minutes set as int
    char description[41];//description, char for character entries

    struct event*ptrNext; //pointer to struct


}Event;


Event* ptrFirst = NULL; // First
Event* ptrLast = NULL; // Last


void addEvent(int, int , char[41]);//function addEvent
void viewEvent();//Function viewEvent
void loadEvent(char *);//function loadEvent
int saveEvent(char *);//function saveEvent
int checkRepeated(int , int ,char[41]) ;//function checkRepeated


/*Function adds an event to the list, and organizes the events in chronological order
 * Function assumes minutes and hours will be numbers, and that the description will be character values
 * Function returns nothing to main*/

void addEvent(int hours, int mins, char des[41])
{
    Event *newnode=(Event *) malloc(sizeof(Event));//allocates enough memory for events
    newnode->hour=hours; // new event entry for all elements of struct
    newnode->min =mins;//sets min will equal mins
    strcpy(newnode->description, des);//copies description to des

    if (ptrFirst == NULL)//condition
    {
        ptrFirst = newnode;//sets ptrfirst to newnode
        return;

    }

    Event * p =ptrFirst, *L = p;

    while ((p != NULL && p->hour<hours)||(p != NULL && p->hour == hours && p->min<mins))//loop
    {
        L=p;
        p=p->ptrNext;

    }

    if(p == ptrFirst)
    {
        newnode-> ptrNext =ptrFirst;
        ptrFirst = newnode;
    }
    else
    {
        newnode->ptrNext = L->ptrNext;
        L->ptrNext=newnode;
    }


}

/*Function prints the event list
 * assumes nothing
 * returns nothing to main function*/

void viewEvent()
{
    Event* ptrCurrent = NULL;//ptrcurrent empty
    ptrCurrent =ptrFirst;//ptrcurrent equals prtfirst

    while (ptrCurrent != NULL)//condition
    {
        printf("%02d:%02d %s\n\n",ptrCurrent->hour, ptrCurrent->min, ptrCurrent->description);//prints event
        ptrCurrent = ptrCurrent ->ptrNext;//ptrcurrent set to next event

    }

}

/*Function saves each event to the event list to be accessed later by other functions
 * assumes nothing
 * returns 'i' */

int saveEvent(char *filename)
{
    FILE *fn;//pointer
    int i = 0;//counter for entries

    Event* ptrCurrent =NULL;//sets to null

    fn = fopen(filename,"w");//opens file

    if (fn != NULL)
    {
        ptrCurrent =ptrFirst;
        while (ptrCurrent != NULL)//while valid each entry will save into the file
        {
            fprintf(fn, "%d %d %s\n", ptrCurrent-> hour , ptrCurrent -> min, ptrCurrent-> description);//print to file
            i++;//adds 1 to i so that next entry can be saved

        }
        fclose(fn);//when complete file will close
    }

    return i;//returns i

}


/*Function loads schedule
 * assumes file has already been created
 * returns nothing*/

void loadEvent(char *filename)
{
    FILE *f;//pointer
    f = fopen(filename,"r"); //reads the file
    int hours;//hours declaration
    int mins;//minutes declaration
    char des[41];//description declaration

    if (f != NULL)//only executes if condition is met
    {
        while (!feof(f))//loop for action
        {
            fscanf(f,"%d %d %s ",&hours,&mins,&des);//scans file
            if (checkRepeated(hours,mins,des)==0) // condition relating to function checkRepeated, if equal to 0 will execute
            {
                addEvent(hours,mins,des);//calls function addEvent
            }
        }
    }
}


/*This function checks each entry while looking for similarities
 * if an entry repeats itself, the entry will be deleted until there is only one
 * Function assumes nothing
 * returns 0 when complete*/

int checkRepeated(int hours , int mins , char des [41])
{
    Event *p = ptrFirst;//pointer set so entries can be compares

    while (p != NULL)//condition
    {
        if (p-> hour ==hours && p->min == mins && strcmp(p->description,des)==0)//condition to check if entries are similar
        {
            return 1;//returns 1 if true
        }
        p = p->ptrNext;//sets p to next pointer
    }

    return 0;//returns 0 when complete

}

/*Main function
 * Assumes nothing
 * returns 0 when complete*/

int main ()
{
    loadEvent("mylist.txt"); // through the loadEvent function, the program reads the text file
    viewEvent();
    saveEvent("mylist.txt");


    return 0;
}//end main