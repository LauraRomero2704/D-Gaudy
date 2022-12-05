let aside = document.querySelector(".aside");
let closeBtn = document.querySelector("#btn");

closeBtn.addEventListener("click", ()=>{
  aside.classList.toggle("closed");
  menuBtnChange();//calling the function(optional)
});

// following are the code to change aside button(optional)
function menuBtnChange() {
 if(aside.classList.contains("closed")){
   closeBtn.classList.replace("bx-menu-alt-right", "bx-menu");//replacing the iocns class
 }else {
   closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");//replacing the iocns class
 }
};
