#include <stdlib.h>
#include <stdio.h>

#include <dynamic-programming/rod-cut/rod-cut.h>


int main(int argc, char *argv[]) {

  int p[] = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
  size_t len_of_p = sizeof p / sizeof *p;

  for(size_t i = 0; i < len_of_p; i++) {
    printf("itr %zd\n", i);
    printf("memoized: %d\n", memoized_cut_rod(p, i));
    printf("bottomup: %d\n", bottom_up_cut_rod(p, i));
    putchar('\n');
  }
}
