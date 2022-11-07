package br.com.soc.sistema.dao.examesFunc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.ExameFuncVo;
import br.com.soc.sistema.vo.ExameVo;

public class ExameFuncDao extends Dao{

    public List<ExameFuncVo> findAllExamesFunc(){
        StringBuilder query = new StringBuilder("SELECT  rowidExameFunc id, data_exame data, nm_funcionario nmFunc, nm_exame nmExame ")
                                        .append("FROM exameFuncionario ")
                                        .append("INNER JOIN exame ON exameFuncionario.rowid = exame.rowid ")
                                        .append("INNER JOIN funcionario ON exameFuncionario.rowidFunc = funcionario.rowidFunc");

        try(
                Connection con = getConexao();
                PreparedStatement  ps = con.prepareStatement(query.toString());
                ResultSet rs = ps.executeQuery()){

            ExameFuncVo vo =  null;
            List<ExameFuncVo> examesFuncionario = new ArrayList<>();
            while (rs.next()) {
                vo = new ExameFuncVo();
                vo.setRowidExameFunc(rs.getString("id"));
                vo.setDataExame(rs.getString("data"));
                vo.setNomeFunc(rs.getString("nmFunc"));
                vo.setNomeExame(rs.getString("nmExame"));

                examesFuncionario.add(vo);
            }
            return examesFuncionario;
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public void updateExameFunc(ExameFuncVo exameFuncVo){
        StringBuilder query = new StringBuilder("UPDATE exameFuncionario (rowid, rowidFunc, data_exame) VALUES (?, ?, ?) WHERE rowidExameFunc = (?)");
        try(
                Connection con = getConexao();
                PreparedStatement  ps = con.prepareStatement(query.toString())){

            int i=1;
            ps.setString(i++, exameFuncVo.getRowid());
            ps.setString(i++, exameFuncVo.getRowidFunc());
            ps.setString(i++, exameFuncVo.getDataExame());
            ps.setString(i++, exameFuncVo.getRowidExameFunc());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteExameFunc(ExameFuncVo exameFuncVo){
        StringBuilder query = new StringBuilder("DELETE FROM exameFuncionario WHERE rowidExameFunc = (?)");
        try(
                Connection con = getConexao();
                PreparedStatement  ps = con.prepareStatement(query.toString())){

            int i=1;
            ps.setString(i++, exameFuncVo.getRowidExameFunc());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertExameFunc(ExameFuncVo exameFuncVo){
        StringBuilder query = new StringBuilder("INSERT INTO exameFuncionario (rowid, rowidFunc, data_exame) VALUES (?, ?, ?)");
        try(
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())){

            int i=1;
            ps.setString(i++, exameFuncVo.getRowid());
            ps.setString(i++, exameFuncVo.getRowidFunc());
            ps.setString(i++, exameFuncVo.getDataExame());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ExameFuncVo findByCodigo(Integer codigo){
        StringBuilder query = new StringBuilder("SELECT rowidExameFunc id, rowid idE, rowidFunc idF, data_exame data FROM exameFuncionario ")
                                    .append("WHERE rowidExameFunc = (?)");

        try(Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query.toString())){
            int i = 1;

            ps.setInt(i, codigo);

            try(ResultSet rs = ps.executeQuery()){
                ExameFuncVo vo =  null;

                while (rs.next()) {
                    vo = new ExameFuncVo();
                    vo.setRowidExameFunc(rs.getString("id"));
                    vo.setRowid(rs.getString("idE"));
                    vo.setRowidFunc(rs.getString("idF"));
                    vo.setDataExame(rs.getString("data"));
                }
                return vo;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExameFuncVo findByCodigoRelatorio(Integer codigo){
        StringBuilder query = new StringBuilder("SELECT  rowidExameFunc id, data_exame data, nm_funcionario nmFunc, nm_exame nmExame, exame.rowid idE, funcionario.rowidFunc idF ")
                                        .append("FROM exameFuncionario ")
                                        .append("INNER JOIN exame ON exameFuncionario.rowid = exame.rowid ")
                                        .append("INNER JOIN funcionario ON exameFuncionario.rowidFunc = funcionario.rowidFunc ")
                                        .append("WHERE rowidExameFunc = (?)");
        try(Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query.toString())){
            int i = 1;

            ps.setInt(i, codigo);

            try(ResultSet rs = ps.executeQuery()){
                ExameFuncVo vo =  null;

                while (rs.next()) {
                    vo = new ExameFuncVo();
                    vo.setRowidExameFunc(rs.getString("id"));
                    vo.setRowid(rs.getString("idE"));
                    vo.setRowidFunc(rs.getString("idF"));
                    vo.setDataExame(rs.getString("data"));
                    vo.setNomeExame(rs.getString("nmExame"));
                    vo.setNomeFunc(rs.getString("nmFunc"));
                }
                return vo;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ExameFuncVo> findAllByNomeFunc(String nome){
        StringBuilder query = new StringBuilder("SELECT  rowidExameFunc id, data_exame data, nm_funcionario nmFunc, nm_exame nmExame ")
                .append("FROM exameFuncionario ")
                .append("INNER JOIN exame ON exameFuncionario.rowid = exame.rowid ")
                .append("INNER JOIN funcionario ON exameFuncionario.rowidFunc = funcionario.rowidFunc ")
                .append("WHERE lower(nm_funcionario) like lower(?)");


        try(Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query.toString())){
            int i = 1;

            ps.setString(i, "%"+nome+"%");

            try(ResultSet rs = ps.executeQuery()){
                ExameFuncVo vo =  null;
                List<ExameFuncVo> ExameFunc = new ArrayList<>();

                while (rs.next()) {
                    vo = new ExameFuncVo();
                    vo.setRowidExameFunc(rs.getString("id"));
                    vo.setDataExame(rs.getString("data"));
                    vo.setNomeFunc(rs.getString("nmFunc"));
                    vo.setNomeExame(rs.getString("nmExame"));

                    ExameFunc.add(vo);
                }
                return ExameFunc;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<ExameFuncVo> findAllByNomeExame(String nome){
        StringBuilder query = new StringBuilder("SELECT  rowidExameFunc id, data_exame data, nm_funcionario nmFunc, nm_exame nmExame ")
                .append("FROM exameFuncionario ")
                .append("INNER JOIN exame ON exameFuncionario.rowid = exame.rowid ")
                .append("INNER JOIN funcionario ON exameFuncionario.rowidFunc = funcionario.rowidFunc ")
                .append("WHERE lower(nm_exame) like lower(?)");


        try(Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query.toString())){
            int i = 1;

            ps.setString(i, "%"+nome+"%");

            try(ResultSet rs = ps.executeQuery()){
                ExameFuncVo vo =  null;
                List<ExameFuncVo> ExameFunc = new ArrayList<>();

                while (rs.next()) {
                    vo = new ExameFuncVo();
                    vo.setRowidExameFunc(rs.getString("id"));
                    vo.setDataExame(rs.getString("data"));
                    vo.setNomeFunc(rs.getString("nmFunc"));
                    vo.setNomeExame(rs.getString("nmExame"));

                    ExameFunc.add(vo);
                }
                return ExameFunc;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
