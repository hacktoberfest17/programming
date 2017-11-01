public class Homework{
  Student assignee;
  int assignmentNumber;
  float grade;
  boolean excused;
  boolean late;
  
  public Homework(int assignmentNumber, Student assignee){
    this.assignmentNumber = assignmentNumber;
    this.assignee = assignee;
  }
  
  public void setLate(boolean late){
    this.late = late;
  }
  public void setExcused(boolean excused){
    this.excused = excused;
  }
  public void setGrade(float grade){
    this.grade = grade;
  }
  
  public Student getAssignee(){ return assignee; }
  public boolean getAssignmentNumber(){ return assignmentNumber; }
  public boolean getLate(){ return late; }
  public boolean getExcused(){ return excused; }
  public float getGrade(){ return grade; }
 }
