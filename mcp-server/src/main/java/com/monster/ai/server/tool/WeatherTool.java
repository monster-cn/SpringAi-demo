package com.monster.ai.server.tool;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

/**
 * @author yang
 * @since 2026/2/10 14:31
 */
@Component
public class WeatherTool implements IAiTool {
    @Tool(name = "getWeather", description = "获取指定城市的天气信息")
    public String getWeather(@ToolParam(description = "城市名") String city) {
        return String.format("""
            {
                "city": "%s",
                "temperature": "25°C",
                "condition": "晴朗",
                "humidity": "60%%",
                "wind": "东风3级"
            }
            """, city);
    }

    @Tool(name = "getForecast", description = "获取指定城市的天气指定日期的天气预报")
    public String getForecast(@ToolParam(description = "城市") String city,@ToolParam(description = "第几天") int days) {
        return String.format("""
            {
                "city": "%s",
                "forecast": [
                    {"day":1, "high":"26°C", "low":"18°C", "condition":"晴"},
                    {"day":2, "high":"24°C", "low":"17°C", "condition":"多云"},
                    {"day":3, "high":"22°C", "low":"16°C", "condition":"小雨"}
                ]
            }
            """, city);
    }
}
