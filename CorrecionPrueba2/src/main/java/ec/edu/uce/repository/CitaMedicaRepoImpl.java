package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.CitaRealizada;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;



@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {
	private static final Logger LOG= (Logger) LoggerFactory.getLogger(CitaMedicaRepoImpl.class);
	
	
	@PersistenceContext
	private EntityManager  entityManager;

	@Override
	public void create(CitaMedica citaMedica) {
		this.entityManager.persist(citaMedica);
		LOG.info(citaMedica.toString());
	}

	@Override
	public CitaMedica read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void update(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(null);
		LOG.info(citaMedica.toString());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		CitaMedica citaBorar=this.read(id);
		this.entityManager.remove(citaBorar);
	}

	

	@Override
	public void acturalizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		CitaMedica cita=this.buscarNumeroCita(numeroCita);
		cita.setDiagnostico(diagnostico);
		cita.setReceta(receta);
		cita.setFechaProximaCita(fechaProximaCita);
		this.entityManager.merge(cita);
	}
	
	public CitaMedica buscarNumeroCita(String numero) {
		TypedQuery<CitaMedica> myQuery =this.entityManager.createQuery("Select c from CitaMedica c where c.numero =:valor",CitaMedica.class);
		myQuery.setParameter("valor", numero);

		return myQuery.getSingleResult();
	}

	@Override
	public List<Paciente> reportePacientes(String cedula, String nombre, LocalDate fecha, String genero) {
		Query myQuery=this.entityManager.createNativeQuery("Select * from paciente p where p.fecha=:valor AND p.genero=:valor2",Paciente.class);
		myQuery.setParameter("fecha", fecha);
		myQuery.setParameter("genero", genero);
		return (List<Paciente>) myQuery.getResultList();
	}

	

	public Paciente buscarPacientecodigoSeguro(String codigoSeguroPaciente) {
		TypedQuery<Paciente> myQuery=(TypedQuery<Paciente>) this.entityManager.createQuery("Select p from Paciente p where p.codigoSeguro=:valor");
		myQuery.setParameter("valor", codigoSeguroPaciente);

		return myQuery.getSingleResult();
	}
	
	public Doctor buscarDoctorApellido(String apellido) {
		TypedQuery<Doctor> myQuery=(TypedQuery<Doctor>) this.entityManager.createQuery("Select d from Doctor d where d.apellido=:valor");
		myQuery.setParameter("valor", apellido);

		return myQuery.getSingleResult();
	}

	@Override
	public List<CitaRealizada> reporteCitas() {
		//citas medicas que ya fueron realizadas y que tienen un diagnostico emitido
		
		
		TypedQuery<CitaRealizada> myQuery= this.entityManager.createQuery("SELECT NEW ec.edu.uce.modelo.CitaRealizada(c.numero,c.valor,c.fecha, c.diagnostico, c.receta, c.paciente.nombre, c.paciente.apellido, c.paciente.cedula, c.doctor.nombre,c.doctor.apellido,  c.doctor.cedula)  FROM CitaMedica c JOIN  c.doctor d JOIN c.paciente p",CitaRealizada.class);
		
	
		return myQuery.getResultList();
		
	}

	@Override
	public List<CitaMedica> citasDoctor(String cedulaDoctor) {
		TypedQuery<CitaMedica> myQuery=this.entityManager.createQuery("Select c from CitaMedica c JOIN c.doctor d where d.cedula=:valor",CitaMedica.class);
		myQuery.setParameter("valor", cedulaDoctor);

		//carga relacionamientos
		List<CitaMedica> listaCitas=myQuery.getResultList();
		for (CitaMedica c : listaCitas) {
			LOG.info("doctor"+ c.getDoctor());
			//LOG.info("Paciente: "+ c.getPaciente());
		}
		
		
		
		return myQuery.getResultList();
	}


	


}
