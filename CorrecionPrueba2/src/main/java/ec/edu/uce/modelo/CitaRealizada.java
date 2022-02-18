package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CitaRealizada {

	private String numero;
	private BigDecimal valor;
	private LocalDateTime fecha;
	private String diagnostico;
	private String receta;
	private String nombrePaciente;
	private String apellidoPaciente;
	private String cedulaPaciente;
	private String nombreDoctor;
	private String apellidoDoctor;
	private String cedulaDoctor;
	
	public CitaRealizada() {}
	
	public CitaRealizada(String numero, BigDecimal valor, LocalDateTime fecha, String diagnostico, String receta,
			String nombrePaciente, String apellidoPaciente, String cedulaPaciente, String nombreDoctor,
			String apellidoDoctor, String cedulaDoctor) {
		super();
		this.numero = numero;
		this.valor = valor;
		this.fecha = fecha;
		this.diagnostico = diagnostico;
		this.receta = receta;
		this.nombrePaciente = nombrePaciente;
		this.apellidoPaciente = apellidoPaciente;
		this.cedulaPaciente = cedulaPaciente;
		this.nombreDoctor = nombreDoctor;
		this.apellidoDoctor = apellidoDoctor;
		this.cedulaDoctor = cedulaDoctor;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getApellidoPaciente() {
		return apellidoPaciente;
	}

	public void setApellidoPaciente(String apellidoPaciente) {
		this.apellidoPaciente = apellidoPaciente;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public String getNombreDoctor() {
		return nombreDoctor;
	}

	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}

	public String getApellidoDoctor() {
		return apellidoDoctor;
	}

	public void setApellidoDoctor(String apellidoDoctor) {
		this.apellidoDoctor = apellidoDoctor;
	}

	public String getCedulaDoctor() {
		return cedulaDoctor;
	}

	public void setCedulaDoctor(String cedulaDoctor) {
		this.cedulaDoctor = cedulaDoctor;
	}

	@Override
	public String toString() {
		return "CitaRealizada [numero=" + numero + ", valor=" + valor + ", fecha=" + fecha + ", diagnostico="
				+ diagnostico + ", receta=" + receta + ", nombrePaciente=" + nombrePaciente + ", apellidoPaciente="
				+ apellidoPaciente + ", cedulaPaciente=" + cedulaPaciente + ", nombreDoctor=" + nombreDoctor
				+ ", apellidoDoctor=" + apellidoDoctor + ", cedulaDoctor=" + cedulaDoctor + "]";
	}
	
	
	
}
