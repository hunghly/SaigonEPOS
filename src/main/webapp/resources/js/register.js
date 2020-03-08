(()=> {
    const listeners = () => {
        const passwordEl = document.querySelector("#password");
        const confirmPasswordEl = document.querySelector("#password-confirm");
        const matchFlagEl = document.querySelector(".match-flag");
        const registerBtnEl = document.querySelector(".register-btn");

        confirmPasswordEl.addEventListener("keyup", function() {
            if(passwordEl.value === confirmPasswordEl.value) {
                matchFlagEl.classList.add("invisible");
                registerBtnEl.removeAttribute("disabled");
            } else {
                matchFlagEl.classList.remove("invisible");
                registerBtnEl.setAttribute("disabled", "true");
            }
        })
    };

    listeners();
})();