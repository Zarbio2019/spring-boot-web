<jsp:include page="header.jsp" flush="true"/>
<center>
    <div class="card">
        <div class="card-body">
            <h3>Login</h3></br>
		<div class="form-group">
                    <input type="text" class="form-control" id="usuario"
					aria-describedby="emailHelp" placeholder="Enter email">
                </div>	
		<div class="form-group">
                    <input type=""password" class="form-control" id="password" placeholder="Password">
                </div>
		<label id="message"></label></br>
		<button onclick="loginUser();" class="btn btn-primary">Submit</button>
		</button>
	</div>
    </div>
</center>
<jsp:include page="footer.jsp" flush="true"/>