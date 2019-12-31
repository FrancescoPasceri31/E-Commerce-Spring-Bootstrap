/**
 * 
 */

function checkPassword() {
	var password = $("#newPassword").val();
	var confirmPassword = $("#confirmNewPassword").val();

	if (password == "" && confirmPassword == "") {
		$("#checkPasswordMatch").html("");
		$("#updateUserInfoButton").prop('disabled', false);
		console.log("no change");
	} else {
		if (password != confirmPassword) {
			$("#checkPasswordMatch").html("Password diverse");
			$("#checkPasswordMatch").css({
				'color' : 'red'
			});
			$("#updateUserInfoButton").prop('disabled', true);
			console.log("diversi");
		} else {
			$("#checkPasswordMatch").html("Password ok");
			$("#checkPasswordMatch").attr('style', 'color: green');
			$("#updateUserInfoButton").prop('disabled', false);
			console.log("ok");
		}
	}
}

function checkCheckbox() {
	if ($("#theSameAsShippingAddress").is(':checked')) {
		$(".couldDisabled").prop('disabled', true);
	} else {
		$(".couldDisabled").prop('disabled', false);
	}
}

$(document).ready(function() {
	$(".cartItemQty").on("change", function() {
		var id = this.id;
		$('#update-item-' + id).css('display', 'inline-block');
	});

	$("#theSameAsShippingAddress").click(checkCheckbox);

	$("#confirmNewPassword").keyup(checkPassword);
	$("#newPassword").keyup(checkPassword);

});