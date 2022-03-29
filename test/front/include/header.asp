<!-- #Include file="menuChk.asp" -->
<!-- 전체메뉴 -->
<div id="total-menu">
	<ul>
		<li>
			<p><a href="../company/introduction.asp">회사소개</a></p>
			<div>
				<a href="../company/introduction.asp">회사소개</a> &nbsp; | &nbsp;
				<a href="../company/greeting.asp">인사말</a> &nbsp; | &nbsp;
				<a href="../company/history.asp">회사연혁</a> &nbsp; | &nbsp;
				<a href="../company/organization.asp">조직도</a>
			</div>
		</li>
		<li>
			<p><a href="../business/business.asp">사업영역</a></p>
		</li>
		<li>
			<p><a href="../product/network01.asp">제품소개</a></p>
			<div>
				<a href="../product/network01.asp">네트워크</a> &nbsp; | &nbsp;
				<a href="../product/security01.asp">보안</a>
			</div>
		</li>
		<li>
			<p><a href="../job/job.asp">채용정보</a></p>
		</li>
		<li>
			<p><a href="../support/inquiry.asp">고객지원</a></p>
			<div>
				<a href="../support/inquiry.asp">상담문의</a> &nbsp; | &nbsp;
				<a href="../support/location.asp">오시는길</a>
			</div>
		</li>
	</ul>
</div>
<!-- 전체메뉴 끝 -->


<!-- 상단영역 -->
<div id="header">
	<dl>
		<dt><a href="../main/"><img src="../../images/common/logo.png" alt="" title="" /></a></dt>
		<dd>
			<ul id="menuArea">
				<li>
					<a href="../company/introduction.asp" <% If oneDT = 1 Then %>class="active"<% End If %>>회사소개</a>
					<div>
						<a href="../company/introduction.asp">회사소개</a>
						<a href="../company/greeting.asp">인사말</a>
						<a href="../company/history.asp">회사연혁</a>
						<a href="../company/organization.asp">조직도</a>
					</div>
				</li>
				<li>
					<a href="../business/business.asp" <% If oneDT = 2 Then %>class="active"<% End If %>>사업영역</a>
					<div>
					</div>
				</li>
				<li>
					<a href="../product/network01.asp" <% If oneDT = 3 Then %>class="active"<% End If %>>제품소개</a>
					<div>
						<a href="../product/network01.asp">네트워크</a>
						<a href="../product/security01.asp">보안</a>
					</div>
				</li>
				<li>
					<a href="../job/job.asp" <% If oneDT = 4 Then %>class="active"<% End If %>>채용정보</a>
					<div>
					</div>
				</li>
				<li>
					<a href="../support/inquiry.asp" <% If oneDT = 5 Then %>class="active"<% End If %>>고객지원</a>
					<div>
						<a href="../support/inquiry.asp">상담문의</a>
						<a href="../support/location.asp">오시는길</a>
					</div>
				</li>
			</ul>
		</dd>
		<dt><a href="#" id="pcRnbOpen"><i class="ion-android-menu"></i></a></dt>
	</dl>
</div>
<!-- 상단영역 끝 -->


<!-- 상단영역 - 전체메뉴 -->
<div id="header-total">
	<div class="gnbTotal">
		<dl>
			<dt><span>M</span><em>E</em><i>N</i><strong>U</strong></dt>
			<dd id="pcRnbClose"><i class="fa fa-times" aria-hidden="true"></i></dd>
		</dl>
		<div id="cssmenu">
			<ul>
				<li class='has-sub'>
					<a href='#'><i class="far fa-building"></i> <span>회사소개</span></a>
					<ul>
						<li><a href='../company/introduction.asp'><i></i> <span>회사소개</span></a></li>
						<li><a href='../company/greeting.asp'><i></i> <span>인사말</span></a></li>
						<li><a href='../company/history.asp'><i></i> <span>회사연혁</span></a></li>
						<li><a href='../company/organization.asp'><i></i> <span>조직도</span></a></li>
					</ul>
				</li>
				<li>
					<a href='../business/business.asp'><i class="fas fa-business-time"></i> <span>사업영역</span></a>
				</li>
				<li class='has-sub'>
					<a href='#'><i class="fas fa-server"></i> <span>제품소개</span></a>
					<ul>
						<li><a href='../product/network01.asp'><i></i> <span>네트워크</span></a></li>
						<li><a href='../product/security01.asp'><i></i> <span>보안</span></a></li>
					</ul>
				</li>
				<li>
					<a href='../job/job.asp'><i class="fa fa-user-md" aria-hidden="true"></i> <span>채용정보</span></a>
				</li>
				<li class='has-sub'>
					<a href='#'><i class="fa fa-street-view" aria-hidden="true"></i> <span>고객지원</span></a>
					<ul>
						<li><a href='../support/inquiry.asp'><i></i> <span>상담문의</span></a></li>
						<li><a href='../support/location.asp'><i></i> <span>오시는길</span></a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- 상단영역 - 전체메뉴 끝 -->


<!-- 상단영역 - 모바일 -->
<div id="header-mobile">
	<dl class="gnbMenu">
		<dt><i class="ion-android-menu" id="mobileLnbOpen"></i></dt>
		<dd><a href="../main/"><img src="../../images/common/logo.png" height="30" alt="" title="" /></a></dd>
		<dt onclick="location.href='tel:02-2628-3911';"><i class="xi-call-outgoing"></i></dt>
	</dl>
	<div class="gnbTotal">
		<dl>
			<dt><span>M</span><em>E</em><i>N</i><strong>U</strong></dt>
			<dd id="mobileLnbClose"><i class="fa fa-times" aria-hidden="true"></i></dd>
		</dl>
		<div id="cssmenu">
			<ul>
				<li class='has-sub'>
					<a href='#'><i class="far fa-building"></i> <span>회사소개</span></a>
					<ul>
						<li><a href='../company/introduction.asp'><i></i> <span>회사소개</span></a></li>
						<li><a href='../company/greeting.asp'><i></i> <span>인사말</span></a></li>
						<li><a href='../company/history.asp'><i></i> <span>회사연혁</span></a></li>
						<li><a href='../company/organization.asp'><i></i> <span>조직도</span></a></li>
					</ul>
				</li>
				<li>
					<a href='../business/business.asp'><i class="fas fa-business-time"></i> <span>사업영역</span></a>
				</li>
				<li class='has-sub'>
					<a href='#'><i class="fas fa-server"></i> <span>제품소개</span></a>
					<ul>
						<li><a href='../product/network01.asp'><i></i> <span>네트워크</span></a></li>
						<li><a href='../product/security01.asp'><i></i> <span>보안</span></a></li>
					</ul>
				</li>
				<li>
					<a href='../job/job.asp'><i class="fa fa-user-md" aria-hidden="true"></i> <span>채용정보</span></a>
				</li>
				<li class='has-sub'>
					<a href='#'><i class="fa fa-street-view" aria-hidden="true"></i> <span>고객지원</span></a>
					<ul>
						<li><a href='../support/inquiry.asp'><i></i> <span>상담문의</span></a></li>
						<li><a href='../support/location.asp'><i></i> <span>오시는길</span></a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- 상단영역 - 모바일 끝 -->
