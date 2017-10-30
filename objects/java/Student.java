//object is an instance of a class
//lets write a class called student
public class Student{
  int rollno;
  String name;
  char gender;
  double gpa;
  //lets write a constructor
  public Student(int rollno, String name, char gender, double gpa){
    this.rollno = rollno;
    this.name = name;
    this.gender = gender;
    this.gpa = gpa;
  }
  public void setId(int id){
    this.rollno = id;
  }
  public void setName(String name){
    this.name = name;
  }
  public double getGPA(){
    return gpa;
  }
  public char getGender(){
    return gender;
  }
  public static void main(String[] args) {
    Student s1 = new Student(19,"ram", 'M', 9.5);//creating a student object
    Student s2 = new Student(21, "Sarvani", 'F', 9.62);//creating a student object using constructor
    //now we can add and access student details using student object
    s1.setId(20);
    s1.setName("John");
    System.out.println("Id: " + s1.rollno + " Name: "+ s1.name+" gender: " + s1.gender+" gpa: "+ s1.gpa);
    System.out.println("Id: " + s2.rollno + " Name: "+ s2.name+" gender: " + s2.gender+" gpa: "+ s2.gpa);
    System.out.println(s1 instanceof Student);// displays true or false
  }
}
