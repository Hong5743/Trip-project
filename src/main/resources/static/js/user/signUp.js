$(document).ready(function () {

    $('#submit-signup').click(function (e) {
        e.preventDefault(); // 기본 폼 제출 동작을 막습니다.
        //빈칸 오류를 위한 변수 선언
        let userId = $("#user_id").val();
        let userPasswd = $("#user_passwd").val();
        let userName = $("#user_name").val();
        let userNickname = $("#user_nickname").val();
        let userEmail = $("#user_email").val();
        let userTell = $("#user_tell").val();
        let userBirth = $("#user_birth").val();

        //모든 오류 메시지 초기화
        $('#textError1').text('');
        $('#textError2').text('');
        $('#textError3').text('');
        $('#textError4').text('');
        $('#textError5').text('');
        $('#textError6').text('');
        $('#textError7').text('');
        //필드 검증
        let check = false;
        if (!userId) {
            $('#textError1').text('아이디를 입력해 주세요.').css('color', 'red');
            check = true;
        } else {
            $('#textError1').text('');
        }
        if (!userPasswd) {
            $('#textError2').text('비밀번호를 입력해 주세요.').css('color', 'red');
            check = true;
        } else {
            $('#textError2').text('');
        }
        if (!userName) {
            $('#textError3').text('이름을 입력해 주세요.').css('color', 'red');
            check = true;
        } else {
            $('#textError3').text('');
        }
        if (!userNickname) {
            $('#textError4').text('닉네임을 입력해 주세요.').css('color', 'red');
            check = true;
        } else {
            $('#textError4').text('');
        }
        if (!userEmail) {
            $('#textError5').text('이메일을 입력해 주세요.').css('color', 'red');
            check = true;
        } else {
            $('#textError5').text('');
        }
        if (!userTell) {
            $('#textError6').text('전화번호를 입력해 주세요.').css('color', 'red');
            check = true;
        } else {
            $('#textError6').text('');
        }
        if (!userBirth) {
            $('#textError7').text('생년월일을 입력해 주세요.').css('color', 'red');
            check = true;
        } else {
            $('#textError7').text('');
        }

        if (!check) {
            // 폼 데이터를 가져옵니다.
            // alert('user의 save함수 호출됨');
            let data = {
                memberId: userId,
                memberPasswd: userPasswd,
                memberName: userName,
                memberNickname: userNickname,
                memberEmail: userEmail,
                memberTell: userTell,
                memberBirth: userBirth
            };
            console.log(data);
            // 확인 대화 상자 표시
            let confirmResult = confirm('회원가입 하시겠습니까?');

            if (confirmResult) {
                // 사용자가 확인을 누른 경우에만 Ajax 요청을 보냅니다.
                $.ajax({
                    type: 'POST',
                    url: '/api/signUp', // 수정 처리를 수행하는 컨트롤러의 URL을 적어야 합니다.
                    data: JSON.stringify(data),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json"
                }).done(function (resp) {
                    // 결과가 정상이면 done 실행
                    alert("회원가입이 완료되었습니다.");
                    location.href = "/login";
                }).fail(function (error) {
                    // 실패하면 fail 실행
                    alert("회원가입이 실패하였습니다.");
                });
            }

        }
    });
});
