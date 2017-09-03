package com.zuravvski.CommandHandlerDemo.Commands;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Author: Michal Zurawski (m.zurawski1994@gmail.com)
 * Created on: 03.09.2017.
 *
 * Command is just a container describing the action that needs to be handled
 */
@Component
@Scope("prototype")
public interface ICommand
{
    // Marker interface
}
