/**
 * Created by ASUS on 2017/5/24.
 */
var user_id=''
var form,layer
var flowDesign;
var dataToAll;//全部数据
var jsondata = {
    "title": "",
    "nodes": {},
    "lines": {},
    "areas": {},
    "initNum": 0
}
var alertData;//条件设置字段
var flowidurl=window.location.href;
var flowstr=flowidurl.substring(flowidurl.indexOf('=')+1)
var numId={};
var conditionsDate;//条件数据


function saveOrUpdate() {
    $.ajax({
        type: 'POST',
        url: '/flowProcess/insert',
        dataType: 'json',
        data: numId,
        success: function (json) {
            if (json.flag) {
               ajaxSvg();
            }else{
                alert("新建流程节点失败");
            }
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert("数据库连接异常，请联系管理员");
        }
    });
}

function inputTheEcho(names,dataNames) {  //input回显
    if(dataNames==''){
        $('[name="'+names+'"]').val('')
        return;
    }
    $('[name="'+names+'"]').val(dataNames);
}
function seleTheEcho(names,dataNames) {  //下拉框回显
    $('[name="'+names+'"]').next().find('dd').each(function (i,n) {
        if($(this).attr('lay-value')==dataNames){
            $(this).parent().prev().find('input').val($(this).text())
        }
    })
}

function radioTheEcho(names,dataNames) {
    $('[name="'+names+'"]').each(function (i,n) {

        if($(this).val()==dataNames){
            $(this).prop('checked',true);
            $(this).next().click();
        }
    })
}


function ajaxSvg() {
    $.ajax({
        type: 'get',
        url: '/flowProcess/flowview',
        dataType: 'json',
        data: {"flowId":flowstr},
        success: function (json) {
            // debugger;
//                    获取数据并添加到流程设计器的插件中
            if (json.flag) {
                var designdata = json.object.designdata;
                var connections = json.object.connections;
                console.log(designdata)
                for(var inde=0;inde<designdata.length;inde++){

                }
                jsondata={
                    "title": "",
                    "nodes": {},
                    "lines": {},
                    "areas": {},
                    "initNum": 0
                }
                jsondata.title = json.object.designdata[0].flowName;
                jsondata.initNum = designdata.length;
                designdata.forEach(function (v, i) {
                    jsondata.nodes['node_' + v.prcsId] = {
                        designerId:v.id,
                        name: v.prcsName,
                        left: v.setLeft,
                        type: v.setType,
                        top: v.setTop,
                        data:{

                            prcsId:v.prcsId,
                            prcsType:v.prcsType,
                            prcsName:v.prcsName,
                            //下一步骤
                            prcsUser:v.prcsUser,
                            prcsDept:v.prcsDept,
                            prcsPriv:v.prcsPriv,
                            signType:v.signType,
                            countersign:v.countersign,
                            userFilter:v.userFilter,
                            autoType:v.autoType,
                            topDefault:v.topDefault,//流转设置
                            userLock:v.userLock,
                            feedback:v.feedback,
                            signlook:v.signlook,
                            turnPriv:v.turnPriv,
                            allowBack:v.allowBack,
                            syncDeal:v.syncDeal,
                            gatherNode:v.gatherNode,
                            viewPriv:v.viewPriv,

                            //可写字段
                            hiddenItem:v.hiddenItem,
                            requiredItem:v.requiredItem,
                            conditionsSet:{
                                conditionDesc:v.conditionDesc,//不符合条件公式时，给用户的文字描述
                                typeJudgments:v.typeJudgments,
                                prcsInSet:v.prcsInSet,
                                conditionDesc:v.conditionDesc,
                                prcsOutSet:v.prcsOutSet,
                                prcsIn:v.prcsIn,
                                prcsOut:v.prcsOut
                            },
                            timeOut:v.timeOut,
                            timeOutModify:v.timeOutModify,
                            timeOutType:v.timeOutType,
                            workingdaysType:v.workingdaysType,
                            timeOutAttend:v.timeOutAttend
                            //触发器
                            //提醒设置
                            //呈批单设置
                        }
                    }
                });
                connections.forEach(function (v, i) {
                    jsondata.lines['line_' + i] = {
                        type: "sl",
                        from: "node_" + v.from,
                        to: "node_" + v.to,
                        name: "",
                        "M": 41.5,
                        alt: true
                    }
                });
            }
            flowDesign.onItemDel = function (id, type) {
                if (confirm("确定要删除该单元吗?")) {
                    // this.blurItem();
                            return true;
                } else {
                    return false;
                }
            };

            flowDesign.loadData(jsondata);
          console.log(jsondata)
            flowDesign.onItemFocus = function (id, model) {
                $('#propertyForm').css('right','0px')
                $('.btnstorage').css('right','0px')
                var obj;
                $("#ele_model").val(model);
                $("#ele_id").val(id);
                if (model == "line") {
                    // obj = this.$lineData[id];
                    // $("#ele_type").val(obj.M);
                    // $("#ele_left").val("");
                    // $("#ele_top").val("");
                    // $("#ele_width").val("");
                    // $("#ele_height").val("");
                    // $("#ele_designerId").val("");
                    // $("#ele_from").val(obj.from);
                    // $("#ele_to").val(obj.to);
                    // $("#ele_flow").val("");

                } else if (model == "node") {
                    obj = this.$nodeData[id];
                    $("#ele_type").val(obj.type);
                    $("#ele_designerId").val(obj.designerId);
                    $("#ele_left").val(obj.left);
                    $("#ele_top").val(obj.top);
                    $("#ele_width").val(obj.width);
                    $("#ele_height").val(obj.height);
                    // $("#ele_from").val("");
                    // $("#ele_to").val("");
                    $("#ele_flow").val('${formId}');
                    var objtwo=obj.data;
                    console.log(objtwo);
                    inputTheEcho('prcsId',objtwo.prcsId)
                    seleTheEcho('prcsType',objtwo.prcsType)
                    inputTheEcho('prcsName',objtwo.prcsName)
                    inputTheEcho('prcsUser',objtwo.prcsUser)
                    inputTheEcho('prcsDept',objtwo.prcsDept)
                    inputTheEcho('prcsPriv',objtwo.prcsPriv)
                    radioTheEcho('signType',objtwo.signType)
                    radioTheEcho('countersign',objtwo.countersign)
                    seleTheEcho('userFilter',objtwo.userFilter)
                    seleTheEcho('autoType',objtwo.autoType)
                    inputTheEcho('timeOut',objtwo.timeOut)
                    radioTheEcho('timeOutModify',objtwo.timeOutModify)
                    radioTheEcho('timeOutType',objtwo.timeOutType)
                    radioTheEcho('workingdaysType',objtwo.workingdaysType)
                    radioTheEcho('timeOutAttend',objtwo.timeOutAttend)
                    radioTheEcho('topDefault',objtwo.topDefault)
                    radioTheEcho('userLock',objtwo.userLock)
                    radioTheEcho('feedback',objtwo.feedback)
                    radioTheEcho('signlook',objtwo.signlook)
                    radioTheEcho('turnPriv',objtwo.turnPriv)
                    radioTheEcho('allowBack',objtwo.allowBack)
                    radioTheEcho('syncDeal',objtwo.syncDeal)
                    radioTheEcho('gatherNode',objtwo.gatherNode)
                    radioTheEcho('viewPriv',objtwo.viewPriv)
                    dataToAll=designdata;//所有数据
                    conditionsDate=objtwo.conditionsSet;
                    //下一步骤
                    for(var inde=0;inde<designdata.length;inde++){
                        if(inde<designdata.length-1) {
                            if (designdata[inde].prcsName == $('[name="prcsName"]').val()) {
                                $('#candidatesPoneli').html('<li>' + designdata[inde + 1].prcsName + '</li>')
                            }
                        }else {
                            if (designdata[inde].prcsName == $('[name="prcsName"]').val()) {
                                $('#candidatesPoneli').html('')
                            }
                        }
                    }


                }
                $("#ele_name").val(obj.name);
                return true;
            };
        },
    });
}
$(function () {
    var fromIdtwo = 17;
    workForm.init({
            formhtmlurl:'../../form/formType',
            resdata:{
                fromId:fromIdtwo
            },
            flag:3
        },
        function(data){
            alertData=data;
            console.log(data);
        });






    $('.savetwo').click(function () {
        $('#datasave').ajaxSubmit({
            type:'post',
            dataType:'json',
            success:function () {
                ajaxSvg();
            }
        })
    })

    $(document).delegate('#checkAll span .layui-form-checkbox','click',function () {
        if($(this).prev().is(':checked')){
            $('.bottomstepstwo input[type=checkbox]').each(function (i,n) {
                $(this).prop('checked',true)
                $(this).next().addClass('layui-form-checked')
            })
        }
        else {
            $('.bottomstepstwo input[type=checkbox]').each(function (i,n) {
                $(this).removeProp('checked')
                $(this).next().removeClass('layui-form-checked')
            })
        }
    })
    $(document).delegate('.theEditor','click',function () {
        $(this).parent().parent().find('span').hide();
        $(this).parent().parent().find('input').show();
        $(this).parent().parent().find('input').val($(this).parent().parent().find('input[type=hidden]').val());
    })

    $(document).delegate('#bottomstepstwoss table tbody input[type=text]','blur',function () {
       $(this).next().val($(this).val());
       $(this).hide();
       $(this).prev().text($(this).val())
        $(this).prev().show();
    })




        var $width=$('body').width();
        var $height=$(document).height();

        var property = {
            width: $width,
            height: $height,
            toolBtns: ["chat"],
//                "start round", "end round", "task round", "node","state", "plug", "join", "fork", "complex mix"
            haveHead: true,
            headBtns: [ ],//如果haveHead=true，则定义HEAD区的按钮
            haveTool: true,
            haveGroup: true,
            useOperStack: true
        };
        var remark = {
            cursor: "选择指针",
            direct: "结点连线",
            start: "入口结点",
            end: "结束结点",
            task: "任务结点",
            node: "自动结点",
            chat: "决策结点",
            state: "状态结点",
            plug: "附加插件",
            fork: "分支结点",
            join: "联合结点",
            "complex mix": "复合结点",
            group: "组织划分框编辑开关"
        };
        flowDesign = $.createGooFlow($("#flowDesignTable"), property);
        flowDesign.setNodeRemarks(remark);

ajaxSvg();


    $('#propertyForm').height($('body').height()-65);
    $('#propertyForm').css('max-height',$('body').height()+2000)
    $('#propertyForm').css('right',-$('#propertyForm').width())
    $('.btnstorage').css('right',-$('.btnstorage').width())



    $('.closebtns').click(function () {
        $('#propertyForm').css('right',-$('#propertyForm').width())
        $('.btnstorage').css('right',-$('.btnstorage').width())
    })
    $('.setUpThe').click(function (event) {
        var me=this;
        $(this).next('.candidatesUl').siblings('.candidatesUl').stop().slideUp('slow');
        $(this).next('.candidatesUl').slideToggle("slow");
        if($(this).hasClass('active')){
            $(this).removeClass('active')
        }else {
            $(this).addClass('active');
        }
        $(me).siblings().removeClass('active');
        event.stopPropagation();
    })

    $('.dropDownDiv .candidatesPTwo').on('click',function (event) {
        $(this).next().stop().slideToggle("slow")
        event.stopPropagation();
    })
    $('.dropDownDiv .dropDown li').on('click',function (event) {
        $(this).parent().stop().slideUp("slow");
        $(this).parent().parent().find('input[type=text]').val($(this).find('span').text())
        $(this).parent().parent().find('input[type=hidden]').val($(this).find('input').val())
        event.stopPropagation();
    })
    $('.theCandidates').on('click',function () {
        user_id = $(this).parent().siblings('input').prop('id');
        var num=$(this).attr('data-num')
        if(num==1) {
            $.popWindow("../common/selectUser");
        }
    })


    layui.use(['layer', 'form'], function(){
        layer = layui.layer
            ,form = layui.form();
        $('.bottomsteps').click(function () {
            var str='';
            for(var i=0;i<dataToAll.length;i++){
                str+='<input type="checkbox" title="'+dataToAll[i].prcsName+'" value="'+dataToAll[i].prcsId+'">'
            }
            var me=this;

        layer.open({
            type:1,
            title:'下一步骤',
            closeBtn:2,
            content:'<div class="bottomstepstwo layui-form" style="margin: 10px ;">'+str+ '<div style="margin-top: 15px;" id="checkAll"><span><input type="checkbox" class="checkedAll" title="全选"></span> <input type="checkbox" title="结束" value="0"></div>'+
            '</div>' ,
            area:['400px','300px'],
            btn:['确定','关闭'],
            yes:function (index) {
                var str='';
                var strTwo='';
                var obj=$('.bottomstepstwo input[type=checkbox]:checked');
                obj.each(function (i,n) {
                    if(i<obj.length-1){
                        str+=$(this).val()+','
                    }else {
                        str+=$(this).val();
                    }
                    strTwo+='<li>('+(i+1)+')'+$(this).next().find('span').text()+'</li>'
                })
                $(me).next().val(str);
                $(me).parent().prev().html(strTwo)
                layer.close(index)
            },
            success:function () {
                form.render();
            }
        })
    })





        $('#conditions').click(function () {//条件生成器

            var strprcsIn=conditionsDate.prcsIn.replace(/\n/g,'');
            var arrprcsIn=strprcsIn.split('\r')
            var intoTheConditionPrcsIn='';
            for(var m=0;m<arrprcsIn.length;m++){
                if(m<arrprcsIn.length-1) {
                    intoTheConditionPrcsIn += '<tr><td width="20%">' + (m + 1) + '</td>' +
                        '<td width="60%"><span>' + arrprcsIn[m] + '</span><input type="text" name="ConditionsInput" style="display: none">' +
                        '<input type="hidden" value="' + arrprcsIn[m] + '"></td>' +
                        '<td><a href="javascript:;" class="theEditor" style="margin-right: 10px;color: #2f8ae3">编辑</a>' +
                        '<a href="javascipt:;" class="deletes" style="color: #2f8ae3">删除</a></td></tr>'
                }
            }
            var strprcsOut=conditionsDate.prcsOut.replace(/\n/g,'');
            var arrprcsOut=strprcsOut.split('\r');
            console.log(arrprcsOut)
            var transferConditionsprcsOut='';
            for(var q=0;q<arrprcsOut.length;q++){
                if(q<arrprcsOut.length-1) {
                    transferConditionsprcsOut += '<tr><td width="20%">' + (q + 1) + '</td>' +
                        '<td width="60%"><span>' + arrprcsOut[q] + '</span><input type="text" name="ConditionsInput" style="display: none">' +
                        '<input type="hidden" value="' + arrprcsOut[q] + '"></td>' +
                        '<td><a href="javascript:;" class="theEditor" style="margin-right: 10px;color: #2f8ae3">编辑</a>' +
                        '<a href="javascipt:;" class="deletes" style="color: #2f8ae3">删除</a></td></tr>'
                }
            }

            var str=''
           for(var i=0;i<alertData.length;i++){
               str+='<option value="'+alertData[i].name+'">'+alertData[i].title+'</option>'
           }
           var arr=[{'name':'等于','val':'='},{'name':'不等于','val':'!='},{'name':'大于','val':'>'},{'name':'小于','val':'<'}
           ,{'name':'小于等于','val':'<='},{'name':'大于等于','val':'>='},{'name':'包含','val':'include'},{'name':'不包含','val':'exclude'}]
            var strone='';
            for(var i=0;i<arr.length;i++){
                strone+='<option value="'+arr[i].val+'">'+arr[i].name+'</option>'
            }
            layer.open({
                type:1,
                title:'条件生成器',
                content:'<div class="bottomstepstwoss layui-form" id="bottomstepstwoss">\
            <ul class="candidatesUl" style="display: block;border: none;">\
                <li>\
                   <p class="candidatesPone">字段</p> \
                    <div class="dropDownDiv">\
                        <p class="candidatesPTwo">\
                        <input type="hidden">\
                            <select name="fieldsele" lay-verify="">'+str+'</select>\
                        </p>\
                    </div>\
                </li>\
                 <li>\
                   <p class="candidatesPone">条件</p> \
                    <div class="dropDownDiv" style="z-index:99998">\
                        <p class="candidatesPTwo">\
                           <select name="conditionss" lay-filter="conditionstwo" lay-verify="">'+strone+'</select>\
                        </p>\
                    </div>\
                </li>\
                <li>\
                   <p class="candidatesPone" id="typepanduan"><input type="checkbox" lay-filter="typeJudgment" title="类型判断"/></p> \
                        <p class="candidatesPTwo" id="typevalue">\
                            <select name="typeJudgments"  lay-verify="" style="display:none">\
                            <option value="数值">数值</option><option value="日期">日期</option><option value="时间+日期">时间+日期</option></select>\
                            <input type="text" name="typeJudgments" class="typeJudgmentTwo" style="    vertical-align: top;"><span style="text-align: center;font-size: 14px;margin-left: 50px;margin-top: 5px;display: inline-block;">值</span>\
                        </p>\
                </li>\
                <li class="btnzhuanru">\
                    <a href="javascript:;" class="intoTheConditionBtn" style="margin: 0 20px 0 -52px;" data-add="0">添加转入条件</a>\
                    <a href="javascript:;" class="intoTheConditionBtn" data-add="1">添加转出条件</a>\
                </li>\
                <li>\
                   <p class="candidatesPone">转入条件列表</p> \
                   <p class="candidatesPTwo" id="intoTheCondition" style="border: none;margin-bottom: 20px;">\
                           <table>\
                                <thead>\
                                    <tr>\
                                        <th width="20%">编号</th>\
                                        <th width="60%">条件描述</th>\
                                        <th width="20%">操作</th>\
                                    </tr>\
                                </thead>\
                                <tbody>'+intoTheConditionPrcsIn+'</tbody>\
                           </table>\
                   </p>\
                   <p class="candidatesPone">转入条件公式(条件与逻辑运算符之间需空格，如[1] AND [2])</p> \
                    <p class="candidatesPTwo">\
                            <input type="text" name="prcsInSet" value="'+conditionsDate.prcsInSet+'">\
                     </p>\
                      <p class="candidatesPone">不符合条件公式时，给用户的文字描述：</p> \
                    <p class="candidatesPTwo">\
                            <input type="text" name="conditionDesc" value="'+conditionsDate.conditionDesc+'">\
                            <p style="color: red;font-size: 12px;margin-top: 5px;">合理设定转入条件，可形成流程的条件分支，但数据满足转入条件，才可转入本步骤</p>\
                     </p>\
                </li>\
                <li style="margin-top: 20px;">\
                     <p class="candidatesPone">转出条件列表</p> \
                     <p class="candidatesPTwo" id="transferConditions" style="border: none;margin-bottom: 20px;">\
                         <table>\
                          <thead>\
                                    <tr>\
                                        <th width="20%">编号</th>\
                                        <th width="60%">条件描述</th>\
                                        <th width="20%">操作</th>\
                                    </tr>\
                                </thead>\
                                <tbody>'+transferConditionsprcsOut+'</tbody>\
                         </table>\
                     </p>\
                      <p class="candidatesPone">转出条件公式(条件与逻辑运算符之间需空格，如[1] AND [2])</p> \
                    <p class="candidatesPTwo">\
                            <input type="text" name="prcsOutSet">\
                     </p>\
                      <p class="candidatesPone">不符合条件公式时，给用户的文字描述：</p> \
                    <p class="candidatesPTwo">\
                            <input type="text" name="conditionDesc">\
                     </p>\
                </li>\
            </ul>\
            </div>',
                area:['800px','600px'],
                btn:['确定','关闭'],
                yes:function (index) {
                    var obj={};
                    obj.intoTheCondition={}
                    obj.intoTheCondition.list=[]
                    $('#intoTheCondition').find('[type=hidden]').each(function (i,n) {
                        obj.intoTheCondition.list.push($(this).val())
                    })
                    obj.intoTheCondition.prcsInSet=$('#bottomstepstwoss').find('[name="prcsInSet"]').val()
                    obj.intoTheCondition.conditionDesc=$('#bottomstepstwoss').find('[name="conditionDesc"]').val()
                    obj.transferConditions={};
                    obj.transferConditions.list=[];
                    $('#transferConditions').find('[type=hidden]').each(function (i,n) {
                        obj.transferConditions.list.push($(this).val())
                    })
                    obj.transferConditions.prcsOutSet=$('#bottomstepstwoss').find('[name="prcsOutSet"]').val()
                    obj.transferConditions.conditionDesc=$('#bottomstepstwoss').find('[name="conditionDesc"]').val()
                   var strobj=JSON.stringify(obj);
                    $('[name="settlementOfCondition"]').val(strobj);
                    $('.setUpThe').removeClass('active')
                    layer.close(index)
                },
                btn2:function () {
                    $('.setUpThe').removeClass('active')
                },
                success:function () {
                    form.render();
                    $('#typevalue').find('select').next().hide();
                    $('.intoTheConditionBtn').click(function () {
                        var strval;
                          if($('#typevalue div').css('display')=='none'){
                              strval=$('input[name="typeJudgments"]').val()
                          }else{
                              strval=$('select[name="typeJudgments"]').val()
                          }
                        var strIng='';
                        var num;
                        var strconditions="'"+$('[name="fieldsele"]').next().find('input').val()+"'" +
                            ""+$('[name="conditionss"]').val()+"'"+strval+"'";
                            if($(this).attr('data-add')=='0'){
                                strIng='<tr><td width="20%">'+($('#intoTheCondition table tbody tr').length+1)+'</td>' +
                                    '<td width="60%"><span>'+strconditions+'</span><input type="text" name="ConditionsInput" style="display: none">' +
                                    '<input type="hidden" value="'+strconditions+'"></td>' +
                                    '<td><a href="javascript:;" class="theEditor" style="margin-right: 10px;color: #2f8ae3">编辑</a>' +
                                    '<a href="javascipt:;" class="deletes" style="color: #2f8ae3">删除</a></td></tr>'
                                $('#intoTheCondition table tbody input[type=hidden]').each(function (i,n) {
                                    if($(this).val()==strconditions){
                                        alert('已有，请不要重复添加');
                                        num=1;
                                        return false;
                                    }
                                })
                                if(num==1){
                                    return;
                                }
                                $('#intoTheCondition table tbody').append(strIng)
                            }else if($(this).attr('data-add')=='1'){
                                strIng='<tr><td width="20%">'+($('#transferConditions table tbody tr').length+1)+'</td>' +
                                    '<td width="60%"><span>'+strconditions+'</span><input type="text" name="ConditionsInput" style="display: none">' +
                                    '<input type="hidden" value="'+strconditions+'"></td>' +
                                    '<td><a href="javascript:;" class="theEditor" style="margin-right: 10px;color: #2f8ae3">编辑</a>' +
                                    '<a href="javascipt:;" class="deletes" style="color: #2f8ae3">删除</a></td></tr>'
                                $('#transferConditions table tbody input[type=hidden]').each(function (i,n) {
                                    if($(this).val()==strconditions){
                                        alert('已有，请不要重复添加');
                                        num=1;
                                        return false;
                                    }
                                })
                                if(num==1){
                                    return;
                                }
                                $('#transferConditions table tbody').append(strIng)
                            }

                    })

                }
            })


            //条件生成器里下拉
            form.on('select(conditionstwo)', function(data){
                console.log(data.elem); //得到select原始DOM对象
                console.log(data.value); //得到被选中的值
                console.log(data.othis); //得到美化后的DOM对象
                if(data.value=='='||data.value=='!='){
                    $('#typepanduan').find('div').show();

                }else {
                    $('#typepanduan').find('div').hide();
                }
            });
            form.on('checkbox(typeJudgment)', function(data){
                console.log(data.elem.checked); //是否被选中，true或者false
                if(data.elem.checked){
                    $('#typevalue').find('select').next().show();
                    $('.typeJudgmentTwo').hide();
                    $('.typeJudgmentTwo').next().hide();
                }else {
                    $('#typevalue').find('select').next().hide();
                    $('.typeJudgmentTwo').show();
                    $('.typeJudgmentTwo').next().show();
                }
            });

        })

        var newtheTrigger={//新增触发器公功能
            obj:{},
            init:function () {
                var me=this;
                $(document).delegate('.newtheTrigger','click',function () {
                    me.openAlert();
                })
            },
            openAlert:function () {
                layer.open({
                    type:1,
                    title:'新建触发器',
                    content:'<div class="bottomstepstwoss layui-form" style="height: 380px;">\
                    <ul class="candidatesUl" style="display: block;border: none;">\
                        <li>\
                            <p class="candidatesPone"><b style="color:red;margin-right: 8px;vertical-align: middle">*</b>触发节点</p> \
                            <div class="dropDownDiv" style="z-index:99999">\
                                <p class="candidatesPTwo">\
                                  <select name="city" lay-verify="">\
                                    <option value="">请选择一个城市</option>\
                                    <option value="010">北京</option>\
                                    <option value="021">上海</option>\
                                    <option value="0571">杭州</option>\
                                </select>\
                                </p>\
                             </div>\
                        </li>\
                        <li>\
                            <p class="candidatesPone"><b style="color:red;margin-right: 8px;vertical-align: middle">*</b>排序号</p> \
                            <div class="dropDownDiv" style="z-index:99998">\
                                <p class="candidatesPTwo">\
                                   <select name="city" lay-verify="">\
                                        <option value="">请选择一个城市</option>\
                                        <option value="010">北京</option>\
                                        <option value="021">上海</option>\
                                        <option value="0571">杭州</option>\
                                     </select>\
                                </p>\
                             </div>\
                        </li>\
                        <li>\
                            <p class="candidatesPone"><b style="color:red;margin-right: 8px;vertical-align: middle">*</b>名称</p> \
                            <div class="dropDownDiv" style="z-index:99997">\
                                <p class="candidatesPTwo">\
                                    <select name="city" lay-verify="">\
                                    <option value="">请选择一个城市</option>\
                                    <option value="010">北京</option>\
                                    <option value="021">上海</option>\
                                    <option value="0571">杭州</option>\
                                     </select>\
                                </p>\
                             </div>\
                        </li>\
                          <li>\
                            <p class="candidatesPone"><b style="color:red;margin-right: 8px;vertical-align: middle">*</b>执行插件</p> \
                            <div class="dropDownDiv" style="z-index:99996">\
                                <p class="candidatesPTwo">\
                                    <input type="text" readonly="true" style="background: #eee"><span style="text-align: center;color: #fff;">选择</span>\
                                </p>\
                             </div>\
                        </li>\
                        <li>\
                            <p class="candidatesPone"><b style="color:red;margin-right: 8px;vertical-align: middle">*</b>执行方式</p> \
                            <div class="dropDownDiv" style="z-index:99995">\
                                <p class="candidatesPTwo">\
                                    <select name="city" lay-verify="">\
                                        <option value="">请选择一个城市</option>\
                                        <option value="010">北京</option>\
                                        <option value="021">上海</option>\
                                        <option value="0571">杭州</option>\
                                    </select>\
                                </p>\
                             </div>\
                        </li>\
                        <li>\
                            <p class="candidatesPone"><b style="color:red;margin-right: 8px;vertical-align: middle">*</b>触发器描述</p> \
                                <p class="candidatesPTwo" style="border:none;overflow:hidden">\
                                   <textarea></textarea><span style="display:inline-block;margin: 19px 0px 0px 10px;text-align:center;color:#3994f7;border-radius:4px;font-size:14px">清空</span>\
                                </p>\
                        </li>\
                        <li>\
                            <p class="candidatesPone"><b style="color:red;margin-right: 8px;vertical-align: middle">*</b>是否启用</p> \
                            <div class="dropDownDiv">\
                                <p class="candidatesPTwo" style="border:none">\
                                    <label style="font-size:14px"><input type="radio" title="启用"></label>\
                                    <label style="font-size:14px"><input type="radio" title="禁用"></label>\
                                </p>\
                             </div>\
                        </li>\
                    </ul>\
                </div>',
                    area:['600px','500px'],
                    btn:['确定','关闭'],
                    yes:function () {

                    },
                    success:function () {
                        form.render()
                    }
                })

            }
        }
        newtheTrigger.init();


        $('#theTrigger').click(function () {
            layer.open({
                type:0,
                title:'管理触发器',
                content:'<div class="bottomstepstwoss" style="height: 460px">\
            <ul class="candidatesUl" style="display: block;border: none;">\
                <li>\
                     <p class="candidatesPone">管理触发器 <label  class="newtheTrigger">新建触发器</label></p> \
                     <p class="candidatesPTwo" style="border: none;margin-bottom: 20px;">\
                         <table>\
                          <thead>\
                                    <tr>\
                                        <th width="10%">触发节点</th>\
                                        <th width="10%">排序号</th>\
                                        <th width="20%">名称</th>\
                                        <th width="15%">执行插件</th>\
                                        <th width="15%">执行方式</th>\
                                        <th width="20%">触发器描述</th>\
                                        <th width="10%">操作</th>\
                                    </tr>\
                                </thead>\
                                <tbody>\
                                    \
                                </tbody>\
                         </table>\
                     </p>\
                    <p class="candidatesPTwo" style="color: red;font-size: 12px;margin-top: 5px;border: none;">说明：列表中按照 【新建操作】->【接收操作】->【保存操作】->【转交操作】->【委托操作】->【退回操作】 的顺序呈现\
            同时，同一触发节点通过 [排序号] 控制触发顺序</p>\
                </li>\
            </ul>\
            </div>',
                area:['800px','600px'],
                btn:['确定','关闭'],
                yes:function (index) {

                },
                btn2:function () {
                    $('.setUpThe').removeClass('active')
                }
            })
        })


        var canWriteField={//字段权限设置
            obj:{},
            init:function () {
                var me=this;
                $(document).delegate('.canWriteFields','click',function () {
                    me.openAlert()
                })
                $(document).delegate('.bottomsteptwos','click',function () {
                    me.bottomsteptwo();
                })
            },
            openAlert:function () {
                var str='';
                var arr=[
                    {'standard':'督办工作内容及完成标准','name':'111'},
                    {'standard':'责任部门','name':'111'},
                    {'standard':'	完成时间','name':'111'},
                    {'standard':'督办工作完成情况','name':'111'},
                    {'standard':'验证结果','name':'111'},
                ]
                for(var i=0;i<arr.length;i++){
                    str+='<tr>\
                              <td width="35%">'+arr[i].standard+'</td>\
                              <td width="75%">\
                                      <input type="checkbox" title="保密模式" lay-skin="primary">\
                                       <input type="checkbox" title="只读模式" lay-skin="primary">\
                                      <input type="checkbox" title="删除模式" lay-skin="primary">\
                               </td>\
                        </tr>'
                }
                layer.open({
                    type:1,
                    title:'字段权限设置',
                    content:'<div class="bottomstepstwoss layui-form" style="height: 300px">\
            <ul class="candidatesUl" style="display: block;border: none;padding-left: 7%;">\
                <li>\
                 <p class="candidatesPTwo" style="border: none;margin-bottom: 20px;width: 92%;margin-top: 36px;">\
                    <table>\
                                <tbody>'+str+'</tbody>\
                      </table>\
                 </p>\
                </li>\
            </ul></div>',
                    area:['600px','400px'],
                    btn:['确定','关闭'],
                    yes:function () {

                    },
                    success:function () {
                        form.render()
                    }
                })
            },
            bottomsteptwo:function () {
                layer.open({
                    type:1,
                    title:'本步骤可写字段',
                    closeBtn:2,
                    content:'<div class="bottomstepstwo layui-form" style="margin: 10px ;">' +
                    '<input type="checkbox" title="行政主管审批">' +
                    '<input type="checkbox" title="上级主管审批">' +
                    '<div style="margin-top: 15px;"><input type="checkbox" title="全选"></div>'+
                    '</div>' ,
                    area:['400px','300px'],
                    btn:['确定','关闭'],
                    yes:function (index) {

                    },
                    success:function () {
                        form.render();
                    }
                })

            }
        }
        canWriteField.init()

        $('#canWriteField').click(function () {//可写字段
            layer.open({
                type:0,
                title:'编辑可写字段',
                closeBtn:2,
                content:' <form class="layui-form"><div class="bottomstepstwoss " style="height: 460px">\
            <ul class="candidatesUl" style="display: block;border: none;">\
                <li>\
                     <p class="candidatesPone">本步骤可写字段</p> \
                     <div class="candidatesPTwoall" style="margin-bottom: 20px;position:relative">\
                         <ul></ul>\
                         <input type="hidden">\
                         <a href="javascript:;" class="bottomsteptwos" style="position:absolute;top:17px;right:105px;color:#2f8ae3">选择</a>\
                     </div>\
                </li>\
                <li>\
                     <p class="candidatesPone">列表控件模式</p> \
                     <p class="candidatesPTwo" style="border: none;margin-bottom: 20px;">\
                           <table>\
                                <thead>\
                                    <tr>\
                                        <th width="20%">列表名称</th>\
                                        <th width="60%">列表内容</th>\
                                        <th width="20%">字段权限 </th>\
                                    </tr>\
                                </thead>\
                                <tbody>\
                                    <tr>\
                                        <td width="20%">督办内容</td>\
                                        <td width="60%">\
                                            <input type="checkbox" title="修改模式" lay-skin="primary">\
                                            <input type="checkbox" title="添加模式" lay-skin="primary">\
                                           <input type="checkbox" title="删除模式" lay-skin="primary">\
                                        </td>\
                                        <td width="20%"><a class="btnradius canWriteFields" href="javascript:;" >字段权限设置</a></td>\
                                    </tr>\
                                </tbody>\
                           </table>\
                   </p>\
                </li>\
                <li>\
                     <p class="candidatesPone">附件上传控件权限（只针对office文档附件，其他格式不控制）</p> \
                     <p class="candidatesPTwo" style="border: none;margin-bottom: 20px;">\
                           <table>\
                                <thead>\
                                    <tr>\
                                        <th width="30%">附件名称</th>\
                                        <th width="70%">控件权限</th>\
                                    </tr>\
                                </thead>\
                                <tbody>\
                                    <tr>\
                                        <td width="30%">督办内容</td>\
                                        <td width="70%">\
                                            ffdaf\
                                        </td>\
                                    </tr>\
                                </tbody>\
                           </table>\
                   </p>\
                </li>\
                <li>\
                     <p class="candidatesPone">图片上传控件权限</p> \
                     <p class="candidatesPTwo" style="border: none;margin-bottom: 20px;">\
                           <table>\
                                <thead>\
                                    <tr>\
                                        <th width="30%">图片名称</th>\
                                        <th width="70%">图片控件权限</th>\
                                    </tr>\
                                </thead>\
                                <tbody>\
                                    <tr>\
                                        <td width="30%">督办内容</td>\
                                        <td width="70%">\
                                            ffdaf\
                                        </td>\
                                    </tr>\
                                </tbody>\
                           </table>\
                   </p>\
                </li>\
               <li>\
                     <p class="candidatesPone">其他设置项</p> \
                     <div class="candidatesPTwoall" style="margin-bottom: 20px;position:relative">\
                         <ul></ul>\
                         <a href="javascript:;" class="bottomsteptwos" style="position:absolute;top:17px;right:105px;color:#2f8ae3">选择</a>\
                     </div>\
                </li>\
                <li>\
                     <p class="candidatesPone activeall" style="margin-bottom:-15px">公共附件中的Office文档详细权限设置</p> \
                     <div style="margin-top:15px">\
                       <input type="checkbox" title="新建权限">\
                       <input type="checkbox" title="编辑权限">\
                        <input type="checkbox" title="删除权限">\
                       <input type="checkbox" title="下载权限">\
                       <input type="checkbox" title="打印权限">\
                     </div>\
                </li>\
                <li>\
                     <p class="candidatesPone activeall" style="margin-bottom:-15px">是否允许本步骤经办人编辑附件</p> \
                     <div>\
                        <label class="canWriteFie"><input type="radio" title="允许"></label>\
                        <label class="canWriteFie"><input type="radio" title="不允许"></label>\
                     </div>\
                </li>\
                <li>\
                     <p class="candidatesPone activeall" style="margin-bottom:-15px">是否允许本步骤办理人在线创建文档</p> \
                     <div>\
                        <label class="canWriteFie"><input type="radio" title="允许"></label>\
                        <label class="canWriteFie"><input type="radio" title="不允许"></label>\
                     </div>\
                </li>\
               <li>\
                     <p class="candidatesPone activeall" style="margin-bottom:-15px">宏标记附件上传为图片时展示效果</p> \
                     <div>\
                        <label class="canWriteFie"><input type="radio" title="显示图片"></label>\
                        <label class="canWriteFie"><input type="radio" title="显示图标和名称"></label>\
                     </div>\
                </li>\
            </ul>\
            </div></form>',
                area:['800px','600px'],
                btn:['确定','关闭'],
                yes:function (index) {

                },
                btn2:function () {
                    $('.setUpThe').removeClass('active')
                },
                success:function () {
                    form.render()
                }
            })

        })
    });
})
