package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;
@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo{

	private static final Logger LOG= (Logger) LoggerFactory.getLogger(PacienteRepoImpl.class);
	@PersistenceContext
	private EntityManager  entityManager;

	
	@Override
	public void create(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
		LOG.info(paciente.toString());
	}

	@Override
	public Paciente read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void update(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
		LOG.info(paciente.toString());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Paciente pacienteBorrar=this.read(id);
		this.entityManager.remove(pacienteBorrar);
	}
	

	@Override
	public Paciente buscarPacienteCedula(String cedula) {
		TypedQuery<Paciente> myQuery=this.entityManager.createQuery("Select p from Paciente p where p.cedula=:valor",Paciente.class);
		myQuery.setParameter("valor", cedula);

		return myQuery.getSingleResult();
	}


}
