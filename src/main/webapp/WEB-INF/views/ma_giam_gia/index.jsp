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
        <h1 class="text-center">Mã giảm giá</h1>
    <%--    <form action="/ma-giam-gia/search" method="get">--%>
    <%--        Mã:<input type="text" name="ma"/>--%>
    <%--        <button type="submit">Search</button>--%>
    <%--    </form>--%>

    <div class="mb-3">
        <form:form action="/ma-giam-gia/add" method="post" modelAttribute="mgg">
            ID:<form:input path="id" class="form-control"/>
            <form:errors path="id"/><br>

            Mã:<form:input path="maGiamGia" class="form-control"/>
            <form:errors path="maGiamGia" cssStyle="color: red"/><br>

            Tên:<form:input path="tenMaGiamGia" class="form-control"/>
            <form:errors path="tenMaGiamGia" class="text-danger"/><br>

            Giá trị giảm:<form:input path="giaTriGiam" class="form-control"/>
            <form:errors path="giaTriGiam" class="text-danger"/><br>

            Ngày bắt đầu:<form:input path="ngayBatDau" class="form-control"/>
            <form:errors path="ngayBatDau" class="text-danger"/><br>

            Ngày kết thúc:<form:input path="ngayKetThuc" class="form-control"/>
            <form:errors path="ngayKetThuc" class="text-danger"/><br>

            Mô tả:<form:input path="moTa" class="form-control"/>
            <form:errors path="moTa" class="text-danger"/><br>

            Số lượng:<form:input path="soLuong" class="form-control"/>
            <form:errors path="soLuong" class="text-danger"/><br>

            Điều kiện:<form:radiobutton path="dieuKien" value="0" checked="true"/>Đủ điều kiện
            <form:radiobutton path="dieuKien" value="1"/>Chưa đủ điều kiện<br><br>

            Trạng thái:<form:radiobutton path="trangThai" value="0" checked="true"/>Còn hạn
            <form:radiobutton path="trangThai" value="1"/>Hết hạn<br><br>

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
            <th>Mã giảm giá</th>
            <th>Tên giảm giá</th>
            <th>Giá trị giảm</th>
            <th>Ngày bắt đầu</th>
            <th>Ngày kết thúc</th>
            <th>Mô tả</th>
            <th>Số lượng</th>
            <th>Điều kiện</th>
            <th>Trạng thái</th>
            <%--            <th>Mã chức vụ</th>--%>

            <th colspan="2">Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="mgg" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${mgg.id}</td>
                <td>${mgg.maGiamGia}</td>
                <td>${mgg.tenMaGiamGia}</td>
                <td>${mgg.giaTriGiam}</td>
                <td>${mgg.ngayBatDau}</td>
                <td>${mgg.ngayKetThuc}</td>
                <td>${mgg.moTa}</td>
                <td>${mgg.soLuong}</td>
                <td>${mgg.dieuKien==0?"Đủ điều kiện":"Chưa đủ điều kiện"}</td>
                <td>${mgg.trangThai==0?"Còn hạn":"Hết hạn"}</td>
                    <%--                <td>${kh.chucVu.maChucVu}</td>--%>
                <td>
                    <button class="btn btn-outline-warning"><a href="${pageContext.request.contextPath}/ma-giam-gia/view-update?id=${mgg.id}">Update</a></button>
                        <%--                    <button class="btn btn-outline-danger"><a href="${pageContext.request.contextPath}/ma-giam-gia/remove?id=${mgg.id}">Remove</a></button>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <p>Page : ${currentPage} / ${totalPages}</p>
        <button class="btn btn-outline-info"><a href="${pageContext.request.contextPath}/ma-giam-gia/hien-thi?page=${currentPage <= 1 ? 1 : (currentPage - 1) }">Previous</a></button>
        <button class="btn btn-outline-info"><a href="${pageContext.request.contextPath}/ma-giam-gia/hien-thi?page=${currentPage >= totalPages ? currentPage : (currentPage + 1) }">Next</a></button>
    </div>
</div>
</body>
</html>
