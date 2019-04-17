package br.com.ccee.model.beans;

import java.math.BigDecimal;

public class DescontosBean {

	private Integer idCliente;
	private Integer idDesconto;
	private BigDecimal desconto;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdDesconto() {
		return idDesconto;
	}
	public void setIdDesconto(Integer idDesconto) {
		this.idDesconto = idDesconto;
	}
	public BigDecimal getDesconto() {
		return desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDesconto == null) ? 0 : idDesconto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DescontosBean other = (DescontosBean) obj;
		if (idDesconto == null) {
			if (other.idDesconto != null)
				return false;
		} else if (!idDesconto.equals(other.idDesconto))
			return false;
		return true;
	}
	
}
