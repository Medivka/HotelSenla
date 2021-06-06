<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <title>Orders</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal"><a class="p-2 text-dark" href="/">My test project</a></h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/me">About me</a>
        <a class="p-2 text-dark" href="/players">My project</a>
        <a class="p-2 text-dark" href="/my_contact">Contact</a>

    </nav>
    <a class="btn btn-outline-primary" href="#">Sign up</a>
</div>
<div th:switch="${orders}" >
    <h2 th:case="null">No orders found!</h2>
    <div th:case="*">
        <H1>Hotel Senla</H1>

        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>guest</th>
                <th>room</th>
                <th>services</th>
                <th>Data</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <tr th:each="order : ${orders}">
                <td th:text="${order.id}"></td>
                <td th:text="${order.guest}"></td>
                <td th:text="${order.room}"></td>
                <td th:text="${order.services}"></td>
                <td th:text="${order.localDate}"></td>

            </tr>
            </tbody>
        </table>
    </div>
    <p><a href="/player-create">
        <button type="submit">Create player</button>
    </a></p>
    <p><a href="/">
        <button type="submit">return main</button>
    </a></p>
</div>

</body>
</html>
<style type="text/css">
    H1 {
        font-family: Arial, Helvetica, Verdana, sans-serif;
        font-size: 150%;
        font-weight: lighter;
    }
</style>
<style>
    body {
        background: #00bfff;
        margin-right: 5%;
        margin-left: 5%;
    }
</style>
<style>
    table {
        width: 100%;
        text-align: center;
        border-bottom: 2px solid #dfdfdf;
        border-radius: 6px;
        border-collapse: separate;
        border-spacing: 1px;
    }

    table thead tr {
        color: #ffffff;
        font-weight: bold;
        background: #00bfff;
    }

    table tr td {
        border-right: 1px solid #dfdfdf;
    }

    table tr td:last-child {
        border-right: 2px;
    }

    table tbody tr:nth-child(1n) {
        background: #f6f6f6;
    }

    table tbody tr:nth-child(2n) {
        background: #e6e6e6;
    }

    table tbody tr:hover {
        background: #ffe8e8;
        transition-duration: 0.6s;
    }
</style>