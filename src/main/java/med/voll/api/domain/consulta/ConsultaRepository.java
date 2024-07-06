package med.voll.api.domain.consulta;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByPacienteIdAndFechaBetween(Long IdPciente, LocalDateTime primerHorario, LocalDateTime ultimoJorario);

    boolean existsByMedicoIdAndFecha(Long idMedico, LocalDateTime fecha);
}