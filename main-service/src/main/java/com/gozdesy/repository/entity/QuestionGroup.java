package com.gozdesy.repository.entity;

import com.gozdesy.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "questiongroups_table")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QuestionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String groupName;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVED;
    @Embedded
    CommonData commonData;
}
