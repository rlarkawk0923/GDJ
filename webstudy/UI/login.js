// 비밀번호 입력 없이 Sign Im 버튼 누르면
// 경고창 띄우기 (비밀번호를 입력하세요.)

document.getElementById('btn_signin').onclick = function(event){
    var pw = document.getElementById('pw');
    if(pw.value == ''){
        alert('비밀번호를 입력하세요.');
        event.preventDefault(); // 기본동작 막기
        return;
    }
}
document.getElementById('id').onkeyup = function(event){
    var id = document.getElementById('id');
    var id_msg = document.getElementById('id_msg');
    if(id.value.length == 0){
        id_msg.textContent = '';
    } else if(id.value.length < 4) {
        id_msg.textContent = '아이디는 4자 이상입니다.';
    } else if(id.value.length >= 4) {
        id_msg.textContent = '정상적인 아이디입니다.';
    }
}