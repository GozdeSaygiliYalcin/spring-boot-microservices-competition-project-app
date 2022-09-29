package com.gozdesy.repository.entity;

import com.gozdesy.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "winners_table")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long competitionId;
    int score;
    int ranking;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVED;
    @Embedded
    CommonData commonData;


}
