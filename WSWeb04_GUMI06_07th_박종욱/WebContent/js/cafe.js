window.onload = function () {

    var signIn = document.getElementById("sign-in");
    var signUp = document.getElementById("sign-up");
    var logout = document.getElementById("logout");
    var mypage = document.getElementById("mypage");
    var manager = document.getElementById("manager");
    var noprofile = document.getElementById("no-profile");
    var profile = document.getElementById("profile");

    // 로그인
    document.getElementById("sign-in").addEventListener("click", function () {
        var id = prompt("아이디 입력");
        var password = prompt("비밀번호 입력");

        if (id == "ssafy" && password == "1234") { 
            alert("로그인 성공!");
            signIn.style.display = "none";
            signUp.style.display = "none";
            logout.style.display = "";
            mypage.style.display = "";
            manager.style.display = "";
            noprofile.style.display = "none";
            profile.style.display = "";
        }
    });


    var openList = document.getElementById("open-store-list");
    var closeList = document.getElementById("close-store-list");
    var seoulSpot = document.getElementById("seoul-spot");
    var daejeonSpot = document.getElementById("daejeon-spot");
    var gumiSpot = document.getElementById("gumi-spot");
    var gwangjuSpot = document.getElementById("gwangju-spot");

    // 전국매장펼치기
    document.getElementById("open-store-list").addEventListener("click", function () {
        openList.style.display = "none";
        closeList.style.display = "";
        seoulSpot.style.display = "";
        daejeonSpot.style.display = "";
        gumiSpot.style.display = "";
        gwangjuSpot.style.display = "";
    });
     // 전국매장접기
    document.getElementById("close-store-list").addEventListener("click", function () {
        openList.style.display = "";
        closeList.style.display = "none";
        seoulSpot.style.display = "none";
        daejeonSpot.style.display = "none";
        gumiSpot.style.display = "none";
        gwangjuSpot.style.display = "none";
    });

    // 특정지역매장펼치기&접기
    document.getElementById("seoul").addEventListener("click", function () {
        if (seoulSpot.style.display == "none") {
            seoulSpot.style.display = "";
        } else { 
            seoulSpot.style.display = "none";
        }
    });
    document.getElementById("daejeon").addEventListener("click", function () {
        if (daejeonSpot.style.display == "none") {
            daejeonSpot.style.display = "";
        } else { 
            daejeonSpot.style.display = "none";
        }
    });
    document.getElementById("gumi").addEventListener("click", function () {
        if ( gumiSpot.style.display == "none") {
            gumiSpot.style.display = "";
        } else { 
            gumiSpot.style.display = "none";
        }
    });
    document.getElementById("gwangju").addEventListener("click", function () {
        if (gwangjuSpot.style.display == "none") {
            gwangjuSpot.style.display = "";
        } else { 
            gwangjuSpot.style.display = "none";
        }
    });
    // 관리자 메뉴 클릭 시
    document.getElementById("manager").addEventListener("click", function () {
        window.open("./makepoll.html", "mp", "width=500, height=200, top=0px, left=300");
    });
};