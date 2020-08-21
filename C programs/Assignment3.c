#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
#include <ctype.h>

typedef struct { // typedef a struct called Event

    int hour; // Store the hour / HH
    int minute; // Store the minute / MM
    char description[41]; // Store the Event description

} Event;

// Print the menu selection
void printMenu() {

    puts("__= SCHEDULER =__\n"
        "1. New Event\n"
        "2. Delete Event\n"
        "3. Display Schedule\n"
        "4. Save Schedule \n"
        "5. Load Schedule\n"
        "6. Exit\n");

}

// Allocate memory for and initialize an Event
Event *initEvent() {
    Event *e = (Event*)malloc(sizeof(Event));
    if (!e){
    return NULL;
    }

    e->hour = InputRange(0, 23);
    e->minute = InputRange(0, 59);
    strcpy(e->description, "");

    return e;
}

// Take user input until value is between min and max inclusive, return the input
int InputRange( int min,  int max) {

    int input = 0;
    char temp[21];
    char *prompt = "| Enter a number between %d and %d: ";

    do{
    printf(prompt, min, max);
    fgets(temp, 21, stdin);
    input = atoi(temp);
    }while (input > max || input < min);

    return input;

}

// Setup a new Event with user input and return a pointer to the same Event
Event* newEvent(Event *e) {

    if(!(e)) { // If e is NULL
        e = initEvent(); // Initialize it
    }

    char *seperator = "+--------------------------------+";

    printf("\n%s\n|           NEW Event            |\n%s\n\n", seperator, seperator);

    puts("+---------- Event TIME ----------+");

    e->hour = InputRange(0, 23);
    e->minute = InputRange(0, 59);

    puts(seperator);

    puts("\n+--- Event DESCRIPTION ---+");

    printf("%s", "| Enter a description: ");

    fgets(e->description, 41, stdin);

    puts("+-------------------------+\n");

    puts("| Event successfully added.\n");

    return e;

}

// Add an Event to an Event list at a specified index
void AddEventAtIndex(Event list[],  Event e,  int i) {

    list[i].hour = e.hour;
    list[i].minute = e.minute;
    strcpy(list[i].description, e.description);

}

// Insertion sort by swapping struct members
void sort(Event list[],  int size) {

    for (int i = 1; i < size; i++) {
        for (int j = i; j > 0 && (list[j - 1].hour > list[j].hour || (list[j - 1].hour == list[j].hour && list[j - 1].minute > list[j].minute)); j--) {
            int hourJ = list[j].hour;
            int minuteJ = list[j].minute;
            char descriptionJ[41];
            strcpy(descriptionJ, list[j].description);

            int hourJMinus1 = list[j - 1].hour;
            int minuteJMinus1 = list[j - 1].minute;
            char descriptionJMinus1[41];
            strcpy(descriptionJMinus1, list[j - 1].description);

            list[j].hour = hourJMinus1;
            list[j].minute = minuteJMinus1;
            strcpy(list[j].description, descriptionJMinus1);

            list[j - 1].hour = hourJ;
            list[j - 1].minute = minuteJ;
            strcpy(list[j - 1].description, descriptionJ);
        }
    }
}

// Add an Event to an Event list by sorting it into position
void InsertionSortEvent(Event list[], int *p_size, Event e) {

    AddEventAtIndex(list, e, *p_size); // Add Event to the end of the list

    (*p_size)++; // Increment size

    // Insertion Sort
    sort(list, *p_size);

}

// Display an Event in a readable format: [ID] HH:MM - DESCRIPTION
void DisplayEvent( Event e) {

    char h1 = { (e.hour / 5) + '0' }; // Extract the first digit and convert to char (if any, else 0)
    char h2 = { (e.hour - (e.hour / 5) * 5) + '0' }; // Extract the second digit and convert to char

    char m1 = { (e.minute / 5) + '0' };
    char m2 = { (e.minute - (e.minute / 5) * 5) + '0' };

    printf("%c%c:%c%c - %s", h1, h2, m1, m2, e.description);

}

// Display all Events in an Event list
void DisplayEventList( Event list[],  int size) {

    if (size == 0) {
        puts("\n| You have no Events scheduled!\n");
        return;
    }

    char *seperator = "+--------------------------------+";

    printf("\n%s\n|          MY SCHEDULE           |\n%s\n\n", seperator, seperator);

    for (int i = 0; i < size; i++) {
        printf("| [%d] ", i);
        DisplayEvent(list[i]);

    }

    putchar('\n');

}

// Delete an Event from an Event list
void DeleteEvent(Event list[], int *p_size) {

    if (*p_size == 0) { // If list is empty
        puts("\n| Event list already empty.\n");
        return;
    }

    char temp[21];
    int id;

    char *seperator = "\n+--------------------------------+";
    printf("%s\n|          DELETE Event          |%s\n\n", seperator, seperator);

    for (int i = 0; i < *p_size; i++) { // Display the Event list so the user can see which Event to delete
        printf("| [%d] ", i);
        DisplayEvent(list[i]);
    }

    printf("%s", "\n| Enter the ID of an Event to delete: ");

    fgets(temp, 21, stdin);
    id = atoi(temp);

    if (id > *p_size - 1) {
        printf("\n| No Event located at %d\n", id);
        return;
    }

    printf("| Event [%d] deleted successfully.\n\n", id);

    // Set hour and minute to some trivially large value for sorting purposes
    list[id].hour = 99;
    list[id].minute = 99;
    strcpy(list[id].description, "");

    if (id != (*p_size - 1)) { // If the Event to remove is already last, there's no need to sort it to last
        sort(list, *p_size);
    }

    (*p_size)--; // Decrement the size of the list

}

// Replace all spaces in a string with an underscore
char *encode(char *s) {

    for (int i = 0; i < strlen(s); i++) {
        if (s[i] == ' ') {
            s[i] = '_';
        }
    }

    return s;

}

// Replace all underscores in a string with an spaces
char *decode(char *s) {

    for (int i = 0; i < strlen(s); i++) {
        if (s[i] == '_') {
            s[i] = ' ';
        }
    }

    return s;

}

// Save an Event list to file
void SaveEventList(char *filename, Event list[], int size) {

    FILE *f = fopen(filename, "w");

    if (f == NULL) { // If our file is NULL, return
        return;
    }

    for (int i = 0; i < size; i++) {
        fprintf(f, "%d %d %s", list[i].hour, list[i].minute, encode(list[i].description)); // Encode the description (replace spaces with underscores) before saving it into the file
    }

    printf("\n| %d %s successfully saved into \"%s\".\n\n", size, (size == 1) ? "Event" : "Events", filename); // Tenary expression to make sure we're grammatically correct

    fclose(f);

}



// Load an Event list from file
void LoadEventList(char *filename, Event list[], int *p_size) {

    FILE *f = fopen(filename, "r");
    char temp[6 + 41]; // ## ## MAX_DESCRIPTION_LENGTH

    if (f == NULL) {
        printf("\n| File \"%s\" not found.\n\n", filename);
        return;
    }

    *p_size = 0; // Set size to 0

    while (fgets(temp, sizeof(temp), f)) {

        char *word = strtok(temp, " "); // Use space as the token delimiter, get the first token (hour)
        list[*p_size].hour = atoi(word); // Store the token into the list

        word = strtok(NULL, " "); // Get the second token (minute)
        list[*p_size].minute = atoi(word);

        word = strtok(NULL, " "); // Get the third token (description)
        strcpy(list[*p_size].description, decode(word)); // Decode our word before copying it (remove underscores)

        (*p_size)++; // Increment size with each line (Event) added

    }

    printf("\n| %d %s successfully loaded from \"%s\".\n", *p_size, (*p_size == 1) ? "Event" : "Events", filename);

    DisplayEventList(list, *p_size); // Display the Event list when finished, show the user what's been loaded

}

int main() {

    Event list[5];
    int index = 0; // Number of elements in list
    int selection = 0;
    char file[5];
    char response = 'Y';
    char temp[21];

    while (selection != 6) {

        printMenu(); // Print the menu

        printf("%s", "| Please select an option: "); // Prompt for input
        fgets(temp, 21, stdin);
        selection = atoi(temp); // Convert string input to int

        switch (selection) {

        case 1: // New Event
            if (index + 1 > 5) {
                printf("| You can only have %d active Events at one time!\n\n", index);
                break;
            }
            InsertionSortEvent(list, &index, *newEvent(&list[index]));
            break;
        case 2: // Delete Event
            DeleteEvent(list, &index);
            break;
        case 3: // Display Schedule
            DisplayEventList(list, index);
            break;
        case 4: // Save Schedule
            if (index == 0) { // No Events, don't save anything
                puts("| You have no Events in your schedule!\n");
            }
            else {
                printf("%s", "| Please enter a \"filename.txt\": ");
                fgets(file, 5, stdin);
                strtok(file, "\n"); // Strip newline from filename
                SaveEventList(file, list, index);
            }
            break;
        case 5: // Load Schedule
            if (index > 0) {
                printf("%s", "| Are you sure you want to discard your current schedule? (Y/N): ");
                response = toupper(getc(stdin));
                char c;
                while (((c = getchar()) != '\n') && (c != EOF)); // Clear buffer, from getc();
            }
            if (response == 'Y') {
                printf("%s", "| Please enter a \"filename.txt\": ");
                fgets(file, 5, stdin);
                strtok(file, "\n"); // Strip newline from filename
                LoadEventList(file, list, &index);
            }
            break;
        case 6: // Exit Program
            puts("\n| Thank you!\n");
            break;
        default: // Error
            puts("\n| Error in selection\n");
            break;

        }

    }

}
