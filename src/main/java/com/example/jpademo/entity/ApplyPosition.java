package com.example.jpademo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "apply_position")
public class ApplyPosition {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated
    @Column(name = "apply_status")
    private ApplyStatus applyStatus;

    @Column(name = "need_1", nullable = false)
    private boolean need1;

    @Column(name = "need_2", nullable = false)
    private boolean need2;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "position_id")
    private ProjectPosition projectPosition;

}