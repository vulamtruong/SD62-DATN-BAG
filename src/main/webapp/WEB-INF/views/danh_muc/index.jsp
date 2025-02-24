<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<jsp:include page="/WEB-INF/view/header/sidebar.jsp"/>--%>

<div class="container">
        <h1 class="text-center">Danh mục</h1>
    <%--    <form action="/danh-muc/search" method="get">--%>
    <%--        Mã:<input type="text" name="ma"/>--%>
    <%--        <button type="submit">Search</button>--%>
    <%--    </form>--%>

    <div class="mb-3">
        <form:form action="/danh-muc/add" method="post" modelAttribute="dm">
            ID:<form:input path="id" class="form-control"/>
            <form:errors path="id"/><br>

            Mã:<form:input path="maDanhMuc" class="form-control"/>
            <form:errors path="maDanhMuc" cssStyle="color: red"/><br>

            Tên:<form:input path="tenDanhMuc" class="form-control"/>
            <form:errors path="tenDanhMuc" class="text-danger"/><br>

            Trạng thái:<form:radiobutton path="trangThai" value="0" checked="true"/>Đang sử dụng
            <form:radiobutton path="trangThai" value="1"/>Ngừng sử dụng<br><br>

            <%--            Mã chức vụ:<form:select path="chucVu">--%>
            <%--            <form:options items="${listChucVu}" itemLabel="maChucVu" />--%>
            <%--        </form:select><br><br>--%>


            <form:button type="submit" class="btn btn-outline-info">Add</form:button>
        </form:form>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>Mã danh mục</th>
            <th>Tên danh mục</th>
            <th>Trạng thái</th>
            <%--            <th>Mã chức vụ</th>--%>

            <th colspan="2">Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="dm" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${dm.id}</td>
                <td>${dm.maDanhMuc}</td>
                <td>${dm.tenDanhMuc}</td>
                <td>${dm.trangThai==0?"Đang sử dụng":"Ngừng sử dụng"}</td>
                    <%--                <td>${kh.chucVu.maChucVu}</td>--%>
                <td>
                    <button class="btn btn-outline-warning"><a href="${pageContext.request.contextPath}/danh-muc/view-update?id=${dm.id}">Update</a></button>
                        <%--                    <button class="btn btn-outline-danger"><a href="${pageContext.request.contextPath}/danh-muc/remove?id=${dm.id}">Remove</a></button>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <p>Page : ${currentPage} / ${totalPages}</p>
        <button class="btn btn-outline-info"><a href="${pageContext.request.contextPath}/danh-muc/hien-thi?page=${currentPage <= 1 ? 1 : (currentPage - 1) }">Previous</a></button>
        <button class="btn btn-outline-info"><a href="${pageContext.request.contextPath}/danh-muc/hien-thi?page=${currentPage >= totalPages ? currentPage : (currentPage + 1) }">Next</a></button>
    </div>
</div>
</body>
</html>
