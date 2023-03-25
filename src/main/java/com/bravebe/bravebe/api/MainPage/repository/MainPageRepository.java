package com.bravebe.bravebe.api.MainPage.repository;

import com.bravebe.bravebe.domain.Post;
import com.bravebe.bravebe.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MainPageRepository extends QuerydslRepositorySupport {

    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    public MainPageRepository(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(Post.class);
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Long selectBearNumbers(String loginId) {

        QMember m = QMember.member;

        return jpaQueryFactory
                .select(m.name.count())
                .from(m)
                .where(m.userid.eq(loginId))
                .fetchOne();

    }

}
