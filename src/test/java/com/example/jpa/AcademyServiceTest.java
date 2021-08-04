package com.example.jpa;

import com.example.jpa.entity.Academy;
import com.example.jpa.entity.AcademyRepository;
import com.example.jpa.entity.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AcademyServiceTest {
    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyQueryRepository academyQueryRepository;

    @Autowired
    private AcademyService academyService;

    @BeforeEach
    void setUp() {
//        List<Academy> academies = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            Academy academy = Academy.builder()
//                    .name("강남스쿨"+i)
//                    .build();
//            academy.addSubject(Subject.builder().name("자바웹개발"+i).build());
//            academy.addSubject(Subject.builder().name("파이썬"+i).build());
//            academies.add(academy);
//        }
//
//        academyRepository.saveAll(academies);
    }

    @Test
    void findAllSubjectNames() {
        //given
        List<String> subjectNames = academyService.findAllSubjectNames();

        assertEquals(10, subjectNames.size());
    }

    @Test
    void querydsl_확인() {
        //given
        academyRepository.save(Academy.builder().name("이덕수").build());

        //when
        List<Academy> result = academyQueryRepository.findByName("이덕수");

        //then
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getName(), "이덕수");
    }
}