document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('form').addEventListener('submit', function(event) {
        event.preventDefault();

        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;

        console.log("Email:", email);
        console.log("Password:", password);
    });
});


//Kalau Sudah Ada registrasi

// document.getElementById('loginForm').addEventListener('submit', function(event) {
//     event.preventDefault(); // Mencegah form submit default
    
//     var email = document.getElementById('email').value;
//     var password = document.getElementById('password').value;
    
//     // Contoh email dan password yang benar
//     var validEmail = "user@example.com";
//     var validPassword = "password123";
    
//     if (email === validEmail && password === validPassword) {
//         alert("Login berhasil!");
//         // Anda dapat mengarahkan ke halaman lain atau melakukan tindakan lain di sini
//     } else {
//         alert("Email atau password salah. Silakan coba lagi.");
//     }
// });