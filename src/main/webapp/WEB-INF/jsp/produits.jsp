
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produits</title>
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="/webjars/font-awesome/4.1.0/css/font-awesome.min.css" />
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
  
<style type="text/css">
i {
	position: relative;
	right: -600px;
}
</style>

</head>
<body>

	<div class="container mt-5 utilisateurs">
		<div class="container">
			<tr>
				<td><a href="/produits">Liste des Produits</a></td>
			</tr>
		</div>
		<form method="get" action="produits">
			<label>Name</label> <i class="fa fa-microphone" aria-hidden="true">
			</i> <input type="text" placeholder="Recherche Vokaris" id="speechToText"
				style="width: 600px;" onclick="record()" name="keyword"
				th:value="${keyword}"></input>
			<button class="btn btn-dark">Chercher</button>
		</form>
	</div>
	<script>
		function record() {
			var recognition = new webkitSpeechRecognition();
			recognition.lang = "en-GB";

			recognition.onresult = function(event) {
				// console.log(event);
				document.getElementById('speechToText').value = event.results[0][0].transcript;
			}
			recognition.start();

		}
	</script>


	<div class="container mt-5">
	

		<table  class="text-center table shadow-lg mt-4 table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Categorie</th>
					<th>Marque</th>
					<th>Prix</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${produits}" var="produits">
					<tr>
						<td>${produits._id}</td>
						<td class="text-justify">${produits.nom}</td>
						<td class="text-justify">${produits.categorie}</td>
						<td class="text-justify">${produits.marque}</td>
						<td class="text-justify">${produits.prix}</td>
						<td class="text-justify">${produits.description}</td>
					</tr>
					<tbody>
				</c:forEach>
		</table>
	</div>
	
	<div class="container">
	<nav aria-label="Page navigation example">
  <ul class="pagination">
     
  
   <c:forEach begin="0" end="${currentPage}" var="page">
    <li class="page-item"><a class="page-link" href="/produits?page=${page}&size=${size}">${page+1}</a></li>
   </c:forEach>
  
    		 <c:forEach begin="0" end="${currentPage+1}"  var="page">
    <li ><a  href="/produits?page=${page}&currentPage=${currentPage+1}"></c:forEach>Next</a></li>
  </ul>
</nav></div>
<%-- 
    <c:forEach begin="0" end="${currentPage+1}"  var="page">  
    <li class="page-item"> <a class="page-link" href="/produits?page=${page}&currentPage=${currentPage+1}"></c:forEach>Next</a></li> --%>
  
<%-- <div class="containter" style="text-align:center">
		<div class="panel-footer">

			<ul class="pagination">
				<c:forEach begin="0" end="${totalPages-1}" var="page">
					<li class="btn btn-sm">
					<a href="/produits?page=${page}&size=${size}">${page+1}</a></li>
				</c:forEach>
			</ul>
		</div> --%>

</body>
</html>
