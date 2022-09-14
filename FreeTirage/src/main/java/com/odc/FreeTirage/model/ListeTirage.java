package com.odc.FreeTirage.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class ListeTirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_listeTirage;
}
