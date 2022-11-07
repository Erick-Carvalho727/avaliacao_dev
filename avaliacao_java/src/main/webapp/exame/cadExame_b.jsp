<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="label.titulo.pagina.consulta"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
	</head>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	<script>function confirmBox() {
		var answer;
		answer = window.confirm("Deseja excluir o exame?");
		if (answer == true) {
		   return true;
		} else {
		   return false;
		}
	 	}</script>

	<body class="bg-secondary">	
		<div class="container">
			<div class="row mt-5 mb-2">
				<div class="col-sm p-0">
					<s:form action="/filtrarExames.action">
						<div class="input-group">
							<span class="input-group-text">
								<strong><s:text name="label.buscar.por"/></strong>
							</span>	
								<s:select  
									cssClass="form-select" 
									name="filtrar.opcoesCombo" 
									list="listaOpcoesCombo"  
									headerKey=""  
									headerValue="Escolha..." 
									listKey="%{codigo}" 
									listValueKey="%{descricao}"
									value="filtrar.opcoesCombo.codigo"									
								/>
								
								<s:textfield cssClass="form-control" id="nome" name="filtrar.valorBusca"/>
								<button class="btn btn-primary" type="submit"><s:text name="label.pesquisar"/></button>
						</div>
					</s:form>			
				</div>				
			</div>

			<div class="row">
				<table class="table table-light table-striped align-middle">
					<thead>
						<tr>
							<th><s:text name="label.id"/></th>
							<th><s:text name="label.nome"/></th>
							<th class="text-end mt-5"><s:text name="label.opcoes"/></th>
						</tr>
					</thead>
					
					<tbody>
						<s:iterator value="exames">
							<tr>
								<td>${rowid}</td>
								<td>${nome}</td>
								<td class="text-end">
									<s:url action="deleteExames" var="excluir">
										<s:param name="exameVo.rowid" value="rowid"></s:param>
									</s:url>
									<s:url action="pegarExames" var="editar">
										<s:param name="exameVo.rowid" value="rowid"></s:param>
									</s:url>

									<a href="${editar}" class="btn btn-warning text-white">
										<s:text name="label.editar"/>
									</a>

									<a href="${excluir}" onclick = "return confirmBox();" class="btn btn-danger"><s:text name="label.excluir"/></a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
					
					<tfoot class="table-secondary">
						<tr>
							<td colspan="5">
								<s:url action="novoExames" var="novo"/>
								
								<a href="${novo}" class="btn btn-success">
									<s:text name="label.novo.exames"/>
								</a>
							</td>
						</tr>
						<tr>
							<td colspan="5">
								<s:url action="todosExames" var="todos"/>
								<a href="${todos}" class="btn btn-success">
									<s:text name="label.exames"/>
								</a>

								<s:url action="todosFuncionarios" var="todosF"/>
								<a href="${todosF}" class="btn btn-success">
										<s:text name="label.funcionario"/>
								</a>

								<s:url action="todosExamesFunc" var="todosExamesF"/>
								<a href="${todosExamesF}" class="btn btn-success">
									<s:text name="label.exames.func"/>
									
								</a>
							</td>
						</tr>
					</tfoot>				
				</table>
			</div>

			<div class="row">

			</div>
		</div>
	</body>
</html>