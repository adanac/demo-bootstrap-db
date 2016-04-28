/*
 *
 *
 *		组件库（Assembly）
 *
 *
 *
 */
 ;(function($){

 	"use strict";

 	var assembly=function(){

 	};
 	assembly.prototype={

 		//返回jquery对象
 		$tar:function(target){		
			return target.push?target:$(target);
		},
		//编辑和禁止文本框
		$edit:function(target,parent){			
			var tar=this.$tar(target);
			var parents=tar.parents(parent),
				ff=false,					//当前状态
				input=parents.find("input"),
				input_arr=[];
			for (var i = 0; i < input.length; i++) {		//如果有需要编辑的请加data-ff=false
				if(!input[i].getAttribute("data-ff")){
					input_arr.push(input[i]);
				}
			}
			tar.on("click",function(){
				for (var i = 0; i < input.length; i++) {
					if(!ff){
						input_arr[i].removeAttribute("disabled");
						if(i===input_arr.length-1){ff=true;}
					}else{
						input_arr[i].setAttribute("disabled","true");
						if(i===input_arr.length-1){ff=false;}
					}
					
				}
			})
		},
		
		Select:function(check,state){		//全选
		
		if(state===1){
			check.prop("checked",true);
		}else if(state===2){
			check.prop("checked",false);
		}
		

	},
		//校验
		checkAll:function(json,type){

			/*
			type:{
				1: 			//清空文本框
				2: 			//文字选中功能
				3: 			//全选与反选
			}

			*/

			/*
			{
				target: 		//目标
				valueNull: 		//需要清空value值的文本框
				state: 			//全选的状态值 1:全选 2:反选
			}

			*/


			var check=function(){
				this.type=type;
				this.obj=json;
			},
			that=this;		//指向assembly;

			//清空文本框
			check.prototype.valueNull=function(){
				var self=this.obj;
				var text=self.valueNull,
					target=that.$tar(self.target);
				target.on("click",function(){
					text.val(null);
					$(".select2-chosen").html(null);
				})
			};

			//文字选中功能
			check.prototype.hrefBox=function(o){
				var o=that.$tar(o)[0],
					l = o.value.length;
				var a = 0, b = l;            if(l){
	                //如果非数值，则表示从起始位置选择到结束位置
	                if(!a){
	                    a = 0;    
	                }
	                if(!b){
	                    b = l;    
	                }
	                //如果值超过长度，则就是当前对象值的长度
	                if(a > l){
	                    a = l;    
	                }
	                if(b > l){
	                    b = l;    
	                }
	                //如果为负值，则与长度值相加
	                if(a < 0){
	                    a = l + a;
	                }
	                if(b < 0){
	                    b = l + b;    
	                }
	                if(o.createTextRange){//IE浏览器
	                    var range = o.createTextRange();         
	                    range.moveStart("character",-l);              
	                    range.moveEnd("character",-l);
	                    range.moveStart("character", a);
	                    range.moveEnd("character",o.value.length);
	                    range.select();
	                }else{
	                    o.setSelectionRange(a, l);
	                    o.focus();
	                }
	            }
			};
			//全选与反选
			check.prototype.Select=function(){
				var self=this.obj;
				if(self.state===1){
					self.target.prop("checked",true);
				}else if(self.state===2){
					self.target.prop("checked",false);
				}
			};
			var c=new check();
			if(c.type===1)c.valueNull();
			else if(c.type===2)c.hrefBox(json.target);
			else if(c.type===3)c.Select();


		},
		//限定只能输入数字
		limitNumber:function(target){
			var tar=this.$tar(target);
			tar.on("keydown",function(event){
				var that=this,
					arr=[0,1,2,3,4,5,6,7,8,9],
					arr2=[48,49,50,51,52,53,54,55,56,57],
					maxlength_reg=/max\d{1,}/g,
					length=57-48;
				var max=tar.attr("class").match(maxlength_reg);
				if(max){
					var number=/\d/g,
						maxlength=max[0].match(number)[0]?Number(max[0].match(number)):0;
				}
				if(event.keyCode>=48&&event.keyCode<=57){
					if(maxlength!==0&&that.value.length<maxlength){
						for (var i = 0; i < length; i++) {
							if(event.keyCode===arr2[i]){
								that.value+=arr[i];
								break;
							}
						}
					}
					
				}
				if(event.keyCode===8||event.keyCode===37||event.keyCode===38||event.keyCode===39||event.keyCode===40){

				}else{
					return false;
				}

			})
		},
		progress:function(dex){
		    var bar=$(".progress-bar"),
		        nav_pills=$(".nav-pills li");
		        wid=nav_pills.width();
		    for (var i = 0; i < nav_pills.length; i++) {
		        $(nav_pills[i]).removeClass("active");
		    }
		    for (var z = 0; z < dex; z++) {
		        $(nav_pills[z]).addClass("active");
		    }
		    bar.css("width",dex*wid+"px");
		},
		layeres:function(target){
	        var body_back,
	            back_ff=$(".body-back")[0]?true:false,      //判定当前是否存在背景
	            tar_sty=target.style;
	        createBack();           //生成背景
	        setTarget();
	        closeBack();            //删除背景
	        window.onresize=function(){setTarget();};
	        function createBack(){
	            if(!back_ff){
	                body_back=document.createElement("div"),
	                    back_sty=body_back.style;
	                body_back.className="body-back"	
	                back_sty.opacity=0;
	                back_sty.position="fixed";
	                back_sty.left=0;
	                back_sty.top=0;
	                back_sty.width="100%";
	                back_sty.zIndex="9999";
	                back_sty.height="100%";
	                back_sty.backgroundColor="rgba(0,0,0,.6)";
	                document.body.appendChild(body_back);
	                
	                playBack();
	                back_ff=true;
	                
	            }
	            
	        };
	        function playBack(){
	            $(".body-back").animate({
	                opacity:1
	            })
	        }
	        function closeBack(){
	            if(body_back){
	                body_back.onclick=function(){
	                    document.body.removeChild(this);
	                    hyTarget();
	                    back_ff=false;
	                }
	            }
	        }
	        function setTarget(){
	            var body_hei=window.innerHeight?window.innerHeight:document.documentElement.clientHeight,
	                body_wid=window.innerWidth?window.innerWidth:document.documentElement.clientWidth;             
	            tar_sty.opacity=0;
	            tar_sty.maxWidth="55%";

	            tar_sty.overflow="hidden";
	            tar_sty.display="block";
	            tar_sty.position="fixed";
	            tar_sty.zIndex=10000;
	            tar_sty.left=(body_wid/2)-(target.offsetWidth/2)+"px";
	            tar_sty.top=(body_hei/2)-(target.offsetHeight/2)-100+"px";
	            playTarget();
	            function playTarget(){
	                $(target).animate({
	                    opacity:1,
	                    top:(body_hei/2)-(target.offsetHeight/2)+"px"
	                },250)
	            }
	        }
	        
	        function hyTarget(){
	            tar_sty.position="";
	            tar_sty.zIndex="";
	            tar_sty.left="";
	            tar_sty.top="";
	            tar_sty.display="none";
	        }
	    },
		$region:function(target){
			var tar=this.$tar(target),
				wid=document.documentElement.getBoundingClientRect().width;
			tar.css({
				"transition":".3s",
				"-webkit-transition":".3s"
			});
			tar.css({
				"transform":"translateX(-"+wid+"px)",
				"-webkit-transform":"translateX(-"+wid+"px)"
			});

		},
		//分页
		$paging:function(parent,succes,tbody){
			var par=this.$tar(parent),
				t_body=this.$tar(tbody),
				page=1,										//当前页数
				btn={
					prevAll:par.find(".prevAll")||false,		//首页
					prev:par.find(".prev")||false,				//上一页
					next:par.find(".next")||false,				//下一页
					nextAll:par.find(".nextAll")||false,		//最后一页
					pag_btn:par.find(".pag-btn")||false		//数字按钮，如[1,2,3,4,5]
				};
			//getAjax();
			for(var i in btn){							//遍历所有按钮
				if(!btn[i])continue;
				var self=$(btn[i]);
				self.on("click",function(){				//添加事件
					getAjax(this);
				})
			};
			function newDemo(data){
				var pul=JSON.parse(data);
				var text="<tr>"
				for (var i = 0; i < pul.length; i++) {
					text+="<td>"+pul[i]+"</td>";
				}
				text+="</tr>";
				t_body.html(text);
				
			}
			function checkPage(target){
				var clas=$(target).attr("class"),
					now=null,
					active="page-active",
					numberBtn=btn.pag_btn;
				for (var i = 0; i < numberBtn.length; i++) {
					var	nowBtn=$(numberBtn[i]);
					
					if(nowBtn.attr("class").indexOf(active)>-1){
						now=nowBtn;
					}
					//
				}
				nowBtn.removeClass(active)
				if(clas.indexOf("prevAll")>-1){
					//alert("首页");
					page=1;
					$(numberBtn[0]).addClass(active);
				}else if(clas.indexOf("prev")>-1){
					//alert("上一页")
					if(page>1){
						page--;
						now.prev(".pag-btn").addClass(active);
					}
				}else if(clas.indexOf("nextAll")>-1){
					//alert("最后一页")
					page=numberBtn.length-1;
					$(numberBtn[numberBtn.length-1]).addClass(active);
				}else if(clas.indexOf("next")>-1){
					//alert("下一页")
					page++;
					now.next(".pag-btn").addClass(active);
				}
				//console.log(page)			//页数变化
			}
			function getAjax(target){
				checkPage(target);
				if(page>1){
					$.ajax({
						url:"test.txt",						//传入url
						type:"get",						//请求方式
						success:function(data){
							newDemo(data);

							succes();				//执行回调
						},
						error:function(){
							alert("报错！")
						}
					})
				}
				
			}

		},
		//定义到当前菜单
		menu:function(){

		    var page_title=$(".page-title"),
		        page=page_title.html().indexOf("<")-1>-1?page_title.html().indexOf("<")-1:page_title.html().length,
		        title="",ff=false,dex=0,t="",
		        page_sidebar=$(".page-sidebar-menu"),
		        slide=page_sidebar.children("li");
		    for (var i = 0; i < page; i++) {
		        if(page_title.attr("data-title")){
		            title=page_title.attr("data-title");
		        }else {
		            title+=page_title.html()[i];
		        }
		        
		    };
		    t=title.match(/[\u4e00-\u9fa5]/g).join("");
		    for (var i =0; i < slide.length; i++) {
		        
		        var n_=$(slide[i]),n_li=n_.find("li");
		        if(ff)break;
		        if(n_.attr("class")==="sidebar-toggler-wrapper")continue;
		       // if(n_li.length<=0)continue;
		        if(n_.find(".title").html()===t){
		            n_.addClass("active open");
		           // break;
		        }else if(n_.find("title").attr("data-title")===t){
		            n_.addClass("active open");

		        };

		        
		        for (var a = 0; a < n_li.length; a++) {
		            var nI=$(n_li[a]).find("a"),place=nI.text().match(/[\u4e00-\u9fa5]/g).join("");
		                
		            if(place===t){
		                $(n_li[a]).addClass("active");
		                $(n_li[a]).parents("li").addClass("active open");
		                ff=true;
		                break;
		            }else{
		                    /*测试专用,以防ie崩溃*/
		                dex++;
		                if(dex===100){
		                    
		                    ff=true;
		                    break;
		                }

		            }
		        }
		    }
			
		},
		$drag:function(target,json,succes){
			var tar=this.$tar(target),
				last=0,
				clas=$(json.zClas),			//所有Drag对象
				yyy=0;
			tar[0].onmousedown=function(event){
				var eve=event||window.event,
					that=this,
					dex=0,
					time=null,
					TopArr=[],
					moveY=0,
					index=0,					//当前的位置，防止重复
					DragArr=[],
					lastTop=that.offsetTop,
					prevAll=$(that).prevAll(json.zClas),
					prevHei=prevAll.length!==0?prevAll.length*prevAll.height():0,
					nextAll=$(that).nextAll(json.zClas),
					nextHei=nextAll.length!==0?nextAll.length*nextAll.height():0;
				eve.preventDefault();
				eve.stopPropagation();
				var top=eve.clientY-that.offsetTop;
				//that.style.zIndex=999;
				for (var i = 0; i < clas.length; i++) {
					TopArr.push(clas[i].offsetTop);
					var t=i*41;
					for (var a = 0; a < clas.length; a++) {
						if(clas[a].offsetTop===t){
							DragArr.push(clas[a]);
							
						}
					}
				};

				console.log(DragArr)

				document.onmousemove=function(event){
					clearTimeout(time);
					moveY=event.clientY;
					yyy=event.clientY-top;
					if(yyy<0){
						yyy=0;
					}else if(yyy>(clas.length-1)*clas.height()){
						yyy=(clas.length-1)*clas.height();
					}
					var leng=(yyy/41).toFixed(0);
					dex=leng;

					time=setTimeout(function(){
						for (var i = 0; i < clas.length; i++) {
							if(clas[i]===that)continue;
							else if(clas[i]===DragArr[leng])continue;
							$(clas[i]).animate({
								top:TopArr[i]+"px"
							})
						}
						$(DragArr[leng]).animate({
							top:lastTop+"px"
						});
					},500)
					
					
					that.style.top=yyy+"px";
					
				};
				document.onmouseup=function(){
					this.onmousemove=null;
					this.onmouseup=null;
					succes(that,yyy);
					last=yyy;
					
					var arr=[0,41,82,123,164]
					var leng=(yyy/41).toFixed(0);
					if(moveY!==0){
						$(that).animate({
		                	top:arr[leng]+"px"
		                })
					}
	                
				}
			}
		}
 	}


 	window['assembly']=assembly;

 })(jQuery);