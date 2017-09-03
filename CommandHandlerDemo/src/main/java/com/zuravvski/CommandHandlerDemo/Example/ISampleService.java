package com.zuravvski.CommandHandlerDemo.Example;

import com.zuravvski.CommandHandlerDemo.Commands.ICommand;

/**
 * Author: Michal Zurawski (m.zurawski1994@gmail.com)
 * Created on: 03.09.2017.
 */
public interface ISampleService
{
    void dispatchCommand(ICommand command);
}
