package com.example.dataparser;


import com.example.dataparser.dto.PostDto;
import com.example.dataparser.listener.PostListener;
import com.example.dataparser.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
    @Autowired
    PostService postService;
    @Autowired
    PostListener postListener;

    @GetMapping("/post")
    public void post() {
        postService.postMessage(new PostDto("My first message!!!", 555));
    }

    @GetMapping("/consume")
    public void consume() {
        postService.postMessage(new PostDto("My first message!!!", 555));
    }

    @GetMapping("/listen")
    public void listen() {
        postListener.listen();
    }
}
