package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.service.ICitaMedicaService;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IGestorCita;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class CorrecionPrueba2Application implements CommandLineRunner{

	private static final Logger LOG= (Logger) LoggerFactory.getLogger(CorrecionPrueba2Application.class);
	
	@Autowired
	IGestorCita gestorCita;
	
	@Autowired
	IDoctorService doctorService;
	
	@Autowired
	IPacienteService pacienteService;
	
	@Autowired
	ICitaMedicaService citaService;
	
	public static void main(String[] args) {
		SpringApplication.run(CorrecionPrueba2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		Paciente paciente=new Paciente();
		paciente.setApellido("Sisalima");
		paciente.setCedula("17000");
		paciente.setCodigoSeguro("a7-78");
		paciente.setEstatura(1.78);
		paciente.setFechaNacimiento(LocalDate.of(1950, Month.FEBRUARY, 10));
		paciente.setGenero("masculino");
		paciente.setNombre("Pedro");
		paciente.setPeso(68.7);
		//paciente.setCitaMedica(citas);
		pacienteService.create(paciente);
		LOG.info(paciente.toString());
		
		Paciente paciente2=new Paciente();
		paciente2.setApellido("Ruiz");
		paciente2.setCedula("237000");
		paciente2.setCodigoSeguro("tyus-45");
		paciente2.setEstatura(1.78);
		paciente2.setFechaNacimiento(LocalDate.of(1950, Month.FEBRUARY, 10));
		paciente2.setGenero("femenino");
		paciente2.setNombre("taty");
		paciente2.setPeso(68.7);
		//paciente2.setCitaMedica(citas);
		pacienteService.create(paciente2);
		LOG.info(paciente2.toString());
		
		Doctor doctor=new Doctor();
		doctor.setApellido("Vinc");
		doctor.setCedula("2300");
		doctor.setCodigoSenescyt("rt-56");
		doctor.setFechaNacimiento(LocalDate.of(1992, Month.JUNE, 24));
		doctor.setGenero("femenino");
		doctor.setNombre("Judit");
		doctor.setNumeroConsultorio(5);
		//doctor.setCitaMedica(citas);
		doctorService.create(doctor);
		LOG.info(doctor.toString());
		
		Doctor doctor2=new Doctor();
		doctor2.setApellido("Ruiz");
		doctor2.setCedula("1706");
		doctor2.setCodigoSenescyt("po-56");
		doctor2.setFechaNacimiento(LocalDate.of(1987, Month.APRIL, 4));
		doctor2.setGenero("masculino");
		doctor2.setNombre("Mauro");
		doctor2.setNumeroConsultorio(7);
		//doctor2.setCitaMedica(citas);
		doctorService.create(doctor2);
		LOG.info(doctor2.toString());
		
		
		CitaMedica cita=new CitaMedica();
		cita.setDiagnostico("disenteria");
		cita.setFecha(LocalDateTime.of(2022, Month.APRIL, 5, 12, 30));
		cita.setLugar("clinica pichincha ala B");
		cita.setNumero("475-78");
		cita.setReceta("paracetamol");
		cita.setValor(new BigDecimal(50.30));
		
		this.citaService.create(cita);*/
		
		//this.gestorCita.agendarCita("45-78", LocalDateTime.of(2022, Month.APRIL, 5, 12, 30), new BigDecimal(50.30), "clinica pichincha ala B", doctor.getCedula(), paciente.getCedula());
		
		this.gestorCita.resultadoCita("475-78", "diabetes", "insulina", LocalDateTime.of(1987, Month.MAY, 4, 0, 0));
		
	}

}
