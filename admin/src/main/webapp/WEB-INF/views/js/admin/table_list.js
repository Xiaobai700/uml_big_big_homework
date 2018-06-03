/**
 * Created by zhangqiao on 2018/6/1.
 */
var table =""
jQuery(function(){
    $(document).ready(function(){
        table = $("table").dataTable({
            "oLanguage": {
                "sProcessing" : "正在加载数据...",
                "sLoadingRecords" : "正在加载数据...",
                "sLengthMenu" : "显示_MENU_条 ",
                "sZeroRecords" : "没有您要搜索的内容",
                "sInfo" : "显示 _START_ 到 _END_ ，共 _TOTAL_ 条",
                "sInfoFiltered": "(共 _MAX_ 条)",
                "sInfoEmpty" : "记录数为0",
                "sInfoPostFix" : "",
                "sSearch" : "餐桌号搜索",
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
            "bProcessing": true, // 是否显示取数据时的那个等待提示
            "bServerSide": true,//这个用来指明是通过服务端来取数据
            "sAjaxSource": "table_list.json",//这个是请求的地址
            "fnServerData": retrieveData, // 获取数据的处理函数
            "fnServerParams": function (aoData) {
                aoData.push({
                        name: "tableStatus",
                        value: $('#tableStatus option:selected').val()
                    })
            },
            "aoColumns":[
                { "mData": "id",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    returnStr += '<input type="checkbox" name="choice" value="'+full["id"]+'">';
                    return returnStr;
                }},
                { "mData": "tableNo",'sClass':'center'},
                { "mData": "seatsNumber",'sClass':'center'},
                { "mData": "tableStatus",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    if(full["tableStatus"]==0){
                        returnStr +="未被预约";
                    }else{
                        returnStr +=full["tableStatus"]+"个预约";
                    }
                    return returnStr;
                }},
                { "mData": "updatetime",'sClass':'center'},
                { "mData": "id",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    returnStr += '<i class="Hui-iconfont cursor-pointer" title="禁用" onClick="jinyong(\''+full["id"]+'\')">&#xe6e2;</i>';
                    return returnStr;
                }}
            ]
        });
        $("#tableStatus").change(function () {
            var tableStatus = $('#tableStatus option:selected').val();
            if (tableStatus != null && tableStatus !="") {
                table.fnDraw();
            }
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
function jinyong() {

}
