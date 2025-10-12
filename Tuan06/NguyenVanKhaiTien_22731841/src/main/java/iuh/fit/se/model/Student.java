package iuh.fit.se.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Student {
//    @Value("22731841")
    private int id;
//    @Value("Nguyen Van Khai Tien")
    private String name;
//    @Value("#{{'A,B,C'.split(',')}}")
    private List<String> subjects;
//    @Value("#{{'X,Y,Z'.split(',')}}")
    private Set<String> hobbies;
//    @Value("#{{'Java':90, 'Spring':88, 'Database':85}}")
    private Map<String, Integer> marks;
//    @Autowired
    private Class_ class_;

    public void setClass_(Class_ class_) {
        this.class_ = class_;
    }
    public Student(int id, String name, Class_ class_) {
        this.id = id;
        this.name = name;
        this.class_ = class_;
    }

    public Student() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Class"+ class_);
        System.out.println("Subjects: " + subjects);
        System.out.println("Hobbies: " + hobbies);
        System.out.println("Marks: " + marks);
    }
    @Override
    public String toString() {
        return "Student {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                ", hobbies=" + hobbies +
                ", marks=" + marks +
                ", class_=" + class_ +
                '}';
    }

}
