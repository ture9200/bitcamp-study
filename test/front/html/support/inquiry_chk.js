//상담문의 ///////////////////////////////////////////////////////////////////////////////////////////////////////
function writeChk()
{
var str;

str=document.writeForm.agreeChk[1].checked;
if (str==true) {
				alert("개인정보에 동의 하셔야 등록이 가능합니다.");
				document.writeForm.agreeChk[0].focus();
				return;
				}

str=document.writeForm.name.value;
if (str=="") {
				alert("성명을 기입하여주세요.");
				document.writeForm.name.focus();
				return;
				}

str=document.writeForm.mobile1.value;
if (str=="") {
				alert("연락번호를 선택하여주세요.");
				document.writeForm.mobile1.focus();
				return;
				}

str=document.writeForm.mobile2.value;
if (str=="") {
				alert("연락번호를 기입하여주세요.");
				document.writeForm.mobile2.focus();
				return;
				}

str=document.writeForm.mobile3.value;
if (str=="") {
				alert("연락번호를 기입하여주세요.");
				document.writeForm.mobile3.focus();
				return;
				}

if (document.writeForm.email1.value=="") {
					alert("이메일주소를 기입해 주십시요");
					document.writeForm.email1.focus();
					return;
					}
if (document.writeForm.email2.value=="" && document.writeForm.email3.value == "") {
											alert("이메일주소를 기입해 주십시요");
											document.writeForm.email2.focus();
											return;
											}
if (document.writeForm.email3.value != "")
      {var email = document.writeForm.email1.value + "@" + document.writeForm.email3.value;}
else
      {var email = document.writeForm.email1.value + "@" + document.writeForm.email2.value;}

if(!checkEmail(email))
{
	alert("올바른 E-Mail형식이 아닙니다.");
	document.writeForm.email1.focus();
	document.writeForm.email1.value = "";
	document.writeForm.email2.value = "";
	return;
}


str=document.writeForm.title.value;
if (str=="") {
				alert("제목을 기입하여주세요.");
				document.writeForm.title.focus();
				return;
				}

str=document.writeForm.memo.value;
if (str=="") {
				alert("문의내용을 기입하여주세요.");
				document.writeForm.memo.focus();
				return;
				}

// 첨부파일 확장자
if( $("#fileExt1").val() != "" ){
	var ext = $('#fileExt1').val().split('.').pop().toLowerCase();
	if($.inArray(ext, ['gif','png','jpg','hwp','zip','doc','docx','ppt','pptx','xls','xlsx','pdf']) == -1) {
		alert('일부 특정파일은 등록할수 없습니다.');
		return;
	}
}


document.writeForm.action = "inquiry_ok.asp"
document.writeForm.submit();
return;
}





//옵션 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//숫자만 입력받기
function suChk(su){
var Str,suLen,suOk;
Str = "0123456789";
suLen = su.value.length;
suOk = 0;

for(var j=0; j < suLen; j++){
	for(var i=0; i < Str.length; i++){
		if(su.value.charAt(j) == Str.charAt(i)){
			suOk++;
		}
	}
}

if(suOk != su.value.length){
//			return false;
	alert("숫자로 입력하세요!");
	su.value = "";
	su.focus();
}
else{
//			return true;
}
}


//이메일 선택 함수
function checkEmail(str)
{
	var point	=	"\.";
	var pcnt	= 0;
	var reg = /^((\w|[\-\_])+)@((\w|[\-\.])+)\.([A-Za-z]+)$/;

	if (str.search(reg) != -1) {
		for(var inx=0; inx < str.length;inx++)
		{
			if(point.indexOf(str.charAt(inx)) != -1)
			{
				pcnt++;
			}
		}
		if(pcnt<=2)
		{
			return true;
		}
	}
	return false;
}


function emailChk(val)
{
	if(val != "")
	{
		document.writeForm.email2.value = val;
		document.writeForm.email2.disabled = true;
	} else {
		document.writeForm.email2.value = "";
		document.writeForm.email2.disabled = false;
	}
}
