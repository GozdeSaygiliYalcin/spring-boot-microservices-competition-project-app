package com.gozdesy.repository.entity;

import com.gozdesy.repository.enums.AccessionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "accessions_table")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Accession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long competitionId;
    Long date;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    AccessionType accessionType = AccessionType.NOTAPPROVED;
    @Embedded
    CommonData commonData;
}
