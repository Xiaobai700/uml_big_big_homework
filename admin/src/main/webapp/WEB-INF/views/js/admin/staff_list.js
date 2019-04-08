/**
 * Created by zhangqiao on 2018/5/31.
 */
jQuery(function(){
    $(document).ready(function(){
        $("table").dataTable({
            "oLanguage": {
                "sProcessing" : "正在加载数据...",
                "sLoadingRecords" : "正在加载数据...",
                "sLengthMenu" : "显示_MENU_条 ",
                "sZeroRecords" : "没有您要搜索的内容",
                "sInfo" : "显示 _START_ 到 _END_ ，共 _TOTAL_ 条",
                "sInfoFiltered": "(共 _MAX_ 条)",
                "sInfoEmpty" : "记录数为0",
                "sInfoPostFix" : "",
                "sSearch" : "员工工号搜索",
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
            "sAjaxSource": "staff_list.json",//这个是请求的地址
            "fnServerData": retrieveData, // 获取数据的处理函数
            "aoColumns":[
                { "mData": "id",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    returnStr += '<input type="checkbox" name="choice" value="'+full["id"]+'">';
                    return returnStr;
                }},
                { "mData": "type",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    if(full["type"]==0){
                        returnStr +="领班";
                    }else{
                        returnStr +="服务员";
                    }
                    return returnStr;
                }},
                { "mData": "jobNumber",'sClass':'center'},
                { "mData": "name",'sClass':'center'},
                { "mData": "sex",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    if(full["sex"]==0){
                        returnStr +="男";
                    }else{
                        returnStr +="女";
                    }
                    return returnStr;
                }},
                { "mData": "id",'sClass':'center',"mRender": function(data, type, full) {
                    var returnStr="";
                    returnStr += '<i class="Hui-iconfont cursor-pointer" title="禁用" onClick="jinyong(\''+full["id"]+'\')">&#xe6e2;</i>';
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
function add_admin(title,url,w,h){
    layer_show(title,url,w,h);
    layer.msg("添加员工功能还未开放", {icon: 5, time: 1000});
}

function jinyong() {
    layer.msg("禁用员工功能还未开放", {icon: 5, time: 1000});
}
