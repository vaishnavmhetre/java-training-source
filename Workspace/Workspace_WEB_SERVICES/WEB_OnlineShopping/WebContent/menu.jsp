<div id="templatemo_menu">
	<ul>
		<li><a href="index.html" class="current">Home</a></li>
		<li><a href="subpage.html">Search</a></li>
		<li><a href="subpage.html">Books</a></li>
		<li><a href="subpage.html">New Releases</a></li>
		<li><a href="#">Company</a></li>
		<li><a href="#">Contact</a></li>
		
				
		<c:if test="${authenticatedUser ne null}">
			
			<li><a href="#">Hello ${authenticatedUser.name}</a></li>
		
		</c:if>
	</ul>
</div>