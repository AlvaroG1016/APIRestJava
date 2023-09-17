package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.direccion.DatosDireccion;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private IMedicoRepository MedicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        MedicoRepository.save(new Medico(datosRegistroMedico));
    }
    @GetMapping
    public Page<DatosListadoMedico> listarMedico(@PageableDefault(size = 2) Pageable paginacion){
        //return MedicoRepository.findAll(paginacion).map(DatosListadoMedico::new);  este lista todos, el otro solo solo
        // trae los activos
        return MedicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);

    }
    @PutMapping
    @Transactional  //Abre una transaccion en bd
    public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        Medico medico = MedicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        return ResponseEntity.ok(new DatosRespuestaMedico(medico.getId(), medico.getNombre(), medico.getTelefono(),
                medico.getEmail(), medico.getEspecialidad().toString(),
                new DatosDireccion(medico.getDireccion().getCalle(),
                medico.getDireccion().getDistrito(), medico.getDireccion().getCiudad(), medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento()
                )));
    }

    //Delete logico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Medico medico = MedicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }


    //Delete base de datos

    //    public void eliminarMedico(@PathVariable Long id){
    //      Medico medico = MedicoRepository.getReferenceById(id);
    //    MedicoRepository.delete(medico);
    //}


}
