
<!DOCTYPE html>
<html lang="en" class="no-js" style="height: 100%;overflow:hidden">
<head>
	<#include "../../pages/common/common.ftl">
	<#include "../../pages/login/modifypw.ftl">
	
	<script type="text/javascript" src="${resRoot}/pages/login/admin.js"></script>
	<style>.menuclick a{background:#2B3643 !important;color:#fff !important;}
	</style>
    <script>
        function iFrameHeight() {
        	var header_hei=$("#headerdiv").height(),
            body_hei=document.documentElement.offsetHeight,
            height=body_hei-header_hei-100;
            var ifm= document.getElementById("iframepage");

            var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;

                if(ifm != null && subWeb != null) {

                ifm.height = height;

                }
            ifm.style.display="block";
            

        }

    </script>
    <link rel="shortcut icon" href="favicon.ico" />
</head>

<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo one-body" style="height: 100%;overflow: hidden;">
   <#if null == userBean || userBean.userName == ""> <input type="hidden" id="userName" value="" />
<#elseif null != userBean && userBean.userName != ""> <input type="hidden" id="userName" value="${userBean.userName!''}" /> </#if>
    <!-- 头部 -->
    <div id="headerdiv">
        <div id="header"> 
        <div class="page-header navbar navbar-fixed-top">
            <div class="page-header-inner">
                <div class="page-logo">
                    <a href="javascript:;">
                    <img src="${resRoot}/assets/images/logo.png" alt="logo" class="logo-default"/>
                    </a>
                    <div class="menu-toggler sidebar-toggler hide">
                    </div>
                </div>

                <div class="page-header-title">零售业全渠道O2O平台</div>

                <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
                </a>
                <div class="top-menu">
                    <ul class="nav navbar-nav pull-right">
                        <li>

                        <div class="header">
                        <#if null == deptName || deptName == "">
                         ${merchantBean.companyName}
                        <#elseif null != deptName && deptName != "">
                        ${deptName}
                        </#if>
                        </div>
                        </li>
                        <li class="dropdown dropdown-user">
                            <a href="javascript:;" class="dropdown-toggle" >
                            <img alt="" class="img-circle" src="${resRoot}/assets/images/avatar3_small.jpg"/>
                            <span class="username username-hide-on-mobile">${userBean.userName}</span>
                            <i class="fa fa-angle-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-default">
                               <li class= "back">
								   <a>
								   <i class="icon-home" ></i> 返回首页</a >
								</li>
								<li class= "modifyPw">
									<a data-toggle="modal"  id="uppw" >
									<i class="icon-lock"></i>修改密码</a>
								</li>
								<li class= "logout">
								   <a>
								   <i class="icon-key" ></i> 退出登录 </a >
								</li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        </div>
        <div class="clearfix"></div></div>
    <div class="page-container" style="overflow:hidden">
        <!-- 菜单 -->
        <div id="menudiv" class="page-sidebar-wrapper">
            <div id="menu" class="page-sidebar-wrapper" style="position:fixed;">
                <div class="page-sidebar navbar-collapse collapse">
                    <ul class="page-sidebar-menu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
                        <li class="sidebar-toggler-wrapper">
                            <div class="sidebar-title">
                                商户中心
                            </div>
                            <div class="sidebar-toggler">
                            </div>
                        </li>
                        <li class="sidebar-search-wrapper">
                			<form class="sidebar-search " action="extra_search.html" method="POST">
                    			<a href="javascript:;" class="remove">
                        			<i class="icon-close"></i>
                    			</a>
                    			<div class="input-group">                 
                    			</div>
                			</form>
            			</li>
			            <#list menuBean as menu>
			            <li>
			                    <#if (menu.size > 0)>
				                    <a href="javascript:;">
					                    <i class="icon-home"></i>
					                    <span class="title">${menu.name}</span>
					                    <span class="arrow"></span>
				                    </a>
				                    <ul class="sub-menu">
				                    	<#list menu.childMenu as childMenu>
				                    		<li>
						                        <a href="${base}${childMenu.url}">
						                            <i class="icon-bulb"></i>${childMenu.name}
						                        </a>
						                    </li>
				                    	</#list>
				                    </ul>
			                    <#else>
			                        <a href="${base}${menu.url}">
						                <i class="icon-home"></i>
						                <span class="title">${menu.name}</span>
					                </a>
			                    </#if>
			               </li>
			            </#list>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 正文 -->
        <div class="page-con" style="margin-left: 235px;margin-top: 0;">
            <div class="page-iframe" style="position: relative;left: 0;background-color: #fff;">
                <iframe id="iframepage" src="" width="100%" frameborder="0" onLoad="iFrameHeight()"></iframe>
                
                <div class="load" style="background: url(${resRoot}/assets/plugins/layer/skin/default/loading-1.gif) no-repeat;width:37px;height: 37px;position: absolute;left: 50%;top: 50%;margin-left: -16.5px;margin-top: -16.5px;display: none;"></div>
            </div>
        </div>
    </div>
    <!-- 弹出链接 -->
    <div class="hrefBox" style="display: none;">
        <textarea name="" style="border:none;outline: none;width: 300px;text-indent: 3px;" value="http://www.baidu.com" cols="30" rows="10" id="song">http://www.baidu.com</textarea>
    </div>
    
    <!-- BEGIN FOOTER -->
    <div id="footer" class="page-footer">
        <div class="page-footer-inner" style="width: 100%;text-align: center;">
             2015 © 江苏创纪云网络科技有限公司. <a href="111111111111" target="_blank">请购买!</a>
        </div>
        <div class="scroll-to-top">
            <i class="icon-arrow-up"></i>
        </div>
    </div>
    <script>
	var firstLogin = "${isFirstFlag}";
	var haveModify = "${haveModify}"
    jQuery(document).ready(function() {
        var rightTopMenu = true;
        //右上角菜单
        $(".dropdown-toggle").on("click",function(){
            
            if(rightTopMenu === false){
                $(this).nextAll("ul").hide();
                rightTopMenu = true;
            }else{
                $(this).nextAll("ul").show();
                rightTopMenu = false;
            }
        });
        $(".one-body").on("click",function(e){
             var target = $(e.target),
                dropdownMenu = $(".dropdown-menu");
            if(!rightTopMenu){
                if(!target.parents(".dropdown-user")[0]){
                    dropdownMenu.hide();
                    rightTopMenu = true;
                }

            }
        });
        setTimeout(function(){
            var frameBody = $("#iframepage").contents().find("body");
            frameBody.unbind("click");
            frameBody.on("click",function(){
                $(".dropdown-menu").hide();
                rightTopMenu = true;
            })
        },300);

    	initFirstLogin();
        var header_hei=$("#headerdiv").height(),
            body_hei=document.documentElement.offsetHeight,
            height=body_hei-header_hei-100;
        var menu_li = $(".sub-menu li");
        menu_li.on("click", function(){
        	for (var i = 0; i < menu_li.length; i++) {
        		menu_li.eq(i).removeClass("menuclick");
                //menu_li.eq(i).removeClass("open");
            }
        	$(this).addClass("menuclick");
        });
        $(".page-iframe").css("height",height+"px")
        var a=document.getElementsByTagName("a");
        for (var i = 0; i < a.length; i++) {
            a[i].onclick=function(event){
                event.preventDefault();

                var reg=/\.do/g,
                    href=this.getAttribute("href");
                if(reg.test(href)){
                	
                    $(".load").css("display","block");
                    var last=$("#iframepage");
                    last.attr("id","iframe");
                    var iframe=document.createElement("iframe");
                    iframe.src=href;
                    iframe.width="100%";
                    iframe.id="iframepage";
                    iframe.style.opacity="0";
                    iframe.style.overflow="hidden";
                    iframe.style.border="none";
                    
                    $(".page-iframe").append(iframe);
                    
                    $("#iframepage").on("load",function(){
                        $(".load").css("display","none");
                        last.remove();
                        iFrameHeight();
                        $("#iframepage").animate({
                            opacity:"1",
                            filter:"alpha(opacity=100)" //标准的css透明度，在大部分的标准浏览器Firefox, Safari, and Opera都有效
                        },160);
                        setTimeout(function(){
                            var frameBody = $("#iframepage").contents().find("body");
                            frameBody.unbind("click");
                            frameBody.on("click",function(){
                                $(".dropdown-menu").hide();
                                rightTopMenu = true;
                            })
                        },300);
                    });
                    //alert(1)
                    //$("#iframepage").attr("src",href);
                }

                return false;
            }
        }
        //assembly.menu();
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        QuickSidebar.init(); // init quick sidebar
        //Demo.initvalue(); // init demo features
		var showProgress = '${showProgress}';
		if(showProgress){ 
			var target_aLib = $('a[href$="'+showProgress+'.do"]').first(); 
			target_aLib.parent().parent().prev('a').click();
			setTimeout(function(){
				target_aLib.click();
			},200);
			//target_aLib.animate({'opacity':1},200,function(){
			//	target_aLib.click();
			//});
			
		}else{
			var li = $('.sidebar-search-wrapper').next();
				li.addClass('open').children().first().click(); 
				setTimeout(function(){
					li.find('ul > li > a').first().click();
				},100);
				//li.animate({'opacity':1},100,function(){
				//	li.find('ul > li > a').first().click();
				//});
		}
    });
    
    $( ".logout").on("click" , function() {
    	var url = '${base}/loginController/removeFlag.do'
    	$.ajax({
    		type : "post",
    		url : url,
    		dataType : "json",
    		success : function(data) {
    			
    				location.href = "${base}" + "/sso/logout.sso?service=${casServerUrl}/${casProjectName}/logout?redirectToUrl=${clientServerUrl}${base}/loginController/exit.do";   			
    		}
    	});
		
	});
    
    $( ".modifyPw").on("click" , function() { 
    		$('#passwordMT').modal('show');
	});
    
	$( ".back").on("click" , function() { 
	        location.href = "${base}" + "/loginController/toIndex.do" ;
	});
	
	function initFirstLogin(){
		if(firstLogin!=null&&firstLogin=="2"&&haveModify!="2"){
			$('#passwordMT').modal('show');
		}
		
	}
    </script>
    

</body>
<!-- END BODY -->
</html>
