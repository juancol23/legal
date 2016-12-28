app.controller("libreriaController", function($scope,libros){
	$scope.articulos = libros.librosFactoria;
})
