package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarPaciente(@NotNull Long id_paciente, String nombre, String Apellido) {

}
