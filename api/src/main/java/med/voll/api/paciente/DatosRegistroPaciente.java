package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DatosDireccion;
import med.voll.api.direccion.Direccion;
import med.voll.api.medico.Especialidad;

public record DatosRegistroPaciente(
        @NotNull
        Long id_medico,
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank
        String documento,
        @NotNull
        @Valid
        DatosDireccion direccion,
        @NotNull
        Especialidad especialidad


) {
}
