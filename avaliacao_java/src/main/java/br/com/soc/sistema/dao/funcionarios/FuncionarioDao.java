package br.com.soc.sistema.dao.funcionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

public class FuncionarioDao extends Dao{
	
	public void insertFuncionario(FuncionarioVo funcionarioVo){
		StringBuilder query = new StringBuilder("INSERT INTO funcionario (nm_funcionario) values (?)");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString())){
			
			int i=1;
			ps.setString(i++, funcionarioVo.getNomeF());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFuncionario(FuncionarioVo funcionarioVo){
		StringBuilder query = new StringBuilder("UPDATE funcionario SET nm_funcionario = (?) WHERE rowidFunc = (?)");
		try(
				Connection con = getConexao();
				PreparedStatement  ps = con.prepareStatement(query.toString())){

			int i=1;
			ps.setString(i++, funcionarioVo.getNomeF());
			ps.setString(i++, funcionarioVo.getRowidFunc());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFuncionario(FuncionarioVo funcionarioVo){
		StringBuilder query = new StringBuilder("DELETE FROM funcionario WHERE rowidFunc = (?)");
		try(
				Connection con = getConexao();
				PreparedStatement  ps = con.prepareStatement(query.toString())){

			int i=1;
			ps.setString(i++, funcionarioVo.getRowidFunc());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<FuncionarioVo> findAllFuncionarios(){
		StringBuilder query = new StringBuilder("SELECT rowidFunc id, nm_funcionario nome FROM funcionario");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery()){
			
			FuncionarioVo vo =  null;
			List<FuncionarioVo> funcionarios = new ArrayList<>();
			while (rs.next()) {
				vo = new FuncionarioVo();
				vo.setRowidFunc(rs.getString("id"));
				vo.setNomeF(rs.getString("nome"));
				
				funcionarios.add(vo);
			}
			return funcionarios;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
	
	public List<FuncionarioVo> findAllByNome(String nome){
		StringBuilder query = new StringBuilder("SELECT rowidFunc id, nm_funcionario nome FROM funcionario ")
								.append("WHERE lower(nm_funcionario) like lower(?)");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setString(i, "%"+nome+"%");
			
			try(ResultSet rs = ps.executeQuery()){
				FuncionarioVo vo =  null;
				List<FuncionarioVo> Funcionarios = new ArrayList<>();
				
				while (rs.next()) {
					vo = new FuncionarioVo();
					vo.setRowidFunc(rs.getString("id"));
					vo.setNomeF(rs.getString("nome"));	
					
					Funcionarios.add(vo);
				}
				return Funcionarios;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return Collections.emptyList();
	}
	
	public FuncionarioVo findByCodigo(Integer codigo){
		StringBuilder query = new StringBuilder("SELECT rowidFunc id, nm_funcionario nome FROM funcionario ")
								.append("WHERE rowidFunc = ?");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setInt(i, codigo);
			
			try(ResultSet rs = ps.executeQuery()){
				FuncionarioVo vo =  null;
				
				while (rs.next()) {
					vo = new FuncionarioVo();
					vo.setRowidFunc(rs.getString("id"));
					vo.setNomeF(rs.getString("nome"));	
				}
				return vo;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

}
