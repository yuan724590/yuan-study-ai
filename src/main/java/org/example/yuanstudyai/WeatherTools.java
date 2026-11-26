package org.example.yuanstudyai;

import org.example.yuanstudyai.entity.WeatherInfo;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class WeatherTools {

    @Tool(description = "查询指定城市的实时天气，返回天气状况、温度和湿度")
    public WeatherInfo getWeather(
            @ToolParam(description = "城市名称，例如：北京、上海") String city) {

        // 真实项目这里应该调用气象 API，这里先用假数据模拟
        System.out.println(">>> 模型触发了 getWeather，参数 city = " + city);

        return new WeatherInfo(city, "晴", 26.5, 45);
    }

    @Tool(description = "查询指定城市未来三天的天气预报")
    public String getForecast(
            @ToolParam(description = "城市名称") String city,
            @ToolParam(description = "查询天数，只能是 1 到 3") int days) {
        return city + "未来" + days + "天：晴、多云、小雨";
    }
}
