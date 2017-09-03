package com.zuravvski.CommandHandlerDemo;

import com.zuravvski.CommandHandlerDemo.Commands.RegisterUser;
import com.zuravvski.CommandHandlerDemo.Example.SampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CommandHandlerDemoApplication
{
    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(CommandHandlerDemoApplication.class, args);
        SampleService sampleService = context.getBean(SampleService.class);


        sampleService.dispatchCommand(new RegisterUser("John", "Doe"));
    }
}
