function table0(data,tableName){

    var l = data.length;

    var content = '<tr>';

    for(var i = 0;i<l;i++)
    {
        content = content +'<td>'+data[i].num+'</td>'
    }

    $(tableName).append(content);



}
function table1(data,tableName){

    //alert("table1");
    //var content='<table id="example-paper"  cellspacing="0"  align="center">'
    //    +'<thead><tr><th>工单流水号</th><th>原因分类</th><th>原因明细</th><th>故障原因</th>处理措施</tr></thead><tbody>'

    var l = data.length;
    var content = ''



    for(var i=0;i<l;i++){
        var ticket = data[i];
        content = content+'<tr><td>'+ticket.ticketNum+'</td><td>'+ticket.reasonClassification+'</td><td>'+ticket.reasonSubdivision+'</td><td>'+ticket.failureReason+'</td><td>'+ticket.processingMeasures+'</td></tr>'

    }

    $(tableName).append(content);

}
function table2(data,tableName){


    var l = data.length;
    var content = ''



    for(var i=0;i<l;i++){
        var ticket = data[i];
        content = content+'<tr><td>'+ticket.ticketNum+'</td><td>'+ticket.alarmTitle+'</td><td>'+ticket.reasonClassification+'</td><td>'+ticket.reasonSubdivision+'</td><td>'+ticket.failureReason+'</td></tr>'

    }

    $(tableName).append(content);

}

function table3(data,tableName){

    //alert("table1");
    //var content='<table id="example-paper"  cellspacing="0"  align="center">'
    //    +'<thead><tr><th>工单流水号</th><th>原因分类</th><th>原因明细</th><th>故障原因</th>处理措施</tr></thead><tbody>'

    var l = data.length;
    var content = ''



    for(var i=0;i<l;i++){
        var ticket = data[i];
        content = content+'<tr><td class="ticketNum">'+ticket.ticketNum+'</td><td class="reasonClassification">'+ticket.reasonClassification+'</td><td class="reasonSubdivision">'+ticket.reasonSubdivision+'</td><td class="failureReason">'+ticket.failureReason+'</td><td class="processingMeasures">'+ticket.processingMeasures+'</td><td><a href="javaScript:;" class="add">ADD</a></td></tr>'

    }



    $(tableName).append(content);


    jQuery('.add').click(function(){

        var reasonClassification =  $(this).parent().parent().children('.reasonClassification').text();

        var reasonSubdivision =  $(this).parent().parent().children('.reasonSubdivision').text();

        var failureReason =  $(this).parent().parent().children('.failureReason').text();

        var processingMeasures =  $(this).parent().parent().children('.processingMeasures').text();

        var reasonAndMeasure = {reasonClassification:reasonClassification,reasonSubdivision:reasonSubdivision,failureReason:failureReason,};

        $.ajax({
            url: "/ticket/test/add_reasonAndMeasure",
            type: "post",
            data:reasonAndMeasure,
            dataType: "text",
            error: function (XMLHttpRequest, textStatus, errorThrown,error) {
                alert(XMLHttpRequest.status);
            },
            success: function (result) {

                alert(result);

            }

        });




    })

}

function table4(data,tableName){


    var l = data.length;
    var content = ''



    for(var i=0;i<l;i++){
        var ticket = data[i];
        content = content+'<tr><td class="ticketNum">'+ticket.ticketNum+'</td><td class="alarmTitle">'+ticket.alarmTitle+'</td><td class="reasonClassification">'+ticket.reasonClassification+'</td><td class="reasonSubdivision">'+ticket.reasonSubdivision+'</td><td class="failureReason">'+ticket.failureReason+'</td><td><a href="javaScript:;" class="add">ADD</a></td></tr>'

    }

    $(tableName).append(content);

    jQuery('.add').click(function(){

        var alarmTitle = $(this).parent().parent().children('.ticketNum').text();

        var reasonClassification =  $(this).parent().parent().children('.reasonClassification').text();

        var reasonSubdivision =  $(this).parent().parent().children('.reasonSubdivision').text();

        var failureReason =  $(this).parent().parent().children('.failureReason').text();

        var alarmAndReason = {alarmTitle:alarmTitle,reasonClassification:reasonClassification,reasonSubdivision:reasonSubdivision,failureReason:failureReason};

        $.ajax({
            url: "/ticket/test/add_alarmAndReason",
            type: "post",
            data:alarmAndReason,
            dataType: "text",
            error: function (XMLHttpRequest, textStatus, errorThrown,error) {
                alert(XMLHttpRequest.status);
            },
            success: function (result) {

                alert(result);

            }

        });




    })



}