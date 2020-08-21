//Abdul Arif 105075345 03-14-2019
//program works on file reads and writes
#include<stdio.h>
#include<stdlib.h>
//structure creation for storitn emplyee details
struct employee{
    char firstname[40];
    char lastname[40];
    int id;
};
typedef struct employee Employee;
/* Input the employee data interactively from the keyboard */
void InputEmployeeRecord(Employee *ptrEmp);
/* Display the contents of a given Employee record*/
void PrintEmployeeRecord(const Employee e[]);
/* Save the contents of the employee record list to the newly created text file specified by FileName */
void SaveEmployeeRecord(const Employee e[], const char *FileName);

int main(){

    Employee e[3]; //an array varible to hold three employee details
    //function call for input taking
    for(int i=0;i<3;i++)
        InputEmployeeRecord(&e[i]);
    //function call for display records
    PrintEmployeeRecord(e);
    //funciton call for store employee details to file
    SaveEmployeeRecord(e, "employee.dat");

    return 0;
}
//Input the employee data interactively from the keyboard
void InputEmployeeRecord(Employee *ptrEmp){
    printf("Enter Employee ID :");
    scanf("%d", &(ptrEmp->id));
    printf("Enter employee's first name :");
    scanf("%s", ptrEmp->firstname);
    printf("Enter employee's last name :");
    scanf("%s", ptrEmp->lastname);
}

// Display the contents of a given Employee record
void PrintEmployeeRecord(const Employee e[]){
    printf("\nEmployee Details are:\n");
    printf("ID\tFIRSTNAME\tLASTNAME\n");
    for(int i=0;i<3;i++){
        printf("%d\t%s\t%s\n",e[i].id,e[i].firstname,e[i].lastname);
    }
}

// Save the contents of the employee record list to the newly created text file specified by FileName
void SaveEmployeeRecord(const Employee e[], const char *FileName)
{
    //Opening a new file called employee and it's a dat file w for writing
    FILE *outfile = fopen("employee.dat", "w");
    if(outfile == NULL){
        fprintf(stderr, "\nError opening file\n");
        exit;
    }
    fprintf(outfile,"ID\tFIRSTNAME\tLASTNAME\n");
    for(int i=0;i<3;i++)
        fprintf(outfile,"%d\t%s\t%s\n",e[i].id,e[i].firstname,e[i].lastname);
}
