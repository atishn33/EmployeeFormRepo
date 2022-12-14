<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="../fragment/header.jsp" %>

<div class="container form-container">

    <form:form action="${pageContext.request.contextPath}/save" method="POST">

        <div class="row">
            <div class="col-25">
                <label for="firstName">FirstName: </label>
            </div>
            <div class="col-75">
                <form:input path="firstName"/>
            </div>
        </div>

        <div class=" row">
            <div class="col-25">
                <label for="lastName">LastName: </label>
            </div>
            <div class="col-75">
                <form:input path="lastName"/>
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="address">Address: </label>
            </div>
            <div class="col-75">
                <form:input path="address"/>
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="phoneNumber">Phone Number: </label>
            </div>
            <div class="col-75">
                <form:input path="phoneNumber"/>
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="Email">Email: </label>
            </div>
            <div class="col-75">
                <form:input path="email"/>
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="Post">Post: </label>
            </div>
            <div class="col-75">
                <form:input path="post"/>
            </div>
        </div>

        <div class="row">
            <div class="col-75">
                <input type="submit" value="<%=request.getAttribute("action")%>">
            </div>
        </div>

    </form:form>
</div>


<%@ include file="../fragment/footer.jsp" %>
