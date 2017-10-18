First run 'make' to compile all the programs

Process - A process is basically a program. The OS handles processes as individual entities and provides them process isolation.

Process ID(pid) - This is used to identify a process by the OS. It is like a roll number alloted to any process at the time of creation. Run the program 'top' to see a list of processes and their pIDs.

In 1_getpid.c, you can see that we use the system call getpid() to get the pid of the process which is running it. Run the compiled code and check if the pid in top matches the one shown by the program.

Creating a new process - In Linux, the standard way to create a new process is by running fork(). This doesn't create an fresh process but creates a copy of the process calling the fork() system call.
Suppose process A calls fork() and creates a new process B. Then A is called the parent process and B is the child process. B copies almost everything(virtual memory layout, values in the memory like variables values, open file descriptors etc.) from A. One important thing which varies is the return value of fork(). Read 2_fork.c and run it.

Program flow - The child copies even the register values of its parent. So it will continue executing from the point where the parent was forked. Read and run 3_flow.c

Memory isolation - Only the memory values before the fork will be copied over. After the fork, both act like individual programs. Read and run 4_mem.c. We see that the address of the variable 'var' is same for both the processes as the have the same virtual memory layout.

Time slice - Each process is given some amount of time to run before it is switched out and scheduled to run later(see round robin scheduling). This process is handled by the OS and we have little control over when our process is switched in favour of another process. Read and run 5_race.c. The output order keeps changing everytime you run the code(increase loopsize if it doesn't). This is because the schedule given to each process varies depending on factors like total number of processes, nice value, history of the process etc.

wait! - One way to handle the above case and keep the code predictable is by using the system call wait(). It puts the process to sleep until the message of stopped child process wakes it up. So it essentially sleeps(waits) until a child has finished executing. 6_wait.c

Running an executable - Just making copies of programs is not very useful. We must be able to run programs that are stored as files(just like bash). There is a family of commands which replace the current process with another process. There is a sample in 7_exec.c . Run 'man 3 exec' and read about them ans choose your prefered format for the assignment.

Notice that exec replaces the whole process. If bash would that, then we wouldn't be able to run one program after another. You need to use both fork() and exec*() to create
