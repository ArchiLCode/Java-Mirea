package com.example.practice10spring;

import org.springframework.stereotype.Component;

@Component("junior")
public class Junior implements Programmer {
    @Override
    public String doCoding() {
        return "Junior is coding...";
    }
}
