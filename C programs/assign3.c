#include <stdio.h>
#define MAX 5

// structure definition of an event aggregate datat type
typedef struct event{
    int hour;               // the hour part of a time stamp (from 0 - 23 inclusively)
    int minute;             // the minute part of a time stamp (from 0 - 59 inclusively)
    char description[41];   // a small description of an event

} Event;

// Function prototypes
int InputRange(int min, int max);
Event* InputEvent(Event *newEvent);
int AddEventAtIndex(Event list[], Event e, int i);
int InsertionSortEvent(Event list[], int *p_size, Event e);
void DisplayEvent(Event e);
void DisplayEventList(Event list[], int size);
int DeleteEvent(Event list[], int i, int *p_size);
int SaveEventList(char *filename,Event list[],int size);
int LoadEventList(char *filename,Event list[],int *p_size);
void encode(char*s);
void decode(char*s);


int InputRange(int min, int max){
    int input;
    do{
        printf("Please enter an integer between %d and %d: ", min, max);
        scanf("%d", &input);
        printf("\n");

        if(input < min || input > max)
            printf("Invalid input\n");

    } while(input < min || input > max);

    return input;
}

Event* InputEvent(Event *newEvent){
    if(newEvent != NULL) // making sure the pointer is valid
    {
        printf("Enter the event time:\n");
        newEvent->hour = InputRange(0, 23);
        newEvent->minute = InputRange(0, 59);
        printf("Enter the event description: ");
        scanf(" %[^\n]s", newEvent->description);
    }
    else{
        return newEvent;
    }
    return newEvent;
}

// this functions adds an already populated event to the specified
// index of an event list, overwriing what was already there
int AddEventAtIndex(Event list[], Event e, int i){
    list[i] = e;
    return i;

}

// Given a new event, it adds in the appropriate, asscending order
int InsertionSortEvent(Event list[], int *p_size, Event e){
    int index = *p_size;
    // finding what index the event "e" should be set to

    if(*p_size == 0){
        list[0] = e;
        ++(*p_size);
        return 0;
    }
    else if (*p_size > 0){
        for(int x = 0; x < *p_size; x++){
            if(((list[x]).hour > e.hour) || (((list[x]).hour == e.hour) && ((list[x]).minute > e.minute))){
                index = x;
                break;
            }
        }

        //moving every wrongly placed event down 1 index
        for(int x = *p_size; x >= index + 1; x--){
            list[x] = list[x-1];
        }

        AddEventAtIndex(list, e, index);
        ++(*p_size);
        //printf("%d\n", *p_size);
        return index;

    }
    else {
        return *p_size;
    }

}

// will display an event e in the format hh:mm description
void DisplayEvent(Event e){
    printf("%02d:%02d %s\n", e.hour, e.minute, e.description);
}


// displays every event inside the Event list
void DisplayEventList(Event list[], int size){
    for(int x = 0; x < size; x++){
        printf("[%d] ", x);
        DisplayEvent(list[x]);
    }
}

int DeleteEvent(Event list[], int i, int *p_size){
    for(int x = i; x < *p_size - 1; x++){
        list[i] = list[i+1];
        }
    --(*p_size);
    return 1;
}
// takes a string and replaces the space characters with a _
void encode(char*s){
    int x = 0;
    while(s[x] != '\0'){
        if(s[x] == ' '){
            s[x] = '_';
        }
        ++x;
    }
}

// takes a string and replaces the _ characters with a space
void decode(char*s){
    int x = 0;
    while(s[x] != '\0'){
        if(s[x] == '_'){
            s[x] = ' ';
        }
        ++x;
    }
}

// saves a given Event list to a file, encoding the description
int SaveEventList(char *filename, Event list[], int size){
    FILE * file;
    file = fopen(filename, "w");
    for(int x = 0; x < size; ++x){
        encode((list[x]).description);
        fprintf(file, "%d %d %s", (list[x]).hour,(list[x]).minute,(list[x]).description);
        decode((list[x]).description);
        if((x+1) != size){
            fprintf(file, "\n");
        }
    }
    fclose(file);
    return size;
}

// loads in the data from a give file and saves it into a
// event list, decoding the description as it goes
int LoadEventList(char *filename, Event list[], int *p_size){
    FILE * file;
    file = fopen(filename, "r");
    *p_size = 0;

    // loading every line in the file until we reach the end of the file
    while(!feof(file)){
        fscanf(file, "%d %d %s", &(list[*p_size]).hour,&(list[*p_size]).minute,(list[*p_size]).description);
        ++(*p_size);
    }

    for(int x = 0; x < *p_size; x++){
        decode(list[x].description);
    }

    fclose(file);
    return *p_size;
}

void PrintMenu(void){
    puts("__= Scheduler v1.0 =__");
    puts("   1. Schedule an event");
    puts("   2. Delete an event");
    puts("   3. Display schedule");
    puts("   4. Save schedule");
    puts("   5. Load schedule");
    puts("   6. Exit");
    printf("==> ");
}

int main(){
    Event EventList[MAX];
    Event tempEvent;
    int eventListSize = 0; // counter to store the amount of events iu have in the EventList array


    int result;
    int opt; // stores the option the user chooses
    int id; // used for knowing which event to delete
    char temp[41];

    PrintMenu();
    opt = InputRange(1, 6);

    while(opt != 6){
        switch(opt){
            case 1:
                if(eventListSize < MAX){
                    InsertionSortEvent(EventList, &eventListSize, *InputEvent(&tempEvent));
                }
                else {
                    printf("The maxmum number of events you can add to the schedule has been reached!\n");
                    printf("We apologize for any inconvenience this may cause.\n");
                }
                break;

            case 2:
                if(eventListSize == 0){
                    printf("You need to have an event to delete first...\n");
                }
                else {
                    printf("Which event would you like to delete (-1 to cancel)?\n");;
                    scanf("%d", &id);
                    if(id == -1){
                        printf("Canceling...\n");
                    }
                    else if(DeleteEvent(EventList, id, &eventListSize) == -1){
                        printf("Deleting the event has failed.\n");
                        printf("We apologize for any inconvenience this may cause.\n");
                        printf("Possible reasons event could not delete:\n1: I is not in a valid range of events in the array\n2: The list is already empty");
                    }
                    else {
                        printf("Deleting the event was successful!\n");
                    }
                }

                break;

            case 3:
                if(eventListSize == 0){
                    printf("You need to have an event to display first...\n");
                }
                else{
                    printf("____=Schedule=____\n");
                    DisplayEventList(EventList, eventListSize);
                }

                break;

            case 4:
                if(eventListSize == 0){
                    printf("There are 0 files to save. Please add atleast 1 event to save.\n");
                } else {
                    printf("What is the name of the file you would like to save to?\n");
                    scanf(" %[^\n]s", temp);
                    result = SaveEventList(temp, EventList, eventListSize);
                    if(result == -1){
                        printf("Something went wrong :/\n");
                    } else {
                        printf("%d events were saved to %s\n", result, temp);
                    }
                }
                break;

            case 5:
                printf("What is the name of the file you would like to load from?\n");
                scanf(" %[^\n]s", temp);
                result = LoadEventList(temp, EventList, &eventListSize);
                if(result == -1){
                    printf("Something went wrond :/\n");
                }
                else {
                    printf("%d events were loaded from %s\n", result, temp);
                }
                break;
            default:
                printf("Something went wrong :/\n");
        }
        PrintMenu();
        opt = InputRange(1, 6);
    }

    return 0;
}



/* James Moore
   Date: March 29th 2015
*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX 5

// Define the aggregate data type event used in scheduleing
typedef struct event{
   int  hour;  // store the hour between 0 - 23
   int minute; // stores the minute between 0 - 59
   char description[41]; // store a 40 character destriction of event 
}Event; // alternate alias 


// Function Prototypes Below 
//-----------------------------------------
int InputRange(int,int); // used in interactive menu to enter int between 1 and 6 
Event* InputEvent( Event *); // Inputs event into eventlist 
void  DisplayEvent(Event);  // display event 
void DisplayEventList(Event[],int); // display list of events 
int AddEventAtIndex(Event[], Event, int i); // add event at specific index 
int InsertionSortEvent(Event[], int *, Event); // Sort by hour and minute ascending 
int SaveEventList(char *,Event[],int); // Save list to specified filename 
int LoadEventList(char *,Event[],int *);  // Load specified filename 
int DeleteEvent(Event[], int, int *); // Delete event at specified index 
char* encode(char*); // change " " = "_" 
char* decode(char*); // change "_" = " " 

//-----------------------------------------


int main(){// Begginging of program 
    
    Event EventList[MAX];  // array of events using structure event 
    int eventListSize = 0; // keeps track of many events in EventList
    Event tempevent;  // temporary event 
    int i; // iterator 
    char f[20]; // file pointer 
    
    // Interactive menu 
    int menu = 0; 
    
    while(menu >= 0 && menu <= 5) // if not between 0 and 5 quit the program 
    {
    printf("    = Scheduler v1.0 =__\n"); 
    printf("Choose [1]: Schedule An Event \n");
    printf("Choose [2]: Delete An Event \n"); 
    printf("Choose [3]: Display Schedule \n"); 
    printf("Choose [4]: Save Schedule \n"); 
    printf("Choose [5]: Load Schedule \n"); 
    printf("Choose [6]: Exit \n"); 
    
    menu = InputRange(1,6); // input range for interactive menu 
    
    // Depending on what option selected call specific function  
    switch(menu)
    {
        case 1: // insertionsort case 
                if(eventListSize < MAX) // if max events not yet reached 
                {
                    i = InsertionSortEvent(EventList, &eventListSize, *InputEvent(&tempevent));
                    printf("Added at Index\n"); 
                }
                else
                {
                    printf("The Maximum number of events Reached\n");
                    printf("Sorry For Any Inconvience\n");                 
                }
                
        break; 
        
        case 2:// delete event case 
                // if theres at least one event run code below 
                if(eventListSize!=0){  
                DisplayEventList(EventList,eventListSize);
                printf("What Index Do You Want To Delete: 0 - %d\n",eventListSize-1);
                printf("Enter -1 to Cancel\n");
                scanf("%d",&i); 
                if(i != -1){
                i = DeleteEvent(EventList,i,&eventListSize); // if -1 is not chosen delete event at index passed to i 
                    
                   if(i != -1 ) printf("Element %d Deleted\n",i);
                
                }else{
                    printf("Operation Canceled\n"); 
                }
                } else printf("Need Something to Delete\n");
        break;
        
        case 3:// display event case 
                if(eventListSize != 0){ // run if theres at least 1 element to dislay 
                DisplayEventList(EventList,eventListSize);
                } else{
                    printf("Need Something to Display first\n"); 
                }
        break; 
        
        case 4:// save event list case 
              printf("What do you want your file name to be? \n"); 
              scanf("%s",f); 
              i = SaveEventList(f,EventList,eventListSize); // will save eventlist to specified filename 
               printf("Amount of Files Saved %d\n",i); 
                
        break; 
        
        case 5:// load event list case 
              printf("Whats the name of the file you want to load\n"); 
              scanf("%s",f);
              i = LoadEventList(f,EventList,&eventListSize); // will load from file into list 
              printf("Amount of events Loaded [%d]\n",i); 
        break; 
        
        case 6:
              printf("GoodBye\n"); 
            break; 
        
         
    }// End of Switch Statement 
    
    
    }// End of While Loop
    
    

return 0; 
}// end of main 


// Function Deffintions
//-----------------------------------------------------------------------------------------------

// Name: InputRange 
// The function infineitely prompts the user until a range min and max is entered. 
// It will return a valid integer entered by the user from stdin within the range min,max 
int InputRange(int min, int max)
{
    printf("Please Enter An Integer Between %d and %d: ",min,max); 
    int menu; // value to be returned 
    scanf("%d",&menu); // try scanninf in value 
    
    // while continue to prompt till its between min and max inclusive 
    while(menu < min){ // wont work with < and > min and max *******
        printf("Invalid Input\n");
        printf("Please Enter an integer between %d and %d: ",min,max); 
        scanf("%d",&menu); 
    }
    while(menu > max){ // wont work with < and > min and max *******
        printf("Invalid Input\n");
        printf("Please Enter an integer between %d and %d: ",min,max); 
        scanf("%d",&menu); 
    }
    
    return menu; // return value 
    
    
}// InputRange Function End 


//Name: InputEvent
//This function prompts the user for a valid hour, a valid minute and a description string. 
//It makes use of InputRange() for the hour and minute input. It takes a pointer to an event 
//that needs to be populated with the user values and returns the same pointer
Event* InputEvent( Event *newEvent)
{
    if (newEvent != NULL) // quality assurance:
    {
        printf("Enter the event time:\n"); 
        newEvent->hour = InputRange(0,23); // input value from 0 - 23 
        newEvent->minute = InputRange(0,59); // input value from 0 - 59 
        printf("Enter The Event Description: "); 
        getchar();
        fgets(newEvent->description,41,stdin); // fgets for sentence of description 
    }
    return newEvent;
}// End of InputEvent function 


// Name: Display Event 
/* will display an event e in the format
 hh:mm description" */
 void DisplayEvent(Event e)
 {
     printf("%02d:%02d %s\n",e.hour, e.minute, e.description);
 } // end of display event 
 
 // Name: Display Event 
 //Display the entire EventList of size eventListSize preceded 
 //by the index number as stored in the array. 
 void DisplayEventList(Event list[], int size)
 {
     int i; 
     for(i = 0; i < size; i++)
     {
         printf("[%d] ",i); DisplayEvent(list[i]);   
     }
 } // End of Display event list 

// Name: AddEventAtIndex
// Function takes EventList and Populated Event
// Overwrites Eventlist[index] with the populated Event 
int AddEventAtIndex(Event list[], Event e, int i)
{
    list[i].hour = e.hour; // swap hours 
    list[i].minute = e.minute; // swap minutes 
    strcpy(list[i].description, e.description); // swap description  
    return i; 
}


//Name: InsertionSortEvent
// Function Swaps structure array elements based on Hour and Minute 
// Takes EventList and Eventlist size 
// outputs sorted array in ascending order 
int InsertionSortEvent(Event list[], int *p_size, Event e)
{
     list[*p_size] = e; // throw that new event in list at index of p_size
     *p_size += 1; // ad one to elementlistsize 
     
     int i, j; // index variables 
     //int index = 0; 
     
       for(i = 1; i < *p_size; i++)
    {
        for(j=0 ; j < *p_size - i; j++)
        {
            if(list[j].hour == list[j+1].hour) // if hours are same sort by minute 
            {
                if(list[j].minute > list[j+1].minute)
                {
                    struct event temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
            if(list[j].hour > list[j+1].hour) // proceed to just sort by hour if not same 
            {
                struct event temp = list[j];
                list[j] = list[j+1];
                list[j+1] = temp;
            }
            
        }
        
    }
    
return 0; //return index; 
}

// Name: DeleteEvent 
// Takes Eventlist and deletes element at specific index and decrements 
// evenlistsize and swaps around the elements 
int DeleteEvent(Event list[], int i, int *p_size)
{
    if(*p_size != 0){
    *p_size -= 1; // subtract one from *p_size 
    
    for(; i < *p_size; i++) list[i] = list[i+1]; // removes specified index event and shifts list 
    return i; 
    }
    else{
        return -1; 
    }
    
}

// Name: SaveEventList 
// Saves elements of eventlist to specified filename
int SaveEventList(char *filename,Event list[],int size)
{
    FILE *f; 
    f = fopen(filename, "w"); // save eventlist to specified filename 
    int i; 
    
    char *s; 
    
        for(i = 0; i < size; i++){
            s = list[i].description; 
        fprintf(f, "%d %d\t%s",list[i].hour, list[i].minute,encode(s)); // encode each description with "_"
        }
        fclose(f); // close the file 
    return i; 
}

// Name: LoadEventList
// Loads all elements from textfile in array evenlist 
int LoadEventList(char *filename,Event list[],int *p_size)
{
    FILE *f; 
    f = fopen(filename, "r"); 
    int i = 0; 
    char *s; 
    if (f != NULL)             // check if null 
    {
        
            while(!feof(f)){
            fscanf(f, "%d %d %s", &list[i].hour, &list[i].minute,list[i].description );
                            s = list[i].description;
                            decode(s); // Decode '_' to ' ' 
            i++; 
            }
                
            
        
    }
    fclose(f);       // close the file 
    *p_size = i; 
    DeleteEvent(list,i,p_size);// because of new line just delete the extra event at psize and decrement the count 
    return *p_size; 
}

// Name: Encode 
// Takes all spaces in description
// Converts each space to underscore so fields dont get messed up 
char* encode(char*s)
{
    char *temp = s;
    while(*s != '\0')
    {
        // change ' ' = _
        if(*s == ' ') 
        {
         *s = '_';    
        }
        s++; 
    }
    return temp; 
}


// Name: Decode 
// Takes all underscores in description 
// Converts each underscore back to a space 
char * decode(char*s)
{
    char *temp = s; 
    while(*s != '\0')
    {
        if(*s == '_') // change _ back to ' '
        {
            *s = ' '; 
        }
        s++; 
    }
    return temp; 
}