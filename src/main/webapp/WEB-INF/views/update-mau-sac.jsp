<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cập nhật Mau sac
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e3f2fd; /* Màu xanh nhẹ */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
        }
        .form-container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            animation: fadeIn 0.5s ease-in-out;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-10px); }
            to { opacity: 1; transform: translateY(0); }
        }
        .btn-primary {
            width: 100%;
            font-weight: bold;
            background-color: #007bff;
            border: none;
            transition: 0.3s;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }
        .form-label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h3 class="text-center mb-4">Cập Nhật Mau Sac</h3>
    <form action="/mau-sac/update/${detail.id}" method="post">
        <input type="hidden" name="id" value="${detail.id}">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" name="ma" value="${detail.ma}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten" value="${detail.ten}" required>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Cập nhật</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
