public class Student_Managment {
    static  Scanner input= new Scanner(System.in);
    String name;
    int id;
    int age;
    String grade;
    double gpa;

    static ArrayList<Student_Managment> Students= new ArrayList<>();

    Student_Managment(String name,int id, int age, String garde, double gpa){
        this.name=name;
        this.id=id;
        this.age=age;
        this.grade=garde;
        this.gpa=gpa;
    }

    static void Add_Student(){
        System.out.print("Enter Name:  ");
        String name=input.next();
        System.out.print("Enter ID:  ");
        int id=input.nextInt();
        System.out.print("Enter Age:  ");
        int age=input.nextInt();
        System.out.print("Enter Grade:  ");
        String grade=input.next();
        System.out.print("Enter GPA:  ");
        double gpa=input.nextDouble();
        Students.add(new Student_Managment(name,id,age,grade,gpa));
        System.out.println("Student added successfully!");
    }
    static void View_All(){
        if(Students.isEmpty()){
            System.out.println("No students available!");
            return;
        }
        for(Student_Managment Student:Students){
            System.out.println("ID:" + Student.id + "| Name: " + Student.name + "| Age: " + Student.age + "| Grade: " + Student.grade +"| GPA: " + Student.gpa);
        }
    }
    static void Search(){
            System.out.print("Enter the id number: ");
            int idNum=input.nextInt();
            boolean found=false;
            for(Student_Managment Student:Students){
                if(idNum == Student.id){
                    System.out.println("ID:" + Student.id + "| Name: " + Student.name + "| Age: " + Student.age + "| Grade: " + Student.grade +"| GPA: " + Student.gpa);
                    found=true;
                    break;
                }
            }
            if(!found){
                System.out.println("Invalid id!");
            }
        }
    static void Update(){
            System.out.print("Enter ID to update: ");
            int idNum=input.nextInt();
            boolean found=false;
            for(Student_Managment Student:Students){
                if(idNum == Student.id){
                    System.out.print("Enter new Grade: ");
                    String grade=input.next();
                    System.out.print("Enter new GPA: ");
                    double gpa=input.nextDouble();
                    Student.grade=grade;
                    Student.gpa=gpa;
                    System.out.println("Student updated successfully!");
                    found=true;
                    break;
                }
            }
            if(!found){
                System.out.println("Invalid id!");
            }
        }
    static void Delete(){
        System.out.println("Enter ID to delete: ");
        int idNum=input.nextInt();
        boolean found=false;
        for (int i = 0; i < Students.size(); i++) {
            if (Students.get(i).id == idNum) {
                Students.remove(i);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Invalid id!");
        }
    }
    public static void main(String[] args) {
        Students.add(new Student_Managment("Yilkal kebede", 107, 20, "A+", 4));
        Students.add(new Student_Managment("Yshak Bedru", 108, 20, "A", 3.75));
        Students.add(new Student_Managment("Zelalem Ftsu", 109, 20, "B-", 2.75));
        Students.add(new Student_Managment("Zehara kemil", 110, 19, "B+", 3));

        while (true) {
            System.out.println("===== STUDENT MANAGEMENT SYSTEM =====\n" +
                    "1. Add Student\n" +
                    "2. View All Students\n" +
                    "3. Search Student by ID\n" +
                    "4. Update Student\n" +
                    "5. Delete Student\n" +
                    "6. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    Add_Student();
                    break;
                case 2:
                    View_All();
                    break;
                case 3:
                    Search();
                    break;
                case 4:
                    Update();
                    break;
                case 5:
                    Delete();
                    break;
                case 6:
                    System.out.println("Thank you for using the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }

        }
    }
}