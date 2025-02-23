<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cập nhật Thoi Gian Bao Hanh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h3 class="text-center mb-4">Cập Nhật Thương Hiệu</h3>
    <form action="/thoi-gian-bao-hanh/update/${detail.id}" method="post">
        <input type="hidden" name="id" value="${detail.id}">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" name="ma" value="${detail.ma}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Thoi Gian</label>
            <input type="text" class="form-control" name="thoiGian" value="${detail.thoiGian}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng thái</label>
            <div>
                <input type="radio" class="form-check-input" name="trangThai" value="1" ${detail.trangThai == 1 ? "checked" : ""}> Đang hoạt động
                <input type="radio" class="form-check-input ms-3" name="trangThai" value="0" ${detail.trangThai == 0 ? "checked" : ""}> Ngừng hoạt động
            </div>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Cập nhật</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
