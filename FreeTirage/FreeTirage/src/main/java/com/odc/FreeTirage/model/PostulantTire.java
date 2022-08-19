package com.odc.FreeTirage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PostulantTire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_postulantTire;

    @ManyToOne
    @JoinColumn(name = "ListeTirage")
    private ListeTirage listeTirage;
}
