<!-- #include virtual="/utf8.asp" -->
<!-- #include virtual="/dbopen.asp" -->
<!DOCTYPE html>
<html lang="ko">
	<head>
		<!-- #Include file="../../include/head.asp" -->
	</head>
	<body>
		<div id="wrap">
			<!-- #Include file="../../include/header.asp" -->




			<!-- 컨텐츠 -->
			<div id="content">



				<!-- 비주얼 영역 -->
				<div class="visual-sub-vagas">
					<div class="vsv-copy">
						<h1>고객지원</h1>
						<h2></h2>
					</div>
					<div class="vsv-menu">
						<a href="notice.asp" class="w20p active">공지사항</a>
						<a href="inquiry.asp" class="w20p">상담문의</a>
						<a href="location.asp" class="w20p">오시는길</a>
					</div>
				</div>
				<!-- 비주얼 영역 끝 -->


				<!-- 타이틀 영역 -->
				<div class="title-basic">
					<h1>공지사항</h1>
					<p>&nbsp;</p>
				</div>
				<!-- 타이틀 영역 끝 -->


				<%
					Dim sql, rs
					Dim page_ea, page, startpage, recordcnt, totalpage, endpage, i
					Dim Stype, Sstring
					Dim idx, updateday, openChk, sort, title, writer, hit, fileThumb, fileAttach

					if request("page_ea") = "" then
					page_ea = 10
					else
					page_ea = request("page_ea")
					end if
					if request("page") = "" then
					page = 1
					else
					page=request("page")
					end if
					if request("startpage") = ""then
					startpage=1
					else
					startpage = request("startpage")
					end if

					Stype = request("Stype")
					Sstring = request("Sstring")

					sql = "select idx, updateday, openChk, sort, title, writer, hit, fileThumb, fileAttach from "&dbName&" where noticeChk = 'N'"
					if Stype <> "" then
					sql = sql & " and " & Stype & " like '%" & Sstring & "%'"
					end If
					sql = sql & " order by updateday desc "
					set rs = server.CreateObject("adodb.recordset")
					rs.PageSize = page_ea
					rs.Open sql, db,1
					recordcnt = rs.recordcount
					totalpage = rs.PageCount


					Dim noticeSql, noticeRs

					noticeSql = "select idx, updateday, openChk, sort, title, writer, hit, fileThumb, fileAttach from "&dbName&" where noticeChk = 'Y'"
					noticeSql = noticeSql & " order by updateday desc"
					set noticeRs = server.CreateObject("adodb.recordset")
					noticeRs.Open noticeSql, db,1
				%>


				<!-- 검색 -->
				<form name="searchForm" method="post" action="<%=pageName%>.asp" class="form-inline">
					<fieldset>
						<legend>게시물 검색</legend>
						<div class="search-table">
							<table cellpadding="0" cellspacing="0" summary="게시물 검색하세요.">
								<caption>게시물 검색</caption>
								<colgroup>
									<col width="17%" />
									<col width="*" />
								</colgroup>
								<tr>
									<th>Search</th>
									<td>
										<select name="Stype" class="form-control w20p" title="검색분류">
											 <option value="title" <% If Stype = "title" Then %>selected="selected"<% End If %>>제목</option>
											 <option value="writer" <% If Stype = "writer" Then %>selected="selected"<% End If %>>작성자</option>
										</select>
										<input type="text" name="Sstring" title="검색어" value="<%=Sstring%>" class="form-control w70p" placeholder="검색어를 입력하세요." />
										<input type="submit" name="검색" value="검색" class="btn btn-dark btn-rdzero" title="검색" />
									</td>
								</tr>
							</table>
						</div>
					</fieldset>
				</form>
				<!-- 검색 끝 -->


				<!-- 리스트정보 -->
				<dl class="list-info">
					<dt>총 <strong><%= recordcnt%></strong> 개 / &nbsp;현재페이지 : <strong>[<%=page%>/<%=totalpage%>]</strong></dt>
					<dd>상단의 <strong>검색창</strong>을 이용하여 검색하세요.</dd>
				</dl>
				<!-- 리스트정보 끝 -->


				<!-- 리스트 -->
				<div class="list-notice">
					<% if noticeRs.BOF or noticeRs.EOF then %>
					<%
						else

						do until noticeRs.EOF

						idx = noticeRs("idx")
						updateday = Left(noticeRs("updateday"),10)
						openChk = noticeRs("openChk")
						sort = noticeRs("sort")
						title = noticeRs("title")
						writer = noticeRs("writer")
						hit = noticeRs("hit")
						fileThumb = noticeRs("fileThumb")
						fileAttach = noticeRs("fileAttach")

						Dim fileExt
						fileExt = Mid(fileAttach, InStrRev(fileAttach, ".") + 1)
					%>
					<div>
						<ul onclick="location.href='<%=pageName%>_view.asp?idx=<%=idx%>&page=<%=page%>&startpage=<%=startpage%>&page_ea=<%=page_ea%>&Stype=<%=Stype%>&Sstring=<%=Sstring%>';" class="active">
							<li><em>공지</em></li>
							<li>
								<em>공지</em>
								<a href="#none"><!-- <span>[<%=sort%>]</span>  --><%=title%></a>
								<% if datediff("h", updateday, now()) < 24 then%><img src="../../images/btnIcn/icn_new2.png" height="22" alt="" title="" /><% end if %>
							</li>
							<li><%=updateday%></li>
							<li><i class="xi-plus"></i></li>
						</ul>
					</div>
					<%
						noticeRs.MoveNext
						loop
						end If

						noticeRs.close
						set noticeRs=Nothing
					%>


					<% if rs.BOF or rs.EOF then %>
					<div class="list-no">
						<p><img src="../../images/btnIcn/icn_big_listNo.png" alt="" title="" /></p>
						<h1>목록이 없습니다.</h1>
					</div>
					<%
						else

						rs.AbsolutePage = page

						endpage = startpage + 9
						if endpage > rs.PageCount then
						endpage = rs.PageCount
						end if

						n = recordcnt - (page-1) * rs.PageSize

						i=1
						do until rs.EOF or i>rs.pagesize

						idx = rs("idx")
						updateday = Left(rs("updateday"),10)
						openChk = rs("openChk")
						sort = rs("sort")
						title = rs("title")
						writer = rs("writer")
						hit = rs("hit")
						fileThumb = rs("fileThumb")
						fileAttach = rs("fileAttach")

						fileExt = Mid(fileAttach, InStrRev(fileAttach, ".") + 1)
					%>
					<div>
						<ul onclick="location.href='<%=pageName%>_view.asp?idx=<%=idx%>&page=<%=page%>&startpage=<%=startpage%>&page_ea=<%=page_ea%>&Stype=<%=Stype%>&Sstring=<%=Sstring%>';">
							<li><%=n%></li>
							<li>
								<a href="#none"><!-- <span>[<%=sort%>]</span>  --><%=title%></a>
								<% if datediff("h", updateday, now()) < 24 then%><img src="../../images/btnIcn/icn_new2.png" height="22" alt="" title="" /><% end if %>
							</li>
							<li><%=updateday%></li>
							<li><i class="xi-plus"></i></li>
						</ul>
					</div>
					<%
						n=n-1
						i=i+1
						rs.MoveNext
						loop
						end if
					%>
				</div>
				<!-- 리스트 끝 -->


				<!-- 페이징 -->
				<div class="list-paging">
					<% if cint(startpage)<>cint(1) then%>
					<a href="<%=pageName%>.asp?page=<%=startpage-10%>&startpage=<%=startpage-10%>&page_ea=<%=page_ea%>&Stype=<%=Stype%>&Sstring=<%=Sstring%>"><img src="/images/bbs/btn_numPrev.gif" alt="" /></a>
					<%end if%>
					<% for i = startpage to endpage step 1 %>
					<% if cint(i) = cint(page) then%>
					<a href="#"><span class="on"><%=i%></span></a>
					<%else%>
					<a href="<%=pageName%>.asp?page=<%=i%>&startpage=<%=startpage%>&page_ea=<%=page_ea%>&Stype=<%=Stype%>&Sstring=<%=Sstring%>"><span><%=i%></span></a>
					<% end if %>
					<% next%>
					<% if cint(endpage)<>cint(rs.PageCount) then%>
					<a href="<%=pageName%>.asp?page=<%=startpage+10%>&startpage=<%=startpage+10%>&page_ea=<%=page_ea%>&Stype=<%=Stype%>&Sstring=<%=Sstring%>"><img src="/images/bbs/btn_numNext.gif" alt="" /></a>
					<% end if %>
				</div>
				<!-- 페이징 끝 -->


				<%
					rs.close
					db.close
					set rs=nothing
					set db = nothing
				%>



			</div>
			<!-- 컨텐츠 끝 -->




			<!-- #Include file="../../include/footer.asp" -->
		</div>
	</body>
</html>
