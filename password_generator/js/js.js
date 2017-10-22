document.getElementById('submit').addEventListener('click', (event) => {
    event.preventDefault();

    const numberOfDidgets = document.getElementById('numberOfDidgets').value;

    document.getElementById('password').innerHTML = 'Your generated password: ' + generatePassword(numberOfDidgets);
});

const generatePassword = (numberOfDidgets) => {
    let password = '';

    for (var index = 0; index < numberOfDidgets; index++) {
        password += String.fromCharCode(Math.floor(Math.random() * (126 - 33) + 33));
    }
    return password;
}