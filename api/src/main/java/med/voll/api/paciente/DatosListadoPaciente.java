package med.voll.api.paciente;

public record DatosListadoPaciente(Long id_paciente, String nombre, String Apellido) {

    public DatosListadoPaciente(Paciente paciente){
        this(paciente.getId_paciente(), paciente.getNombre(), paciente.getApellido());
    }
}
