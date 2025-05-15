$(document).ready(function () {
  // Fetch shooting data from the backend
  $.ajax({
    url: 'http://localhost:9002/view/swwv',
    method: 'GET',
    success: function (data) {
      let tableHTML = `
        <table class="table table-bordered table-striped" id="data-table">
          <thead class="table-dark">
            <tr>
              <th>ID</th>

              <th>Distance</th>
              <th>Distance Category</th>
              <th>Shots Fired</th>
              <th>Hit</th>
              <th>Date Of Shooting</th>

              <th>Weapon ID</th>
              <th>Weapon Brand</th>
              <th>Weapon Serial Number</th>
              <th>Bore Size</th>
              <th>Bore Unit</th>

              <th>Weapon Type</th>
              <th>Weapon Photo QR</th>
            </tr>
          </thead>
          <tbody>`;

      data.forEach(item => {
        tableHTML += `
          <tr>
            <td>${item.id}</td>

            <td>${item.distance}</td>
            <td>${item.distance_category}</td>
            <td>${item.shot_fired}</td>
            <td>${item.hit}</td>
            <td>${item.date_of_shooting}</td>

            <td>${item.weapon_id}</td>
            <td>${item.weapon_brand}</td>
            <td>${item.weapon_serial_number}</td>
            <td>${item.weapon_bore_size}</td>
            <td>${item.weapon_bore_unit}</td>
            
            <td>${item.weapon_type}</td>
            <td>${item.weapon_photo_qr}</td>
          </tr>`;
      });

      tableHTML += `</tbody></table>`;
      $('#table-container').html(tableHTML);
    },
    error: function (err) {
      console.error('Error fetching data:', err);
      $('#table-container').html(
        `<div class="alert alert-danger">Failed to load data</div>`
      );
    }
  });

  // Download Excel button - submit hidden form
  $('#download-excel').click(function () {
    $('#download-form').submit();
  });
});
