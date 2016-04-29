var queryParams = function (params){
		var temp = {
			limit: params.limit,  //页面大小
		    offset: params.offset, //页码
		};
		return temp;
	}
    function queryAlipayList() {
    	console.log('${basePath}');
		$('#alipay_list').bootstrapTable({
			method: 'get',
			url: basePath + "/picupload/ajaxList.do",
			queryParams: queryParams,//传递参数
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true
			pagination: true,     //是否显示分页
			sortable: true, //是否排序
			sidePagination: "server",//服务端分页
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 5,      //每页的记录行数（*）
			pageList: [5, 10, 20],  //可供选择的每页的行数（*）
		    columns: [{
                field: 'number',
                title: '序号',
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                	var num = index+1;
                	if(num<10){
                		return "0"+num;
                	}
					return num;
				}
            }, {
                field: 'account',
                title: '支付宝账号',
                align: 'center',
                valign: 'middle',
                formatter:function(value,row,index){
                	var temp = "<a href='${base}/picupload/toAlipayApplied.do?id="+row.id+"'>"+row.account+"</a>";
           		    return temp;
                }
            }]                
		   });  
	}