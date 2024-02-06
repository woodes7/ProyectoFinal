package Proyecto_Final.Periodico.dtos;

import java.util.Calendar;
import java.util.Objects;


public class UsuarioDto {
	//Atributos
	private long id;
	private String nombreUsuario;
	private String apellidosUsuario;
	private String dniUsuario;
	private String tlfUsuario;
	private String emailUsuario;
	private String claveUsuario;
	private String rol;
	private String token;
	private String password;
	private String password2;
	private Calendar expiracionToken;
	
		//Constructor
	public UsuarioDto(long id, String nombreUsuario, String apellidosUsuario, String dniUsuario, String tlfUsuario,
			String emailUsuario, String claveUsuario, String rol) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.dniUsuario = dniUsuario;
		this.tlfUsuario = tlfUsuario;
		this.emailUsuario = emailUsuario;
		this.claveUsuario = claveUsuario;
		this.rol= rol;
	}
	
	public UsuarioDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidosUsuario() {
		return apellidosUsuario;
	}
	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}
	
	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	
	public String getTlfUsuario() {
		return tlfUsuario;
	}
	public void setTlfUsuario(String tlfUsuario) {
		this.tlfUsuario = tlfUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getClaveUsuario() {
		return claveUsuario;
	}
	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public Calendar getExpiracionToken() {
		return expiracionToken;
	}
	public void setExpiracionToken(Calendar expiracionToken) {
		this.expiracionToken = expiracionToken;
	}	
	

	@Override
	public int hashCode() {
		return Objects.hash(apellidosUsuario, claveUsuario, dniUsuario, emailUsuario, expiracionToken, id,
				nombreUsuario, password, password2, rol, tlfUsuario, token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDto other = (UsuarioDto) obj;
		return Objects.equals(apellidosUsuario, other.apellidosUsuario)
				&& Objects.equals(claveUsuario, other.claveUsuario) && Objects.equals(dniUsuario, other.dniUsuario)
				&& Objects.equals(emailUsuario, other.emailUsuario)
				&& Objects.equals(expiracionToken, other.expiracionToken) && id == other.id
				&& Objects.equals(nombreUsuario, other.nombreUsuario) && Objects.equals(password, other.password)
				&& Objects.equals(password2, other.password2) && Objects.equals(rol, other.rol)
				&& Objects.equals(tlfUsuario, other.tlfUsuario) && Objects.equals(token, other.token);
	}

	@Override
	public String toString() {
		return "UsuarioDto [nombreUsuario=" + nombreUsuario + ", apellidosUsuario=" + apellidosUsuario + ", dniUsuario="
				+ dniUsuario + ", tlfUsuario=" + tlfUsuario + ", emailUsuario=" + emailUsuario + ", claveUsuario="
				+ claveUsuario + ", token=" + token + ", password=" + password + ", password2=" + password2
				+ ", expiracionToken=" + expiracionToken + "]";
	}
    
}
