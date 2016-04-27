var queryParams = function (params){
		var temp = {
			limit: params.limit,  //页面大小
		    offset: params.offset, //页码
		};
		return temp;
	}
    function queryApplyList() {
    	console.log('${base}');
    	console.log(basePath);
		$('#apply_list').bootstrapTable({
			method: 'get',
			url: basePath + '/pubapply/pubApplyList.do',
			queryParams: queryParams,//传递参数
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true
			pagination: true,     //是否显示分页
			sortable: false, //是否排序
			sidePagination: "server",//服务端分页
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 5,      //每页的记录行数（*）
			pageList: [5, 10, 20],  //可供选择的每页的行数（*）
		    columns: [{
                field: 'number',
                title: '序号',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'applyName',
                title: '服务项目',
                align: 'center',
                valign: 'middle',
            }, {
                field: 'applyDate',
                title: '申请日期',
                align: 'center',
                valign: 'middle',
            }, {
                field: 'status',
                title: '状态',
                align: 'center',
                valign: 'middle',
                formatter:function(value,row,index){
                	var status = "<span class=\"label label-sm label-success\">已申请</span>";
	            	if(value == 1){
	            		status = "<span class=\"label label-sm label-info\">已审核</span>";
	            	}else if(value == 2){
	            		status = "<span class=\"label label-sm label-warning\">被驳回</span>";
	            	}else if(value == 3){
	            		status = "<span class=\"label label-sm label-danger\">已终止</span>";
	            	}
           		    return status;
                }
            }, {
                field: 'rejectReason',
                title: '驳回原因',
                align: 'center',
                valign: 'middle'
            }, {
                title: '操作',
                field: 'id',
                align: 'center',
                formatter:function(value,row,index){  
                  var temp="";
                  var status = row.status;
                  if(status==2){
                	  temp = "<a href='" + basePath + "/pubapply/toReg.do?id=" + row.number
						+ "' title='重新申请'><i class='btn glyphicon glyphicon-refresh'></i></a>";
                  }
                  return temp;
                } 
            }]                
		   });  
	}