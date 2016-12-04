package esestream02;

import java.util.ArrayList;

/**
 *
 * @author ncvescera
 */
public class JavaEseStream02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cognome;
        String materia;
        String valutazione;
        int voto;
        
        ScriviFile fileWriter = new ScriviFile();
        
        do{
            cognome = EasyInput.inputS("Cognome: ");
            materia = EasyInput.inputS("Materia: ");
            valutazione = EasyInput.inputS("Valutazione: ");
            voto = EasyInput.inputI("Voto: ");
            
            fileWriter.scrivi(cognome,materia,valutazione,voto);
            
        }while(!(EasyInput.inputS("Continuare?\t[no-0]").equals("0")));
        
        fileWriter.close(); //chiusura del fileWriter
        
        LeggiFile fileReader = new LeggiFile();
        ArrayList<Record> rows = new ArrayList(); //array che conterrà ogni riga del file
        
        
        fileReader.readAll(rows);
        fileReader.close();
        
        for(Record elem:rows)
            elem.print();
        
        System.out.println("MEDE\n");
        
        Analizza recordAnalizer = new Analizza(rows);
        
        recordAnalizer.analizza();
    }
    
}
