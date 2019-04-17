package br.com.ccee.model.dao.implementacoes.mock;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ccee.model.beans.DescontosBean;
import br.com.ccee.model.beans.FuncionarioBean;
import br.com.ccee.model.dao.interfaces.Consultas;

public class ConsultasMock implements Consultas {

	@Override
	public List<FuncionarioBean> getFuncionarios() throws SQLException {
		List<FuncionarioBean> funcionarios = new ArrayList<FuncionarioBean>();
		for(int i = 0 ; i < 5 ; i++) {
			FuncionarioBean f = new FuncionarioBean();
			f.setIdCliente(i);
			f.setNomeCliente("Funcionario "+i);
			f.setVlSalarioBruto(generateRandomBigDecimalFromRangeToSalary());
			funcionarios.add(f);
		}
		return funcionarios;
	}

	@Override
	public List<DescontosBean> getDescontos(Integer idFuncionario) throws SQLException {
		List<DescontosBean> descontos = new ArrayList<DescontosBean>();
		for(int i = 0 ; i < 3 ; i++) {
			DescontosBean d = new DescontosBean();
			d.setIdCliente(idFuncionario);
			d.setIdDesconto(i);
			d.setDesconto(generateRandomBigDecimalFromRangeToTax());
			descontos.add(d);
		}
		return descontos;
	}
	
	public static BigDecimal generateRandomBigDecimalFromRangeToSalary() {
		BigDecimal min = new BigDecimal(10000);
		BigDecimal max = new BigDecimal(100000);
	    BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
	    return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal generateRandomBigDecimalFromRangeToTax() {
		BigDecimal min = new BigDecimal(100);
		BigDecimal max = new BigDecimal(2000);
	    BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
	    return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
}
