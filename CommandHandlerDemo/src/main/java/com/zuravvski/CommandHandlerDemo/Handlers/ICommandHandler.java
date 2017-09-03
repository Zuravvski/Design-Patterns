package com.zuravvski.CommandHandlerDemo.Handlers;

import com.zuravvski.CommandHandlerDemo.Commands.ICommand;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Author: Michal Zurawski (m.zurawski1994@gmail.com)
 * Created on: 03.09.2017.
 *
 * Command handler interface. Handlers are responsible for carrying out concrete action, based upon
 * the information provided by command.
 */
@Component
@Scope("prototype")
public interface ICommandHandler<T extends ICommand>
{
    void handle(T command);
}
