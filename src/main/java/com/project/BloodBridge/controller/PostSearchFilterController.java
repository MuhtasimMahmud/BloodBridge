package com.project.BloodBridge.controller;

import com.project.BloodBridge.model.Post;
import com.project.BloodBridge.service.PostSearchFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostSearchFilterController {

    @Autowired
    private PostSearchFilterService postSearchFilterService;

    @GetMapping("/searchResultsWithFilter")
    public List<Post> filterSearchResult(@RequestBody Post post){
        return postSearchFilterService.searchFilter(post);
    }
}
