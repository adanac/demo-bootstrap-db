<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">

<body>
    <!--用户批量导入layer弹层-->
    <form id="fileupload" name="fileuploadForm" action="${base}/excel/upload.do"  method="post" enctype="multipart/form-data">
    	文件名: <input type="text" name="fileName" /><br/>
            <input type="file" name="clientFile" /><br/>
            <input type="submit" value="上传文件 "/>
    </form>
   </body>
</html>

