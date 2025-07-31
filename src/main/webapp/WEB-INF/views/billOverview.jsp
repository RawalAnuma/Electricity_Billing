<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty billRecords}">
<section class="bg-white rounded-lg py-4 antialiased dark:bg-gray-900 md:py-4">
    <p class="text-4xl font-bold mb-8 text-center text-gray-800 dark:text-white">Bill Overview</p>
    <form action="${pageContext.request.contextPath}/billRecords" class="mx-auto max-w-screen-xl px-4 2xl:px-0" method="post">
        <!-- Hidden Fields -->
        <input type="hidden" name="billAmount" value="${billRecords.billAmount}" />
        <input type="hidden" name="customer.customerId" value="${billRecords.customer.customerId}" />

        <div class="mt-6 w-full space-y-6 sm:mt-8 lg:mt-0 lg:max-w-xs xl:max-w-md">
            <div class="flow-root">
                <div class="-my-3 divide-y divide-gray-200 dark:divide-gray-800">
                    <dl class="flex items-center justify-between gap-4 py-3">
                        <dt class="w-40 font-medium text-lg text-gray-500 dark:text-gray-400">Customer Name:</dt>
                        <dd class="text-base font-medium text-gray-900 dark:text-white">
                            <c:out value="${billRecords.customer.customerName}" />
                        </dd>
                    </dl>

                    <dl class="flex items-center justify-between gap-4 py-3">
                        <dt class="w-40 font-medium text-gray-500 dark:text-gray-400">House Number:</dt>
                        <dd class="text-base font-medium text-green-500">
                            <c:out value="${billRecords.customer.houseNumber}" />
                        </dd>
                    </dl>

                    <dl class="flex items-center justify-between gap-4 py-3">
                        <dt class="w-40 font-medium text-gray-500 dark:text-gray-400">Units Consumed:</dt>
                        <dd class="text-base font-medium text-gray-900 dark:text-white">
                            <c:out value="${billRecords.customer.unitsConsumed}" />
                        </dd>
                    </dl>

                    <dl class="flex items-center justify-between gap-4 py-3">
                        <dt class="w-40 font-bold text-gray-900 dark:text-white">Bill Amount:</dt>
                        <dd class="text-base font-bold text-gray-900 dark:text-white">
                            Rs. <c:choose>
                                <c:when test="${not empty billRecords.billAmount}">
                                    <c:out value="${billRecords.billAmount}" />
                                </c:when>
                                <c:otherwise>0</c:otherwise>
                            </c:choose>
                        </dd>
                    </dl>
                </div>
            </div>

            <div class="space-y-3">
                <button type="submit" class="flex w-full items-center justify-center rounded-lg bg-green-700 text-white px-6 py-2 hover:bg-blue-800 text-lg">Save Bill</button>
            </div>
        </div>
    </form>
</section>
</c:if>
