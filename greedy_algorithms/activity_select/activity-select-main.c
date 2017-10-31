#include <stdio.h>

#include <greedy-algorithms/activity-select/activity-select.h>
#include <util/list.h>


int main() {
  int s[] = {0, 1, 3, 0, 5, 3, 5,  6,  8,  8,  2, 12};
  int f[] = {0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
  size_t s_len = sizeof s / sizeof *s;

  list_t *(*selects[])(int *, int *, size_t) =
      { recursive_activity_select, iterative_activity_select };
  size_t selects_len = sizeof selects / sizeof *selects;

  for(size_t i = 0; i < selects_len; i++) {
    size_t calls = 0;
    list_t *solution = selects[i](s, f, s_len);
    list_print(solution);
    list_destroy(solution);
  }
}
