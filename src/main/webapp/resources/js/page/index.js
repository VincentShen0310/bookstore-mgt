$('.form-signin').submit(function login(){

	var match=false;
	var username=$(":input[name='name']").val(); 
	var password=$(":input[name='password']").val(); 
	
	if (username=="admin"){
		match=true;
	}

	if (match==true){
		location.href="http://localhost:8080/bookstore-mgt/book/list";
	}
	else{
		alert("error");
	}

})
   



