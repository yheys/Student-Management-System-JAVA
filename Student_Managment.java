class Student_Managment{
    private ArrayList<Student> students;

    public Student_Managment() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public ArrayList<Student> getAllStudents() {
        return students;
    }
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                
                return student;
            }
        }
        
        return null;
    }
    public boolean updateStudent(int id, String name, String department, double gpa) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setDepartment(department);
                student.setGpa(gpa);
                return true;
            }
        }
        
        return false;
    }
    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == id) {
                students.remove(i);
                
                return true;
            }
        }
        
        return false;
    }
}