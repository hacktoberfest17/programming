## The Walking Robot

### Description

It is the standard task for the interview on a Java Developer position. It requires basic knowledge on Java Concurrency. The task is to create 2 threads, each of which will be the foot (right and left). When the application starts, each thread should print its foot sequentially, so that it looks like when a person goes (left, right, left, etc).

### Solution

There are many solutions. This solution is based on common monitor for 2 threads, so that only 1 thread have access to it and can print his own foot.

### Output
`left`

`right`

`left`

`right`

etc.
