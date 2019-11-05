## Linear Search (LS)

### How does it work?
This algorithm searches for the target element by looking through each element of an array at a time. For example given an array A

```
A = [1,6,7,3,4]
```
and you need to find the index of let's say 3 in the array. LS works like this

```
#pseudo code  
i = 0

while (i < length(A)) and (A[i] not equal to 3)
  compare A[i] with 3
  if matches
    return i value
  else continue
```
### When can we use LS ?
- When the given data is unstructured
- When we have only sequential access to data
