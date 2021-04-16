<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="formCat" >
		<f:form modelAttribute="categorie"  action="saveCat" method="post" enctype="multipart/form-data">
				
			<table id="table1" >
				<tr>
					<td>ID CATEGORIE</td>
					<td><f:input path="idcategorie" /></td>
					<td><f:errors path="idcategorie" cssClass="errors"></f:errors></td>
				</tr>
				<tr>
					<td>NOM CATEGORIE</td>
					<td><f:input path="nomcategorie"/></td>
					<td><f:errors path="nomcategorie" cssClass="errors"></f:errors></td>
				</tr>
				<tr>
					<td>DESCRPTION CAT</td>
					<td><f:textarea path="description"/></td>
					<td><f:errors path="description" cssClass="errors"></f:errors></td>
				</tr>
				<tr>
					<td>PHOTO CAT</td>
					<!--<c:if test="${categorie.idcategorie!=null}">
				    <td><image src="CatPhoto?idCat=${categorie.idcategorie}"/></td>
					</c:if>		-->	
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Valider" /></td>
					<!--td><a href="editCategValide"><input type="button" value="Editer" /></a></td-->
				</tr>
			</table>
		</f:form>
	</div>
	<div id=""  >
	<table >
		<tr>
			<th>ID</th><th>NOM CAT</th><th>DESCRIPTION</th><th>PHOTO</th><th colspan="2">GESTION</th>
		</tr>
			<c:forEach items="${categories}" var="categorie"> 
				<tr>
				 <td>${categorie.idcategorie}</td>
				 <td>${categorie.nomcategorie}</td>
				 <td>${categorie.description}</td>		
				 <td><image src="CatPhoto?idCat=${categorie.idcategorie}"/></td>		
				</tr>
		</c:forEach>
	</table>
	
	</div>