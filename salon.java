import java.util.ArrayList; 
import java.util.List;

public class Salon {
    private int sede;
    private int edificio;
    private int nivel;
    private int salon;
    private int capacidad;
    private ArrayList<Horario> horarios; 
    private List<Curso> cursosAsignados = new ArrayList<>();

    // Constructor
    public Salon(int sede, int edificio, int nivel, int salon, int capacidad) {
        this.sede = sede;
        this.edificio = edificio;
        this.nivel = nivel;
        this.salon = salon;
        this.capacidad = capacidad;
        this.horarios = new ArrayList<>();
        
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
    public ArrayList<Horario> getHorarios() {
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
    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }
    public List<Curso> getCursosAsignados() {
        return cursosAsignados;
    }
    public boolean horarioDisponible(Horario horario) {
        for (Horario horarioExistente : horarios) {
            if (haySuperposicionHoraria(horarioExistente, horario)) {
                return false; // Hay superposición
            }
        }
        return true; // No hay superposición
    }
    
    
    public void agregarCurso(Curso curso) {
        // Verificar si hay superposición con otros cursos asignados al mismo salón
        if (haySuperposicion(curso)) {
            System.out.println("El curso no se puede asignar debido a una superposición de horarios.");
        } else {
            cursosAsignados.add(curso);
            System.out.println("Curso asignado con éxito.");
        }
    }
        
    private boolean haySuperposicion(Curso curso) {
        for (Curso cursoAsignado : cursosAsignados) {
            // Comparar el día de la semana y horarios
            if (cursoAsignado.getHorario().getDiaSemana().equals(curso.getHorario().getDiaSemana())
                && haySuperposicionHoraria(cursoAsignado.getHorario(), curso.getHorario())) {
                return true; // Hay superposición
            }
        }
        return false; // No hay superposición
    }
    
    private boolean haySuperposicionHoraria(Horario horario1, Horario horario2) {
        // Lógica para verificar superposición de horarios
        int horaInicio1 = horario1.getHoraInicio();
        int horaFin1 = horario1.getHoraFin();
        int horaInicio2 = horario2.getHoraInicio();
        int horaFin2 = horario2.getHoraFin();
    
        // Verificar si hay superposición de horarios
        if (horaInicio1 <= horaFin2 && horaFin1 >= horaInicio2) {
            return true; // Hay superposición
        }
    
        return false; // No hay superposición
    }
    

}


