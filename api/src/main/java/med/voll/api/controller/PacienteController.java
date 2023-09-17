package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteRepository PacienteRepository;

    @PostMapping
    public void registrarPaciente(@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente){
        PacienteRepository.save(new Paciente(datosRegistroPaciente));
    }
    @GetMapping
    public Page<DatosListadoPaciente> listarPacientes(@PageableDefault(size = 2) Pageable pageable){
        return PacienteRepository.findAll(pageable).map(DatosListadoPaciente::new);
    }
    @PutMapping
    @Transactional
    public void editarPaciente(@RequestBody @Valid DatosActualizarPaciente datosActualizarPaciente){
        Paciente paciente = PacienteRepository.getReferenceById(datosActualizarPaciente.id_paciente());
        paciente.actualizarDatos(datosActualizarPaciente);
    }
    @DeleteMapping("/{id_paciente}")
    @Transactional
    public void eliminarPaciente(@PathVariable Long id_paciente){
        Paciente paciente = PacienteRepository.getReferenceById(id_paciente);
        PacienteRepository.delete(paciente);
    }
}
