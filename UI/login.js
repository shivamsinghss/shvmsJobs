async function loginUser() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({
            username: email,
            password: password
        })
    });

    const result = await response.text();
    if (result === 'Login successful!') {
        displaySuccessMessage(result, 'green');
    } else {
        displayFailureMessage(result, 'red');
    }
    function displaySuccessMessage(message, color) {
    const messageElement = document.getElementById('message');
    messageElement.textContent = message;
    messageElement.style.color = color;
}

function displayFailureMessage(message, color) {
    const messageElement = document.getElementById('message');
    messageElement.textContent = message;
    messageElement.style.color = color;
}
}
function redirectToPage(page) {
    window.location.href = page;
}
