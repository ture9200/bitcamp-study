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
					Dim page, startpage, page_ea, Stype, Sstring
					Dim idx, updateday, noticeChk, sort, title, writer, hit, pw, memo, fileThumb, fileAttach

					page = request("page")
					startpage = request("startpage")
					page_ea = request("page_ea")
					Stype = request("Stype")
					Sstring = request("Sstring")
					idx = request("idx")

					SQL = "Update "&dbName&" Set hit = hit + 1"
					SQL = SQL & " Where idx = " & idx
					db.Execute SQL

					sql = "select idx, updateday, noticeChk, sort, title, writer, hit, pw, memo, fileThumb, fileAttach from "&dbName&" where idx='"&idx&"'"
					set rs=server.createobject("adodb.recordset")
					rs.open sql,db,1

					idx = rs("idx")
					updateday = Left(rs("updateday"),10)
					title = rs("title")
					noticeChk = rs("noticeChk")
					sort = rs("sort")
					writer = rs("writer")
					pw = rs("pw")
					hit = rs("hit")
					memo = rs("memo")
					fileThumb = rs("fileThumb")
					fileAttach = rs("fileAttach")


					Dim prs, nrs
					Dim prev_idx, prev_title, next_idx, next_title

					'이전 글의 board_idx 값을 구하는 부분
					Set prs = Server.CreateObject("Adodb.RecordSet")
					sql = "Select idx, title from "&dbName&" where idx = (select Max(idx) from "&dbName&" where idx < '"&idx&"') "
					prs.open sql, db, 1
					if Not prs.eof Then
					prev_idx = prs("idx")
					prev_title = prs("title")
					end If

					'다음 글의 board_idx 값을 구하는 부분
					Set nrs = Server.CreateObject("Adodb.RecordSet")
					sql = "Select idx, title from "&dbName&" where idx = (select Min(idx) from "&dbName&" where idx > '"&idx&"') "
					nrs.open sql, db, 1
					if Not nrs.eof then
					next_idx = nrs("idx")
					next_title = nrs("title")
					end If


					'SNS관련
					Dim snsUrl, memoSNS

					memoSNS = rs("memo")
					snsUrl = Request.ServerVariables("SERVER_NAME") & Request.ServerVariables("PATH_INFO")

					Function RemoveHTML( strText )
						dim tagfree
						set tagfree = New Regexp
						tagfree.Pattern= "<[^>]+>"
						tagfree.Global=true
						strText=tagfree.Replace(strText,"")
						RemoveHTML= strText
					End Function

					memoSNS = RemoveHTML(memoSNS)

					If Len(memoSNS) > 150 Then
					memoSNS = Mid(memoSNS,1,150)&"..."
					End If

					Dim fileExt
					fileExt = Mid(fileAttach, InStrRev(fileAttach, ".") + 1)


					rs.close
					set rs=nothing
					prs.close
					set prs=nothing
					nrs.close
					set nrs=Nothing
				%>


				<!-- SNS관련 -->
				<meta property="og:title" content="<%=title%>"/>
				<meta property="og:url" content="http://<%=snsUrl%>?idx=<%=idx%>"/>
				<meta property="og:image" content=""/>
				<meta property="og:description" content="<%=memoSNS%>"/>
				<meta property="og:article:author" content=""/>

				<meta name="twitter:card" content="summary">
				<meta name="twitter:url" content="http://<%=snsUrl%>?idx=<%=idx%>">
				<meta name="twitter:title" content="<%=title%>">
				<meta name="twitter:description" content="<%=memoSNS%>">
				<meta name="twitter:image" content="">

				<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
				<script>
					function snsfacebook(url){
						window.open("http://www.facebook.com/sharer/sharer.php?u="+url+"", "페이스북 공유", "width=555, height=525, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );
					}

					function snstwitter(){
						var content = "<%=title%>\r\n\r\n";
						var link = "http://<%=snsUrl%>?idx=<%=idx%>";
						var popOption = "width=640, height=440, resizable=no, scrollbars=no, status=no;";
						var wp = window.open("http://twitter.com/share?url=" + encodeURIComponent(link) + "&text=" + encodeURIComponent(content), 'twitter', popOption);
						if ( wp ) {
							wp.focus();
						}
					}

					function snskakaostory(url){
						window.open("https://story.kakao.com/share?url="+url+"", "카카오스토리 공유", "width=555, height=525, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );
					}
				</script>
				<!-- SNS관련 끝 -->


				<!-- 상세 -->
				<div class="view-area">
					<div class="va-info">
						<p>
							<% If noticeChk = "Y" Then %>
							<em>공지</em>
							<% End If %>
							<!-- <span>[<%=sort%>]</span>  --><%=title%>
						</p>
						<div>
							<span>Writer.</span> 관리자<!-- <%=writer%> --> &nbsp; / &nbsp;
							<span>Data.</span> <%=updateday%> &nbsp; / &nbsp;
							<span>Hit.</span> <%=hit%>
						</div>
						<% If fileAttach <> "" Then %>
						<h1>
							<span>File.</span>
							<% If fileExt = "gif" Then %>
							<img src="../../images/fileIcn/gif.gif" alt="" title="" />
							<% ElseIf fileExt = "png" Then %>
							<img src="../../images/fileIcn/png.gif" alt="" title="" />
							<% ElseIf fileExt = "jpg" Then %>
							<img src="../../images/fileIcn/jpg.gif" alt="" title="" />
							<% ElseIf fileExt = "hwp" Then %>
							<img src="../../images/fileIcn/hwp.gif" alt="" title="" />
							<% ElseIf fileExt = "zip" Then %>
							<img src="../../images/fileIcn/zip.gif" alt="" title="" />
							<% ElseIf fileExt = "doc" Then %>
							<img src="../../images/fileIcn/doc.gif" alt="" title="" />
							<% ElseIf fileExt = "docx" Then %>
							<img src="../../images/fileIcn/doc.gif" alt="" title="" />
							<% ElseIf fileExt = "ppt" Then %>
							<img src="../../images/fileIcn/ppt.gif" alt="" title="" />
							<% ElseIf fileExt = "pptx" Then %>
							<img src="../../images/fileIcn/ppt.gif" alt="" title="" />
							<% ElseIf fileExt = "xls" Then %>
							<img src="../../images/fileIcn/xls.gif" alt="" title="" />
							<% ElseIf fileExt = "xlsx" Then %>
							<img src="../../images/fileIcn/xls.gif" alt="" title="" />
							<% ElseIf fileExt = "pdf" Then %>
							<img src="../../images/fileIcn/pdf.gif" alt="" title="" />
							<% End If %>
							<a href="/data/<%=fileFolder%>/<%=fileAttach%>"><strong><%=fileAttach%></strong></a>
						</h1>
						<% End If %>
					</div>

					<div class="va-ctn">
						<div class="mt50"><%=memo%></div>
					</div>

					<dl class="va-btn">
						<dt>
							<!-- <a href="javascript:snsfacebook('http://<%=snsUrl%>?idx=<%=idx%>');"><img src="../../images/btnIcn/btn_facebook.gif" alt="" title="" /></a>
							<a href="javascript:snstwitter('<%=title%>', 'http://<%=snsUrl%>?idx=<%=idx%>');"><img src="../../images/btnIcn/btn_twitter.gif" alt="" title="" /></a>
							<a href="javascript:snskakaostory('http://<%=snsUrl%>?idx=<%=idx%>');"><img src="../../images/btnIcn/btn_kakao.gif" alt="" title="" /></a> -->
						</dt>
						<dd>
							<a href="<%=pageName%>.asp?page=<%=page%>&startpage=<%=startpage%>&page_ea=<%=page_ea%>&Stype=<%=Stype%>&Sstring=<%=Sstring%>" class="btn btn-dark btn-rdzero w90"><i class="fa fa-list" aria-hidden="true"></i> 목록</a>
						</dd>
					</dl>

					<div class="va-pn">
						<table cellpadding="0" cellspacing="0" summary="">
							<caption>이전글/다음글</caption>
							<colgroup>
								<col width="120px" />
								<col width="*" />
							</colgroup>
							<tr>
								<th><img src="../../images/btnIcn/icn_prev.gif" alt="" title="" /> 이전글</th>
								<td>
									<% If prev_title <> "" Then %>
									<a href="<%=pageName%>_view.asp?idx=<%=prev_idx%>&page=<%=page%>&startpage=<%=startpage%>&page_ea=<%=page_ea%>"><%=prev_title%></a>
									<% Else %>
									이전글이 없습니다.
									<% End If %>
								</td>
							</tr>
							<tr>
								<th><img src="../../images/btnIcn/icn_next.gif" alt="" title="" /> 다음글</th>
								<td>
									<% If next_title <> "" Then %>
									<a href="<%=pageName%>_view.asp?idx=<%=next_idx%>&page=<%=page%>&startpage=<%=startpage%>&page_ea=<%=page_ea%>"><%=next_title%></a>
									<% Else %>
									다음글이 없습니다.
									<% End If %>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- 상세 끝 -->



			</div>
			<!-- 컨텐츠 끝 -->




			<!-- #Include file="../../include/footer.asp" -->
		</div>
	</body>
</html>
