package com.gozdesy.repository.entity;

import com.gozdesy.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "questions_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long adminId;
    @Column(length = 1000)
    String questionContent;
    int duration;
    int numberOfOption;
    String numberOfGroup;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.AWAITINGAPPROVAL;
    @Embedded
    CommonData commonData;


}
