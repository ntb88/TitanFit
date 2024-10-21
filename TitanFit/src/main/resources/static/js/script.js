function handleRedirect(){
    const currentURL = window.location.href;
    const baseURL = window.location.origin;

    console.log("Current URL: ", currentURL);
    console.log("Base URL: ", baseURL);

    if(currentURL.includes("/admin")){
        window.location.assign(baseURL+"/admin");
    } else if (currentURL.includes("/user")){
        window.location.assign(baseURL+"/user");
    }
}