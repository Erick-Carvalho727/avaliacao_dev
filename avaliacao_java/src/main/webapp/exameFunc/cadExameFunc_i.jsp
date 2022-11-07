<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="label.titulo.pagina.novoexafunc"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
	</head>
	<body class="bg-secondary">

		<div class="container">
			<s:form action="/novoExamesFunc.action">

				<div class="card mt-5">
					<div class="card-header">
						<div class="row">
							<div class="col-sm-5 ">
								<s:url action="todosExamesFunc" var="todosExamesF"/>
								<a href="${todosExamesF}" class="btn btn-success" >EXAMES REALIZADOS PELOS FUNCIONARIOS</a>
							</div>
							
							<div class="col-sm pt-2">
								<h5 class="card-title">SETAR EXAME PARA UM FUNCIONARIO</h5>
							</div>
						</div>
					</div>
					
					<div class="card-body ">
						<div class="row align-items-center mb-2">
							<label for="id" class="col-sm-2 col-form-label text-center">
								Codigo:
							</label>
							<div class="col-sm-2">
								<s:textfield cssClass="form-control" id="idExameF" name="exameFuncVo.rowidExameFunc" readonly="true"/>						
							</div>	
						</div>

						<div class="row align-items-center mb-2">
							<label for="id" class="col-sm-2 col-form-label text-center">
								Codigo do funcionario:
							</label>
							<div class="col-sm-2">
								<s:textfield cssClass="form-control" id="idFunc" name="exameFuncVo.rowidFunc"/>			
							</div>	
						</div>
						
						<div class="row align-items-center mb-2">
							<label for="nome" class="col-sm-2 col-form-label text-center">
								Codigo do exame:
							</label>	
							<div class="col-sm-2">
								<s:textfield cssClass="form-control" id="idExame" name="exameFuncVo.rowid"/>							
							</div>	
						</div>

						<div class="row align-items-center ">
							<label for="nome" class="col-sm-2 col-form-label text-center">
								Data:
							</label>	
							<div class="col-sm-2">
								<s:textfield cssClass="form-control" type="date" id="idData" name="exameFuncVo.dataExame"/>							
							</div>	
						</div>
					</div>
					<td>
						<div class="card-footer">
							<div class="form-row">
								<button class="btn btn-primary col-sm-4 offset-sm-1">Salvar</button>
								<button type="reset" class="btn btn-secondary col-sm-4 offset-sm-2">Limpar Formulario</button>
							</div>
						</div>
					</td>
				</div>
			</s:form>			
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>