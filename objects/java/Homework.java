public class Homework {
  String subject;
  int assignmentNumber;
  String assignmentName;

  public Homework(int assignmentNumber, String subject, String assignmentName){
    this.assignmentName = assignmentName;
    this.assignmentNumber = assignmentNumber;
    this.subject = subject;
  }

  public getNumber(){
    return this.assignmentNumber;
  }
  public getAssignment(){
    return this.assignmentName;
  }
  public getSubject(){
    return this.subject;
  }

  public static void main(String[] args){
    Homework physics = new Homework(1, "Physics", "Problem Set 1");
    System.out.println(physics.getSubject);
  }
}
