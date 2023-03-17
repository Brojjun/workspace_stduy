let imgEl = document.querySelector(".img-view>img");
let nameEl = document.querySelector("#foodName");

function changeImg(id) {
    let save = document.getElementById(id);
    imgEl.setAttribute("src", save.src);
    console.dir(save);
    nameEl.innerText = save.title;
}

function randBtn() {
    let rand = Math.floor(Math.random()*(4)+1);
    console.dir(rand);
    changeImg(rand);
}