let formCount = 0;

function createForm() {
    formCount++;
    let formHTML = '';

    if (formCount === 1) {
        formHTML += '<p class="h4">Formulir Tambah Barang</p>';
    }

    formHTML += `<p class="h5">Barang ${formCount}</p>`;
    formHTML += '<form class="item-form row g-3">';
    formHTML += '<div class="col-12 col-md-6">';
    formHTML += '<label for="item-name" class="form-label label-mt">Nama Barang</label>';
    formHTML += '<input type="text" class="form-control item-name" placeholder="Nama Barang">';
    formHTML += '</div>';
    formHTML += '<div class="col-12 col-md-6">';
    formHTML += '<label for="item-quantity" class="form-label label-mt">Jumlah Barang</label>';
    formHTML += '<div class="input-group" style="width: 180px;">';
    formHTML += '<button type="button" class="btn btn-outline-secondary decrease-quantity"><i class="fa-solid fa-circle-minus"></i></button>';
    formHTML += '<input type="text" class="form-control item-quantity" placeholder="Jumlah Barang" value="0" style="text-align: center;">';
    formHTML += '<button type="button" class="btn btn-outline-secondary increase-quantity"><i class="fa-solid fa-circle-plus"></i></button>';
    formHTML += '</div>';
    formHTML += '</div>';
    formHTML += '<div class="col-12 desc-item">';
    formHTML += '<label for="item-desc" class="form-label label-mt">Deskripsi Barang</label>';
    formHTML += '<textarea rows="5" class="form-control item-desc"></textarea>';
    formHTML += '</div>';
    formHTML += '<div class="col-12">';
    formHTML += '<button type="button" class="btn btn-primary add-item-btn"><i class="fa-solid fa-plus"></i>Tambah Barang</button>';
    formHTML += '</div>';
    formHTML += '</form>';

    // Menambahkan form ke dalam container
    var itemContainer = document.getElementById('item-container');
    var formElement = document.createElement('div');
    formElement.innerHTML = formHTML;
    itemContainer.appendChild(formElement);

    // Menambahkan event listener untuk tombol plus dan minus
    formElement.querySelectorAll('.increase-quantity').forEach(button => {
        button.addEventListener('click', function () {
            var quantityInput = this.previousElementSibling;
            quantityInput.value = parseInt(quantityInput.value) + 1;
        });
    });

    formElement.querySelectorAll('.decrease-quantity').forEach(button => {
        button.addEventListener('click', function () {
            var quantityInput = this.nextElementSibling;
            if (quantityInput.value > 0) {
                quantityInput.value = parseInt(quantityInput.value) - 1;
            }
        });
    });

    // Menambahkan event listener untuk membatasi input hanya pada angka
    formElement.querySelectorAll('.item-quantity').forEach(input => {
        input.addEventListener('input', function (e) {
            this.value = this.value.replace(/[^0-9]/g, '');
        });
    });

    // Menambahkan event listener untuk tombol "Tambah Barang" yang baru
    formElement.querySelectorAll('.add-item-btn').forEach(button => {
        button.addEventListener('click', function () {
            var form = this.closest('.item-form');
            var itemName = form.querySelector('.item-name').value;
            var itemQuantity = form.querySelector('.item-quantity').value;
            var itemDesc = form.querySelector('.item-desc').value;

            // Validasi input
            if (!itemName) {
                alert('Anda belum menginputkan Nama Barang');
                return;
            }

            if (itemQuantity == 0) {
                alert('Anda belum memasukkan Jumlah Barang.');
                return;
            }

            // Menampilkan data di console.log
            console.log({
                itemName: itemName,
                itemDesc: itemDesc,
                itemQuantity: itemQuantity
            });

            // Menyembunyikan tombol "Tambah Barang" dari form sebelumnya
            this.style.display = 'none';

            // Membuat form baru
            createForm();
        });
    });
}

document.getElementById('add-item-btn').addEventListener('click', function () {
    // Menyembunyikan tombol "Tambah Barang"
    this.style.display = 'none';

    // Membuat form pertama
    createForm();
});
