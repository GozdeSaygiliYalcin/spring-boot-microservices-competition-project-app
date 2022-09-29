package com.gozdesy.repository.entity;

import com.gozdesy.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "competition_questions_table")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CompetitionQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long questionId;
    Long competitionId;
    int duration;
    int numberOfQueue;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVED;
    @Embedded
    CommonData commonData;

}
