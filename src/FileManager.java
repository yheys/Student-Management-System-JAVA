import java.io.*;
import java.util.*;

class FileManager {
    static final String TEXT_FILE = "data/students.txt";
    static final String BINARY_FILE = "data/students.dat";
    static final String SERIAL_FILE = "data/students.ser";
    static final String BACKUP_FILE = "data/backup/backup.txt";

    public void createDirectories() {
        new File("data").mkdirs();
        new File("data/backup").mkdirs();
    }
    public void displayFileProperties(String filePath){
        File file = new File(filePath);
        if(file.exists()){
            System.out.println("File: " + file.getName());
            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
        } else {
            System.out.println("File not found: " + filePath);
        }
    }
    public void saveToTextFile(ArrayList<Student> students){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEXT_FILE))) {
    for (Student s : students) {
        writer.write(s.getId() + "," + s.getName() + "," + s.getDepartment() + "," + s.getGpa());
        writer.newLine();
    }
    } catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
    }

    }
    public ArrayList<Student> loadFromTextFile(){
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String department = parts[2];
                double gpa = Double.parseDouble(parts[3]);
                students.add(new Student( name, id,department, gpa));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return students;
    }
}