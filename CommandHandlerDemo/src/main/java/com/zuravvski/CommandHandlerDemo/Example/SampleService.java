package com.zuravvski.CommandHandlerDemo.Example;

import com.zuravvski.CommandHandlerDemo.Commands.CommandDispatcher;
import com.zuravvski.CommandHandlerDemo.Commands.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: Michal Zurawski (m.zurawski1994@gmail.com)
 * Created on: 03.09.2017.
 *
 * This is sample consuming service which gets commands from a given source and passes them to dispatcher.
 * This can be i.e. Controller in web application or a predefined "packet" in network desktop application.
 */
@Component
public class SampleService implements ISampleService
{
    private final CommandDispatcher dispatcher;

    @Autowired
    public SampleService(CommandDispatcher dispatcher)
    {
        this.dispatcher = dispatcher;
    }

    @Override
    public void dispatchCommand(ICommand command)
    {
        dispatcher.dispatch(command);
    }
}
