package br.com.ccee.model.dao.implementacoes.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ccee.model.beans.DescontosBean;
import br.com.ccee.model.beans.FuncionarioBean;
import br.com.ccee.model.dao.Conexao;
import br.com.ccee.model.dao.interfaces.Consultas;

public class ConsultasOracle implements Consultas {

	private static Connection con = null;

	@Override
	public List<FuncionarioBean> getFuncionarios() throws SQLException {
		List<FuncionarioBean> funcionarios = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			stmt = con.createStatement();  
			rs = stmt.executeQuery("select id_cliente, nm_cliente, vl_salario_bruto from Funcionario");
			funcionarios = new ArrayList<FuncionarioBean>();
			while(rs.next()) {
				try {
					FuncionarioBean f = new FuncionarioBean();
					f.setIdCliente(rs.getInt(1));
					f.setNomeCliente(rs.getString(2));
					f.setVlSalarioBruto(rs.getBigDecimal(3));
					funcionarios.add(f);
				}catch(Exception e) {
					System.out.println("erro ao recuperar um funcionario do banco");
				}
			}
		}catch(SQLException e) {
			throw e;
		} finally {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			if(rs != null && !rs.isClosed())
				rs.close();	
			if(con != null && !con.isClosed())
				con.close();
		}
		return funcionarios;
	}

	@Override
	public List<DescontosBean> getDescontos(Integer idFuncionario) throws SQLException {
		List<DescontosBean> descontos = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("select id_desconto, vl_desconto from Descontos where id_cliente = ? ");  
			stmt.setInt(1, idFuncionario);
			rs = stmt.executeQuery();
			descontos = new ArrayList<DescontosBean>();
			while(rs.next()) {
				try {
					DescontosBean d = new DescontosBean();
					d.setIdCliente(idFuncionario);
					d.setIdDesconto(rs.getInt(1));
					d.setDesconto(rs.getBigDecimal(2));
					descontos.add(d);
				}catch(Exception e) {
					System.out.println("erro ao recuperar dados de Descontos do Funcionario de id "+idFuncionario);
				}
			}
		}catch(SQLException e) {
			throw e;
		} finally {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			if(rs != null && !rs.isClosed())
				rs.close();	
			if(con != null && !con.isClosed()) {
				con.close();
			}
		}
		return descontos;
	}
}
