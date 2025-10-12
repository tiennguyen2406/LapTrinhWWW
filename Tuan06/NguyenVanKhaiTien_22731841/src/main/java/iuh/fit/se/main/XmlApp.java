package iuh.fit.se.main;

import iuh.fit.se.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApp {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("XML Student");
        Student student1 = context.getBean("student1",Student.class);
        student1.displayInfo();

        Student student2 = context.getBean("student2",Student.class);
        student2.displayInfo();
    }
}
