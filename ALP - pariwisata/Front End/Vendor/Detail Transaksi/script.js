function openPage(pageName, elmnt, color) {
  // Hide all elements with class="tabcontent" by default */
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }

  // Remove the background color of all tablinks/buttons
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = "";
  }

  // Show the specific tab content
  document.getElementById(pageName).style.display = "block";

  // Add the specific color to the button used to open the tab content
  elmnt.style.backgroundColor = color;
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();

document.addEventListener('DOMContentLoaded', () => {
  // Function to fetch and display orders
  async function fetchAndDisplayOrders() {
    try {
      const response = await fetch('/api/orders');
      const orders = await response.json();

      // Clear existing table data
      document.getElementById('waiting-orders').innerHTML = '';
      document.getElementById('success-orders').innerHTML = '';
      document.getElementById('cancel-orders').innerHTML = '';
      document.getElementById('failed-orders').innerHTML = '';

      // Populate tables based on order status
      orders.forEach(order => {
        const row = `
            <tr>
              <td>${order.id}</td>
              <td>${order.date}</td>
              <td>${order.customer}</td>
              <td>${order.status}</td>
              <td>${order.paymentMethod}</td>
              <td><button class="btn btn-primary">Detail</button></td>
            </tr>
          `;

        if (order.status === 'Menunggu Pembayaran') {
          document.getElementById('waiting-orders').insertAdjacentHTML('beforeend', row);
        } else if (order.status === 'Berhasil') {
          document.getElementById('success-orders').insertAdjacentHTML('beforeend', row);
        } else if (order.status === 'Dibatalkan') {
          document.getElementById('cancel-orders').insertAdjacentHTML('beforeend', row);
        } else if (order.status === 'Gagal') {
          document.getElementById('failed-orders').insertAdjacentHTML('beforeend', row);
        }
      });

      // Update the status counts
      document.getElementById('waiting-number').textContent = orders.filter(order => order.status === 'Menunggu Pembayaran').length;
      document.getElementById('success-number').textContent = orders.filter(order => order.status === 'Berhasil').length;
      document.getElementById('cancel-number').textContent = orders.filter(order => order.status === 'Dibatalkan').length;
      document.getElementById('failed-number').textContent = orders.filter(order => order.status === 'Gagal').length;
    } catch (error) {
      console.error('Error fetching orders:', error);
    }
  }

  // Call the function to fetch and display orders
  fetchAndDisplayOrders();
});