package com.bravebe.bravebe.api.Community.repository;

import com.bravebe.bravebe.api.dto.CommunityDTO;
import com.bravebe.bravebe.domain.Market;
import com.bravebe.bravebe.domain.Post;
import com.querydsl.core.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommunityRepository extends JpaRepository<Post, Integer> {

    @Query("select a.title, a.content, a.image, a.nickname from Post a")
    List<Post> selectInPost();

    @Query("select m from Post m where m.postId = :postId")
    Optional<Post> findPostById(String postId);

    @Query("select m from Post m where m.userId = :userId")
    List<Post> findMineById(String userId);

}
