package H3;

public class Student implements Comparable<Student>{
    int ID;
    double Grade;
    String Name;
    String Major;

    public Student(double Grade, int ID, String Name, String Major) {
        this.ID = ID;
        this.Grade = Grade;
        this.Name = Name;
        this.Major = Major;
    }

    public int getID() {
        return ID;
    }

    public double getGrade() {
        return Grade;
    }

    public String getName() {
        return Name;
    }

    public String getMajor() {
        return Major;
    }

    @Override
    public String toString() {
        return ID + "              " + Name + "              " + Major + "              " + Grade + ' ';
    }
    
  public int compareTo(Student o) {
    if (o == null) {
      return -1;
    }
    int c = Double.valueOf(Grade).compareTo(o.Grade);
    if (c != 0) {
      return c;
    }
    return Name.compareTo(o.Name);
  }
}
