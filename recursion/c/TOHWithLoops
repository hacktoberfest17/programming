#include <stdio.h>
#include <limits.h>
#include <stdlib.h>
#include <math.h>
 
struct Stack_Structure
{
      int top;
      int *array;
      int max;
};
 
struct Stack_Structure* createStack(int max)
{
      struct Stack_Structure* stack_object = (struct Stack_Structure*)malloc(sizeof(struct Stack_Structure));
      stack_object -> max = max;
      stack_object -> top = -1;
      stack_object -> array = (int*)malloc(stack_object -> max*sizeof(int));
      return stack_object;
}
 
int isEmpty(struct Stack_Structure* stack_object)
{
      return (stack_object->top == -1);
} 
 
int isFull(struct Stack_Structure* stack_object)
{
      return (stack_object->top == stack_object->max - 1);
}
 
void display_shift(char fromTower, char toTower, int disk)
{
      printf("Move Disk %d from \'%c\' to \'%c\'\n", disk, fromTower, toTower);
}
 
void add_element(struct Stack_Structure *stack_object, int item)
{
      if(isFull(stack_object))
      {
            return;
      }
      stack_object -> array[++stack_object -> top] = item;
}
 
int remove_element(struct Stack_Structure* stack_object)
{
      if(isEmpty(stack_object))
      {
            return INT_MIN;
      }
      return stack_object -> array[stack_object -> top--];
}
 
void shift_Disks(struct Stack_Structure *source_tower, struct Stack_Structure *destination_tower, char source, char destination)
{
      int tower1 = remove_element(source_tower);
      int tower2 = remove_element(destination_tower);
      if(tower1 == INT_MIN)
      {
            add_element(source_tower, tower2);
            display_shift(destination, source, tower2);
      }
      else if(tower2 == INT_MIN)
      {
            add_element(destination_tower, tower1);
            display_shift(source, destination, tower1);
      } 
      else if(tower1 > tower2)
      {
            add_element(source_tower, tower1);
            add_element(source_tower, tower2);
            display_shift(destination, source, tower2);
      } 
      else
      {
            add_element(destination_tower, tower2);
            add_element(destination_tower, tower1);
            display_shift(source, destination, tower1);
      }
}
 
void tower_of_hanoi(int limit, struct Stack_Structure *source_tower, struct Stack_Structure *temporary_tower, struct Stack_Structure *destination_tower)
{
      int count, shift;
      char destination = 'D', source = 'S', temporary = 'A';
      if(limit % 2 == 0)
      {
            char x = destination;
            destination = temporary;
            temporary  = x;
      }
      shift = pow(2, limit) - 1;
      for(count = limit; count >= 1; count--)
      {
            add_element(source_tower, count);
      } 
      for(count = 1; count <= shift; count++)
      {
            if(count%3 == 1)
            {
                  shift_Disks(source_tower, destination_tower, source, destination);
            } 
            else if(count%3 == 2)
            {
                  shift_Disks(source_tower, temporary_tower, source, temporary);
            }
            else if(count%3 == 0)
            {
                  shift_Disks(temporary_tower, destination_tower, temporary, destination);
            }
      } 
}
 
int main()
{
      int limit;
      struct Stack_Structure *source_tower, *destination_tower, *temporary_tower;
      printf("\nEnter The Number of Disks:\t");
      scanf("%d", &limit);
      printf("\nSequence of Disk Moves:\n\n");
      source_tower = createStack(limit);
      temporary_tower = createStack(limit);
      destination_tower = createStack(limit);
      tower_of_hanoi(limit, source_tower, temporary_tower, destination_tower);
      printf("\n");
      return 0;
}
