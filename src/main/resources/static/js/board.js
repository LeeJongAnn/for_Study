let index = {


		init: function(){
			$("#btn-save").on("click", ()=>{
				this.save();
			}),
			$("#btn-delete").on("click", ()=>{
            				this.deletebyId();
            			});
		},

		save: function(){
			let data = {
                title : $("#title").val(),
                content : $("#content").val(),
			}

				$.ajax({
            				type: "POST",
            				url: "/SpringBoard/api/board",
            				data: JSON.stringify(data),
            				contentType: "application/json; charset=utf-8",
            				dataType: "json"
            			}).done(function(resp){
            				alert("글쓰기가 완료되었습니다.");
            				location.href = "/SpringBoard/board/view/1";
            			}).fail(function(error){
            				alert(JSON.stringify(error));
            			});

            		},

        deletebyId: function(){
                var id = $("#id").text();
        				$.ajax({
                    				type: "DELETE",
                    				url: "/SpringBoard/api/board/"+id,
                    				dataType: "json"
                    			}).done(function(resp){
                    				alert("삭제가 완료되었습니다.");
                    				location.href = "/SpringBoard/board/view/1";
                    			}).fail(function(error){
                    				alert(JSON.stringify(error));
                    			});

                    		},

			}

index.init()