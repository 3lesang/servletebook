const books = document.getElementsByClassName("delete-book");
const users = document.getElementsByClassName("delete-user");
Array.from(books).forEach((book) => {
		book.onclick = (e) => {
			if(!confirm("you want to delete?")) {
				e.preventDefault();
			}
		};
});
if(users != null) {
	Array.from(users).forEach((user) => {
		const userid = user.dataset.userid;
		user.onclick = (e) => {
			if(confirm("you want to delete?")) {
				e.preventDefault();
				const url = `${document.location}/user/delete`;
				console.log(url);
				fetch(url, {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded',
					},
					body: `userid=${userid}`
				});
				user.parentElement.parentElement.remove();
				
			}
		}
	})
};

const userBtn = document.querySelector("#user-btn");
const bookBtn = document.querySelector("#book-btn");
const bookTitle = document.querySelector("#book-title");
const bookList = document.querySelector("#book-list");
const userTitle = document.querySelector("#user-title");
const userList = document.querySelector("#user-list");
bookBtn.addEventListener('click', (e) => {
	e.preventDefault();
	userTitle.classList.remove('active');
	userList.classList.remove('active');
	bookTitle.classList.add('active');
	bookList.classList.add('flx');
});
userBtn.addEventListener('click', (e) => {
	e.preventDefault();
	bookTitle.classList.remove('active');
	bookList.classList.remove('flx');
	userTitle.classList.add('active');
	userList.classList.add('active');
});