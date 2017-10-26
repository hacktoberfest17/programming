# Insertion sort

**Insertion** sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort. However, insertion sort provides several advantages:

- Simple implementation
- Efficient for (quite) small data sets
- More efficient in practice than most other simple quadratic algorithms

Insertion sort in action
![GIF](https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif "Insertion Sort")

**Insertion sort** iterates, consuming one input element each repetition, and growing a sorted output list. At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there. It repeats until no input elements remain
