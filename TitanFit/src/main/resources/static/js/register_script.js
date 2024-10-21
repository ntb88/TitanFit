document.getElementById('register-form').addEventListener('submit', function(event) {
    // Prevent the form from submitting automatically
    event.preventDefault();

    // Validation flags
    let isValid = true;

    // Email validation
    const nameInput = document.getElementById('name');
    const nameError = document.getElementById('name-error');
    const nameValue = nameInput.value.trim();
    if (!validateEmail(nameValue)) {
        nameError.style.display = 'block';
        isValid = false;
    } else {
        nameError.style.display = 'none';
    }

    // Email validation
    const emailInput = document.getElementById('email');
    const emailError = document.getElementById('email-error');
    const emailValue = emailInput.value.trim();
    if (!validateEmail(emailValue)) {
        emailError.style.display = 'block';
        isValid = false;
    } else {
        emailError.style.display = 'none';
    }

    // Password validation
    const passwordInput = document.getElementById('password');
    const passwordError = document.getElementById('password-error');
    const passwordValue = passwordInput.value.trim();
    if (passwordValue.length < 6) {
        passwordError.style.display = 'block';
        isValid = false;
    } else {
        passwordError.style.display = 'none';
    }

    // If the form is valid, submit it
    if (isValid) {
        alert('Registration Successful!');
        // Optionally, add the logic to submit the form
        this.submit();
    }
});

// Function to validate email format
function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(String(email).toLowerCase());
}
