console.log("script loaded");
// get theme from local storage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

// set theme to local storage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

let currTheme = getTheme();
//  initailly

document.addEventListener('DOMContentLoaded', () =>{
    changeTheme();
})


// todo
function changeTheme() {
  // set to webpage
  changePageTheme(currTheme, currTheme);
  // set the listener to change theme button
  const changeThemeButton = document.querySelector("#theme-change-button");
  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currTheme;
    if (currTheme == "dark") {
      currTheme = "light";
    } else {
      currTheme = "dark";
    }
    changePageTheme(currTheme, oldTheme);
  });
}
// change current page theme
function changePageTheme(theme, oldTheme) {
  //updating local storage
  setTheme(currTheme);
  // 1. remove the currtheme
  document.querySelector("html").classList.remove(oldTheme);
  // 2. set the currrtheme
  document.querySelector("html").classList.add(theme);
  // change the text of button
  //   const changeThemeButton = document.querySelector('#theme-change-button')
  document
    .querySelector("#theme-change-button")
    .querySelector("span").textContent = theme == "light" ? "dark" : "light";
}
