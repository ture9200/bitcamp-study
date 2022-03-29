<!-- #include virtual="/utf8.asp" -->
<!-- #include virtual="/dbopen.asp" -->
<%
Dim uploadform

Set uploadform = Server.CreateObject("DEXT.FileUpload")
uploadform.DefaultPath = server.mappath("/") & "\data\inquiry"
uploadform.MaxFileLen = 5242880



' 정보받기 =================================================================================
Dim sql
Dim dayChk, language, name, mobile, email, sort, title, memo

dayChk = Date()
language = "국문"
name = uploadform("name")
mobile = uploadform("mobile1")&"-"&uploadform("mobile2")&"-"&uploadform("mobile3")

if uploadform("email3") = "" then
email = uploadform("email1")&"@"&uploadform("email2")
else
email = uploadform("email1")&"@"&uploadform("email3")
end If

sort = uploadform("sort")
title = uploadform("title")

memo = uploadform("memo")
memo = Replace(memo,"'","")
memo = Replace(memo,"&","&amp")
memo = Replace(memo,"""","&#34;")
memo = Replace(memo,"<","&lt")
memo = Replace(memo,">","&gt")
memo = Replace(memo,chr(13)&chr(10),"<br>")



' 용량체크 =================================================================================
Dim f, fileChkName

For f= 1 To uploadform("files").Count

	fileChkName = uploadform("files")(f).FileName

	If fileChkName <> "" Then

		If uploadform("files")(f).FileLen > uploadform.MaxFileLen Then
		%>
		<script type="text/javascript">
		alert("첨부파일 용량이 5메가를 초과하였습니다. 다시 등록하세요.");
		history.back();
		</script>
		<%
		Response.End
		End If

	End If

Next



'파일첨부 ============================================================================
Dim fileName, filePath, fileNameOnly, fileExt, i, j, chgExt

For j= 1 To uploadform("files").Count

	fileName = uploadform("files")(j).FileName
	'If fileName <> "" Then
	'	chgExt = mid(fileName,instrrev(fileName,".")+1)
	'	fileName = "notice_"&primaryval&"."&chgExt
	'End If
	filePath = uploadform.DefaultPath & "\" & fileName

	If filename <> "" Then

		If uploadform.FileExists(filePath) Then

			If InStrRev(fileName, ".") <> 0 Then
				fileNameOnly = Left(fileName, InStrRev(fileName, ".") - 1)
				fileExt = Mid(fileName, InStrRev(fileName, "."))
			 Else
				fileNameOnly = fileName
				fileExt = ""
			 End If

			 i = 2
			Do While (1)
				filePath = uploadform.DefaultPath & "\" & fileNameOnly & "[" & i & "]" & fileExt
				fileName = fileNameOnly & "[" & i & "]" & fileExt
				If Not uploadform.FileExists(filePath) Then Exit Do
				i = i + 1
			Loop

		End If

		uploadform("files")(j).SaveAs filePath

	End If

	if j = 1 then
	fileAttach = fileName
	end if

Next



'DB등록 =================================================================================
sql="insert into SG_inquiry (updateday, dayChk, language, name, mobile, email, sort, title, memo, fileAttach) values"
sql=sql & "(getdate(),'"
sql=sql & dayChk &"','"
sql=sql & language &"','"
sql=sql & name &"','"
sql=sql & mobile&"','"
sql=sql & email&"','"
sql=sql & sort&"','"
sql=sql & title&"','"
sql=sql & memo&"','"
sql=sql & fileAttach &"')"
db.execute sql
'Response.Write sql



Set uploadform = Nothing
Db.Close
Set Db = Nothing
%>
<script type="text/javascript">
alert("상담문의 접수되였습니다.\n담당자 확인 후 답변드리겠습니다.");
window.location.href='inquiry.asp';
</script>
