package com.gozdesy.repository.entity;

import com.gozdesy.repository.enums.CompetitionState;
import com.gozdesy.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "competitions_table")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long competiterId;
    String competitionTitle;
    String competitionDefinition;
    String picture;
    int numberOfWinner;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    CompetitionState competitionState = CompetitionState.ACTIVE_SESSION;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.AWAITINGAPPROVAL;

    @Embedded
    CommonData commonData;

    @Transient
    List<Question> questionList;

}
