package com.zuravvski.CommandHandlerDemo.Commands;

import org.springframework.stereotype.Component;

/**
 * Author: Michal Zurawski (m.zurawski1994@gmail.com)
 * Created on: 03.09.2017.
 *
 * Interface for command dispatchers.
 * Command dispatcher is responsible for resolving the handler and invoking resolved handler
 * for a given command.
 * You can additionally introduce resolver to decouple DI framework from dispatcher.
 */
@Component
public interface ICommandDispatcher
{
    <T extends ICommand> void dispatch(T command);
}
