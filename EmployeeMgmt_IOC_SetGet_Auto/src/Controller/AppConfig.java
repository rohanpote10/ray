package Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.model.Company;
import com.model.Department;
import com.model.Employee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Employee employee1() {
        return new Employee(10, "DonaldPote", 85000);
    }

    @Bean
    public Employee employee2() {
        return new Employee(20, "DavidNangare", 70000);
    }

    @Bean
    public Employee employee3() {
        return new Employee(30, "SarthakWilliams", 65000);
    }

    @Bean
    public Employee employee4() {
        return new Employee(40, "VijayTrump", 59000);
    }

    @Bean
    public Department department1() {
        Map<String, String> locations = new HashMap<>();
        locations.put("Infra Support", "Mumbai");
        locations.put("Infra Maintenance", "Mumbai");

        return new Department(120, "IT Infra", locations, Arrays.asList(employee1(), employee2()));
    }

    @Bean
    public Department department2() {
        Map<String, String> locations = new HashMap<>();
        locations.put("HR", "Pune");
        locations.put("Operations", "Pune");

        return new Department(130, "Admin", locations, Arrays.asList(employee3(), employee4()));
    }

    @Bean
    public Company company() {
        return new Company(21010, "ExponentITServices", Arrays.asList(department1(), department2()));
    }
}
