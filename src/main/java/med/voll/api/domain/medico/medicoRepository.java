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
        select m from Medico m
         where m.activo=1 and
         m.especialidad=:especialidad and
         m.id not in(select c.medico.id from Consulta c where c.fecha=:fecha)
         order by rand()
         limit 1
        """)
    Medico seleccionarMedicoConEspecialidadAndFecha(Especialidad especialidad, LocalDateTime fecha);


    @Query("""
            select m.activo
            from Medico m
            where m.id=:idMedico
            """)
    Integer findActivoById(Long idMedico);
}
