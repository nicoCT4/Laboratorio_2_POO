import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class sistema {
    private ArrayList<salon> salones;
    private ArrayList<curso> cursos;

    public sistema() {
        this.salones = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    // Método para cargar el archivo de salones
    public void cargarsalones(String archivosalones) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivosalones));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datossalon = linea.split(";");
                int idSede = Integer.parseInt(datossalon[0]);
                char edificio = datossalon[1].charAt(0);
                int nivel = Integer.parseInt(datossalon[2]);
                int idsalon = Integer.parseInt(datossalon[3]);
                int capacidad = Integer.parseInt(datossalon[4]);

                salon salon = new salon(idSede, edificio, nivel, idsalon, capacidad);
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

                curso curso = new curso(idCurso, idSede, nombreCurso, duracion, idSede, dias, duracion);
                cursos.add(curso);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para asignar un curso a un salón
    public boolean asignarCursoAsalon(curso curso, salon salon) {
        // Verificar condiciones de asignación
        if (curso.getIdSede() != salon.getSede()) {
            System.out.println("El curso y el salón no pertenecen a la misma sede.");
            return false;
        }

        // Verificar disponibilidad de horario en el salón (debes implementar esta lógica)

        if (curso.getCantidadEstudiantes() > salon.getCapacidad()) {
            System.out.println("El salón no tiene suficiente capacidad para el curso.");
            return false;
        }

        // Si pasa todas las verificaciones, asignar el curso al salón
        salon.agregarCurso(curso);
        return true;
    }

    // Método para consultar un salón por id de sede, edificio, nivel y número de salón
    public salon consultarsalon(int idSede, char edificio, int nivel, int idsalon) {
        for (salon salon : salones) {
            if (salon.getSede() == idSede && salon.getEdificio() == edificio &&
                salon.getNivel() == nivel && salon.getSalon() == idsalon) {
                return salon; // Se encontró el salón
            }
        }
        System.out.println("El salón no fue encontrado.");
        return null; // No se encontró el salón
    }

    // Método para consultar un curso por su id
    public curso consultarCurso(int idCurso) {
        for (curso curso : cursos) {
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
        for (salon salon : salones) {
            System.out.println("Salón " + salon.getSalon() + ":");
            for (curso curso : salon.getCursosAsignados()) {
                System.out.println(" - " + curso.getNombre() + " (" + curso.getIdCurso() + ")");
            }
        }

        System.out.println("\nCursos No Asignados:");
        for (curso curso : cursos) {
            boolean asignado = false;
            for (salon salon : salones) {
                if (salon.horarioDisponible(curso)) {
                    asignado = true;
                    break;
                }
            }
            if (!asignado) {
                System.out.println(" - " + curso.getNombre() + " (" + curso.getIdCurso() + ")");
            }
        }
    }
}
