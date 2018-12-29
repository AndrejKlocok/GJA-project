package cz.vutbr.fit.gja.springmvc.configuration;

import cz.vutbr.fit.gja.springmvc.entity.Student;
import cz.vutbr.fit.gja.springmvc.entity.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Martin Kocour
 * created on 29/12/2018
 */
@Configuration
public class Database {

    @Bean
    public CommandLineRunner initDB(StudentRepository repository) {
        return args -> {
            if (repository.findAll().isEmpty()) {
                repository.save(new Student("Martin Kocour", "xkocou08", null));
            }
        };
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/GJA");
        dataSource.setUsername("user69");
        dataSource.setPassword("heslo"); // Should be hidden in properties file
        return dataSource;
    }
}
