package med.voll.api.paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;
import med.voll.api.medico.Especialidad;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_paciente")

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente;
    private Long id_medico;
    private String nombre;
    private String apellido;
    private String documento;
    @Embedded
    private Direccion direccion;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;


    public Paciente(DatosRegistroPaciente datosRegistroPaciente){
        this.id_medico = datosRegistroPaciente.id_medico();
        this.nombre = datosRegistroPaciente.nombre();
        this.apellido = datosRegistroPaciente.apellido();
        this.documento = datosRegistroPaciente.documento();
        this.direccion = new Direccion(datosRegistroPaciente.direccion());
        this.especialidad = datosRegistroPaciente.especialidad();
    }

    public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {
        if(datosActualizarPaciente.nombre() != null){
            this.nombre = datosActualizarPaciente.nombre();
        }
        if(datosActualizarPaciente.Apellido() != null){
            this.apellido = datosActualizarPaciente.Apellido();
        }
    }
}
