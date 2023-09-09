package org.jwt.service;

import org.jwt.entities.LikeDislike;

public interface ILikeDislikeService {
    void save(String vote, Long id);


}
