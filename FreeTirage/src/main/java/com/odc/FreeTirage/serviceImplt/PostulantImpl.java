package com.odc.FreeTirage.serviceImplt;

import com.odc.FreeTirage.model.Postulants;
import com.odc.FreeTirage.repository.PostulantsRepository;
import com.odc.FreeTirage.service.ServicePostulants;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class PostulantImpl implements ServicePostulants {
    private PostulantsRepository postulantsRepository;

    @Override
    public List<Postulants> enregistrer(List<Postulants> listPost) {
        return postulantsRepository.saveAll(listPost);
    }

    //@Autowired
    //final private PostulantRepository postulantRepository;
    @Override
    public ArrayList<Postulants> INSERPostulant(MultipartFile file, String nompostulants, String prenompostulants, String numeropostulants, String emailpostulants) {

        DataFormatter formatter=new DataFormatter();
        ArrayList<Postulants> values = new ArrayList<Postulants>(); // Variable permettant de prendre toutes les donnes du tableau

        // Bloque permettant de lever les exception lors de l'importation du fichier excel
        try{
            //InputStream fichier = new FileInputStream("fichierSource.xls"); // Recuperation du fichier Execl sous forme de fichier simple

            POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream()); // conversion du fichier simple sous forme d'un fichier POI

            HSSFWorkbook wb = new HSSFWorkbook(fs); // Conversion du fichier POI sous format Workbook

            HSSFSheet sheet = wb.getSheetAt(0); // Recuperation du Premier page du fichier excel

            Iterator rows = sheet.rowIterator(); // Recuperation de tous les lignes de la page du fichier
            // Boucle permettant de parcours toutes lignes de la page

            while (rows.hasNext()){

                //values.clear(); // Vider toutes les donnes du tableau dynamique "values"

                HSSFRow row = (HSSFRow) rows.next(); // Recuperation d'une ligne du tableau

                Iterator cells = row.cellIterator(); // Recuperation de toutes toutes les colonnes de chaque ligne
                Postulants p=new Postulants(nompostulants, prenompostulants, numeropostulants, emailpostulants);
                int numColun=0;
                // Boucle permettant de parcourut toutes les colonnes de chaque ligne
                while (cells.hasNext()){

                    HSSFCell cell = (HSSFCell) cells.next(); // Recuperation d'une colonne

                    switch (numColun){

                        case 0:
                            p.setPrenom(formatter.formatCellValue(cell));
                            break;
                        case 1:
                            p.setNom(formatter.formatCellValue(cell));
                            break;
                        case 2:
                            p.setNumero(formatter.formatCellValue(cell));
                            break;
                        case 3:
                            p.setEmail(formatter.formatCellValue(cell));
                            break;
                        default:
                            break;
                    }
                    numColun++;

                    // Condition permettant de verifier le type de la colonne et effectuer une convesion si c'est type int
                    // if (cell.getCellType() == CellType.NUMERIC){
                    //   values.add(Integer.toString((int) cell.getNumericCellValue()));
                    // }
                    //else{
                    //  values.add(cell.getStringCellValue());
                    // }
                }

                //postulantRepository.INSERTPOSTULANT (values.get(3),values.get(1),values.get(2),values.get(0));
                values.add(p);
            }
            return values;

        }catch (Exception e){

            e.printStackTrace();
            return null;

        }

    }

    @Override
    public Postulants creerPostulant(Postulants postulants) {

        return postulantsRepository.save(postulants);
    }






    @Override
    public List<Postulants> TrouveridPostList(Long idListe) {

        return postulantsRepository.FINDIDPOSTLIST(idListe);
    }

    @Override
    public List<Postulants> affichee(Postulants postulants) {
        return postulantsRepository.findAll();
    }
}
