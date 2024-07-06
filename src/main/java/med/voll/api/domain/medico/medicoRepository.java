package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface medicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByActivoTrue(Pageable paginacion);

    //primer cambio

@Query("""
        select m from medico m
         where m.activo=1 and
         m.especialidad=:especialidad and
         m.id not in(
         select c.medico.id from consulta c where
         c.data=:fecha
         )
         order by rand()
         limit 1
        """)
    Medico seleccionarMedicoConEspecialidadEnFecha(Especialidad especialidad, LocalDateTime fecha);
}
