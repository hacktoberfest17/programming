# Selection Sort

### How does it work?
Selection sort in action

![GIF](https://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif "Selection Sort")

Consider an array
L = [9, 4, 6, 1 , 2]

Initially we start by assuming 9 as smallest number that we have seen till now and then compare 9 with each element of L as

```
is 4 < 9 ?
  yes, so 4 is the smallest number till seen
  now start comparing 4 with rest of elements of L

is 4 < 6 ?
  no , so continue

is 1 < 4 ?
  yes,so 1 is the smallest number now

is 2 < 1 ?
  no

Once you have completely traversed elements of L, replace the first index with smallest element as

Original
L = [9, 4, 6, 1 , 2]

After first iteration
L = [1, 4, 6, 9, 2]

Second iteration
L = [1, 2, 6, 9, 4]

Third iteration
L = [1, 2, 4, 9, 6]

and Finally you'll get
L = [1, 2, 4, 6, 9]

```
 
### Program format:

#### Input:
Enter the elements of array with space as delimeter: 4 6 7 8 2

#### Output:
Sorted list: [2, 4, 6, 7, 8]
