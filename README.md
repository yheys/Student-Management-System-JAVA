# Student Management System — Java

A console-based Student Record Management System built with Java, demonstrating core OOP principles and File I/O concepts.

---

## 📁 Project Structure

```
src/
├── Student.java           # Data model
├── Student_Managment.java # Business logic
├── ReportGenerator.java   # GPA statistics
├── FileManager.java       # File I/O operations
└── Main.java              # User interface
```

---

## ✅ Features

### Student Operations
- Add a new student
- View all students
- Search student by ID
- Update student information
- Delete student

### File Storage
- Save and load using Text Files (`BufferedWriter`, `BufferedReader`)
- Save and load using Binary Files (`DataOutputStream`, `DataInputStream`)
- Save and load using Object Serialization (`ObjectOutputStream`, `ObjectInputStream`)

### Reports
- Total number of students
- Highest GPA
- Lowest GPA
- Average GPA

### File Management
- Auto-create required directories and files
- Display file properties (name, path, size, permissions, last modified)
- Backup student records using Buffered Streams

---

## 🗂️ Data Directory Structure

```
data/
├── students.txt      # Text file storage
├── students.dat      # Binary file storage
├── students.ser      # Serialized object storage
└── backup/
    └── backup.txt    # Buffered stream backup
```

---

## 🧠 OOP Concepts Used

| Concept | Where Applied |
|---|---|
| Encapsulation | Private fields in `Student` with getters/setters |
| Abstraction | `Main` interacts through methods, not internal logic |
| Single Responsibility | Each class has one job |
| Method Overriding | `toString()` in `Student` |
| Interface | `Student` implements `Serializable` |

---

## 🚀 How to Run

**1. Navigate to the src folder:**
```
cd src
```

**2. Compile all files:**
```
javac Student.java Student_Managment.java ReportGenerator.java FileManager.java Main.java
```

**3. Run the program:**
```
java Main
```

---

## 🛠️ Technologies Used

- Java SE
- Java File I/O and Streams
- Java Collections (`ArrayList`)
- Exception Handling (`IOException`, `InputMismatchException`)

---

## 👨‍💻 Author

Built as a learning project to practice Java OOP and File I/O concepts.
