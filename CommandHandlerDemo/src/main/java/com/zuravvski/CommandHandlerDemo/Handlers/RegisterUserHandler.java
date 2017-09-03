package com.zuravvski.CommandHandlerDemo.Handlers;

import com.zuravvski.CommandHandlerDemo.Commands.RegisterUser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Author: Michal Zurawski (m.zurawski1994@gmail.com)
 * Created on: 03.09.2017.
 *
 * Class representing sample command handler
 */
@Component
@Scope("prototype")
public class RegisterUserHandler implements ICommandHandler<RegisterUser>
{
    @Override
    public void handle(RegisterUser command)
    {
        // Call services, DBs etc.
        // Basically handle the command
        System.out.println(String.format("Registering user with login: \"%s\" and password: \"%s\"",
                command.getLogin(), command.getPassword()));
    }
}
