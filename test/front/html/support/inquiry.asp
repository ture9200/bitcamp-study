<!-- #include virtual="/utf8.asp" -->
<!DOCTYPE html>
<html lang="ko">
	<head>
		<!-- #Include file="../../include/head.asp" -->
		<script type="text/javascript" src="inquiry_chk.js"></script>
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
						<a href="inquiry.asp" class="w20p active">상담문의</a>
						<a href="location.asp" class="w20p">오시는길</a>
					</div>
				</div>
				<!-- 비주얼 영역 끝 -->


				<!-- 타이틀 영역 -->
				<div class="title-basic">
					<h1>상담문의</h1>
					<p>&nbsp;</p>
				</div>
				<!-- 타이틀 영역 끝 -->


				<!-- 상담문의 -->
				<form name="writeForm" method="post" enctype="multipart/form-data" action="javascript:writeChk();" class="form-inline">
					<fieldset>
					<ul class="counsel-info">
						<li>
							<div>
								<p><i class="xi-call"></i></p>
								<h1>PHONE</h1>
								<h2>02-2628-3911</h2>
							</div>
						</li>
						<li>
							<div>
								<p><i class="xi-fax"></i></p>
								<h1>FAX</h1>
								<h2>02-2628-3912</h2>
							</div>
						</li>
						<li>
							<div>
								<p><i class="xi-mail-o"></i></p>
								<h1>EMAIL</h1>
								<h2>sales@smartgate.co.kr</h2>
							</div>
						</li>
					</ul>


					<div class="counsel-agree">
						<p>
							■ 스마트게이트에서 제공하는 서비스를 원활히 제공받기 위하여, 아래와 같이 개인정보의 수집 및 이용에 동의합니다.<br />
							1. 개인정보의 수집 및 이용 목적 : 스마트게이트 상담신청 <br />
							2. 개인정보의 수집 및 이용 범위 : 이름, 연락처, 이메일, 제목, 내용, 첨부파일<br />
							3. 개인정보의 수집 및 이용 기간 : 접수완료일로부터 90일<br /><br />

							■ 본 개인정보 수집 및 동의서의 내용에 동의하지 않을 권리가 있으며, 동의를 거부하는 경우에는 온라인 신청을 하실 수 없습니다.
						</p>
						<div>
							<div class="check-radio">
								<input type="radio" name="agreeChk" id="radio1" value="Y" title="동의함" checked="checked" /><label for="radio1"><span></span>동의합니다</label> &nbsp; &nbsp; &nbsp;
								<input type="radio" name="agreeChk" id="radio2" value="N" title="동의안함" /><label for="radio2"><span></span>동의하지 않습니다.</label>
							</div>
						</div>
					</div>


					<div class="counsel-area">
						<div>
							<ul>
								<li><input type="text" name="name" maxlength="20" class="form-control w30p" placeholder="성명" /></li>
								<li>
									<select name="mobile1"  class="form-control w15p">
										<option value="" selected="selected">연락처</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option>
										<option value="02">02</option>
										<option value="031">031</option>
										<option value="032">032</option>
										<option value="033">033</option>
										<option value="041">041</option>
										<option value="042">042</option>
										<option value="043">043</option>
										<option value="051">051</option>
										<option value="052">052</option>
										<option value="053">053</option>
										<option value="054">054</option>
										<option value="055">055</option>
										<option value="061">061</option>
										<option value="062">062</option>
										<option value="063">063</option>
										<option value="064">064</option>
									</select>
									- <input name="mobile2" type="text" maxlength="4" onkeyup="suChk(this);"  class="form-control w20p" />
									- <input name="mobile3" type="text" maxlength="4" onkeyup="suChk(this);"  class="form-control w20p" />
								</li>
								<li>
									<input type="text" name="email1" maxlength="20" class="form-control w20p" placeholder="이메일" />
									<strong>@</strong>
									<input type="text" name="email2" maxlength="20" class="form-control w20p" />
									<select name="email3" onchange="emailChk(this.value)" class="form-control w30p">
										<option value="">직접입력</option>
										<option value="naver.com">naver.com</option>
										<option value="nate.com">nate.com</option>
										<option value="daum.net">daum.net</option>
										<option value="hanmail.net">hanmail.net</option>
										<option value="hotmail.com">hotmail.com</option>
										<option value="gmail.com">gmail.com</option>
									</select>
								</li>
								<!-- <li>
									<select name="sort" class="form-control w30p">
										<option value="">문의구분</option>
										<option value="수리">수리</option>
										<option value="비용">비용</option>
										<option value="A/S">A/S</option>
										<option value="기타">기타</option>
									</select>
								</li> -->
								<li><input type="text" name="title" maxlength="200" class="form-control w100p" placeholder="제목" /></li>
								<li><textarea name="memo" rows="" cols="" class="form-control" style="width:100%; height:230px;"></textarea></li>
								<li>
									<input type="file" name="files" id="fileExt1" class="w600" />
									<div class="mt5">* 파일첨부 용량은 <strong>5M</strong> 이하입니다. 특수한 파일일 경우 등록이 안될수도 있습니다.</div>
								</li>
							</ul>

							<div class="mt20 text-center">
								<a href="javascript:writeChk();" class="btn btn-dark btn-lg btn-rdzero w250"><i class="far fa-file-alt"></i> 상담문의 신청하기</a>
							</div>
						</div>
					</div>
					</fieldset>
				</form>
				<div class="mt70">&nbsp;</div>
				<!-- 상담문의 끝 -->



			</div>
			<!-- 컨텐츠 끝 -->




			<!-- #Include file="../../include/footer.asp" -->
		</div>
	</body>
</html>
