#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>
struct employee{
    char firstname[40];
    char lastname[40];
    int id;
};typedef struct employee Employee;

Employee EmployeeList[3];
void WordCap(char *x, char *y);
void SaveEmployeeRecord();

int main(){

    FILE *infile;
    infile = fopen ("employee.dat", "r");

    for(int  x = 0; x < 3; x++){
        fscanf(infile,"%d%s%s", &EmployeeList[x].id, EmployeeList[x].firstname, EmployeeList[x].lastname);
    }
    WordCap(EmployeeList[0].firstname,EmployeeList[0].lastname);
    SaveEmployeeRecord();
}

void WordCap(char *x,char *y){
    x[0] = toupper(x[0]);
    y[0] = toupper(y[0]);
}

void SaveEmployeeRecord(){

    char buffer[10];
    char buffer1[10];
    char buffer2[10];

    FILE *outfile;
    outfile = fopen ("employee.dat", "w");
    if (outfile == NULL){
        fprintf(stderr, "\nError opening file\n");
    }
    fprintf(outfile,"ID\tFIRSTNAME\tLASTNAME\n");
    fscanf(outfile, "%s %s %s", buffer, buffer1, buffer2);
    fprintf(outfile,"%d\t%s\t%s\n",EmployeeList[0].id,EmployeeList[0].firstname,EmployeeList[0].lastname);
    fprintf(outfile,"%d\t%s\t%s\n",EmployeeList[1].id,EmployeeList[1].firstname,EmployeeList[1].lastname);
    fprintf(outfile,"%d\t%s\t%s\n",EmployeeList[2].id,EmployeeList[2].firstname,EmployeeList[2].lastname);
}
