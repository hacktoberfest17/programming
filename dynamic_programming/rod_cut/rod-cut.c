#include <stdlib.h>

#include <dynamic-programming/rod-cut/rod-cut.h>
#include <util/debug.h>


int max(int a, int b) {
  return a > b ? a : b;
}

int memoized_cut_rod_aux(int *p, size_t n, int *r) {
  if(r[n] >= 0)
    return r[n];

  int q;
  if(n == 0)
    q = 0;

  else {
    q = -1;
    for(size_t i = 1; i <= n; i++)
      q = max(q, p[i] + memoized_cut_rod_aux(p, n - i, r));
  }

  r[n] = q;
  return q;
}

int memoized_cut_rod(int *p, size_t n) {
  int *r;
  check_mem(r = malloc((n + 1) * sizeof *r));
  for(size_t i = 0; i <= n; i++)
    r[i] = -1;

  return memoized_cut_rod_aux(p, n, r);

  error:
  return -1;
}

int bottom_up_cut_rod(int *p, size_t n) {
  int *r;
  check_mem(r = malloc((n + 1) * sizeof *r));
  r[0] = 0;

  for(size_t j = 1; j <= n; j++) {
    int q = -1;
    for (size_t i = 1; i <= j; i++)
      q = max(q, p[i] + r[j - i]);
    r[j] = q;
  }
  return r[n];

  error:
  return -1;
}
