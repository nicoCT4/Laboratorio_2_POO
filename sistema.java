import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Salon> salones;
    private ArrayList<Curso> cursos;

    public Sistema() {
        this.salones = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    // Método para cargar el archivo de salones
    public void cargarSalones(String archivoSalones) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoSalones));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datosSalon = linea.split(";");
                int idSede = Integer.parseInt(datosSalon[0]);
                char edificio = datosSalon[1].charAt(0);
                int nivel = Integer.parseInt(datosSalon[2]);
                int idSalon = Integer.parseInt(datosSalon[3]);
                int capacidad = Integer.parseInt(datosSalon[4]);

                Salon salon = new Salon(idSede, edificio, nivel, idSalon, capacidad);
                salones.add(salon);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar el archivo de cursos
    public void cargarCursos(String archivoCursos) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoCursos));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datosCurso = linea.split(";");
                int idCurso = Integer.parseInt(datosCurso[0]);
                int idSede = Integer.parseInt(datosCurso[1]);
                String nombreCurso = datosCurso[2];
                String horario = datosCurso[3];
                int duracion = Integer.parseInt(datosCurso[4]);
                String dias = datosCurso[5];

                String[] horarioSplit = horario.split("-");
                int horaInicio = Integer.parseInt(horarioSplit[0]);
                int horaFin = Integer.parseInt(horarioSplit[1]);
                Horario horarioCurso = new Horario(horario, horaInicio, horaFin);
                Curso curso = new Curso(idCurso, idSede, nombreCurso, duracion, horarioCurso, dias, duracion);
                cursos.add(curso);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para asignar un curso a un salón
    public boolean asignarCursoASalon(Curso curso, Salon salon) {
        // Verificar condiciones de asignación
        if (curso.getIdSede() != salon.getSede()) {
            System.out.println("El curso y el salón no pertenecen a la misma sede.");
            return false;
        }
    
        if (curso.getCantidadEstudiantes() > salon.getCapacidad()) {
            System.out.println("El salón no tiene suficiente capacidad para el curso.");
            return false;
        }
    
        // Verificar disponibilidad de horario
        if (!salon.horarioDisponible(curso.getHorario())) {
            System.out.println("El curso no se puede asignar debido a una superposición de horarios.");
            return false;
        }
    
        // Si se cumplen todas las condiciones, asignar el curso al salón
        salon.agregarCurso(curso);
        return true;
    }
    

    // Método para consultar un salón por id de sede, edificio, nivel y número de salón
    public Salon consultarSalon(int idSede, char edificio, int nivel, int idSalon) {
        for (Salon salon : salones) {
            if (salon.getSede() == idSede && salon.getEdificio() == edificio &&
                salon.getNivel() == nivel && salon.getSalon() == idSalon) {
                return salon; // Se encontró el salón
            }
        }
        System.out.println("El salón no fue encontrado.");
        return null; // No se encontró el salón
    }

    // Método para consultar un curso por su id
    public Curso consultarCurso(int idCurso) {
        for (Curso curso : cursos) {
            if (curso.getIdCurso() == idCurso) {
                return curso; // Se encontró el curso
            }
        }
        System.out.println("El curso no fue encontrado.");
        return null; // No se encontró el curso
    }

    // Método para generar un informe
    public void generarInforme() {
        System.out.println("Cursos Asignados:");
        for (Salon salon : salones) {
            System.out.println("Salón " + salon.getSalon() + ":");
            for (Curso curso : salon.getCursosAsignados()) {
                System.out.println(" - " + curso.getNombre() + " (" + curso.getIdCurso() + ")");
            }
        }

        System.out.println("\nCursos No Asignados:");
        for (Curso curso : cursos) {
            boolean asignado = false;
            for (Salon salon : salones) {
                if (salon.horarioDisponible(curso.getHorario())) {
                    asignado = true;
                    break;
                }
            }
            if (!asignado) {
                System.out.println(" - " + curso.getNombre() + " (" + curso.getIdCurso() + ")");
            }
        }
    }
    public Salon consultarSalonPorSede(int idSede) {
        for (Salon salon : salones) {
            if (salon.getSede() == idSede) {
                return salon; // Se encontró un salón en la sede especificada
            }
        }
        System.out.println("No se encontró ningún salón en la sede especificada.");
        return null; // No se encontró un salón en la sede especificada
    }
    
}
