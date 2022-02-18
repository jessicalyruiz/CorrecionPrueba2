package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.CitaRealizada;
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
		
		this.gestorCita.agendarCita("10-89", LocalDateTime.of(2022, Month.MAY, 5, 14, 30), new BigDecimal(25.30), "clinica pichincha ala A", "2300", "17000");
		
		//this.gestorCita.acturalizarCita("78-89", "diabetes", "insulina", LocalDateTime.of(1987, Month.MAY, 4, 0, 0));
		
		//tarea 20
		//1.       Un reporte donde se visualice todas las citas medicas que ya fueron realizadas y que tienen un diagnostico emitido, este reporte debe contener los siguientes datos:

		
		List<CitaRealizada> citasRealizadas=this.gestorCita.reporteCitas();
		for (CitaRealizada citaRealizada : citasRealizadas) {
			LOG.info(citaRealizada.toString());
		}
		
		
		// 2. Un reporte que muestre la cantidad de citas asignadas a cada Doctor, el reporte es considerando todas las citas médicas.
		
				//consultar el numero de citas dado la cedula de un doctor
		List<CitaMedica> citaDoctor=this.gestorCita.citasDoctor("2300");
		LOG.info("Citas Doctor: "+ citaDoctor.size());
		for (CitaMedica c : citaDoctor) {
			LOG.info(c.toString());
		}
		
		//3. Un reporte de la sumatoria total de lo que han pagado cada paciente, el reporte es considerando todas las citas médicas.
		List<CitaRealizada> citasTotales=this.gestorCita.reporteCitasTotales();
		BigDecimal sumatoriaIngresos=new BigDecimal(0);
		for (CitaRealizada c : citasTotales) {
			LOG.info(c.toString());
			sumatoriaIngresos=sumatoriaIngresos.add(c.getValor());
		}
		LOG.info("ingresos: "+sumatoriaIngresos);
	}

}
