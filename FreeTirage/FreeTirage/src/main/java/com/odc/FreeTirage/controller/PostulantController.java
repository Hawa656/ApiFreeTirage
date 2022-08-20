package com.odc.FreeTirage.controller;

import com.odc.FreeTirage.model.ListePostulants;
import com.odc.FreeTirage.model.PostulantExcelImport;
import com.odc.FreeTirage.model.Postulants;
import com.odc.FreeTirage.service.ServiceListPostulant;
import com.odc.FreeTirage.service.ServicePostulants;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/postulant")
@AllArgsConstructor
public class PostulantController {
    final private ServicePostulants servicePostulants;
    final  private ServiceListPostulant serviceListPostulant;

    @RequestMapping("/import/excel/{libele}")
    @ResponseBody
    public String importFormatExcel(@Param("file") MultipartFile file, ListePostulants liste, String libele){
        PostulantExcelImport excelImporter = new PostulantExcelImport();
        List<Postulants> postulantsList = excelImporter.excelImport(file);
        if(postulantsList.size() == 0){
            return "fichier vide";
        }else{
            liste.setDate(new Date());
            ListePostulants l = serviceListPostulant.creerListe(liste);
            for (Postulants p:postulantsList){
              p.setIdliste(l);
            }
            servicePostulants.enregistrer(postulantsList);
            return "import avec succes";
        }

    }
}
