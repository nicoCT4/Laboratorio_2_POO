public class horario {
    public class Horario {
        private String diaSemana;
        private int horaInicio;
        private int horaFin;
    
        // Constructor
        public Horario(String diaSemana, int horaInicio, int horaFin) {
            this.diaSemana = diaSemana;
            this.horaInicio = horaInicio;
            this.horaFin = horaFin;
        }
    
        // Métodos getters y setters para acceder y modificar los atributos
        public String getDiaSemana() {
            return diaSemana;
        }
    
        public void setDiaSemana(String diaSemana) {
            this.diaSemana = diaSemana;
        }
    
        public int getHoraInicio() {
            return horaInicio;
        }
    
        public void setHoraInicio(int horaInicio) {
            this.horaInicio = horaInicio;
        }
    
        public int getHoraFin() {
            return horaFin;
        }
    
        public void setHoraFin(int horaFin) {
            this.horaFin = horaFin;
        }
    
    }
    
}
