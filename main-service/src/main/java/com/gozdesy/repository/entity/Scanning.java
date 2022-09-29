package com.gozdesy.repository.entity;

import com.gozdesy.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "scannings_table")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Scanning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long questionId;
    Long date;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVED;
    @Embedded
    CommonData commonData;
}
