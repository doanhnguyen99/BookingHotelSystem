$(document).ready(function() {
    // $("#myWish").click(function showAlert() {
    //     $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
    //         $("#success-alert").slideUp(500);
    //     });
    //     $("#success-alert").hide();
    // });
    $("myWish").click(
        setTimeout(function(){
            $("#success-alert").hide();
        }, 3000)
    );
});
