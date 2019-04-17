package br.com.ccee.model.beans;

import java.math.BigDecimal;
import java.util.List;

public class FuncionarioBean {

	private Integer idCliente;
	private String nomeCliente;
	private BigDecimal vlSalarioBruto;
	
	private List<DescontosBean> descontos;
	private BigDecimal vlSalarioLiquido;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public BigDecimal getVlSalarioBruto() {
		return vlSalarioBruto;
	}
	public void setVlSalarioBruto(BigDecimal vlSalarioBruto) {
		this.vlSalarioBruto = vlSalarioBruto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
		FuncionarioBean other = (FuncionarioBean) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}
	public List<DescontosBean> getDescontos() {
		return descontos;
	}
	public void setDescontos(List<DescontosBean> descontos) {
		this.descontos = descontos;
	}
	public BigDecimal getVlSalarioLiquido() {
		if(this.descontos != null && this.descontos.size() > 0) {
			BigDecimal totalDescontos = descontos.stream().map(d -> d.getDesconto()).reduce(BigDecimal.ZERO, BigDecimal::add);
			return vlSalarioBruto.subtract(totalDescontos);
		}
		return vlSalarioLiquido;
	}
	public void setVlSalarioLiquido(BigDecimal vlSalarioLiquido) {
		this.vlSalarioLiquido = vlSalarioLiquido;
	}
	
}
