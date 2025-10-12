package iuh.fit.se.javabased;

import iuh.fit.se.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Employee emp = context.getBean(Employee.class);
        System.out.println("Java-Based Configuration");
        emp.showInfo();

        context.close();
    }
}
