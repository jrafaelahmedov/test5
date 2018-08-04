function click(elemAttr){
   var elements = document.querySelectorAll('[data-purpose="'+elemAttr+'"]');
   elements.forEach(function(elem){
      elem.click();
    });
}

click("review-star-input-5-label");