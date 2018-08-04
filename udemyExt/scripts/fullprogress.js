function fullprogess(){
  	var elements = document.querySelectorAll('[aria-label="Course Progress"]');
	elements.forEach(function(elem){
		elem.click();
	});
}
fullprogess();