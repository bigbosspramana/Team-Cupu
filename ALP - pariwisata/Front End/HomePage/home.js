var loginText = document.getElementById('tologin');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = '../LoginPage/login-page.html'
    })
})

var loginText = document.getElementById('surabaya');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = ''
    })
})

var loginText = document.getElementById('makassar');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = ''
    })
})

var loginText = document.getElementById('jakarta');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = ''
    })
})

var loginText = document.getElementById('bandung');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = ''
    })
})

document.getElementById('search-button').addEventListener('click', function() {
    var query = document.getElementById('search-input').value;
    alert('You searched for: ' + query);
});

function openPage(url) {
    window.location.href = url;
}

var loginText = document.getElementById('home-page');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = ''
    })
})

var loginText = document.getElementById('home-page-logo');

loginText.addEventListener('click', function() {
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    setTimeout(function() {
        window.location.href = ''
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