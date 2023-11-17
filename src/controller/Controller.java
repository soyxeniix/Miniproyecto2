package controller;

import java.util.ArrayList;

import models.Candidato;
import models.Propuesta;

public class Controller {
  
    private ArrayList<Candidato> listaCandidato;

    public Controller() {
       listaCandidato = new ArrayList<>();
    }

    public ArrayList<Candidato> getListaCandidato() {
        return listaCandidato;
    }

    public boolean addCandidato(Candidato candidato) {
        return this.listaCandidato.add(candidato);
    }

    public boolean removeCandidato(Candidato candidato) {
        return this.listaCandidato.remove(candidato);
    }

     public boolean removeCandidato(int index) {
        return this.listaCandidato.remove(index) != null;
    }

    public Candidato getCandidato(int index) {
        return this.listaCandidato.get(index);
    }

    public String[] getListaCandidatoString() {
        String[] lista = new String[this.listaCandidato.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = this.listaCandidato.get(i).toString();
        }
        return lista;
    }

    public Candidato getCandidato(String name) {
        for (Candidato candidato : this.listaCandidato) {
            if (candidato.getNombre().toLowerCase().equals(name.toLowerCase())) {
                return candidato;
            }
        }
        return null;
    }

    public boolean updateCandidato(Candidato candidatold, Candidato candidato) {
        for (int i = 0; i < this.listaCandidato.size(); i++) {
            if (this.listaCandidato.get(i).getNombre().equals(candidatold.getNombre()) &&  this.listaCandidato.get(i).getCedula().equals(candidatold.getCedula()))   {
                this.listaCandidato.set(i, candidato);
                return true;
            }
        }
        return false;
    }


    public boolean updateCandidato(int index, Candidato candidato) {
        if (index >= 0 && index < this.listaCandidato.size()) {
            this.listaCandidato.set(index, candidato);
            return true;
        }
        return false;
    }

    public String infoCandidato(Candidato candidato) {
        String infoCompleta = "";
        infoCompleta += "Nombre: " + candidato.getNombre() + "\n";
        infoCompleta += "Cedulaa: " + candidato.getCedula() + "\n";
        infoCompleta += "Cuidad: " + candidato.getCiudad() + "\n";
        infoCompleta += "Orientacion: " + candidato.getOrientacion() + "\n";
        infoCompleta += "Partido: " + candidato.getPartido() + "\n";
        infoCompleta += "Votos: " + candidato.getVotos() + "\n";
        infoCompleta += "Promesas: \n";
        for (Propuesta promesa : candidato.getPromesas()) {
            infoCompleta += "\t" + promesa.getTitulo() + ": ";
            infoCompleta +=  promesa.getDescripcion() + "\n";
        }
        return infoCompleta;
    }

    public String infoCandidato(Candidato candidato, boolean showPromesas) {
        String infoCompleta = "";
        infoCompleta += "Nombre: " + candidato.getNombre() + "\n";
        infoCompleta += "Cedulaa: " + candidato.getCedula() + "\n";
        infoCompleta += "Cuidad: " + candidato.getCiudad() + "\n";
        infoCompleta += "Orientacion: " + candidato.getOrientacion() + "\n";
        infoCompleta += "Partido: " + candidato.getPartido() + "\n";
        infoCompleta += "Votos: " + candidato.getVotos() + "\n";
        
        if(showPromesas){
            infoCompleta += "Promesas: \n";
            for (Propuesta promesa : candidato.getPromesas()) {
             infoCompleta += "\t" + promesa.getTitulo() + ": ";
             infoCompleta +=  promesa.getDescripcion() + "\n";
            }
        }
        
        return infoCompleta;
    }
    public Candidato getCandidatoGanador(){
        ArrayList <Candidato> listaCandidato = this.listaCandidato;
        Candidato aux;
        if (listaCandidato.isEmpty()) {
            return null;
        }
        for(int i =0; i< listaCandidato.size()-1;i++){
            for(int j=0;j<listaCandidato.size()-i-1;j++){
                Candidato next_candidato = listaCandidato.get(j+1);
                Candidato candidato_actual = listaCandidato.get(j);
                if(candidato_actual.getVotos()<next_candidato.getVotos()){
                    aux = candidato_actual;
                    listaCandidato.set(j, next_candidato);
                    listaCandidato.set(j+1, aux);
                }
                
            }
            }
        return listaCandidato.get(0).getVotos() != 0 ? listaCandidato.get(0) : null;
    }

}
