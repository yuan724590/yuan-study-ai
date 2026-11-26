package org.example.yuanstudyai;

import org.example.yuanstudyai.entity.WeatherInfo;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeepSeekChatService {

    private final ChatClient chatClient;

    @Autowired
    private WeatherTools weatherTools;

    // 构造器注入 ChatClient.Builder，由 Spring AI 自动提供
    public DeepSeekChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String chat(String userMessage) {
        return chatClient.prompt()
                .user(userMessage)
                .call()
                .content();
    }

    public WeatherInfo askWeather(String city) {
        return chatClient.prompt()
                .user(u -> u.text("给我 {city} 当前的天气情况").param("city", city))
                .call()
                .entity(WeatherInfo.class);
    }

    public String ask(String q) {
        return chatClient.prompt()
                .user(q)
                .tools(weatherTools)        // 只有这次请求带上这个工具
                .call()
                .content();

    }
}