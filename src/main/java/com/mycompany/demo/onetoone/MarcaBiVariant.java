package com.mycompany.demo.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MarcaBiVariant {

	@Id
	@GeneratedValue
	private Long id;
	private Integer anoFundacion;
	private String fundador;
	private String paisOrigen;
	@OneToOne(cascade=CascadeType.ALL)
	private DetalleMarcaBiVariant detalleMarcaBiVariant;

	public MarcaBiVariant() {
	}

	public MarcaBiVariant(Integer anoFundacion, String fundador,
			String paisOrigen) {
		super();
		this.anoFundacion = anoFundacion;
		this.fundador = fundador;
		this.paisOrigen = paisOrigen;
	}

	public MarcaBiVariant(Integer anoFundacion, String fundador,
			String paisOrigen, DetalleMarcaBiVariant detalleMarcaBiVariant) {
		super();
		this.anoFundacion = anoFundacion;
		this.fundador = fundador;
		this.paisOrigen = paisOrigen;
		this.detalleMarcaBiVariant = detalleMarcaBiVariant;

	}

	public MarcaBiVariant(Long id, Integer anoFundacion, String fundador,
			String paisOrigen, DetalleMarcaBiVariant detalleMarcaBiVariant) {
		super();
		this.id = id;
		this.anoFundacion = anoFundacion;
		this.fundador = fundador;
		this.paisOrigen = paisOrigen;
		this.detalleMarcaBiVariant = detalleMarcaBiVariant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DetalleMarcaBiVariant getDetalleMarcaBiVariant() {
		return detalleMarcaBiVariant;
	}

	public void setDetalleMarcaBiVariant(
			DetalleMarcaBiVariant detalleMarcaBiVariant) {
		this.detalleMarcaBiVariant = detalleMarcaBiVariant;
	}

	public Integer getAnoFundacion() {
		return anoFundacion;
	}

	public void setAnoFundacion(Integer anoFundacion) {
		this.anoFundacion = anoFundacion;
	}

	public String getFundador() {
		return fundador;
	}

	public void setFundador(String fundador) {
		this.fundador = fundador;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MarcaBiVariant))
			return false;
		MarcaBiVariant other = (MarcaBiVariant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + "]";
	}

}
