<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary mb-4">
    <div class="container">
        <a class="navbar-brand" href="#">PROJECT</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/">
                            게시물 목록
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/add">
                            글쓰기
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/member/list">
                            회원목록
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="not isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/member/signup">
                            회원가입
                        </a>
                    </li>
                    <%--li.nav-item>a.nav-link{로그인}--%>
                    <li class="nav-item">
                        <a href="/member/login" class="nav-link">
                            로그인
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <%--li.nav-item>a.nav-link{로그아웃}--%>
                    <li class="nav-item">
                        <a href="/logout" class="nav-link">
                            로그아웃
                        </a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>