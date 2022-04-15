let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!!
				this.save();
			});
		},

		save: function(){
//			alert('user의 save함수 호출됨');
			let data = {
                username : $("#username").val(),
                password : $("#password").val(),
                email : $("#email").val()
			}
			console.log(data)
			}
}

index.init()