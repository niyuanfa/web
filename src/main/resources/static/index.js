function login() {
    var userName = document.getElementById('userName').value
    var password = document.getElementById('password').value
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/finduser',
        data: {
            username:userName,
        },
        complete: function (xhr, status) {
            if (status == 'success') {
                console.log(xhr.responseText)
                var res=JSON.parse(xhr.responseText)
                if(password==res[0].password){
                    alert("登录成功")
                }
                else{
                    console.log(xhr.responseText[0].password)
                    alert("登录失败")
                }
             } else if (status == 'error') {
                alert(error(e))
            }
        }
    });

}
function logout() {
    var username = document.getElementById('userName').value
    var password = document.getElementById('password').value
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/saveUser',
        data: {
            'username': username,
            'password': password,
        },
        complete: function (xhr, status) {
            if (status == 'success') {
                alert("注册成功")
            } else if (status == 'error') {
                alert(JSON.parse(xhr.responseText).message)
            }
        }
    });
}
function forget() {
    var userName = document.getElementById('userName').value
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/finduser',
        data: {username:userName},
        complete: function (xhr, status) {
            if (status == 'success') {
                var res=JSON.parse(xhr.responseText)
                alert("该用户密码为"+res[0].password)
            } else if (status == 'error') {

            }
        }
    });
}
function every() {
    var userName = document.getElementById('userName').value
    var password = document.getElementById('password').value
    $.ajax({
        type: 'GET',
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