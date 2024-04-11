package com.example.practice12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;


@Getter
@Setter
@Slf4j
@Component
public class ComponentClass {
    private String fileFrom = "C:\\Users\\Пользователь\\IdeaProjects\\java-mirea\\practice12\\first-file.txt";
    private String fileTo = "C:\\Users\\Пользователь\\IdeaProjects\\java-mirea\\practice12\\second-file.txt";

    @PostConstruct
    public void postConstruct() {
        log.info("Started!");
    }

    @PreDestroy
    public void preDestroy() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTo));
        if (new File(fileFrom).exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileFrom));
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
            bufferedWriter.write(String.valueOf(text.hashCode()));
            log.info("Okay!");
            bufferedReader.close();
        } else {
            bufferedWriter.write("null");
            log.info("I have a trouble");
        }
        bufferedWriter.close();
    }
}