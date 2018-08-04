function setInput(value, elemAttr){
   var elements = document.querySelectorAll('[data-purpose="'+elemAttr+'"]');
   elements.forEach(function(elem){
       elem.value+=value; 
       elem.value+=" "; 
       elem.focus();
       simulateKeydown(77);
   });
}

function simulateKeydown (keycode,isCtrl,isAlt,isShift){
    var e = new KeyboardEvent( "keydown", { bubbles:true, cancelable:true, char:String.fromCharCode(keycode), key:String.fromCharCode(keycode), shiftKey:isShift, ctrlKey:isCtrl, altKey:isAlt } );
    Object.defineProperty(e, 'keyCode', {get : function() { return this.keyCodeVal; } });     
    e.keyCodeVal = keycode;
    document.dispatchEvent(e);
}
function click(elemAttr){
   var elements = document.querySelectorAll('[data-purpose="'+elemAttr+'"]');
   elements.forEach(function(elem){
      elem.click();
    });
}
setInput(reviewText,"public-review");
setTimeout(function () {
        	click('right-button');
      }, 2000);
// setTimeout(function () {
//         	click('right-button');
//       }, 4000);

// click('right-button');