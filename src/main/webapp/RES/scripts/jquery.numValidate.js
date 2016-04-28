/* 
 * 功能：文本框限制只能输入数字和两位小数
 * 版本：v0.1
 */ 
// 创建一个闭包    
(function($) {        

    $.fn.numValidate = function(){
        /* 如果输入非数字或不是两位小数，则替换为'' */    
        $(this).keyup(function(){
            
        //清除"数字"和"."以外的字符
        this.value = this.value.replace(/[^\d.]/g,"");
        //必须保证第一个为数字而不是.
        this.value = this.value.replace(/^\./g,"");
        //只保留第一个. 清除连续多余的.
        this.value = this.value.replace(/\.{2,}/g,".");
        //保证.只出现一次，而不能出现两次以上
        this.value = this.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
        //只能输入两个小数
        this.value = this.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');
          
        });
    
     };
     
})(jQuery);  // 闭包结束