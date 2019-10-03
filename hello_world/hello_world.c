#include <stdio.h>
 
int main()
{
  char s1[] = "HELLO WORLD";
  char s2[] = {'H','e','l','l','o',' ','w','o','r','l','d','\0'};
 
  printf("%s %s", s1, s2);
 
  return 0;
}
