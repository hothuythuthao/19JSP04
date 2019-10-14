$(document).ready(function() {

	/* --------- --- --------- */
	$('input[name="submit"]').click(function() {
		console.log($('input[name="name"]').val().trim());
		console.log($('input[name="age"]').val().trim());
		console.log($('input[name="dob"]').val().trim());
		console.log($('input[name="pn"]').val().trim());
		console.log($('input[name="email"]').val().trim());
		var info = [];
		$('input[name="name"]').each(function() {
			if ($(this) != '') {
				info.push($(this).val());
			}
		});
		$('input[name="age"]').each(function() {
			if ($(this) != '') {
				info.push($(this).val());
			}
		});
		$('input[name="dob"]').each(function() {
			if ($(this) != '') {
				info.push($(this).val());
			}
		});
		$('input[name="pn"]').each(function() {
			if ($(this) != '') {
				info.push($(this).val());
			}
		});
		$('input[name="email"]').each(function() {
			if ($(this) != '') {
				info.push($(this).val());
			}
		});
		console.log(info);
		html = info[0] + ' - ' + info[1] + ' - ' + info[2] + ' - ' + info[3] + ' - ' + info[4];
		$('.rs').append(html);
	});

	/* --------- --- --------- */

});


