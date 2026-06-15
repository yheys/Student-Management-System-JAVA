import java.util.ArrayList;
import java.io.*;
import java.util.Date;

class Student_Managment {
    private ArrayList<Student> students;


    private static final String DATA_DIR    = "data";
    private static final String TEXT_FILE   = "data/students.txt";
    private static final String BINARY_FILE = "data/students.dat";
    private static final String SERIAL_FILE = "data/students.ser";
    private static final String BACKUP_FILE = "data/backup/backup.txt";

    public Student_Managment() {
        this.students = new ArrayList<>();
        initFiles();         
        loadFromText();      
    }


    private void initFiles() {
        try {
            
            new File(DATA_DIR).mkdirs();
            new File("data/backup").mkdirs();

            
            new File(TEXT_FILE).createNewFile();
            new File(BINARY_FILE).createNewFile();
            new File(SERIAL_FILE).createNewFile();
            new File(BACKUP_FILE).createNewFile();

        } catch (IOException e) {
            System.out.println("Error initializing files: " + e.getMessage());
        }
    }

    

    public void addStudent(Student student) {
        students.add(student);
        saveToText();
        saveToBinary();
        saveToSerial();
        System.out.println("Student added successfully!");
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
                saveToText();
                saveToBinary();
                saveToSerial();
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                saveToText();
                saveToBinary();
                saveToSerial();
                return true;
            }
        }
        return false;
    }

    
    private void saveToText() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(TEXT_FILE, false))) {
            for (Student s : students) {
                pw.println(s.getId() + "," + s.getName() + "," + s.getDepartment() + "," + s.getGpa());
            }
        } catch (IOException e) {
            System.out.println("Error saving to text file: " + e.getMessage());
        }
    }

    private void loadFromText() {
        students.clear();
        try (Scanner sc = new Scanner(new File(TEXT_FILE))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int    id         = Integer.parseInt(parts[0]);
                    String name       = parts[1];
                    String department = parts[2];
                    double gpa        = Double.parseDouble(parts[3]);
                    students.add(new Student(name, id, department, gpa));
                }
            }
        } catch (FileNotFoundException e) {
    
        } catch (Exception e) {
            System.out.println("Error loading from text file: " + e.getMessage());
        }
    }

        private void saveToBinary() {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(BINARY_FILE)))) {
            dos.writeInt(students.size());
            for (Student s : students) {
                dos.writeInt(s.getId());
                dos.writeUTF(s.getName());
                dos.writeUTF(s.getDepartment());
                dos.writeDouble(s.getGpa());
            }
        } catch (IOException e) {
            System.out.println("Error saving to binary file: " + e.getMessage());
        }
    }

    public void loadFromBinary() {
        students.clear();
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream(BINARY_FILE)))) {
            int count = dis.readInt();
            for (int i = 0; i < count; i++) {
                int    id         = dis.readInt();
                String name       = dis.readUTF();
                String department = dis.readUTF();
                double gpa        = dis.readDouble();
                students.add(new Student(name, id, department, gpa));
            }
            System.out.println("Loaded " + count + " students from binary file.");
        } catch (IOException e) {
            System.out.println("Error loading from binary file: " + e.getMessage());
        }
    }

    
    private void saveToSerial() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(SERIAL_FILE))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving serialized file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromSerial() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(SERIAL_FILE))) {
            students = (ArrayList<Student>) ois.readObject();
            System.out.println("Loaded " + students.size() + " students from serialized file.");
        } catch (Exception e) {
            System.out.println("Error loading serialized file: " + e.getMessage());
        }
    }



    public void generateReport() {
        if (students.isEmpty()) {
            System.out.println("No students to report.");
            return;
        }

        int    total   = students.size();
        double highest = students.get(0).getGpa();
        double lowest  = students.get(0).getGpa();
        double sum     = 0;

        for (Student s : students) {
            double gpa = s.getGpa();
            if (gpa > highest) highest = gpa;
            if (gpa < lowest)  lowest  = gpa;
            sum += gpa;
        }

        double average = sum / total;

        System.out.println("================================");
        System.out.println("        STUDENT REPORT          ");
        System.out.println("================================");
        System.out.println("Total Students : " + total);
        System.out.printf ("Highest GPA    : ", highest);
        System.out.printf ("Lowest GPA     : ", lowest);
        System.out.printf ("Average GPA    : ", average);
        System.out.println("================================");
    }

    
    public void backupRecords() {
        try (
            BufferedReader br = new BufferedReader(new FileReader(TEXT_FILE));
            BufferedWriter bw = new BufferedWriter(new FileWriter(BACKUP_FILE, false))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error creating backup: " + e.getMessage());
        }
    }

    
    public void displayFileProperties() {
        System.out.println("================================");
        System.out.println("        FILE PROPERTIES         ");
        System.out.println("================================");
        printFileInfo(new File(TEXT_FILE));
        printFileInfo(new File(BINARY_FILE));
        printFileInfo(new File(SERIAL_FILE));
        printFileInfo(new File(BACKUP_FILE));
    }

    private void printFileInfo(File f) {
        System.out.println("File     : " + f.getName());
        System.out.println("Path     : " + f.getAbsolutePath());
        System.out.println("Size     : " + f.length() + " bytes");
        System.out.println("Modified : " + new Date(f.lastModified()));
        System.out.println("--------------------------------");
    }
}