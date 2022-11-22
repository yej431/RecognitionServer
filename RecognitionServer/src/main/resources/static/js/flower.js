let index={
	init: function(){
		$('#btn-delete').on("click", ()=>{
			this.delete();
		});
	},
	
	delete: function(){
		var id=$("#id").val();
		$.ajax({
			type: "DELETE",
			url: "/api/flowerListDel/"+id,
			dataType: "json"
		}).done(function(resp){
			console.log(resp);
			alert("삭제가 완료되었습니다.");	
			location.href="/flowerList";		
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
}

index.init();