package iuh.fit.se.JDBC;

import iuh.fit.se.dao.EmployeeDAO;
import iuh.fit.se.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringPureJdbcxmlConfigApplication {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws SQLException{
        SpringApplication.run(SpringPureJdbcxmlConfigApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("databaseConfig.xml");
        DataSource dataSource = context.getBean("dataSource",DataSource.class);
        System.out.println(dataSource.getConnection());

        // Lấy bean DAO
        EmployeeDAO employeeDAO = context.getBean("employeeDAO", EmployeeDAO.class);

        // Tạo nhân viên mới
        Employee emp = new Employee();
//        emp.setName("Le Van D");
//        emp.setRole("er");
//
//        employeeDAO.save(emp);
//        System.out.println("Saved employee: " + emp);

//         Lấy nhân viên theo ID
        Employee empFromDb = employeeDAO.getById(1);
        System.out.println("Employee from DB: " + empFromDb);
    }
}
