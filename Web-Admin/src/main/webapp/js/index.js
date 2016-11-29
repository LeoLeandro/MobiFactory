$('input[type="submit"]').mousedown(function(){
  $(this).css('background', '#2ecc71');
});
$('input[type="submit"]').mouseup(function(){
  $(this).css('background', '#1abc9c');
});

$('#loginform').click(function(){
  $('.criarConta').display = "none";
  $('.login').fadeToggle('slow');
  $(this).toggleClass('green');
});

$('#contaForm').click(function(){
  $('.login').display = "none";
  $('.criarConta').fadeToggle('slow');
  $(this).toggleClass('green');
});


$(document).mouseup(function (e)
{
    var container = $(".login");
    var containerConta = $(".criarConta");

    if (!container.is(e.target) // if the target of the click isn't the container...
        && container.has(e.target).length === 0) // ... nor a descendant of the container
    {
        container.hide();
        $('#loginform').removeClass('green');
    }

    if (!containerConta.is(e.target) // if the target of the click isn't the container...
        && containerConta.has(e.target).length === 0) // ... nor a descendant of the container
    {
        containerConta.hide();
        $('#criarConta').removeClass('green');
    }
});