<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
    <meta charset="utf-8" />
    <title>创纪云|零售业全渠道O2O平台</title>
    <!-- 图标库,bootstrap -->
    <link href="${resRoot}/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="${resRoot}/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="${resRoot}/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${resRoot}/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css" />
    <style>
    .form-control {
        background-color: transparent !important;
    }
    
    .layer_form2 {
        padding: 5px 25px 20px 25px;
    }
    
    .table>tbody>tr>td:nth-child(2) {
        color: #000000;
    }
    </style>
</head>

<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
    <div class="body-bj"></div>
    <div id="headerdiv">
    </div>
    <div class="page-container" style="margin-top: 0;">
        <div class="page-content-wrapper">
            <div class="page-content" style="margin-left: 0;">
                <h3 class="page-title">服务申请查询 <small>商户查看服务申请信息</small></h3>
                <div class="page-bar">
                    <ul class="page-breadcrumb">
                        <li>
                            <i class="fa fa-home"></i>
                            <a href="javascript:;">服务设置</a>
                        </li>
                        <li>
                            <i class="fa fa-angle-right"></i>
                            <a href="javascript:;">服务申请查询</a>
                        </li>
                    </ul>
                </div>
                <div class="page-staus" style="border:none;">
                    <div class="page-tab">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="icon-tag"></i>
                                    <span>服务申请查询</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="page-table page-lit">
                        <div class="page-table page-lit page-border">
                            <div id="page-Tab" class="jy-Tab" style="width: 100%;">
                                <!-- 全部订单 -->
                                <table id="apply_list" data-side-pagination="server" data-pagination="true" data-height="" class="table table-hover" style="width: 100%;border:1px solid #ddd;">
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${resRoot}/common/jquery.min.js" type="text/javascript"></script>
    <script src="${resRoot}/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 表格插件 -->
    <script src="${resRoot}/plugins/bootstrap-table/js/bootstrap-table.js"></script>
    <script src="${resRoot}/pages/pubapply/apply.js" type="text/javascript"></script>
    <script>
    /*jQuery(document).ready(function() {
    	queryApplyList();
    });*/
    $(function(){
    	queryApplyList();
    });
    var basePath = '${base}';
    </script>
</body>

</html>
