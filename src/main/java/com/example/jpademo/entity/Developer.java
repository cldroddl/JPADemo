package com.example.jpademo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "developer")
@Setter
@Getter
@ToString
public class Developer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "developer", orphanRemoval = true)
    private List<ApplyPosition> applyPositions = new ArrayList<>();

    @Column(name = "name")
    private String name;

    public void addApplyPosition(ApplyPosition applyPosition) {
        applyPositions.add(applyPosition);
        applyPosition.setDeveloper(this);
    }
}