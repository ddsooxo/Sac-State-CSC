function bigger() {
    document.getElementById("big-button");
    document.getElementById("text-area").style.fontSize = "24pt";
    // alert("hello world!");

}


function fancyText() {
    //alertUser();
    document.getElementById("fancify");
    document.getElementById("text-area").style.fontFamily = "cursive";
    document.getElementById("text-area").style.fontWeight = "bold";
    document.getElementById("text-area").style.color = "blue";
    document.getElementById("text-area").style.backgroundColor = "beige";
    document.getElementById("text-area").style.textDecoration = "underline";

}

function plainText() {
    document.getElementById("plainJane");
    document.getElementById("text-area").style.fontFamily = "inherit";
    document.getElementById("text-area").style.fontSize = "inherit";
    document.getElementById("text-area").style.fontWeight = "inherit";
    document.getElementById("text-area").style.color = "inherit";
    document.getElementById("text-area").style.backgroundColor = "inherit";
    document.getElementById("text-area").style.textTransform = "inherit";
    document.getElementById("text-area").style.textDecoration = "inherit";
}


function moo() {
    document.getElementById("moo-button");
    document.getElementById("text-area").style.textTransform = "uppercase";
    addMoo();
}

function addMoo() {
    var moo = '-Moo';
    var str = document.getElementById("text-area").value;
    // console.log(str);
    var parts = str.split("."); //replaces period character with '-Moo'
    str = parts.join(moo);
    // console.log(str);
    document.getElementById("text-area").value = str + ".";
}

function alertUser() {
    alert("oh so you want to be FancyShmancy huh?!");
}