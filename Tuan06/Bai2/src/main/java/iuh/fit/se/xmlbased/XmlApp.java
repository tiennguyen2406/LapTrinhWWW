package iuh.fit.se.xmlbased;

import iuh.fit.se.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Employee emp1 = (Employee) context.getBean("employeeSetter");
        Employee emp2 = (Employee) context.getBean("employeeConstructor");

        System.out.println("XML-Based Configuration");
        emp1.showInfo();
        System.out.println();
        emp2.showInfo();
    }
}
