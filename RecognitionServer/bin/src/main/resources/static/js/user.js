$('#btn-join').on('click', join);
$('#btn-block').on('click', blockUser);

function join() {
	let data={
		userid: $('#userid').val(),
		password: $('#password').val(),
		email: $('#email').val()
	};
	if($('#userid').val()=="" || $('#userid').val()==null){
		alert("아이디를 입력해주세요.");
		return false;
	}else if($('#email').val()=="" || $('#email').val()==null){
		alert("이메일을 입력해주세요.");
		return false;
	}else if($('#password').val()=="" || $('#password').val()==null){
		alert("패스워드를 입력해주세요.");
		return false;
	}else{
		$.ajax({
			type: "post",
			url: "/auth/join",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8", 
			dataType: "json" 
		}).done(function(result){
			if(result.data==1 & result.status == 200){
				alert('회원가입이 완료되었습니다.');
				location.href = "/";	
			}else if(result.data==0){
				alert('아이디가 중복됩니다.');
			}else{
				alert('다시 시도해주세요.');
			}	
		}).fail(function(error){
			alert("회원가입에 실패하였습니다.");
			console.log(JSON.stringify(error));
		});
	}		 
}

function blockUser() {
	var userid = $('#userid').val();
	var request = confirm('정말 차단하시겠습니까?');
	let data={
		userid: $('#userid').val(),
		reason: $('#reason').val()
	};
	if(request){
		$.ajax({
			type: "post",
			url: "/api/blockUser",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8", 
			dataType: "json" 
		}).done(function(res){
			if(res.result==1){
				alert('차단이 완료되었습니다.');
				location.href = "/blockUser/"+userid;	
			}else{
				alert('차단에 실패하였습니다.');
			}	
		}).fail(function(error){
			console.log(JSON.stringify(error));
		});
	}else{
		return;
	}		
}		