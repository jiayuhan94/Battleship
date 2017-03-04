var gameModel;
var scan_counter = 0;

$( document ).ready(function() {
  // Handler for .ready() called.
  $.getJSON("model", function( json ) {
  gameModel = json;
    console.log( "JSON Data: " + json );
   });
});

function cancelShips() {
    div = document.getElementById('place-ships');
    div.style.display = "none";
    document.getElementById("scan").disabled = false;
    document.getElementById("fire").disabled = false;
}
function scan() {
    if (scan_counter < 3){
    console.log($( "#rowFire" ).val());
    console.log($( "#colFire" ).val());
//var menuId = $( "ul.nav" ).first().attr( "id" );
    var request = $.ajax({
        url: "/scan/"+$( "#rowScan" ).val()+"/"+$( "#colScan" ).val(),
        method: "post",
        data: JSON.stringify(gameModel),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
   });


   request.done(function( currModel ) {
        if (currModel.error_message != null){
               alert(currModel.error_message)
        }else{
            displayGameState(currModel);
            gameModel = currModel;
            scan_counter++;
            if (currModel.scan_result){
                alert("Ship Detected.\nThere is at least one ship here or in an adjacent tile.")
            }else{
                alert("Man, you wasted this!\nThere aren't any ships here or in any adjacent tiles.")
            }
        }

   });

   request.fail(function( jqXHR, textStatus ) {
     alert( "Request failed: scan is out of bounds.\nRow and Column MUST be integers between 1 and 10." /*+ textStatus */ );
   });
    }
    else{
        alert("Request failed: You have already used all of your scans!\nAre you trying to cheat?\nI guess I will have to disable the button to prevent you from trying that again.")
        document.getElementById("scan").disabled = true;
        $( document.getElementById('scan')  ).css("background-color", "gray");
    }
}

function placeShip() {
   console.log($( "#shipSelec" ).val());
   console.log($( "#rowSelec" ).val());
   console.log($( "#colSelec" ).val());
   console.log($("input[name='orientationSelec']:checked").val());

   //var menuId = $( "ul.nav" ).first().attr( "id" );
   var request = $.ajax({
     url: "/placeShip/"+$( "#shipSelec" ).val()+"/"+$( "#rowSelec" ).val()+"/"+$( "#colSelec" ).val()+"/"+$("input[name='orientationSelec']:checked").val(),
     method: "post",
     data: JSON.stringify(gameModel),
     contentType: "application/json; charset=utf-8",
     dataType: "json"
   });

   request.done(function( currModel ) {
     displayGameState(currModel);
     gameModel = currModel;

   });

   request.fail(function( jqXHR, textStatus ) {
     alert( "Request failed: " + textStatus  );
   });
}


function fire(){
 console.log($( "#rowFire" ).val());
 console.log($( "#colFire" ).val());
//var menuId = $( "ul.nav" ).first().attr( "id" );
   var request = $.ajax({
     url: "/fire/"+$( "#rowFire" ).val()+"/"+$( "#colFire" ).val(),
     method: "post",
     data: JSON.stringify(gameModel),
     contentType: "application/json; charset=utf-8",
     dataType: "json"
   });

   request.done(function( currModel ) {

        if (currModel.error_message != null){
            alert(currModel.error_message)
        }else if(currModel.playerHitpoints == 14){
            displayGameState(currModel);
            gameModel = currModel;
            alert(currModel.AI_win);
        }else if(currModel.computerHitpoints == 14){
            displayGameState(currModel);
            gameModel = currModel;
            alert(currModel.Player_win)
        }else{
            displayGameState(currModel);
            gameModel = currModel;}
   });

   request.fail(function( jqXHR, textStatus ) {
     alert( "Request failed: Invalid fire point.\nRow and Column MUST be integers between 1 and 10." /*+ textStatus */ );
   });

}


function log(logContents){
    console.log(logContents);
}

function displayGameState(gameModel){
$( '#MyBoard td'  ).css("background-color", "blue");
$( '#TheirBoard td'  ).css("background-color", "blue");

displayShip(gameModel.aircraftCarrier);
displayShip(gameModel.battleship);
displayShip(gameModel.dinghy);
displayShip(gameModel.clipper);
displayShip(gameModel.submarine);

document.getElementById("playerhits").innerHTML = gameModel.computerHits.length;
document.getElementById("AIhits").innerHTML = gameModel.playerHits.length;
document.getElementById("playermisses").innerHTML = gameModel.computerMisses.length;
document.getElementById("AImisses").innerHTML = gameModel.playerMisses.length;


for (var i = 0; i < gameModel.computerMisses.length; i++) {
   $( '#TheirBoard #' + gameModel.computerMisses[i].Across + '_' + gameModel.computerMisses[i].Down ).css("background-color", "green");
}
for (var i = 0; i < gameModel.computerHits.length; i++) {
   $( '#TheirBoard #' + gameModel.computerHits[i].Across + '_' + gameModel.computerHits[i].Down ).css("background-color", "red");
}

for (var i = 0; i < gameModel.playerMisses.length; i++) {
   $( '#MyBoard #' + gameModel.playerMisses[i].Across + '_' + gameModel.playerMisses[i].Down ).css("background-color", "green");
}
for (var i = 0; i < gameModel.playerHits.length; i++) {
   $( '#MyBoard #' + gameModel.playerHits[i].Across + '_' + gameModel.playerHits[i].Down ).css("background-color", "red");
}



}



function displayShip(ship){
 startCoordAcross = ship.start.Across;
 startCoordDown = ship.start.Down;
 endCoordAcross = ship.end.Across;
 endCoordDown = ship.end.Down;
// console.log(startCoordAcross);
 if(startCoordAcross > 0){
    if(startCoordAcross == endCoordAcross){
        for (i = startCoordDown; i <= endCoordDown; i++) {
            $( '#MyBoard #'+startCoordAcross+'_'+i  ).css("background-color", "yellow");
        }
    } else {
        for (i = startCoordAcross; i <= endCoordAcross; i++) {
            $( '#MyBoard #'+i+'_'+startCoordDown  ).css("background-color", "yellow");
        }
    }
 }
}

