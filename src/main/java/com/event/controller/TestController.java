package com.event.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class TestController {

    @GetMapping("/repo")
    public Object getRepo(@RequestParam("query") String query) {
        String url = "https://api.github.com/search/repositories?q=" + query;
        RestTemplate request = new RestTemplate();
        return request.getForObject(url, Object.class);
    }

    @GetMapping("/repo2")
    public Object getRepo2(@RequestParam("query") String query) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.github.com/search/repositories?q=" + query;
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
