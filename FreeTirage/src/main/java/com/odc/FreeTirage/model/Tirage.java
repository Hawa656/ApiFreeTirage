package com.odc.FreeTirage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data

@NoArgsConstructor
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTirage;
    private Date date;
    private String libelle;

    public Tirage(Long idTirage, Date date, String libelle) {
        super();
        this.idTirage = idTirage;
        this.date = date;
        this.libelle = libelle;
    }
}


