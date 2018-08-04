// freeUrl = "https://www.udemy.com/complete-java-course-from-scratch/?couponCode=FREE_10";

function redirectToUrl(url){
  console.log("url="+url);
   window.location.href=url;
}

console.log("redirectToUrl begin");
redirectToUrl(urlRedirect);
console.log("redirectToUrl end");
