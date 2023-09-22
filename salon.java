import java.util.ArrayList; // Importa la clase ArrayList

public class salon {
    private int sede;
    private int edificio;
    private int nivel;
    private int salon;
    private int capacidad;
    private ArrayList<horario> horarios; 

    // Constructor
    public salon(int sede, int edificio, int nivel, int salon, int capacidad) {
        this.sede = sede;
        this.edificio = edificio;
        this.nivel = nivel;
        this.salon = salon;
        this.capacidad = capacidad;
        this.horarios = new ArrayList<>();
        
    }
    public void agregarCurso(curso curso) {

        
    }
    
    //getters
    public int getSede() {
        return sede;
    }
    public int getEdificio() {
        return edificio;
    }
    public int getNivel() {
        return nivel;
    }
    public int getSalon() {
        return salon;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public ArrayList<horario> getHorarios() {
        return horarios;
    }

    //setters
    public void setSede(int sede) {
        this.sede = sede;
    }
    public void setEdificio(int edificio) {
        this.edificio = edificio;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setSalon(int salon) {
        this.salon = salon;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public void setHorarios(ArrayList<horario> horarios) {
        this.horarios = horarios;
    }
}


