package iuh.fit.se.annotationbased;

import iuh.fit.se.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Employee emp = context.getBean(Employee.class);
        System.out.println("Annotation-Based Configuration");
        emp.showInfo();
    }
}
