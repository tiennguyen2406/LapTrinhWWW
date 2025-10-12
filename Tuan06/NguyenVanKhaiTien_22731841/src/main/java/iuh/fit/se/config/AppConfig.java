package iuh.fit.se.config;

import iuh.fit.se.model.Class_;
import iuh.fit.se.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Class_ class1() {
        // Tạo bean Class_
        Class_ c = new Class_();
        c.setClassId("DHKTPM17C");
        c.setClassName("Dai Hoc KTPM17C");
        return c;
    }
    @Bean
    public Student student1() {
        // Inject bằng setter
        Student s = new Student();
        s.setId(22731841);
        s.setName("Nguyen Van");
        s.setClass_(class1());
        s.setSubjects(List.of("Java", "Spring", "Database"));
        s.setMarks(Map.of("Java", 90, "Spring", 88, "Database", 85));
        return s;
    }

    @Bean
    public Student student2() {
        // Inject bằng constructor
        Student s = new Student(003, "Nguyen Van Anh", class1());
        s.setSubjects(List.of("C#", "React", "SQL"));
        s.setMarks(Map.of("C#", 80, "React", 85, "SQL", 90));
        return s;
    }

}
