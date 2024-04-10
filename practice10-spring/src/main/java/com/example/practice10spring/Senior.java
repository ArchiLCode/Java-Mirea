package com.example.practice10spring;

import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmer{
    @Override
    public String doCoding() {
        return "Senior is coding...";
    }
}