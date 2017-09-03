package com.zuravvski.CommandHandlerDemo.Commands;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Author: Michal Zurawski (m.zurawski1994@gmail.com)
 * Created on: 03.09.2017.
 *
 * Sample command containing data for user registration
 */
@Component
@Scope("prototype")
public class RegisterUser implements ICommand
{
    private final String login;
    private final String password;

    public RegisterUser(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }
}
