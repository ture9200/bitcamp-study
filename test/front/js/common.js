$(document).ready(function() {
	// 기간검색 - 달력 //
	$( "#from" ).datepicker({
		showOn: "both",
		buttonImage: "../../images/btnIcn/btn_calendar.png",
		buttonImageOnly: true,
		buttonText: "Select date",
		dateFormat:'yy-mm-dd',
		minDate: 0,
		onClose: function( selectedDate ) {
			$( "#to" ).datepicker( "option", "minDate", selectedDate );
		}
	});
	$( "#to" ).datepicker({
		showOn: "both",
		buttonImage: "../../images/btnIcn/btn_calendar.png",
		buttonImageOnly: true,
		buttonText: "Select date",
		dateFormat:'yy-mm-dd',
		onClose: function( selectedDate ) {
			$( "#from" ).datepicker( "option", "maxDate", selectedDate );
		}
	});


	// 달력/시간 //
	$( "#dayTime" ).datetimepicker({
		showOn: "both",
		buttonImage: "../../images/btnIcn/btn_calendar.png",
		buttonImageOnly: true,
		buttonText: "Select date",
		dateFormat:'yy-mm-dd'
	});


	// 부트스트랩 - 툴팁 //
	$('[data-toggle="tooltip"]').tooltip()


	// 즐겨찾기 //
	$('#favorite').on('click', function(e) {
        var bookmarkURL = window.location.href;
        var bookmarkTitle = document.title;
        var triggerDefault = false;

        if (window.sidebar && window.sidebar.addPanel) {
            // Firefox version < 23
            window.sidebar.addPanel(bookmarkTitle, bookmarkURL, '');
        } else if ((window.sidebar && (navigator.userAgent.toLowerCase().indexOf('firefox') > -1)) || (window.opera && window.print)) {
            // Firefox version >= 23 and Opera Hotlist
            var $this = $(this);
            $this.attr('href', bookmarkURL);
            $this.attr('title', bookmarkTitle);
            $this.attr('rel', 'sidebar');
            $this.off(e);
            triggerDefault = true;
        } else if (window.external && ('AddFavorite' in window.external)) {
            // IE Favorite
            window.external.AddFavorite(bookmarkURL, bookmarkTitle);
        } else {
            // WebKit - Safari/Chrome
            alert((navigator.userAgent.toLowerCase().indexOf('mac') != -1 ? 'Cmd' : 'Ctrl') + '+D 키를 눌러 즐겨찾기에 등록하실 수 있습니다.');
        }

        return triggerDefault;
    });


	// 모달 - 유튜브 자동재생 //
	autoPlayYouTubeModal();


	//FUNCTION TO GET AND AUTO PLAY YOUTUBE VIDEO FROM DATATAG
	function autoPlayYouTubeModal() {
	  var trigger = $("body").find('[data-toggle="modal"]');
	  trigger.click(function () {
		  var theModal = $(this).data("target"),
			  videoSRC = $(this).attr("data-theVideo"),
			  videoSRCauto = videoSRC + "?autoplay=1";
		  $(theModal + ' iframe').attr('src', videoSRCauto);
		  $(theModal + ' button.close').click(function () {
			  $(theModal + ' iframe').attr('src', videoSRC);
		  });
		  $('.modal').click(function () {
			  $(theModal + ' iframe').attr('src', videoSRC);
		  });
	  });
	}


	// 오른마우스 금지 //
	$(document).bind("contextmenu", function(e) {
		return false;
	});

});


//부트스트랩 멀티 모달 음영
var count = 0; // 모달이 열릴 때 마다 count 해서  z-index값을 높여줌
$(document).on('show.bs.modal', '.modal', function () {
    var zIndex = 1040 + (10 * count);
    $(this).css('z-index', zIndex);
    setTimeout(function() {
        $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');
    }, 0);
    count = count + 1
});


// 부트스트랩 멀티모달 스크롤
$(document).on('hidden.bs.modal', '.modal', function () {
    $('.modal:visible').length && $(document.body).addClass('modal-open');
});


// 부트스트랩 모달 가운데정렬
/*
function alignModal(){
	var modalDialog = $(this).find(".modal-dialog");
	modalDialog.css("margin-top", Math.max(0, ($(window).height() - modalDialog.height()) / 2));
}

$(".modal").on("shown.bs.modal", alignModal);

$(window).on("resize", function(){
	$(".modal:visible").each(alignModal);
});
*/

// get파라미터 가져오기 //
var getParam = function(key){
	var _parammap = {};
	document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
		function decode(s) {
			return decodeURIComponent(s.split("+").join(" "));
		}

		_parammap[decode(arguments[1])] = decode(arguments[2]);
	});

	return _parammap[key];
};


// 서브 메뉴 이동 //
function scrollLink(obj, num){
  var position = $("#"+obj).offset();
  $('html, body').animate({scrollTop : position.top-num}, 900, 'easeOutQuad');
}


// 링크점선 제거 //
function bluring(){
	if(event.srcElement.tagName=="A" || event.srcElement.tagName=="IMG")
	document.body.focus();
}
document.onfocusin=bluring;


// 댓글  //
function cmtChk()
{
		var str;

// 작성자
str=document.cmtForm.writer.value;
if (str=="") {
				alert("댓글 작성자를 입력하세요.");
				document.cmtForm.writer.focus();
				return;
				}

// 비밀번호
str=document.cmtForm.pw.value;
if (str=="") {
				alert("댓글 비밀번호를 입력하세요.");
				document.cmtForm.pw.focus();
				return;
				}

// 댓글
str=document.cmtForm.memo.value;
if (str=="") {
				alert("댓글을 입력하세요.");
				document.cmtForm.memo.focus();
				return;
				}


document.cmtForm.action = "../comment/cmt_ok.asp"
document.cmtForm.submit();
return;
}


// 댓글삭제 - 비밀번호입력 열기
function cmtDelOpen(cmtIdx)
{
    $("#cmtDel"+cmtIdx).css({ display : 'inline-block' });
}

function cmtDel(idx,page,startpage,page_ea,Stype,Sstring,pageUrl,pageName,dbName,cmtIdx,cmtpwChk,branchChk)
{
	str=cmtpwChk.value;
    if (str=="") {
					alert("댓글 비밀번호를 입력하세요.");
					cmtpwChk.focus();
					return;
					}

	document.cmtpwForm.action = "../comment/cmt_del_ok.asp?idx=" + idx + "&page=" + page + "&startpage=" + startpage + "&page_ea=" + page_ea + "&Stype=" + Stype + "&Sstring=" + Sstring + "&pageUrl=" + pageUrl + "&pageName=" + pageName + "&dbName=" + dbName + "&cmtIdx=" + cmtIdx + "&branchChk=" + branchChk + ""
	document.cmtpwForm.submit();
}








// 개별 ========================================================================================== //







$(document).ready(function() {
	 // 상단영역 //
	$(window).scroll(function() {
		if ($("#header").offset().top > 50) {
			$('#header').stop().animate({ marginTop : '-10px' }, 350, 'easeOutQuad');
			$('#header > dl > dd > ul > li > a').stop().animate({ padding : '30px 0 20px 0' }, 350, 'easeOutQuad');
		} else {
			$('#header').stop().animate({ marginTop : '0' }, 350, 'easeOutQuad');
			$('#header > dl > dd > ul > li > a').stop().animate({ padding : '30px 0 30px 0' }, 350, 'easeOutQuad');
		}
	});


	// 토탈메뉴 //
	var openChk = 0;
	$('#tmOpen').click(function(){
		if (openChk == 0){
			$('#total-menu').slideDown(500, 'easeOutQuad');
			$('#header > dl > dd > ul').animate({ opacity : '0' }, 800, 'easeOutQuad');
			$('#tmOpen i').removeClass('ion-android-menu');
			$('#tmOpen i').addClass('ion-android-close');
			openChk = 1;

			var stepTime = 0;
			$('#total-menu > ul > li').each(function (index) {
				var stepChk = 0+String(index);
				stepChk = setInterval(function() {
					$('#total-menu > ul > li').eq(index).animate({ marginTop : '0', opacity : '1' }, 1200, 'easeOutQuad');
					clearInterval(stepChk);
				}, stepTime);
				stepTime = stepTime+50;
			});
		} else {
			stepChk = setInterval(function() {
				$('#total-menu').slideUp(500, 'easeOutQuad');
				$('#header > dl > dd > ul').animate({ opacity : '1' }, 800, 'easeOutQuad');
				$('#tmOpen i').removeClass('ion-android-close');
			    $('#tmOpen i').addClass('ion-android-menu');
				clearInterval(stepChk);
			}, 650);
			openChk = 0;

			var stepTime = 0;
			$('#total-menu > ul > li').each(function (index) {
				var stepChk = 0+String(index);
				stepChk = setInterval(function() {
					$('#total-menu > ul > li').eq(index).animate({ marginTop : '-100px', opacity : '0' }, 1200, 'easeOutQuad');
					clearInterval(stepChk);
				}, stepTime);
				stepTime = stepTime+50;
			});
		}
	});


	// 상단서브메뉴 //
	$('#menuArea > li > div').each(function (index) {
		$('#menuArea > li').eq(index).mouseenter(function(){
			$('#menuArea > li > div').eq(index).stop().slideDown(400, 'easeOutQuad');
		});
		$('#menuArea > li').eq(index).mouseleave(function(){
			$('#menuArea > li > div').eq(index).stop().slideUp(400, 'easeOutQuad');
		});
	});


	// 토탈메뉴 //
	var pcRnbChk = 0;
	$('#pcRnbOpen').click(function(){
		$('.gnbTotal').animate({ marginRight : '0' }, 350, 'easeOutQuad');
		//$(this).removeClass('ion-android-menu').addClass('ion-android-close');
	});
	$('#pcRnbClose').click(function(){
		$('.gnbTotal').animate({ marginRight : '-250px' }, 350, 'easeOutQuad');
		//$('.ion-android-close').removeClass('ion-android-close').addClass('ion-android-menu');
	});

	// $("body").click(function(e) {
  //    if($("#header-total").css("display") == "block") {
  //       if(!$('#header-total').has(e.target).length) {
	// 				$('.gnbTotal').animate({ marginRight : '-250px' }, 350, 'easeOutQuad');
	// 				$('.ion-android-close').removeClass('ion-android-close').addClass('ion-android-menu');
  //       }
  //    }
	// });


	// 모바일 토탈메뉴 //
	var mobileLnbChk = 0;
	$('#mobileLnbOpen').click(function(){
		$('.gnbTotal').animate({ marginLeft : '0' }, 350, 'easeOutQuad');
		$(this).removeClass('ion-android-menu').addClass('ion-android-close');
	});
	$('#mobileLnbClose').click(function(){
		$('.gnbTotal').animate({ marginLeft : '-250px' }, 350, 'easeOutQuad');
		$('.ion-android-close').removeClass('ion-android-close').addClass('ion-android-menu');
	});

	$("body").click(function(e) {
     if($("#header-mobile").css("display") == "block") {
        if(!$('#header-mobile').has(e.target).length) {
					$('.gnbTotal').animate({ marginLeft : '-250px' }, 350, 'easeOutQuad');
					$('.ion-android-close').removeClass('ion-android-close').addClass('ion-android-menu');
        }
     }
	});


	// 상단 - 언어변경 //
	/*
	$('#flagChk').click(function(){
		$('#flagSelect').slideDown(400, 'easeOutQuad');
	});
	$('#flagSelect li').each(function (index) {
		$('#flagSelect li').eq(index).click(function(){
			$('#flagSelect').slideUp(400, 'easeOutQuad');
			if (index == 0){
				$('#flagChk span').text('KR');
				$('#flagChk img').attr('src', '../../images/btnIcn/icn_flag_korea24.png');
			}else if (index == 1){
				$('#flagChk span').text('EN');
				$('#flagChk img').attr('src', '../../images/btnIcn/icn_flag_america24.png');
			}else if (index == 2){
				$('#flagChk span').text('CH');
				$('#flagChk img').attr('src', '../../images/btnIcn/icn_flag_china24.png');
			}else if (index == 3){
				$('#flagChk span').text('JP');
				$('#flagChk img').attr('src', '../../images/btnIcn/icn_flag_japan24.png');
			}
		});
	});
	*/


	// 퀵메뉴 - 따라다니는 메뉴 //
	/*
	var currentPosition = parseInt($("#quickMenu").css("top"));
	$(window).scroll(function()
	{       var position = $(window).scrollTop();
		   $("#quickMenu").stop().animate({"top":position+currentPosition+"px"},1000);
	 });
	 */


	// 메인 비주얼 //
	$(".main-vegas").vegas({
	slides: [
			{ src: "../../images/main/visual_img01.jpg" },
			{ src: "../../images/main/visual_img02.jpg" },
			{ src: "../../images/main/visual_img03.jpg" }
		],
		animation: 'kenburns',
		delay: 7000
		//overlay: '../../images/btnIcn/overlay_07.png'
	});

	$('.mv-prev').on('click', function () {
		$(".main-vegas").vegas('options', 'transition', 'fade').vegas('previous');
	});

	$('.mv-next').on('click', function () {
		$(".main-vegas").vegas('options', 'transition', 'fade').vegas('next');
	});


	$('.mv-btm').click(function(){
		$('html, body').animate({ scrollTop : $(window).height()-51 }, 900, 'easeOutQuad');
	});


	// 메인 카피 //
	setTimeout(function() {
		$('.mv-copy').css({ display : 'block' });
		$('.mv-copy > h1').textillate();
		$('.mv-copy > h2').textillate();
		$('.mv-copy > h3').textillate();
		$('.mv-copy > h4').textillate();
	}, 1);

	setTimeout(function() {
		$('.mv-copy div').animate({ opacity : '1.0' }, 350, 'easeOutQuad');
	}, 3500);


	// 메인 아래로 이동버튼 //
	$('.main-visual .crosscover-island > p').click(function(){
		$('html, body').animate({ scrollTop : $(window).height()-156 }, 900, 'easeOutQuad');
	});


	// 메인 포트폴리오 - 오버 //
	var $mainPortfolio = $('.mainPortfolio > div > ul').isotope({
	  itemSelector: '.item',
	  layoutMode: 'masonry'
	});

	$mainPortfolio.imagesLoaded().progress( function() {
	  $mainPortfolio.isotope('layout');
	});

	$('#MPFfilters').on( 'click', 'a', function() {
		var filterValue = $(this).attr('data-filter');
		$mainPortfolio.isotope({ filter: filterValue });
		$('#MPFfilters > a').removeClass('on');
		$(this).addClass('on');
	});

	$('.mainPortfolio > div > ul > li').hover(function (event) {
		$(this).find('p img').stop().animate({ width : '105%', margin : '-2.5% 0 0 -2.5%', opacity : '0.5' }, 500, 'easeOutQuad');
	}, function (event) {
		$(this).find('p img').stop().animate({ width : '100%', margin : '0', opacity : '1.0' }, 500, 'easeOutQuad');
	});


	// 서브 비주얼 //
	$(".visual-sub-vagas").vegas({
    slides: [
			{ src: "../../images/common/sub_visual_img01.jpg" },
			{ src: "../../images/common/sub_visual_img02.jpg" },
			{ src: "../../images/common/sub_visual_img03.jpg" },
			{ src: "../../images/common/sub_visual_img04.jpg" },
			{ src: "../../images/common/sub_visual_img05.jpg" }
		],
		//animation: 'kenburns',
		animation: 'random',
		delay: 7000,
		overlay: '../../images/btnIcn/overlay_01.png'
	});


	// 갤러리 //
	$('.list-gallery-basic ul li').hover(function (event) {
		$(this).find('p img').stop().animate({ width : '105%', margin : '-2.5% 0 0 -2.5%', opacity: '0.3' }, 300, 'easeOutQuad');
		$(this).find('> h1').stop().animate({ bottom : '115px', opacity: '1.0' }, 400, 'easeOutQuad');
	}, function (event) {
		$(this).find('p img').stop().animate({ width : '100%', margin : '0', opacity: '1.0' }, 300, 'easeOutQuad');
		$(this).find('> h1').stop().animate({ bottom : '100px', opacity: '0.0' }, 400, 'easeOutQuad');
	});


	// 자주하는질문 //
	$('.list-faq > dl > dt').each(function (index) {
		var faqChk = 0+String(index);
		$('.list-faq > dl > dt').eq(index).click(function(){
			if (faqChk == 0+String(index)) {
				//$('.list-faq > dd').slideUp(300, 'easeOutQuad');
				$('.list-faq > dl > dd').eq(index).slideDown(300, 'easeOutQuad');
				$('.list-faq > dl > dt').eq(index).css({ color : '#000', background : 'url(../../images/btnIcn/icn_faq_q2.gif) 20px 20px no-repeat, url(../../images/btnIcn/icn_arrUp.gif) right 26px no-repeat, #fff', border : '#29b5f0 1px solid' });
				faqChk = 1+String(index);
			} else {
				//$('.list-faq dd').slideUp(300, 'easeOutQuad');
				$('.list-faq > dl > dd').eq(index).slideUp(300, 'easeOutQuad');
				$('.list-faq > dl > dt').eq(index).css({ color : '#777', background : 'url(../../images/btnIcn/icn_faq_q2.gif) 20px 20px no-repeat, url(../../images/btnIcn/icn_arrDown.gif) right 26px no-repeat, #fff', border : '#e5e5e5 1px solid' });
				faqChk = 0+String(index);
			}
		});
	});

});



// 서브상단 //
/*
document.addEventListener('DOMContentLoaded', function () {
	particleground(document.getElementById('visual-particles'), {
	dotColor: 'rgba(255,255,255,0.7)',
	lineColor: 'rgba(255,255,255,0.5)'
});
var intro = document.getElementById('vp-intro');
//intro.style.marginTop = - intro.offsetHeight / 2 + 'px';
}, false);
*/
