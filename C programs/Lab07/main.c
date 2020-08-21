#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct ProductDescription{

    char productName [25];
    float productPrice;
    float  productWeight;

} Product;


void CreateProductList(Product **productList, int size){

    *productList = (Product *)malloc(sizeof(Product) * 5);

}

void ResizeProductList(Product **productList, int newSize){

    *productList = (Product*) realloc(productList, newSize);
}

Product SetProductInfo(){
    Product product;

    printf("\nPlease Enter the Product Name: ");
    scanf(" %[^\n]s", product.productName);

    printf("\nPlease Enter the Product Price: ");
    scanf(" %d", &product.productPrice);

    printf("\nPlease Enter the Product Weight: ");
    scanf(" %d", &product.productWeight);

    return product;

}


void SortProductList(Product *productList, int size, char sortOption){

}

void AddProductToProductList(Product *productList, int size){

    for(int i=0; i< size; i++){

        printf("\nPlease enter product info for product %d: \n", i);
        *(productList+i) = SetProductInfo();
    }

}

void PrintProductList(Product *productList, int size){

    for(int i=0; i< size; i++){

       printf("\n Product ID: %d Name:  %s", i, (productList+i)->productName);
       printf("\n Product ID: %d Price: %f", i, (productList+i)->productPrice);
       printf("\n Product ID: %d Weight: %f", i, (productList+i)->productPrice);
       printf("\n----------------------------------------------------------------\n");
    }

}

int main() {

    printf("\n");

    Product *list;

    int listSize;
    char sortOption;
    char resize;

    printf("Please Enter the size of the list: ");
    scanf("%d", &listSize);

    CreateProductList(&list, listSize );

    AddProductToProductList(list, listSize);

    PrintProductList(list, listSize);

    printf("\n\nTo sort the product list press: \n'p' to sort by price, or 'w' to sort by weight, or 'n' to sort by name  : ");

    scanf(" %c", &sortOption);

    SortProductList(list,listSize, sortOption);

    PrintProductList(list,listSize);

    printf("\n\nTo resize the product list press 'y' or any other key to escape: ");
    scanf(" %c", &resize);

    if(resize == 'y' || resize == 'Y'){
        printf("Please Enter the new size of the list: ");
        scanf("%d", &listSize);
        ResizeProductList(&list, listSize);
        PrintProductList(list, listSize);
    }




    return 0;
}
