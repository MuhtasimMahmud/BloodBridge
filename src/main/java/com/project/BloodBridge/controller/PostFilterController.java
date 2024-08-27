package com.project.BloodBridge.controller;

import com.project.BloodBridge.model.Post;
import com.project.BloodBridge.repository.PostRepository;
import com.project.BloodBridge.service.SearchFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostFilterController {

    @Autowired
    private SearchFilterService searchFilterService;

    @GetMapping("/searchResultsWithFilter")
    public List<Post> filterSearchResult(@RequestBody Post post){
        return searchFilterService.searchFilter(post);
    }
}
