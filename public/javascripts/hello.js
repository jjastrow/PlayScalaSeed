if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

function flip(c,o){
  var card = document.getElementById(c);
  var orig = document.getElementById(o);
  card.innerHTML = orig.innerHTML;
}
