package com.odc.FreeTirage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTirage;
    private Date date;
    private String libelle;
/*
    @JsonIgnore
    @OneToMany(mappedBy = "Tirage")
    List<ListeTirage> ListeTirage = new ArrayList<>();
*/
    @ManyToOne
    @JoinColumn(name = "Tirage")
    private ListePostulants listePostulants;

}
