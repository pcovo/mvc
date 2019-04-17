package br.com.ccee.view;

import java.sql.SQLException;
import java.util.List;

import br.com.ccee.controller.FuncionarioController;
import br.com.ccee.model.beans.FuncionarioBean;

public class FuncionarioView {

	public void apresentarRelacaoFuncionariosPorSalarioLiquidoDesc() throws SQLException {
		FuncionarioController fc = new FuncionarioController();
		List<FuncionarioBean> lf = fc.ordenarSalarioLiquidoDosFuncionarios(fc.calcularSalarioLiquidoDosFuncionarios());
		for(FuncionarioBean f : lf) {
			System.out.println("Funcionario "+f.getNomeCliente()+", salario liquido: "+f.getVlSalarioLiquido());
		}
	}
}
