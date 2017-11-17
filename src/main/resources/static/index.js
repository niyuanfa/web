function login() {
    var userName = document.getElementById('userName').value
    var password = document.getElementById('password').value
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/finduser',
        data: {userName:JSON.stringify(userName)},
        complete: function (xhr, status) {
            if (status == 'success') {
                 password="\""+password+"\""
                console.log(password)
                if(password== xhr.responseText){
                    alert("登录成功")
                }
                else{
                    alert("登录失败")
                }
            } else if (status == 'error') {
                alert(error(e))
            }
        }
    });

}
function logout() {
    var userName = document.getElementById('userName').value
    var password = document.getElementById('password').value
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/saveUser',
        data: {
            'userName': JSON.stringify(userName),
            'password': JSON.stringify(password),
        },
        complete: function (xhr, status) {
            if (status == 'success') {
                alert("注册成功")
            } else if (status == 'error') {

            }
        }
    });

}
function forget() {
    var userName = document.getElementById('userName').value
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/finduser',
        data: {userName:JSON.stringify(userName)},
        complete: function (xhr, status) {
            if (status == 'success') {
                alert("该用户密码为"+xhr.responseText)
            } else if (status == 'error') {

            }
        }
    });
}
function all() {
    var userName = document.getElementById('userName').value
    var password = document.getElementById('password').value
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/all',
        data: { },
        complete: function (xhr, status) {
            if (status == 'success') {
               console.log(xhr.responseText)
            } else if (status == 'error') {
              console.log(err)
            }
        }
    });
}