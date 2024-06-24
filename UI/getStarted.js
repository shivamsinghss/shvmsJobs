let currentPage = 1; 

function nextPage() {
    const page1 = document.getElementById('page-1');
    const page2 = document.getElementById('page-2');

    page1.style.display = 'none';
    page2.style.display = 'block';
    currentPage = 2;
}

function prevPage() {
    const page1 = document.getElementById('page-1');
    const page2 = document.getElementById('page-2');

    page2.style.display = 'none';
    page1.style.display = 'block';
    currentPage = 1;
}

function addEducation() {
    const educationContainer = document.getElementById('education-container');
    const educationGroup = document.createElement('div');
    educationGroup.classList.add('education-group');

    educationGroup.innerHTML = `
        <div class="form-group">
            <label for="degreeName">Degree Name:</label>
            <input type="text" class="degreeName" placeholder="Enter your degree name">
        </div>
        <div class="form-group">
            <label for="institutionName">Institution Name:</label>
            <input type="text" class="institutionName" placeholder="Enter your institution name">
        </div>
        <div class="form-group">
            <label for="yearOfPassing">Year of Passing:</label>
            <input type="text" class="yearOfPassing" placeholder="Enter your year of passing">
        </div>
        <div class="form-group">
            <label for="percentage">Percentage:</label>
            <input type="text" class="percentage" placeholder="Enter your percentage">
        </div>
    `;

    educationContainer.appendChild(educationGroup);
}

function submitForm() {
    const username = sessionStorage.getItem('username');

    if (!username) {
        alert('Username not found in session storage.');
        return;
    }

    const educationGroups = document.querySelectorAll('.education-group');
    const qualifications = Array.from(educationGroups).map(group => ({
        degreeName: group.querySelector('.degreeName').value,
        institutionName: group.querySelector('.institutionName').value,
        yearOfPassing: group.querySelector('.yearOfPassing').value,
        percentage: group.querySelector('.percentage').value
    }));

    const jobTitle = document.getElementById('jobTitle').value;
    const preferredLocation = document.getElementById('preferredLocation').value;
    const salary = document.getElementById('salary').value;

    const formData = {
        username: username,
        qualificationList: qualifications,
        jobSpecificProblem: {
            jobTitle: jobTitle,
            preferredLocation: preferredLocation,
            salary: salary
        }
    };

    fetch('http://localhost:8080/details', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        console.log('Form data saved successfully:', data);
        displaySuccessMessage();
        setTimeout(() => {
            window.location.href = 'jobSearch.html'; 
        }, 3000);
    })
    .catch(error => {
        console.error('Error saving form data:', error);
        alert('Error saving form data. Please try again.');
    });
}

function displaySuccessMessage() {
    const successMessage = document.createElement('div');
    successMessage.textContent = 'Details saved successfully!!!';
    successMessage.style.color = 'green';
    document.getElementById('success-message').appendChild(successMessage);
}
function redirectToPage(page) {
    window.location.href = page;
}
