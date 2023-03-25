package com.bravebe.bravebe.api.MyPage.repository;

import com.bravebe.bravebe.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyPageRepository extends JpaRepository<Member, String> {
    @Query("select m from Member m where m.userid = :userid")
    Optional<Member> findByUserId(String userid);
}
