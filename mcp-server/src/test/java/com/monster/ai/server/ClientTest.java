package com.monster.ai.server;

import com.monster.ai.server.tool.IAiTool;
import com.monster.ai.server.tool.WeatherTool;
import org.junit.jupiter.api.Test;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yang
 * @since 2026/2/11 16:03
 */
@SpringBootTest
public class ClientTest {

    @Autowired
    private ToolCallbackProvider toolCallbackProvider;

    @Autowired
    private List<IAiTool> aiTools;

    @Test
    public void client(){
        Set<String> methodNames = Arrays.stream(WeatherTool.class.getMethods()).map(Method::getName)
                .collect(Collectors.toSet());

        for (ToolCallback toolCallback : toolCallbackProvider.getToolCallbacks()) {
            if (methodNames.contains(toolCallback.getToolDefinition().name())) {
                System.out.println(toolCallback.getToolDefinition());
                String info = toolCallback.call("{\"city\":\"济南\", \"days\": 3}");
                System.out.println(info);
            }
        }
    }
}
