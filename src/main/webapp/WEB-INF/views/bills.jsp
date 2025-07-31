<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Bill Records</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class = "bg-gray-50 text-gray-800">
<%@ include file="/WEB-INF/views/navBar.jsp" %>
<div class="max-w-6xl mx-auto px-6 py-8">
    <h1 class="text-4xl font-bold mb-8 text-center text-navy-800">Bill Records Details</h1>
    <table class="table-auto w-full border-collapse border border-gray-400 text-center text-lg">
        <thead>
            <tr class="bg-blue-900 text-white">
                <th class="border px-4 py-2">Bill ID</th>
                <th class="border px-4 py-2">Customer Id</th>
                <th class="border px-4 py-2">Date</th>
                <th class="border px-4 py-2">Bill Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bill" items="${billRecords}">
                <tr class="text-gray-800">
                    <td class="border px-4 py-2">${bill.billId}</td>
                    <td class="border px-4 py-2">${bill.customer.customerId}</td>
                    <td class="border px-4 py-2">${bill.billDate}</td>
                    <td class="border px-4 py-2">${bill.billAmount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
