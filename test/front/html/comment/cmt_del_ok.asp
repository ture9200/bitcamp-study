<!-- #include virtual="/utf8.asp" -->
<!-- #include virtual="/dbopen.asp" -->
<%
Dim sql, rs
Dim page, startpage, page_ea, Stype, Sstring, Sday1, Sday2
Dim idx, cmtIdx, cmtPW, pw
Dim pageUrl, pageName, dbName

page = request("page")
startpage = request("startpage")
page_ea = request("page_ea")
Stype = request("Stype")
Sstring = request("Sstring")

idx = request("idx")
cmtIdx = request("cmtIdx")
cmtPW = request("cmtpw"&cmtIdx)

pageUrl = request("pageUrl")
pageName = request("pageName")
dbName = request("dbName")

sql = "select pw from SG_comment where idx ='" & cmtIdx &"'"
set rs=server.createobject("adodb.recordset")
rs.open sql,db,1

pw = rs("pw")


if cmtPW <> pw then
%>
<script type="text/javascript">
alert("비밀번호가 틀립니다. \n\n다시 확인하세요.")
history.back();
</script>
<%
Else



sql = "delete from SG_comment where idx ='" & cmtIdx &"'"
db.execute sql



db.close
set db = nothing
%>

<script language="javascript">
alert("댓글을 삭제하였습니다.");
location.href="../<%=pageUrl%>/<%=pageName%>_view.asp?idx=<%=idx%>&page=<%=page%>&startpage=<%=startpage%>&page_ea=<%=page_ea%>&Stype=<%=Stype%>&Sstring=<%=Sstring%>"
</script>
<% End If %>
