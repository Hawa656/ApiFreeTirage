package com.odc.FreeTirage.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ListePostulants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_listepostulants;
    private Date date;
    private String libele;


}
