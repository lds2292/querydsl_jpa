package com.example.jpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Academy {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "academy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subject> subjects = new ArrayList<>();

    @Builder
    public Academy(String name, List<Subject> subjects){
        this.name = name;
        if(subjects != null) {
            this.subjects = subjects;
        }
    }

    public void addSubject(Subject subject){
        this.subjects.add(subject);
        subject.updateAcademy(this);
    }
}
