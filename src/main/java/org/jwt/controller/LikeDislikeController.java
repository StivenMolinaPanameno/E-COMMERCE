package org.jwt.controller;

import org.apache.catalina.connector.Response;
import org.jwt.service.ILikeDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class LikeDislikeController {
    @Autowired
    ILikeDislikeService service;
    @PostMapping("/{id}/{likeOrDislike}")
    public ResponseEntity<?> likeOrDislike(@PathVariable Long id, @PathVariable String likeOrDislike){
        if(likeOrDislike.equals("like") || likeOrDislike.equals("dislike") ){
            service.save(likeOrDislike, id);
            return ResponseEntity.ok(" ");
        }
        return ResponseEntity.badRequest().build();
    }
}
