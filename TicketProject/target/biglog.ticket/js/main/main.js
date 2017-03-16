
jQuery(document).ready(function() {

    $(".check").click(function(){

        var num1=$('#num1').val();
        var num2=$('#num2').val();
        var fileName=$('#fileToUpload').val();
        var mime = fileName.toLowerCase().substr(fileName.lastIndexOf("."));
        if(isNaN(num1)||isNaN(num2))
        {
            alert("请输入数值");
            return false;
        }
        if(mime!=".xls")
        {
            alert("请选择xls格式的工单文件");
            return false;
        }
        $.ajaxFileUpload({
            url : '/ticket/test/submit?num1='+num1+'&num2='+num2,
            secureuri : false,
            fileElementId : 'fileToUpload',
            dataType : 'json',//此时指定的是后台需要返回json字符串,前端自己解析,可以注释掉.后台直接返回map
            success : function(data) {
                table0(data[0],'.table0');
                table1(data[4],'.table1');
                table2(data[3],'.table2');
                table3(data[2],'.table3');
                table4(data[1],'.table4');

            }
        })
    });


})