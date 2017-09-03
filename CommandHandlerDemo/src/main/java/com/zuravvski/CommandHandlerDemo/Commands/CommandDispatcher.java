package com.zuravvski.CommandHandlerDemo.Commands;

import com.zuravvski.CommandHandlerDemo.Handlers.ICommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Michal Zurawski (m.zurawski1994@gmail.com)
 * Created on: 03.09.2017.
 */
@Component
public class CommandDispatcher implements ICommandDispatcher, ApplicationListener<ContextRefreshedEvent>
{
    private Map<Class<?>, String> handlers = new HashMap<>();

    private final ConfigurableListableBeanFactory beanFactory;

    @Autowired
    public CommandDispatcher(ConfigurableListableBeanFactory beanFactory)
    {
        this.beanFactory = beanFactory;
    }

    @Override
    public <T extends ICommand> void dispatch(T command)
    {
        if (command == null)
        {
            throw new NullPointerException("Invalid command was provided");
        }

        // Resolving the handler for a given command
        String handlerName = handlers.get(command.getClass());
        ICommandHandler handler = beanFactory.getBean(handlerName, ICommandHandler.class);

        // Invoking the handler
        handler.handle(command);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        handlers.clear();
        String[] commandHandlersNames = beanFactory.getBeanNamesForType(ICommandHandler.class);
        for (String beanName : commandHandlersNames)
        {
            BeanDefinition commandHandler = beanFactory.getBeanDefinition(beanName);
            try
            {
                Class<?> handlerClass = Class.forName(commandHandler.getBeanClassName());
                handlers.put(getHandledCommandType(handlerClass), beanName);
            }
            catch (ClassNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    private Class<?> getHandledCommandType(Class<?> clazz)
    {
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        ParameterizedType type = findByRawType(genericInterfaces, ICommandHandler.class);
        return (Class<?>) type.getActualTypeArguments()[0];
    }

    private ParameterizedType findByRawType(Type[] genericInterfaces, Class<?> expectedRawType)
    {
        for (Type type : genericInterfaces)
        {
            if (type instanceof ParameterizedType)
            {
                ParameterizedType parametrized = (ParameterizedType) type;
                if (expectedRawType.equals(parametrized.getRawType()))
                {
                    return parametrized;
                }
            }
        }
        throw new RuntimeException();
    }
}
