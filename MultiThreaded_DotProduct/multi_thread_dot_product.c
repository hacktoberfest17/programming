/** 
 * File: multi_thread_dot_product.c
 * Description:
 *  This program calculates the dot product of two vectors using an number
 *  of threads. The length of the vectors and the number of threads to be
 *  used for the dot product calculation are inputed by the user when executing
 *  the program as arguments of main().
 *  Don't forget to link the pthread library to compile the program!
 *  Compile command example using gcc: 
 *      gcc -o mt_dot_product multi_thread_dot_product.c -pthread
 * Author: Nicktheway(NTW)
 * Made for HacktoberFest'17 on 16/10/2017
 * USAGE: ./name #number_of_threads #length_of_arrays
 *   example command: ./mt_dot_product 4 5000000
 */

#include <stdio.h>      //For printing the result (with the function printf())
#include <stdlib.h>     //For dynamic memory allocation
#include <pthread.h>    //Thread manipulating functions

//Define a struct with all the data each thread should know
//This struct will be passed as argument in the method each thread will execute.
typedef struct VectorData
{
    double *firstVector;
    double *secondVector;
    double dotProduct;
    int    vector_len;
} VectorData;

//Define a VectorData type global variable in order to be accessible by all threads
// to calculate the dot product.
VectorData vData;

//Global variable for storing the used thread number in order to be accessible
// from all threads.
int threadNumber;
    
//The mutex variable that will be responsible of not letting two or more threads change
// the dot product value simutenously producing wrong result. (search race condition for more info)
pthread_mutex_t mutexVar;

//Declaring the method that each thread will execute.
//Defined under main().
void* dotProductPart(void* arg);

int main(int argc, char** argv)
{
    //Check the execution command. If incorrect terminate the program, else pass the arguments to const vars.
    if (argc != 3){
        printf("Usage:This program should be executed with 2 positive integer arguments:\n.\\program_name <number of threads> <length of vectors>\n");
        return 1;
    }
    //The first argument (literally 2nd as the first is the name of the program)
    //  will be the number of threads.
    const int THREAD_NUM = atoi(argv[1]);   
    //The second (or 3rd if you like) will be the length of the vectors.
    const int VECTOR_LENGTH = atoi(argv[2]);
    
    if (THREAD_NUM <= 0 || VECTOR_LENGTH <= 0){
        printf("The arguments must be positive integers\n");
        return 2;
    }
    //fprintf(stderr, "%d %d\n", THREAD_NUM, VECTOR_LENGTH); //Uncomment for debug
    threadNumber = THREAD_NUM;
    
    //Making two double vectors and giving space to them.
    double *firstVector =   (double *) malloc(VECTOR_LENGTH * sizeof(double));
    double *secondVector =  (double *) malloc(VECTOR_LENGTH * sizeof(double));
    
    //Check for successful heap memory allocation.
    if (firstVector == NULL || secondVector == NULL)
    {
        fprintf(stderr, "Couldn't allocate memory for the two vectors, using a smaller vector length will probably fix this error.\nExiting...\n");
        exit(1);
    }
    
    //Filling vectors with ones(1) in order to check the correctness of the final output.
    //It should be equal to the vector length.
    long i;
    for (i = 0; i < VECTOR_LENGTH; i++)
    {
        firstVector[i] = 1;
        secondVector[i] = 1;
    }
    
    //Pass the vectors and their length in the vData
    vData.firstVector = firstVector;
    vData.secondVector = secondVector;
    vData.vector_len = VECTOR_LENGTH;
    
    //Initialize their dot product to zero.
    vData.dotProduct = 0.0;
    
    /**
     * T'S FINALLY TIME TO CREATE THE TREADS
     * Just kidding we 'll have to make sure they have some convenient attibutes first
     * oh and prepare the mutex variable to make sure we get the correct result.
     */
    
    //Create the attibutes variable.
    pthread_attr_t threadAttr;
    //Initialize it. PS: Should not forget to destroy it later.
    pthread_attr_init(&threadAttr);
    //Making sure the threads will be joinable.
    pthread_attr_setdetachstate(&threadAttr, PTHREAD_CREATE_JOINABLE);
    
    //Initialize the mutex variable (2nd argument is NULL for default initialization)
    //PS again: Should not forget to destroy it later.
    pthread_mutex_init(&mutexVar, NULL);
    
    //Now, for real, it's time to create the threads.
    
    //Creating pthreat_t variables and allocating memory for them.
    pthread_t *pthreads = (pthread_t *) malloc(THREAD_NUM * sizeof(pthread_t));
    //In case the memory couldn't be allocated.
    if (pthreads == NULL)
    {
        fprintf(stderr, "Couldn't allocate memory for the pthreads, using a smaller number of threads will probably fix this error.\nExiting...\n");
        exit(2);
    }
    
    //Create the pthreads.
    int returnCode;
    for (i = 0; i < THREAD_NUM; i++)
    {
        returnCode = pthread_create(&pthreads[i], &threadAttr, dotProductPart, (void *) i);
        if (returnCode)
        {
            fprintf(stderr, "Error at creating threads. Return code of pthread_create() is: %d\n", returnCode);
            exit(3);
        }
    }
    
    //Wait for all threads to finish their work
    void* status;
    for (i = 0; i < THREAD_NUM; i++)
    {
        returnCode = pthread_join(pthreads[i], &status);
        if (returnCode) {
         printf("Error at joining threads. Return code from pthread_join() is %d\n", returnCode);
         exit(4);
         }
    }
    
    //Print the result
    printf("The dot product is: %lf\n", vData.dotProduct);
    
    //Free allocated memory.
    pthread_attr_destroy(&threadAttr);
    pthread_mutex_destroy(&mutexVar);
    free(firstVector);
    free(secondVector);
    free(pthreads);
    
    //Return 0 indicating successful execution of the program.
    return 0;
}

//This function calculates a part of the dot product sum (the 1/NUMBER_OF_THREADS part)
//The argument passed defines which of the #<NUMBER_OF_THREADS> parts will be calculated
//and added to the final dot product value.
void* dotProductPart(void* arg)
{
    //The part variable is of type long in order to have equal size with the void* arg.
    //It should take values from zero to NUMBER_OF_THREADS - 1.
    long part = (long) arg;
    
    //To calculate the part sum of the dot product we 'll have to iterate through allocate
    // the vector elements in that part. These will start and end according to the following
    // variables.
    long start = vData.vector_len * part / threadNumber;
    long end = vData.vector_len * (part +  1) / threadNumber;
    
    //Variable for storing this part of the dot product.
    double dotProductPart = 0;
    
    //Calculating the part
    int i;
    for (i = start; i < end; i++)
    {
        dotProductPart += vData.firstVector[i] * vData.secondVector[i];
    }
    
    //Add the part to the global dotProduct variable after locking the mutex variable.
    pthread_mutex_lock(&mutexVar);
    vData.dotProduct += dotProductPart;
    
    //For debuging.
    //fprintf(stdout, "Thread %ld did %ld to %ld: dotProductPart = %lf global dotProduct = %lf\n", part, start, end, dotProductPart, vData.dotProduct);
    
    //Unlocking mutex var indicating the global dotProduct var can safely be read and changed
    // if needed by other threads.
    pthread_mutex_unlock(&mutexVar);
    
    //Thread's work is completed.
    pthread_exit(NULL);
}
