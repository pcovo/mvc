package br.com.ccee.controller;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ccee.model.FuncionarioModel;
import br.com.ccee.model.beans.FuncionarioBean;

public class FuncionarioController {

	private FuncionarioModel fm = new FuncionarioModel();
	
	public List<FuncionarioBean> calcularSalarioLiquidoDosFuncionarios() throws SQLException {
		// Recupera os funcionários e seus descontos
		List<FuncionarioBean> funcionarios = fm.getFuncionarios();
		for(FuncionarioBean f : funcionarios)  {
			f.setDescontos(fm.getDescontos(f.getIdCliente()));
		}
		
		return funcionarios;
	}
	
	public List<FuncionarioBean> ordenarSalarioLiquidoDosFuncionarios(List<FuncionarioBean> fList) throws SQLException {
		fList = fList.stream().sorted(Comparator.comparing(FuncionarioBean::getVlSalarioLiquido).reversed()).collect(Collectors.toList());
		return fList;
	}
}
