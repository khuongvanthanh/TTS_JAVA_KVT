document.addEventListener("DOMContentLoaded", () => {
    const showError = (key, display) => {
        document.querySelector(`#error-${key}`).style.display = display;
    }

    try {
        document.querySelector('#onSubmit').addEventListener('click', (e) => {
            const data = {
                'facility': document.getElementById('facility').value,
                'department': document.getElementById('department').value,
                'major': document.getElementById('major').value,
            };

            let isValid = true;

            if (data['facility'].length < 1) {
                showError('facility', '');
                isValid = false;
            } else {
                showError('facility', 'none');
            }

            if (data['department'].length < 1) {
                showError('department', '');
                isValid = false;
            } else {
                showError('department', 'none');
            }

            if (data['major'].length < 1) {
                showError('major', '');
                isValid = false;
            } else {
                showError('major', 'none');
            }

            if (isValid) {
                document.querySelector('#send').submit();
            }
        });
    } catch (error) {
        console.error('Error:', error);
    }
});
