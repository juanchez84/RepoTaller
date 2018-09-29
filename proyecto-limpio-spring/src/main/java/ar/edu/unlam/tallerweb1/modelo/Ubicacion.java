package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ubicacion {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Double latitud;
private Double longitud;


public Double getLatitud() {
	return latitud;
}
public void setLatitud(Double latitud) {
	this.latitud = latitud;
}
public Double getLongitud() {
	return longitud;
}
public void setLongitud(Double longitud) {
	this.longitud = longitud;
}




}
