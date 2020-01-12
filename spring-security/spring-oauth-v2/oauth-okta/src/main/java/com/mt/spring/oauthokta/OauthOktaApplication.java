package com.mt.spring.oauthokta;

import com.mt.spring.oauthokta.model.Person;
import com.mt.spring.oauthokta.model.Task;
import com.mt.spring.oauthokta.service.PersonService;
import com.mt.spring.oauthokta.service.TaskService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableOAuth2Sso
@Log
public class OauthOktaApplication {

    @Autowired
    private TaskService taskService;

    @Autowired
    private PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(OauthOktaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            taskService.save(1L, new Task(1L, "Task 1"));
            taskService.save(2L, new Task(2L, "Task 2"));

            personService.save(1L, new Person(1L, "John", "SMITH"));
            personService.save(2L, new Person(2L, "Alex", "LACOSTE"));

            taskService.findAll().forEach(
                task -> {
                    log.info(task.toString());
                });

            personService.findAll().forEach(
                    person -> {
                        log.info(person.toString());
                    });
        };
    }

}
