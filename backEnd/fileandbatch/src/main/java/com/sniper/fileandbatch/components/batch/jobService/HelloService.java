package com.sniper.fileandbatch.components.batch.jobService;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public void sayHello() {
        System.out.println("Hi from HelloService!");
    }
}
