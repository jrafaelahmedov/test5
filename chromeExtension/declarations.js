//declarations
    function includeSignup(){
        console.log("click signup");
        chrome.tabs.getSelected(null, function(tab){
        	var name = document.getElementById("name").value;
			console.log("name="+name);
			var surname = document.getElementById("surname").value;
			console.log("surname="+surname);

			var customCode = 
					'var name = "'+name+'";'+
					'var surname = "'+surname+'"';
        	chrome.tabs.executeScript(tab.id, {
			    code: customCode
			}, function() {
			    chrome.tabs.executeScript(tab.id, {file: "scripts/signup.js"});
			});
            
        }); 
    } 

    document.addEventListener('DOMContentLoaded', function () {
      document.getElementById("signup").addEventListener('click', includeSignup);
    });

    
    function includeRedirect(){
        console.log("click redirect");
        chrome.tabs.getSelected(null, function(tab){
			var couponCode = document.getElementById("couponCode").value;
			console.log("couponCode="+couponCode);

			var customCode = 'var couponCode = "'+couponCode+'"';
        	chrome.tabs.executeScript(tab.id, {
			    code: customCode
			}, function() {
			    chrome.tabs.executeScript(tab.id, {file: "scripts/redirect.js"});
			});
            
        }); 
    } 

    document.addEventListener('DOMContentLoaded', function () {
      document.getElementById("redirect").addEventListener('click', includeRedirect);
    });