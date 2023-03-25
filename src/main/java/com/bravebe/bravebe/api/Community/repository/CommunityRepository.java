package com.bravebe.bravebe.api.Community.repository;

import com.bravebe.bravebe.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Post, Integer> { //Post클래스의 @Id
}
