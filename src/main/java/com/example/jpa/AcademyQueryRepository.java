package com.example.jpa;

import com.example.jpa.entity.Academy;
import com.example.jpa.entity.QAcademy;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AcademyQueryRepository {
    private final JPAQueryFactory queryFactory;

    public AcademyQueryRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public List<Academy> findByName(String name){
        return queryFactory.selectFrom(QAcademy.academy)
                .where(QAcademy.academy.name.eq(name))
                .fetch();
    }

}
