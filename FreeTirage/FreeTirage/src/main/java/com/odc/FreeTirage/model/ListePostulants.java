package com.odc.FreeTirage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
/*
    @JsonIgnore
    @OneToMany(mappedBy = "ListePostulants")
    List<Tirage> Tirage = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ListePostulants")
    List<Postulants> postulants = new ArrayList<>();

 */



}
