var freeUrl = "https://www.udemy.com/complete-java-course-from-scratch/?couponCode="+couponCode;
// freeUrl = "https://www.udemy.com/complete-java-course-from-scratch/?couponCode=FREE_10";

function click(elemAttr){
  console.log("click="+elemAttr);
   var elements = document.querySelectorAll('[data-purpose="'+elemAttr+'"]');
   elements.forEach(function(elem){
      elem.click();
    });
}
function setInput(value, elemAttr){
   var elements = document.querySelectorAll('[data-purpose="'+elemAttr+'"]');
   elements.forEach(function(elem){
       elem.value=value;
   });
}
function redirectToUrl(url){
  console.log("url="+url);
   window.location.href=url;
}
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

console.log("redirectToUrl begin");
redirectToUrl(freeUrl);
console.log("redirectToUrl end");
