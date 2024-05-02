<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary mb-4">
    <div class="container">
        <a class="navbar-brand" href="#">PROJECT</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">
                        목록
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/add">
                        글쓰기
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/member/signup">
                        회원가입
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>