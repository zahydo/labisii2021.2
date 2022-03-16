package co.edu.unicauca.cor.domain;

/**
 *
 * @author Libardo, Julio
 */
public class Reclamos_Manager {

    private NivelUno atrNivelUno;
    private NivelDos atrNivelDos;
    private NivelTres atrNivelTres;
    private NivelCuatro atrNivelCuatro;

   

    public void createAthentionFlow() {
        atrNivelUno = new NivelUno("jabella@unicauca.edu.co");
        atrNivelDos = new NivelDos("jnino@unicauca.edu.co");
        atrNivelTres = new NivelTres("lbolivar@unicauca.edu.co");
        atrNivelCuatro = new NivelCuatro("hyun@unicauca.edu.co");
        // Crea los enlaces
        atrNivelUno.setAtrSiguienteManipulador(atrNivelDos);
        atrNivelDos.setAtrSiguienteManipulador(atrNivelTres);
        atrNivelTres.setAtrSiguienteManipulador(atrNivelCuatro);
    }

    public NivelUno getAtrNivelUno() {
        return atrNivelUno;
    }

    public void setAtrNivelUno(NivelUno atrNivelUno) {
        this.atrNivelUno = atrNivelUno;
    }

    public NivelDos getAtrNivelDos() {
        return atrNivelDos;
    }

    public void setAtrNivelDos(NivelDos atrNivelDos) {
        this.atrNivelDos = atrNivelDos;
    }

    public NivelTres getAtrNivelTres() {
        return atrNivelTres;
    }

    public void setAtrNivelTres(NivelTres atrNivelTres) {
        this.atrNivelTres = atrNivelTres;
    }
    
    
    public NivelCuatro getLeverFour() {
        return atrNivelCuatro;
    }

    public void setLeverFour(NivelCuatro leverFour) {
        this.atrNivelCuatro = leverFour;
    }

}
