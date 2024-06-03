var loginText = document.getElementById('home-page');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = '../HomePage/homePage.html'
    })
})

var loginText = document.getElementById('home-page-logo');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = '../HomePage/homePage.html'
    })
})

var loginText = document.getElementById('wisata');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = '../pageWisata/wisata.html'
    })
})

var loginText = document.getElementById('tologin');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = '../LoginPage/login-page.html'
    })
})