package com.example.practice10spring;

import org.springframework.stereotype.Component;

@Component
public class Programming {
    private Programmer programmer;
    public void setType(Programmer programmer) {
        this.programmer = programmer;
    }
    public void DoProgramming() {
        System.out.println(programmer.doCoding());
    }
}
