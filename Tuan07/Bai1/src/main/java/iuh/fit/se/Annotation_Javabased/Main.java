package iuh.fit.se.Annotation_Javabased;

import iuh.fit.se.config.DatabaseConfig;
import iuh.fit.se.model.Employee;
import iuh.fit.se.repository.EmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DatabaseConfig.class, EmployeeRepository.class);

        EmployeeRepository repo = context.getBean(EmployeeRepository.class);

        // Thêm mới
        Employee e = new Employee();
        e.setRole("Developer");
        e.setName("Nguyen Van B");
        repo.save(e);

        // Hiển thị danh sách
        repo.findAll().forEach(emp ->
                System.out.println(emp.getId() + " - " + emp.getName() + " - " + emp.getRole()));

        context.close();
    }
}
