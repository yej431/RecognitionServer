$('.clickUser').on('click', clickUser);
$('.blockUser').on('click', blockUser);

function clickUser() {
	if($(this).children('div').css("display") == "none"){
		$(this).children('div').css('display','block');
	}else{
		$(this).children('div').css('display','none');
	}
}
function blockUser() {
	var userid = $('#userid').val();
	var request = confirm('정말 차단하시겠습니까?');
	
	if(request){
		$.ajax({
			type: "POST",
			url: "/api/blockUser/"+userid,
			dataType: "json"
		}).done(function(res){
			if(res.result==0){
				alert('차단에 실패하였습니다.');
			}else{
				alert('차단이 완료되었습니다.');
				location.href="/userList";
			}	
		}).fail(function(error){
			console.log(JSON.stringify(error));
		});
	}else{
		return;
	}	
}