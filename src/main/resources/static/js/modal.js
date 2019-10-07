function openModal() {
	document.getElementById('overlay').classList.add('is-visible');
	document.getElementById('modal').classList.add('is-visible');
}

function closeModal() {
	document.getElementById('overlay').classList.remove('is-visible');
	document.getElementById('modal').classList.remove('is-visible');
}

document.getElementById('overlay').addEventListener('click', function() {
	document.getElementById('overlay').classList.remove('is-visible');
	document.getElementById('modal').classList.remove('is-visible');
});
