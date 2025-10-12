package iuh.fit.se.main;

import iuh.fit.se.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = context.getBean(Student.class);
        student1.displayInfo();
    }
}
