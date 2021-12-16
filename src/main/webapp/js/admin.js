const users = document.getElementsByClassName("delete");

Array.from(users).forEach((user) => {
		user.onclick = (e) => {
			if(!confirm("you want to delete?")) 
			{
				e.preventDefault();
			}
		};
});

