    import java.util.ArrayList;
    import java.util.Scanner;
    class Main{
        static Scanner input = new Scanner(System.in);
        public static void main(String[] args) {
            System.out.println("-------------------------------");
            System.out.println("Welcome to Student Management System!");
            System.out.println("-------------------------------");
            Student_Managment sm = new Student_Managment();

            while(true) {
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                try{
                int choice = input.nextInt();
                input.nextLine(); 
                switch (choice) {
                    case 1:{
                        System.out.print("Enter student name: ");
                        String name = input.nextLine();
                        System.out.print("Enter student ID: ");
                        try {
                            int id = input.nextInt();
                            input.nextLine(); 
                            System.out.print("Enter student department: ");
                            String department = input.nextLine();
                            System.out.print("Enter student GPA: ");
                            double gpa = input.nextDouble();
                            sm.addStudent(new Student(name, id, department, gpa));
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid number for ID and GPA!");
                            input.nextLine();
                        }
                        break;}
                    case 2:{
                        ArrayList<Student> list = sm.getAllStudents();
                        if (list.isEmpty()) {
                            System.out.println("No students found!");
                        } else {
                        for (Student s : list) {
                        System.out.println(s); 
                        }
                        }
                        break;
                        }
                    case 3:{
                        System.out.print("Enter student ID to search: ");
                        int id = input.nextInt();
                        input.nextLine(); 
                        Student s = sm.getStudentById(id);
                        if(s != null) {
                            System.out.println(s);
                        } else {
                            System.out.println("Not found!");
                        }
                        
                        break;}
                    case 4:{
                        try {
                        System.out.print("Enter student ID to update: ");
                        int id = input.nextInt();
                        input.nextLine(); 
                        System.out.print("Enter new student name: ");
                        String name = input.nextLine();
                        System.out.print("Enter new student department: ");
                        String department = input.nextLine();
                        System.out.print("Enter new student GPA: ");
                        double gpa = input.nextDouble();
                        if (sm.updateStudent(id, name, department, gpa)) {
                            System.out.println("Updated successfully!");
                        } else {
                        System.out.println("Not found!");}
                        }catch (InputMismatchException e) {
                            System.out.println("Please enter a valid number for ID and GPA!");
                            input.nextLine();
                        }
                        break;}
                    case 5:{
                        try{
                        System.out.print("Enter student ID to delete: ");
                        int id = input.nextInt();
                        input.nextLine(); 
                        if (sm.deleteStudent(id)) {
                            System.out.println("Deleted!");
                        } else {
                            System.out.println("Not found!");}
                        }catch (InputMismatchException e) {
                            System.out.println("Please enter a valid number for ID !");
                            input.nextLine();
                        }
                        break;}
                    case 6:
                        System.out.println("Exiting the system. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                input.nextLine();
            }
        }
    }