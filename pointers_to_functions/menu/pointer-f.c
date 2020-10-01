#include <stdio.h>

void option0 (void){
  printf("Printed from option0\n");
}
void option1 (void){
  printf("Printed from option1\n");
}
void option2 (void){
  printf("Printed from option2\n");
}
void option3 (void){
  printf("Printed from option3\n");
}

int main(void)
{
  void (*p[]) (void) = {option0, option1, option2, option3};
  int op;

  do {
    printf("Press an option:\n");
    printf("0) Option 0\n");
    printf("1) Option 1\n");
    printf("2) Option 2\n");
    printf("3) Option 3\n");
    printf("other) Exit\n");
    scanf("%d", &op);
    if (op >= 0 && op <= 3)
      p[op]();

  } while (op >=0 && op < 4);
  printf("Bye\n");

  return 0;
}
