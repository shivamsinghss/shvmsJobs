async function registerUser() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const response = await fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            username: email,
            password: password,
            email: email
        })
    });

    const result = await response.text();
    if (result === 'User registered successfully!') {
        displaySuccessMessage(result, 'green');
        redirectToPage('Register.html');
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