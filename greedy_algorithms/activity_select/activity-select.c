#include <greedy-algorithms/activity-select/activity-select.h>


void recursive_activity_select_aux(int *s, int *f, size_t k, size_t n, list_t *res);

list_t *recursive_activity_select(int *s, int *f, size_t n) {
  list_t *A = list_init();

  recursive_activity_select_aux(s, f, 0, n, A);

  return A;
}

void recursive_activity_select_aux(int *s, int *f, size_t k, size_t n, list_t *res) {
  size_t m = k + 1;
  while(m <= n && s[m] < f[k]) m++;
  if (m <= n) {
    list_add(res, (long)m);
    recursive_activity_select_aux(s, f, m, n, res);
  }
}

list_t *iterative_activity_select(int *s, int *f, size_t n) {
  list_t *A = list_init();

  size_t k = 1;
  list_add(A, 1);
  for(size_t m = 2; m < n; ++m) {
    if(s[m] >= f[k]) {
      k = m;
      list_add(A, m);
    }
  }
  return A;
}
