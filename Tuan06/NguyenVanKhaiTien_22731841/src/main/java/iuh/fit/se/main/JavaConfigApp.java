package iuh.fit.se.main;

import iuh.fit.se.config.AppConfig;

import iuh.fit.se.model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Student s1 = context.getBean("student1", Student.class);
        Student s2 = context.getBean("student2", Student.class);
        System.out.println("=== Java-Based Configuration ===");
        s1.displayInfo();
        s2.displayInfo();
        context.close();
    }
}
