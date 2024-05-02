<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>

<c:import url="/WEB-INF/fragment/navbar.jsp"></c:import>

<%--div.container>div.row.justify-content-center>div.col-6--%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">
            <%--h3.mb-4{회원 정보 수정}--%>
            <h3 class="mb-4">회원 정보 수정</h3>
            <form action="/member/modify" method="post" onsubmit="return confirm('수정하시겠습니까?')">
                <input type="hidden" name="id" value="${member.id}">
                <%--div.mb-3*2>label.form-label+input.form-control[name][value]--%>
                <div class="mb-3">
                    <label for="inputEmail" class="form-label">계정</label>
                    <input style="background-color: lightsalmon" id="inputEmail" type="email" class="form-control"
                           name="email" value="${member.email}"
                           readonly>
                </div>
                <div class="mb-3">
                    <label for="inputPassword" class="form-label">비밀번호</label>
                    <input oninput="passwordCheck()" id="inputPassword" type="password" class="form-control"
                           name="password"
                           value="${member.password}">
                </div>
                <div class="mb-3">
                    <label for="inputPasswordCheck" class="form-label">비밀번호 확인</label>
                    <input oninput="passwordCheck()" id="inputPasswordCheck" type="password" class="form-control"
                           value="${member.password}">

                    <div class="form-text" id="passwordMessage"></div>

                </div>
                <div class="mb-3">
                    <label for="inputNickname" class="form-label">닉네임</label>
                    <input id="inputNickname" type="text" class="form-control" name="nickname"
                           value="${member.nickname}">
                </div>
                <div class="mb-3">
                    <button class="btn btn-secondary">저장</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>

    function passwordCheck() {
        const password = document.querySelector("#inputPassword").value;
        const passwordCheck = document.querySelector("#inputPasswordCheck").value;

        if (password != passwordCheck) {
            // 메시지 보여주기
            document.querySelector("#passwordMessage").textContent = "패스워드가 일치하지 않습니다."
        } else {
            document.querySelector("#passwordMessage").textContent = ""
        }
    }

    function checkValues() {
        const password = document.getElementById("inputPassword").value;
        const passwordCheck = document.getElementById("inputPasswordCheck").value;

        if (password != "" && password == passwordCheck) {
            return true
        } else {
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        }
    }
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
