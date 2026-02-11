package com.monster.ai.client;

import org.junit.jupiter.api.Test;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yang
 * @since 2026/2/11 16:03
 */
@SpringBootTest
public class ClientTest {

    @Autowired
    private SyncMcpToolCallbackProvider toolCallbackProvider;

    @Test
    public void client(){
        for (ToolCallback toolCallback : toolCallbackProvider.getToolCallbacks()) {
            System.out.println(toolCallback.getToolDefinition());
            String info = toolCallback.call("{\"city\":\"济南\", \"days\": 3}");
            System.out.println(info);
        }
    }
}
