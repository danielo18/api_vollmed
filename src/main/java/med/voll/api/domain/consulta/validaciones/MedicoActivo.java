package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.medicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoActivo implements ValidadorDeConsultas{
    @Autowired
    private medicoRepository medicoRepository;

    public void validar(DatosAgendarConsulta datos){

        if (datos.idPaciente()==null){
            return;
        }
        var medicoActivo=medicoRepository.findActivoById(datos.idMedico());
        if (medicoActivo==0){
            throw new ValidationException("No se puede permitir agendar citas con medicos inactivos");
        }
    }
}
