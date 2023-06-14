jQuery(function() {
	if(jQuery("#formulario").length){
		jQuery("#formulario").validate({
			rules: {
				nome: {
					required: true,
					minlength: 2
				},
				fone: {
					required:true,
					number:true
				},
				email: {
					required: true,
					minlength: 4,
					email: true
				}
			},
			messages: {
				nome: {
					required: "O nome é obrigatório",
					minlength: "Seu nome deve ter ao menos dois caracteres"
				},
				fone:{
					required:"O número é obrigatório",
					number:"Somente números,por favor"
				},
				email: {
					minlength: "Digite ao menos quatro caracteres",
					email: "O email deve obedecer à formatação-padrão (Exemplo: Abcd@gmail.com)",
					required: "O e-mail é obrigatório"
				}
			}
		});
	}
	else{
		function validar() {
			document.forms["frmContato"].submit();
		}
	}
});

jQuery(function(){
	jQuery("a.excluir").click(function(){
		alert("Confirma a exclusão deste contato?")
	})
})