package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ciudad {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private Pais pais;
	
	@OneToOne(cascade = { CascadeType.ALL })
	private Ubicacion ubicacionGeografica;
	
	
	public Ciudad() {
		
	}
	
	public Ciudad(String nombre, Pais pais, Ubicacion ubicacionGeografica) {
		this.nombre = nombre;
		this.pais = pais;
		this.ubicacionGeografica = ubicacionGeografica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Ubicacion getUbicacion() {
		return ubicacionGeografica;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacionGeografica = ubicacion;
	}
	
	

	
	
}
