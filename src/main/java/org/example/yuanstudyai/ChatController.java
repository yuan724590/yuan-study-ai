package org.example.yuanstudyai;

import org.example.yuanstudyai.entity.WeatherInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final DeepSeekChatService chatService;

    public ChatController(DeepSeekChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return chatService.chat(message);
    }

    @GetMapping("/askWeather")
    public WeatherInfo askWeather(@RequestParam String message) {
        return chatService.askWeather(message);
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String message) {
        return chatService.ask(message);
    }
}