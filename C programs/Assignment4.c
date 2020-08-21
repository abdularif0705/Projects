/*
Author: Breanna Healey-King 
Due Date: April 8 2019 	
Student ID: 104787467
Description: Allows the user to load , save and view the text file 
mylist.txt , and then checks for any repeated events and prints the new list without
them.
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

//event struct
typedef struct event 
{
	int hour;
	int min; 
	char description[41];

	struct event*ptrNext; // self referential 


}Event; 


Event* ptrFirst = NULL; // first 
Event* ptrLast = NULL; // last 

//prototypes 
void addEvent(int, int , char[41]);
void viewEvent(); 
void loadEvent(char *); 
int saveEvent(char *); 
int checkRepeated(int , int ,char[41]) ; 



int main ()
{
	loadEvent("mylist.txt"); // loads the text file  
	viewEvent();
	printf("Save [%d]events back into the schedule \n",saveEvent("mylist.txt")); 


return 0; 
}

//Description: adds an event to the list , adding it 
// in order from earliest time to latetest 
//Input: each event
//Output: returns the event added to the list 
void addEvent(int h, int m, char des[41])
{
	Event *newnode=(Event *) malloc(sizeof(Event));
	newnode->hour=h; // points to a new position for the new event
	newnode->min =m; 
	strcpy(newnode->description, des); 

	if (ptrFirst == NULL)
	{
		ptrFirst = newnode; 
		return; 

	}

	Event * p =ptrFirst, *L = p; 
	
	while ((p != NULL && p->hour<h)||(p != NULL && p->hour == h && p->min<m))
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


}//closing brace 

//Description: allows the events in the list to be seen  
//Input:none 
//Output: prints out the event with the time and description 
void viewEvent()
{
	Event* ptrCurrent = NULL; 
	ptrCurrent =ptrFirst; 	
	
	while (ptrCurrent != NULL)
	{
		printf("%02d:%02d %s\n\n",ptrCurrent->hour, ptrCurrent->min, ptrCurrent->description); 
		ptrCurrent = ptrCurrent ->ptrNext; 

	}

}//closing brace 

//Description:Saves the events to the schedule with the time and desscription 
//writing to the file 
//Input: file name 
//Output: returns a file with saved events 
int saveEvent(char *filename)
{
	FILE *fn; 
	int i = 0; 
	
	Event* ptrCurrent =NULL; 
	
	fn = fopen(filename,"w"); 

	if (fn != NULL)
	{
		ptrCurrent =ptrFirst;
		while (ptrCurrent != NULL)
		{
			fprintf(fn, "%d %d %s\n", ptrCurrent-> hour , ptrCurrent -> min, ptrCurrent-> description);
			i++;

		}
		fclose(fn); 
	}

	return i; 

}//closing brace 


//Description: loads the saved schedule 
//Input: a pointer to the file name 
//Output: returns the file 
void loadEvent(char *filename)
{
	FILE *f; 
	f = fopen(filename,"r"); //reads the file 
	int h; 
	int m; 
	char des[41]; 

	if (f != NULL)
	{
		while (!feof(f))
		{
			fscanf(f,"%d %d %s ",&h,&m,&des);
			if (checkRepeated(h,m,des)==0) // if there are no repeated events 
			{
				addEvent(h,m,des); 
			}

		}


	}
		
} //closing brace 


//Description: Checks the events in the list to see if any two 
// are the same, if there are it removes one of them from the list 
//Input:the description of the event 
//Output: returns a list without duplicates 
int checkRepeated(int h , int m , char des [41])
{
	Event *p = ptrFirst; 
	
	while (p != NULL)
	{
		if (p-> hour ==h && p->min == m && strcmp(p->description,des)==0)
		{
			return 1;
		}
		p = p->ptrNext; 
	}

	return 0; 

}// closing brace 





