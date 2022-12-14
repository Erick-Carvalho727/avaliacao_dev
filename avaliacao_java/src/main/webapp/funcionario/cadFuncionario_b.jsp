<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="label.titulo.pagina.funcionario"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
	</head>
	<body class="bg-secondary">	
		<div class="container">
				<div class="row mt-5 mb-2">
					<div class="col-sm p-0">
						<s:form action="/filtrarFuncionarios.action">
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
									
									<s:textfield cssClass="form-control" id="nomeF" name="filtrar.valorBusca"/>
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
							<s:iterator value="funcionarios" >
								<tr>
									<td>${rowidFunc}</td>
									<td>${nomeF}</td>
									<td class="text-end">
										<s:url action="deleteFuncionarios" var="excluir">
											<s:param name="funcionarioVo.rowidFunc" value="rowidFunc"></s:param>
										</s:url>
										<s:url action="pegarFuncionarios" var="editarF">
											<s:param name="funcionarioVo.rowidFunc" value="rowidFunc"></s:param>
										</s:url>

										<a href="${editarF}" class="btn btn-warning text-white">
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
									<s:url action="novoFuncionarios" var="novof"/>
									
									<a href="${novof}" class="btn btn-success">
										<s:text name="label.novo.funcionario"/>
									</a>
								</td>
							</tr>
							<tr>
								<td colspan="5">
									<s:url action="todosExames" var="todos"/>
									<a href="${todos}" class="btn btn-success">
										<s:text name="label.exames"/>
									</a>

									<s:url action="todosFuncionarios" var="todosf"/>
									<a href="${todosf}" class="btn btn-success">
										<s:text name="label.funcionario"/>
									</a>

									<s:url action="todosExamesFunc" var="todosExamesFunc"/>
									<a href="${todosExamesFunc}" class="btn btn-success">
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
		
		<div  class="modal fade" id="confirmarExclusao" 
			data-bs-backdrop="static" data-bs-keyboard="false"
			tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title"><s:text name="label.modal.titulo"/></h5>
		        
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      
		      <div class="modal-body">
		      	<span><s:text name="label.modal.corpo"/></span>
		      </div>
		      
		      <div class="modal-footer">
	        	<a class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">
					<s:text name="label.nao"/>
				</a>
	        	
				<s:a id="excluir" class="btn btn-primary" style="width: 75px;">
					<s:text name="label.sim"/>
				</s:a>						
		      </div>
		    </div>		    
		  </div>
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
		<script>function confirmBox() {
			var answer;
			answer = window.confirm("Deseja excluir o funcionario?");
			if (answer == true) {
			   return true;
			} else {
			   return false;
			}
			 }</script>
	</body>
</html>