//Add the two polynomials using linked list.
#include<stdio.h>
#include<stdlib.h>

struct poly{
  int num, expo;
  struct poly *right;
}*p1 = NULL, *p2 = NULL, *aRoot = NULL;

void eqn1(){
  struct poly *new = (struct poly *)malloc(sizeof(struct poly));
  if (p1 == NULL){
    printf("Adding new polynomial\n");
    printf("\nEnter the number: ");
    scanf("%d", &new->num);
    printf("\nEnter the exponent: ");
    scanf("%d", &new->expo);
    p1 = new;
    new->right = NULL;
    printf("\nDone adding the polynomial!\n");
  }else{
    struct poly *itr = p1;
    printf("\nEnter the number: ");
    scanf("%d", &new->num);
    printf("\nEnter the exponent: ");
    scanf("%d", &new->expo);
    while(itr != NULL) itr = itr->right;
    itr->right = new;
    new->right = NULL;
  }
}

void eqn2(){
  struct poly *new = (struct poly *)malloc(sizeof(struct poly));
  if (p2 == NULL){
    printf("Adding new polynomial\n");
    printf("\nEnter the number: ");
    scanf("%d", &new->num);
    printf("\nEnter the exponent: ");
    scanf("%d", &new->expo);
    p2 = new;
    new->right = NULL;
    printf("\nDone adding the polynomial!\n");
  }else{
    struct poly *itr = p2;
    printf("\nEnter the number: ");
    scanf("%d", &new->num);
    printf("\nEnter the exponent: ");
    scanf("%d", &new->expo);
    while(itr != NULL) itr = itr->right;
    itr->right = new;
    new->right = NULL;
  }
}

void addPoly(){
  struct poly *itr1=p1, *itr2=p2, *itr3 = aRoot;
  struct poly *aNode = (struct poly *)malloc(sizeof(struct poly));
  while (itr1 != NULL && itr2 != NULL){

    if (itr1->expo == itr2->expo){
      aNode->expo = itr1->expo;
      aNode->num = itr1->num + itr2->num;
      aNode->right = NULL;
      if (aRoot == NULL) aRoot = aNode;
      else{
        while (itr3 != NULL) itr3 = itr3->right;
        itr3->right = aNode;
      }
      itr1 = itr1->right;
      itr2 = itr2->right;

    }else if (itr1->expo > itr2->expo){
      aNode->expo = itr1->expo;
      aNode->num = itr1->num;
      aNode->right = NULL;
      if (aRoot == NULL) aRoot = aNode;
      else{
        while (itr3 != NULL) itr3 = itr3->right;
        itr3->right = aNode;
      }
      itr1 = itr1->right;

    }else{
      aNode->expo = itr2->expo;
      aNode->num = itr2->num;
      aNode->right = NULL;
      if (aRoot == NULL) aRoot = aNode;
      else{
        while (itr3 != NULL) itr3 = itr3->right;
        itr3->right = aNode;
      }
      itr2 = itr2->right;
    }
  }
  while (itr1 != NULL || itr2 != NULL){
    if (itr2 == NULL){
      aNode->expo = itr1->expo;
      aNode->num = itr1->num;
      aNode->right = NULL;
      if (aRoot == NULL) aRoot = aNode;
      else{
        while (itr3 != NULL) itr3 = itr3->right;
        itr3->right = aNode;
      }
      itr1 = itr1->right;
    }
    if (itr1 == NULL){
      aNode->expo = itr2->expo;
      aNode->num = itr2->num;
      aNode->right = NULL;
      if (aRoot == NULL) aRoot = aNode;
      else{
        while (itr3 != NULL) itr3 = itr3->right;
        itr3->right = aNode;
      }
      itr2 = itr2->right;
    }
  }
}

void display(){
  struct poly *show = aRoot;
  while (show != NULL){
    printf("%d ", show->num);
    show = show->right;
  }
}

int main(){
  printf("Let us begin!\n");
  eqn1();
  eqn2();
  printf("\n\n---- adder ---- \n\n");
  addPoly();
  printf("\n\nadding done----\n\n");
  printf("printing\n\n");
  display();
  return 0;
}
