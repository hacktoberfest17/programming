import java.util.Scanner;

/* A somewhat clunky queue allowing creation of a queue of String, char, or int
  Repeatedly prompts user and outputs queue contents. Not sure how useful it
  actually is, but its a queue
  */
class Queue {
  int putloc, getloc;
  char q[];

  Queue (char a[]) {
    //put index and get index
    putloc = 0;
    getloc = 0;
    q = new char [a.length];
    //put array characters in queue
    for (int i = 0; i < a.length; i++) put(a[i]);
  }

  Queue (int a[]) {
    putloc = 0;
    getloc = 0;
    q = new int [a.length];

    for (int i = 0; i < a.length; i++) put(a[i]);
  }

  Queue (String a[]) {
    putloc = 0;
    getloc = 0;
    q = new String[a.length];

    for (int i = 0; i < a.length; i++) put(a[i]);
  }

  public void put(char ch) {
    //If items are being added and put index is greater than queue capacity
    if (putloc == q.length) {
      System.out.println("Queue is Full");
      return;
    }
    //Place item value i at put index and iterate put index
    q[putloc++] = ch;
  }

  public void put(int i) {
    if (putloc == q.length) {
      System.out.println("Queue is Full");
      return;
    }
    q[putloc++] = i;
  }

  public void put(String s) {
    if (putloc == q.length) {
      System.out.println("Queue is Full");
      return;
    }
    q[putloc++] = s;
  }

//Get method for String queue
  public String getString() {
    if (putloc == getloc) {
      System.out.println("Queue is Empty");
      return;
    }
    //Grab item at get index (starting at 0) and iterate
    return q[getloc++];
  }
//Get method for char queue
  public char getChar() {
    if (putloc == getloc) {
      System.out.println("Queue is Empty");
      return;
    }
    return q[getloc++];
  }
//get method for int queue
  public int getInt() {
    if (putloc == getloc) {
      System.out.println("Queue is Empty");
      return;
    }
    return q[getloc++];
  }
}

class runQueue {
  public static void main (String args[]) {
    Scanner keyboard = new Scanner(System.in);

        boolean check = false;
       System.out.println("Create a queue of int, characters, or Strings");
       String choice = keyboard.nextLine();

       //Repeatedly prompts user until user stops (changes check to true)
      while (check) {
      System.out.println("Size of queue: ");
      int size = keyboard.nextInt();
      //Valid inputs are 'int', 'character' or 'String'
       switch (choice) {
         //creates queue for inputted ints
         case "int":
            int arr[] = new arr [size];
            for (int i = 0; i < arr.length; i++) {
              System.out.println("Input next item");
              int next = keyboard.nextInt();
              arr[i] = next;
              //output queue items
              Queue q1 = new Queue(arr);
              for (int i = 0; i < q1.q.lenght; i++) {
                System.out.print(q1.getInt() + " ");
              }
            }
          //creates queue for inputted characters
          case "character":
             char arr[] = new arr [size];
             for (int i = 0; i < arr.length; i++) {
                System.out.println("Input next item");
                char next = keyboard.nextLine().charAt(0);
                arr[i] = nextChar;

                Queue q2 = new Queue(arr);
                for (int i = 0; i < q2.q.length; i++) {
                  System.out.print(q2.getChar() + " ");
                }
              }
          //creates queue for inputted strings
          case "String":
              String arr[] = new arr [size];
              for (int i = 0; i < arr.length; i++) {
                System.out.println("Input next item: ");
                String next = keyboard.nextLine();
                arr[i] = next;
                //Seperate object for each data type
                Queue q3 = new Queue(arr);
                for (int i = 0; i < q3.q.length; i++) {
                  System.out.print(q3.getString() + " ");
                }
              }
          default:

              System.out.println("Invalid input, try again");
       }
       System.out.println("Create another: y/n");
       char input = keyboard.nextLine().charAt(0);
       //'n' or 'N' to terminate
       if (input == 'n' || 'N') {
         check = true;
       }
    }
  }
}
