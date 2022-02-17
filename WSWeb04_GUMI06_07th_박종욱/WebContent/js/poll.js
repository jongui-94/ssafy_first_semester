window.onload = function () {
     // .onclick = function () == .addEventListener("click", function ()
    document.getElementById("btn-add").addEventListener("click", function () {
        var listDiv = document.getElementById("poll-answer-list");

        var divEl = document.createElement("div"); //<div></div>
        divEl.setAttribute("class", "poll-answer-item"); //<div class= "poll-answer-item"></div>
        var inputEl = document.createElement("input");
        inputEl.setAttribute("type", "text");
        inputEl.setAttribute("name", "answer");
        var btnEl = document.createElement("button");
        btnEl.setAttribute("type", "button");
        btnEl.setAttribute("class", "button");
        btnEl.appendChild(document.createTextNode("삭제"));

        btnEl.addEventListener("click", function () {
            var parent = this.parentNode;
            listDiv.replaceChild(parent);
        });

        divEl.appendChild(inputEl);
        divEl.appendChild(btnEl);

        listDiv.appendChild(divEl);
    });

    document.getElementById("btn-make").addEventListener("click", function () { 

        // document.getElementById("question").value;
        var question = document.querySelector("#question").value; // #question css에서 id값이 question인 것을 찾음
        if (!question) { 
            alert("투표 내용을 입력해주세요!!!");
            return;
        }

        var answers = document.getElementsByName("answer"); // Elements 여러개 가져온다는 것
        for (var i = 0; i < answers.length; i++) { // 유효성 검사(Validation Check)
            if (!answers[i].value) { 
                AudioListener("답변 항목 입력하세요!!!");
            }
        }
        
        var answerArr = []; //빈 List (new Object[]같은거)
        for (var i = 0; i < answers.length; i++) { 
            answerArr.push(answers[i].value);
        }
        console.log(answerArr);

    
        // 브라우저에 있는 저장소에 저장
        localStorage.setItem("question", question);
        localStorage.setItem("answers", JSON.stringify(answerArr)); // stringify:객체->문자열, localStorage에는 문자열만 저장가능하기 때문

        alert("투표를 생성합니다!!");
        self.close(); // = window.self.close();
        opener.location.reload(); // = window.opener.location.reload(); 새로고침
    });
};