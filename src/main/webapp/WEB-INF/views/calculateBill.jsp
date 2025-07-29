<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Calculate Electricity Bill</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen">
<%@ include file="/WEB-INF/views/navBar.jsp" %>

<div class="flex items-center justify-center pt-10">
  <div class="bg-white p-8 rounded-2xl shadow-lg w-full max-w-md">
    <h2 class="text-2xl font-bold text-center text-gray-800 mb-6">Calculate Bill</h2>
    <form action="${pageContext.request.contextPath}/customer" method="POST" class="space-y-4">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

      <div>
        <label for="customerName" class="block text-sm font-medium text-gray-700">Customer Name</label>
        <input
          type="text"
          id="customerName"
          name="customerName"
          required
          class="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:ring-blue-500 focus:border-blue-500"
        />
      </div>

      <div>
        <label for="houseNumber" class="block text-sm font-medium text-gray-700">House Number</label>
        <input
          type="number"
          id="houseNumber"
          name="houseNumber"
          required
          class="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:ring-blue-500 focus:border-blue-500"
        />
      </div>

      <div>
        <label for="unitsConsumed" class="block text-sm font-medium text-gray-700">Units Consumed</label>
        <input
          type="number"
          id="unitsConsumed"
          name="unitsConsumed"
          required
          class="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:ring-blue-500 focus:border-blue-500"
        />
      </div>

      <button
        type="submit"
        class="w-full py-3 px-4 bg-blue-600 text-white font-semibold rounded-lg shadow-md hover:bg-blue-700 transition"
      >
        Calculate Bill
      </button>
    </form>
  </div>
</div>
</body>
</html>
