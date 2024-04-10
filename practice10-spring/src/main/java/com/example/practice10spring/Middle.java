package com.example.practice10spring;

import org.springframework.stereotype.Component;

@Component("middle")
public class Middle implements Programmer {
    @Override
    public String doCoding() {
        return "Middle is coding...";
    }
}