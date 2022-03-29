<!-- #include virtual="/utf8.asp" -->
<!-- #include virtual="/dbopen.asp" -->
<%
Dim sql, rs
Dim page, startpage, page_ea, Stype, Sstring
Dim bbsIdx, writer, pw, memo
Dim pageUrl, pageName, dbName

page = request("page")
startpage = request("startpage")
page_ea = request("page_ea")
Stype = request("Stype")
Sstring = request("Sstring")

bbsIdx = request("bbsIdx")
writer = request("writer")
pw = request("pw")
memo = request("memo")

pageUrl = request("pageUrl")
pageName = request("pageName")
dbName = request("dbName")

sql="insert into SG_comment (updateday, bbsIdx, bbsName, writer, pw, memo) values"
sql=sql & "(getdate(),'"
sql=sql & bbsIdx &"','"
sql=sql & dbName &"','"
sql=sql & writer &"','"
sql=sql & pw &"','"
sql=sql & memo &"')"
'Response.Write sql
db.execute sql



db.close
set db = nothing
%>

<script language="javascript">
alert("댓글을 등록하였습니다.");
location.href="../<%=pageUrl%>/<%=pageName%>_view.asp?idx=<%=bbsIdx%>&page=<%=page%>&startpage=<%=startpage%>&page_ea=<%=page_ea%>&Stype=<%=Stype%>&Sstring=<%=Sstring%>"
</script>
