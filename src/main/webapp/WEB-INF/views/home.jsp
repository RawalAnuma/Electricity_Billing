<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculate Bill</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 text-gray-800">
<%@ include file="/WEB-INF/views/navBar.jsp" %>

<div class="max-w-7xl mx-auto px-6 py-8 flex flex-col md:flex-row gap-8">
    <!-- Left: Form -->
    <div class="w-full md:w-1/2">
        <section class="rounded-lg py-4 md:py-4">
        <h1 class="text-4xl font-bold mb-8 text-center text-navy-800">Calculate Bill</h1>
        <form action="${pageContext.request.contextPath}/customer/calculate" method="post" class="space-y-4">
            <div class="flex items-center">
                <label class="w-40 font-medium text-lg">Customer Name:</label>
                <input type="text" name="customerName" class="flex-1 border border-gray-300 p-2 rounded text-lg" required>
            </div>
            <div class="flex items-center">
                <label class="w-40 font-medium text-lg">House number:</label>
                <input type="text" name="houseNumber" class="flex-1 border border-gray-300 p-2 rounded text-lg" required>
            </div>
            <div class="flex items-center">
                <label class="w-40 font-medium text-lg">Units Consumed:</label>
                <input type="number" name="unitsConsumed" class="flex-1 border border-gray-300 p-2 rounded text-lg" required>
            </div>
            <div class="flex justify-end mt-4">
                <button type="submit" class="bg-blue-700 text-white px-6 py-2 rounded hover:bg-blue-800 text-lg">Calculate Bill</button>
            </div>
        </form>
        </section>
    </div>
    <!-- Right: Bill Overview -->
    <div class="w-full md:w-1/2">
        <%@ include file="/WEB-INF/views/billOverview.jsp" %>
    </div>
</div>

</body>
</html>