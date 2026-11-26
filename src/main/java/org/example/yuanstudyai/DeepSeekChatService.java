package org.example.yuanstudyai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class DeepSeekChatService {

    private final ChatClient chatClient;

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
}