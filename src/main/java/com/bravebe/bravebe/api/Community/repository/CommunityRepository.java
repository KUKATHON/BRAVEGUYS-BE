package com.bravebe.bravebe.api.Community.repository;

import com.bravebe.bravebe.api.dto.CommunityDTO;
import com.bravebe.bravebe.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Post, Integer> {

    @Query("select a.title, a.content, a.image, a.nickname from Post a")
    List<CommunityDTO> selectInPost();

}
