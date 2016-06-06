if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

var clickCount = 0;
var handMessage = "Full House";

function flip(c,o){
  var card = document.getElementById(c);
  var orig = document.getElementById(o);
  card.innerHTML = orig.innerHTML;

  clickCount = clickCount + 1;
  if (clickCount == 5) { displayMessage() }
}

function displayMessage() {
  alert('You have a ' + handMessage + '!');
}
