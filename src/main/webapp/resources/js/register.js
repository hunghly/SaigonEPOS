const Register = (()=> {
    const listeners = () => {
        const passwordEl = document.querySelector("#password");
        const confirmPasswordEl = document.querySelector("#password-confirm");
        confirmPasswordEl.addEventListener("keyup", function() {
            console.log({passwordEl});
            console.log(passwordEl.getAttributeNames());
            console.log(passwordEl.attributes);
            if(passwordEl.value === confirmPasswordEl.value) {
                console.log("equal");
            } else {
                console.log("not equal");
            }
        })
    };

    return {
        listeners
    }
})();

Register.listeners();