function subRegister() {
    const username = $('#username').val().trim();
    const password = $('#password').val().trim();
    const repassword = $('#repassword').val().trim();
    const wxname = $('#wxname').val().trim();
    const email = $('#email').val().trim();
    const reg = /^([a-zA-Z0-9]+[_\-.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_\-.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;

    if (username === "" || username.length < 5) {
        alert("用户名不得为空且不能少于五位英文加数字");
    } else if (password == null || password.length < 5) {
        alert("密码不得为空且不能少于五位英文加数字");
    } else if (password !== repassword) {
        alert("两次密码不一致");
    } else if (wxname === "" || wxname.length > 20) {
        alert("姓名不得为空且不能大于十位中文或英文");
    } else if (email === "" || !reg.test(email)) {
        alert("邮箱格式不正确")
    } else {
        $("#registerForm").submit();
    }
}