import java.util.ArrayList;
class ReportGenerator{
    private ArrayList<Student> students;

    public ReportGenerator(ArrayList<Student> students) {
        this.students = students;
    }

    public int getTotalStudents(){
        return students.size();
    }
    public double getHighestGPA(){
        if(students.isEmpty()) return 0.0;
        double maxGPA = students.get(0).getGpa();
        for(Student s : students){
            if(s.getGpa() > maxGPA){
                maxGPA = s.getGpa();
            }
        }
        return maxGPA;
    }
    public double getLowestGPA(){
        if(students.isEmpty()) return 0.0;
        double minGPA = students.get(0).getGpa();
        for(Student s : students){
            if(s.getGpa() < minGPA){
                minGPA = s.getGpa();
            }
        }
        return minGPA;
    }
    public double getAverageGPA(){
        if(students.isEmpty()) return 0.0;
        double totalGPA = 0.0;
        for(Student s : students){
            totalGPA += s.getGpa();
        }
        return totalGPA / students.size();
    }

    public void getReport(){
        System.out.println("-------------------------------");
        System.out.println("Total Students: " + getTotalStudents());
        System.out.println("Highest GPA: " + getHighestGPA());
        System.out.println("Lowest GPA: " + getLowestGPA());
        System.out.println("Average GPA: " + getAverageGPA());
    }
}