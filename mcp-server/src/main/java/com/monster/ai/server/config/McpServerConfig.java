package com.monster.ai.server.config;

import com.monster.ai.server.tool.IAiTool;
import com.monster.ai.server.tool.WeatherTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author yang
 * @since 2026/2/11 15:50
 */
@Configuration
public class McpServerConfig {


    @Bean
    public ToolCallbackProvider weatherTools(List<IAiTool> aiTools) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(aiTools.toArray())
                .build();
    }
}
