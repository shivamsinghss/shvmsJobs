async function registerUser() {
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const phone = document.getElementById('phone').value;
    const age = document.getElementById('age').value;
    const gender = document.getElementById('gender').value;

    const response = await fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            username: username,
            email: email,
            password: password,
            phone: phone,
            age: age,
            gender: gender
        })
    });

    const result = await response.text();
    if (result === 'User registered successfully!') {
        displaySuccessMessage(result, 'green');
        redirectToPage('login.html');
    } else {
        displayFailureMessage(result, 'red');
    }
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

function redirectToPage(page) {
    window.location.href = page;
}
    