public class Student {
    private String name;
    private int id;
    private String department;
    private double gpa;

    Student(String name,int id,String department, double gpa){
        this.name=name;
        this.id=id;
        this.department=department;
        this.gpa=gpa;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getDepartment() {
        return department;
    }
    public double getGpa() {
        return gpa;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }  
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        System.out.println("-------------------------------");
        System.out.println("ID  | Name | Department | GPA");
        System.out.println("-------------------------------");
        System.out.println(id + "  | " + name + " | " + department + " | " + gpa);
        return "";
    }
}