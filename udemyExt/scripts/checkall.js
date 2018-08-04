function checkAll(section){
  var elements = document.querySelectorAll('[data-purpose="section-'+section+'"]');
  elements.forEach(function(elem){
     var innerElems = elem.querySelectorAll('[type="checkbox"]');
     for(var i=0;i<innerElems.length;i++){
          var innerElem = innerElems[i];
          console.log(innerElem); 
          innerElem.click();
     };
  });
}  

function click(elemAttr){
   var elements = document.querySelectorAll('[data-purpose="'+elemAttr+'"]');
   elements.forEach(function(elem){
      elem.click();
    });
}

checkAll(12);
checkAll(14);

setTimeout(function () {
        	click('right-button');
      }, 1000);