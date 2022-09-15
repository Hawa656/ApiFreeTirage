package com.odc.FreeTirage.model;

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
    private Long id_listepostulants;
    private Date date;
    private String libele;
    private  Long NombreTirage;

}
