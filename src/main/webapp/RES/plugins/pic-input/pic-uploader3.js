function initUploader(startBtn,target,fileContainer,url){
	var uploader=null,
		$time=null,
        $ff=1,          //1：初始值 2：成功 3：失败 4:正在上传
	uploader = WebUploader.create({

	    // 选完文件后，是否自动上传。
	    auto: false,
	    fileNumLimit: 1,
	    fileSingleSizeLimit: 1*1024*1024,

	    /*// swf文件路径
	    swf: BASE_URL + '/js/Uploader.swf',*/

	    // 文件接收服务端。
	    server: url,

	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: target,

	    // 只允许选择图片文件。
	    accept: {
	        title: 'Images',
	        extensions: 'gif,jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    },

	    fileVal:"FileContent",

	    withCredentials:true,

	    duplicate:true
	});
	uploader.on( 'fileQueued', function( file ) {
	    var $li = $(
	            '<div id="' + file.id + '" class="file-item thumbnail">' +
	                '<img>' +
	                '<div class="info">' + file.name + '</div>' +
	            '</div>'
	            ),
	        $img = $li.find('img');


	    // $list为容器jQuery实例
	    $(fileContainer).append( $li );

	    // 创建缩略图
	    // 如果为非图片文件，可以不用调用此方法。
	    // thumbnailWidth x thumbnailHeight 为 100 x 100
	    uploader.makeThumb( file, function( error, src ) {
	        if ( error ) {
	            //$img.replaceWith('<span>不能预览</span>');
	            layer.msg("不能预览");
	            return;
	        }

	        $img.attr( 'src', src );
	    }, 100, 100 );
	});

	//上传开始触发
	uploader.on('startUpload',function(){
		var index = layer.load(2, {shade: false}); //0代表加载的风格，支持0-2
	})


	uploader.on( 'uploadProgress', function( file, percentage ) {
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress span');

	    // 避免重复创建
	    if ( !$percent.length ) {
	        $percent = $('<p class="progress"><span></span></p>')
	                .appendTo( $li )
	                .find('span');
	    }

	    $percent.css( 'width', percentage * 100 + '%' );
	});

	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file ) {
		layer.closeAll();
		layer.msg("恭喜！上传成功");
		$ff=2;
	    $( '#'+file.id ).addClass('upload-state-done');
	});

	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
	    var $li = $( '#'+file.id ),
	        $error = $li.find('div.error');

	   /* // 避免重复创建
	    if ( !$error.length ) {
	        $error = $('<div class="error"></div>').appendTo( $li );
	    }*/

	   // $error.text('上传失败');
	   	layer.closeAll();
	    layer.msg("抱歉，上传失败");
	    $ff=3;
	});

	uploader.addButton({
	    id: '#btnContainer',
	    innerHTML: '选择文件'
	});
	

	$(".Btnfiles").on("click",function(){
		//uploader.addFiles($("#file1")[0]);
	})

	startBtn.on("click",function(){
		clearTimeout($time);
		layer.closeAll();
		uploader.upload();
		$ff=4;

		//当请求的时间过长
		$time=setTimeout(function(){
			if($ff!==2&&$ff!==3){
				layer.closeAll();
				layer.msg("服务器繁忙，请稍后再试。");
				clearTimeout($time);
			}
		},12000)
	})
}