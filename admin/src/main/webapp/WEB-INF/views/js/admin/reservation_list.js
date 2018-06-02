/**
 * Created by zhangqiao on 2018/6/1.
 */
jQuery(function(){
    $(document).ready(function(){
        $("table").dataTable({
            "oLanguage": {
                "sProcessing" : "店小二在拼命加载...",
                "sLoadingRecords" : "店小二在拼命加载...",
                "sLengthMenu" : "显示_MENU_条 ",
                "sZeroRecords" : "没有您要搜索的内容",
                "sInfo" : "显示 _START_ 到 _END_ ，共 _TOTAL_ 条",
                "sInfoFiltered": "(共 _MAX_ 条)",
                "sInfoEmpty" : "记录数为0",
                "sInfoPostFix" : "",
                "sSearch" : "餐桌桌号搜索",
                "sUrl" : "",
                "oPaginate" : {
                    "sFirst" : "第一页",
                    "sPrevious" : " 上一页 ",
                    "sNext" : " 下一页 ",
                    "sLast" : " 最后一页 "
                }
            },
            "sErrMode": "throw",
            "bDestroy": true,
            "bSort": false,
            "bStateSave": true,
            "bProcessing": false, // 是否显示取数据时的那个等待提示
            "bServerSide": true,//这个用来指明是通过服务端来取数据
            "sAjaxSource": "reservation_list.json",//这个是请求的地址
            "fnServerData": retrieveData, // 获取数据的处理函数
            "fnServerParams": function (aoData) {
            },
            "aoColumns":[
                { "mData": "id",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    returnStr += '<input type="checkbox" name="choice" value="'+full["id"]+'">';
                    return returnStr;
                }},
                { "mData": "userId",'sClass':'center'},
                { "mData": "mealTime",'sClass':'center'},
                { "mData": "tablewareNumber",'sClass':'center'},
                { "mData": "status",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    if(full["status"]==0){
                        returnStr +="客人还未到";
                    }else  if(full["status"]==0){
                        returnStr +="可用";
                    }else  if(full["status"]==-1){
                        returnStr +="取消";
                    }else  if(full["status"]==1){
                        returnStr +="客人到达";
                    }else  if(full["status"]==2){
                        returnStr +="调换餐桌";
                    }
                    return returnStr;
                }},
                { "mData": "remarks",'sClass':'center'},
                { "mData": "flag",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    if(full["flag"]==0){
                        returnStr +="预约";
                    }else{
                        returnStr +="直接进店";
                    }
                    return returnStr;
                }},
                { "mData": "id",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    returnStr += '<i class="Hui-iconfont cursor-pointer" title="调换餐桌" onClick="transfer(\''+full["id"]+'\')" style="font-size: large;">&#xe647;</i>';
                    returnStr += '&nbsp;&nbsp;<i class="Hui-iconfont cursor-pointer" title="取消" onClick="cancel(\''+full["id"]+'\')" style="color: red;font-size: large;">&#xe66b;</i>';
                    returnStr += '&nbsp;&nbsp;<i class="Hui-iconfont cursor-pointer" title="记录到达" onClick="record_arrival(\''+full["id"]+'\')" style="font-size: large;">&#xe60c;</i>';
                    return returnStr;
                }},
            ]
        });
    });
});

// 3个参数的名字可以随便命名,但必须是3个参数,少一个都不行
function retrieveData( sSource111,aoData111, fnCallback111) {
    $.ajax({
        url : sSource111,//这个就是请求地址对应sAjaxSource
        data : {"aoData":JSON.stringify(aoData111)},//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
        type : 'post',
        dataType : 'json',
        async : false,
        success : function(result) {
            fnCallback111(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
        },
        error : function(msg) {
        }
    });
}

/*
 参数解释：
 title	标题
 url		请求的url
 id		需要操作的数据id
 w		弹出层宽度（缺省调默认值）
 h		弹出层高度（缺省调默认值）
 */
/*管理员-增加*/
function transfer() {

}

function cancel() {
    
}

