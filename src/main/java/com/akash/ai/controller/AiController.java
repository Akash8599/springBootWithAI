package com.akash.ai.controller;


import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {


    private  OllamaChatClient chatClient;

    private static final String prompt = "Hi";
    public AiController(OllamaChatClient client){
        chatClient = client;
    }

    @GetMapping("prompt")
   public Flux<String> getMessage(){
        System.out.println("in");
        Flux<String> res = chatClient.stream(prompt);
        return res;
   }
}
