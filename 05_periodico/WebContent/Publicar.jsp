<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Publicar una noticia</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		Materialize.updateTextFields();
		$('select').material_select();
	});
</script>
</head>
<body>
	<div align="center" style="padding: 0 20%">
		<h2>Publica tu noticia</h2>

		<div class="form" align="center">
			<form method="post" action="Publicar">
				<div class="input-field col s6">
					<label>Introduce el email</label> <input placeholder="Email"
						id="email" name="email" type="text" class="validate">

				</div>
				<div class="input-field col s6">
					<label>Introduce el titulo</label> <input placeholder="Titulo"
						id="titulo" name="titulo" type="text" class="validate">
				</div>
				<select multiple name="categoria">
					<option value="" disabled selected>Choose your option</option>
					<option value="1">Deportes</option>
					<option value="2">Option 2</option>
					<option value="3">Option 3</option>
				</select>
				<hr>
				<textarea id="textarea1" name="contenido" class="materialize-textarea" placeholder="Escribe tu noticia"></textarea>
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Publicar <i class="material-icons right">send</i>
				</button>
			</form>
		</div>
	</div>

</body>
</html>