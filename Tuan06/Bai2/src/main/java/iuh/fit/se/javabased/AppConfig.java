package iuh.fit.se.javabased;

import iuh.fit.se.model.Address;
import iuh.fit.se.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address("Ho Chi Minh City", "District 10", "Vietnam");
    }

    @Bean
    public Employee employee() {
        return new Employee(104, "Pham Thi D", address());
    }
}
