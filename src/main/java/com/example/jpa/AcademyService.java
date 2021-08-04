package com.example.jpa;

import com.example.jpa.entity.Academy;
import com.example.jpa.entity.AcademyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AcademyService {
    private AcademyRepository academyRepository;

    public AcademyService(AcademyRepository academyRepository) {
        this.academyRepository = academyRepository;
    }

    @Transactional(readOnly = true)
    public List<String> findAllSubjectNames(){
//        return extractSubjectNames(academyRepository.findAll());
//        return extractSubjectNames(academyRepository.findAllJoinFetch());
        return extractSubjectNames(academyRepository.findAllEntityGraph());
    }

    private List<String> extractSubjectNames(List<Academy> academies) {
        log.info(">>>>모든과목을 추출한다>>>>");
        log.info("Academy Size : {}", academies.size());

        return academies.stream()
                .map(data -> data.getSubjects().get(0).getName())
                .collect(Collectors.toList());
    }


}
