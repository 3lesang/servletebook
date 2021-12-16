const followBtn = document.getElementsByClassName('follow-btn');
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

Array.from(followBtn).forEach((item) => {
	const userid = item.dataset.user;
	const bookid = item.dataset.book;
	item.addEventListener('click', (e) => {
		e.preventDefault();
		
		const url = document.location + `/follow`;
		fetch(url, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded',
			},
			body: `userid=${userid}&bookid=${bookid}`
			
		});
	});
}); 