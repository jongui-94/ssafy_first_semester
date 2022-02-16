window.onload = function () {

    var isLogin;
    var userid;
    var userpw;
    var loginBtn = document.getElementById("login");
    var signupBtn = document.getElementById("signup");
    var logoutBtn = document.getElementById("logout");
    var mypageBtn = document.getElementById("mypage");
    var adminBtn = document.getElementById("admin");
    var profileImg = document.getElementById("profile_img");

    var isOpened = true;
    var allOpen = document.getElementById("allOpen");
    var seoul = document.getElementById("seoul");
    var daejeon = document.getElementById("daejeon");
    var gumi = document.getElementById("gumi");
    var guangju = document.getElementById("guangju");
    var seoulList = document.getElementById("seoulList");
    var daejeonList = document.getElementById("daejeonList");
    var gumiList = document.getElementById("gumiList");
    var guangjuList = document.getElementById("guangjuList");
    var allOpenList = document.getElementsByClassName("store_list");

    adminBtn.onclick = function () { openAdmin() };
    allOpen.onclick = function () { OpenClick(allOpen.id) };
    seoul.onclick = function () { OpenClick(seoul.id) };
    daejeon.onclick = function () { OpenClick(daejeon.id) };
    gumi.onclick = function () { OpenClick(gumi.id) };
    guangju.onclick = function () { OpenClick(guangju.id) };

    function openAdmin() {
        window.open("./makepoll.html", "mp", "width=500, height=500, top=0, left=0");
    }

    document.getElementById("login").addEventListener("click", function () {
        userid = prompt("아이디입력", "아이디를 입력하세요");
        if (userid == "ssafy") {
            userpw = prompt("비밀번호입력", "비밀번호 입력하세요");
            if (userpw == "1234") {
                alert("로그인 성공!!!");
                changepage();
            }
        }
    });

    document.getElementById("logout").addEventListener("click", function () {
        logout();
    })

    function changepage() {
        isLogin = checkLogin();

        if (!isLogin) {
            loginBtn.style.display = "inline";
            signupBtn.style.display = "inline";
            logoutBtn.style.display = "none";
            mypageBtn.style.display = "none";
            adminBtn.style.display = "none";
            profileImg.src = "img/noimg.png";
        }
        else {
            loginBtn.style.display = "none";
            signupBtn.style.display = "none";
            logoutBtn.style.display = "inline";
            mypageBtn.style.display = "inline";
            adminBtn.style.display = "inline";
            profileImg.src = "img/profile.png";
        }
    }

    function checkLogin() {
        if (userid == "ssafy" && userpw == "1234") {
            return true;
        }
        else {
            return false;
        }
    }

    function logout() {
        userid = null;
        userpw = null;
        changepage();
    }

    function changeAllOpenState() {
        for (let i = 0; i < allOpenList.length; i++){
            //하나라도 닫혀있는 경우 펼치기
            if (allOpenList[i].style.display == "none") {
                isOpened = false;
                allOpen.textContent = "전국매장펼치기";
                return;
            }
        }
        isOpened = true;
        allOpen.textContent = "전국매장접기";
    }


    //Open
    function changeOpenState(regionWrap) {
        //단일 요소인 경우 각 지역
        if (regionWrap.id != undefined){
            if (regionWrap.style.display == "none") {
                regionWrap.style.display = "block";
                changeAllOpenState();
            }
            else {
                regionWrap.style.display = "none";
                changeAllOpenState();
            }
        }
        //리스트인 경우 allOpen
        else {
            if (isOpened) {
                isOpened = false;
                allOpen.textContent = "전국매장펼치기";
                for (let i = 0; i < regionWrap.length; i++){
                    regionWrap[i].style.display = "none";
                }
            }
            else {
                isOpened=true;
                allOpen.textContent = "전국매장접기";
                for (let i = 0; i < regionWrap.length; i++){
                    regionWrap[i].style.display = "block";
                } 
            }
        }
    }

    //Open
    function OpenClick(clickedId) {
        switch (clickedId) {
            case "allOpen":
                changeOpenState(allOpenList);
                break;
            case "seoul":
                changeOpenState(seoulList);
                break;
            case "daejeon":
                changeOpenState(daejeonList);
                break;
            case "gumi":
                changeOpenState(gumiList);
                break;
            case "guangju":
                changeOpenState(guangjuList);
                break;
        }
    }


};