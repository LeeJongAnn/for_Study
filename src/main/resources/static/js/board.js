let index = {


		init: function(){
			$("#btn-save").on("click", ()=>{
				this.save();
			}),
			$("#btn-delete").on("click", ()=>{
                this.deletebyId();
            			}),
            $("#btn-update").on("click", ()=>{
                this.update();
                        			}),
             $("#btn-reply-save").on("click", ()=>{
                this.saveReply();
                                    });
		},

		update: function(){
		    let id = $("#id").val();

			let data = {
                title : $("#title").val(),
                content : $("#content").val(),
			};
			console.log(title);
			console.log(content);

				$.ajax({
            				type: "PUT",
            				url: "/SpringBoard/api/board/detail/" + id,
            				data: JSON.stringify(data),
            				contentType: "application/json; charset=utf-8",
            				dataType: "json"
            			}).done(function(resp){
            				alert("글수정이 완료되었습니다.");
            				location.href = "/SpringBoard/board/view/detail/" + id;
            			}).fail(function(error){
            				alert(JSON.stringify(error));
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
                      				location.href = "/SpringBoard/board/view/1?classify=id&Direction=asc";
                      			}).fail(function(error){
                      				alert(JSON.stringify(error));
                      			});

                      		},

          saveReply: function(){
                  			let data = {
                  			      boardId : $("#boardId").val(),
                                  content : $("#reply-content").val()
                  			}
                            console.log(data);
                  				$.ajax({
                              				type: "POST",
                              				url: `/SpringBoard/api/${data.boardId}/reply`,
                              				data: JSON.stringify(data),
                              				contentType: "application/json; charset=utf-8",
                              				dataType: "json"
                              			}).done(function(resp){
                              				alert("댓글 작성이 완료되었습니다.");
                              				location.href = `/SpringBoard/board/view/detail/${data.boardId}`;
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
                    				location.href = "/SpringBoard/board/view/1?classify=id&Direction=asc";
                    			}).fail(function(error){
                    				alert(JSON.stringify(error));
                    			});

                    		}

			}

index.init()