<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8" />
    <title>创纪云|零售业全渠道O2O平台</title>
    <#include "../common/common.ftl">
</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
    <!-- BEGIN CONTAINER -->
    <div class="page-container" style="margin:0">
        <!-- END SIDEBAR -->
        <!-- BEGIN CONTENT -->
        <div class="page-content-wrapper">
            <div class="page-content" style="margin-left: 0;">
                <h3 class="page-title"> 支付宝 <small>管理支付宝申请服务</small></h3>
                <div class="page-bar">
                    <ul class="page-breadcrumb">
                        <li><i class="fa fa-home"></i><a href="#">服务设置</a><i class="fa fa-angle-right"></i></li>
                        <li><a href="#">支付宝</a><i class="fa fa-angle-right"></i></li>
                        
                    </ul>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption"> 支付宝管理 </div>
                                <div class="actions">
                                    <a href="${base}/payment/toAlipayApply.do?flag=0" class="btn btn-default btn-sm"><i class="fa fa-plus"></i> 新申请 </a>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <!-- 表格开始-->
                                <div id="sample_2_wrapper" class="dataTables_wrapper no-footer">
                                    <div class="table-scrollable">
                                        <table id="alipay_list" data-side-pagination="server" data-pagination="true" data-height="" class="table table-hover dataTable no-footer table-striped table-bordered" style="width: 100%;border:1px solid #ddd;">
                                        </table>
                                    </div>
                                    
                                </div>
                                <!-- 表格结束 -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END QUICK SIDEBAR -->
    </div>
    <!-- END CONTAINER -->
    <!-- BEGIN FOOTER -->
    <!-- END FOOTER -->
    <script src="${resRoot}/pages/picupload/alipayQuer.js" type="text/javascript"></script>
    <script>
	    $(function() {
	        queryAlipayList();
	    });
    </script>
</body>
<!-- END BODY -->

</html>
