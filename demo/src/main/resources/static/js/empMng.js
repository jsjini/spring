// var empService = return { infoReq, saveReq, listReq }
var empService = (function(){ 

// 리스트 요청
async function listReq(p) {
	const param = "?page=" + p;
	/*fetch("/ajax/empList" + param)
	.then(res => res.json())
	.then(res => listRes(res))*/
	
	// 비동기
	// axios.get("/ajax/empList" + param)
	// .then(res => listRes(res.data))
	
	// 동기식
	const res = await axios.get("/ajax/empList" + param);
	listRes(res.data);
}

// 리스트 응답
function listRes(res) {
	empList.innerHTML = '';
	nav.innerHTML = '';
	let i = 0;
	// 목록출력
	for( obj of res.data ) {
		empList.innerHTML += makeTr(++i, obj);
	}
	// 페이징처리
	nav.innerHTML += makePage(res.paging);
}

// 페이징생성
function makePage(paging) {
	let tag = `<nav aria-label="...">
		  <ul class="pagination">`
	// 이전버튼
	if(paging.startPage > 1) {
	  tag += `<li class="page-item">
	        <a class="page-link" href="javascript:gopage(${paging.startPage-1})">Previous</a></li>`
	}
	// 페이지번호
	for(i = paging.startPage; i<=paging.endPage; i++) {
		tag += `<li class="page-item">
	        <a class="page-link" href="javascript:gopage(${i})">${i}</a></li>`
	}
	// 다음버튼
	if(paging.endPage <= paging.lastPage) {
		tag += `<li class="page-item">
	        <a class="page-link" href="javascript:gopage(${paging.endPage+1})">Next</a></li>`
	}
	
	tag += ` </ul>
		</nav>`
		
	return tag;
}

// tr생성
function makeTr(i, obj) {
	let bonusBtn = '<button>신청</button>';
	if(obj.salary > 10000) {
		bonusBtn = '<button>미신청</button>';
	}
	let newTag = `<tr>
		<td>${++i}</td>
		<td onclick="infoReq(${obj.employeeId})">${obj.employeeId}</td>
		<td>${obj.firstName} ${obj.lastName}</td>
		<td>${obj.hireDate}</td>
		<td>${obj.salary}</td>
		<td>${bonusBtn}</td>
		<td><button type="button" onclick="move(${obj.employeeId})">조회</button></td>
	</tr>`
	return newTag;
}
			
// 등록 요청
function saveReq() {
	const lastName=frm.lastName.value;
	const email=frm.email.value;
	const jobId=frm.jobId.value;
	const hireDate=frm.hireDate.value;
	let param = {lastName, email, jobId, hireDate }
	/*fetch("/ajax/emp",{
		method : "post",
		headers: {
		      "Content-Type": "application/json",
		    },
		body : JSON.stringify(param)
	})
	.then(res => res.json())
	.then(res => saveRes(res))*/
	
	axios.post("/ajax/emp", param)
	.then(res => saveRes(res.data))
	
}

// 등록 응답
function saveRes(res) {
	listReq(1);
}

// 상세조회 요청
function infoReq(employeeId) {
	fetch("/ajax/emp/" + employeeId)
	.then(res => res.json())
	.then(res => infoRes(res))
}

// 상세조회 응답
function infoRes(res) {
	// input tag에 표시
	frm.lastName.value = res.lastName;
	frm.email.value = res.email;
	frm.jobId.value = res.jobId;
	frm.hireDate.value = res.hireDate;
	
}

// 포맷
function dateFormat(dt) {
	const date = new Date(dt);
	let year = date.getFullYear(dt);
	let month = ('0' + (date.getMonth(dt) + 1)).slice(-2);
	let day = ('0' + date.getDate(dt)).slice(-2);
	let dateStr = `${year}-${month}-${day}`;

	return dateStr;
}

return {
	infoReq,
	saveReq,
	listReq
}
})();