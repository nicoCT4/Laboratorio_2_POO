
public class Curso {
    private int idCurso;
    private int idSede;
    private String nombre;
    private int duracion;
    private Horario horario;
    private String dias;
    private int cantidadEstudiantes;

    // Constructor
    public Curso(int idCurso, int idSede, String nombre, int duracion, Horario horario, String dias, int cantidadEstudiantes) {
        this.idCurso = idCurso;
        this.idSede = idSede;
        this.nombre = nombre;
        this.duracion = duracion;
        this.horario = horario;
        this.dias = dias;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    // Métodos getters y setters
    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }
    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getNombre() {
        return nombre;
    }
    public Horario getHorario() {
        return horario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

