/**
 * Created by ASUS on 2017/5/24.
 */
var user_id=''
var form,layer


$(function () {
    $('#propertyForm').height($('body').height()-65);
    $('#propertyForm').css('max-height',$('body').height()+2000)
    $('#propertyForm').css('right',-$('#propertyForm').width())
    $('.btnstorage').css('right',-$('.btnstorage').width())

    $(document).delegate('#flowDesignTable .GooFlow_work table','click',function () {
        $('#propertyForm').css('right','0px')
        $('.btnstorage').css('right','0px')
    })

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
        console.log(form)
        $('.bottomsteps').click(function () {
        layer.open({
            type:1,
            title:'下一步骤',
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
    })
        $('#conditions').click(function () {
            layer.open({
                type:1,
                title:'条件生成器',
                content:'<div class="bottomstepstwoss layui-form">\
            <ul class="candidatesUl" style="display: block;border: none;">\
                <li>\
                   <p class="candidatesPone">字段</p> \
                    <div class="dropDownDiv">\
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
                   <p class="candidatesPone">条件</p> \
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
                   <p class="candidatesPone"><input type="checkbox" title="类型判断"/></p> \
                        <p class="candidatesPTwo">\
                            <input type="text"><span style="text-align: center;color: #fff;">值</span>\
                        </p>\
                        <div class="dropDownDiv" style="display: none">\
                        <p class="candidatesPTwo">\
                            <input type="text" readonly="true"><span style="text-align: center;color: #fff;">类型</span><input type="hidden">\
                        </p>\
                        <ol class="dropDown">\
                            <li>\
                                <span></span>\
                                <input type="hidden" value="0">\
                            </li>\
                        </ol>\
                    </div>\
                </li>\
                <li class="btnzhuanru">\
                    <a href="javascript:;" style="margin: 0 20px 0 -52px;">添加转入条件</a><a href="javascript:;">添加转出条件</a>\
                </li>\
                <li>\
                   <p class="candidatesPone">转入条件列表</p> \
                   <p class="candidatesPTwo" style="border: none;margin-bottom: 20px;">\
                           <table>\
                                <thead>\
                                    <tr>\
                                        <th width="20%">编号</th>\
                                        <th width="60%">条件描述</th>\
                                        <th width="20%">操作</th>\
                                    </tr>\
                                </thead>\
                                <tbody>\
                                    \
                                </tbody>\
                           </table>\
                   </p>\
                   <p class="candidatesPone">转入条件公式(条件与逻辑运算符之间需空格，如[1] AND [2])</p> \
                    <p class="candidatesPTwo">\
                            <input type="text">\
                     </p>\
                      <p class="candidatesPone">不符合条件公式时，给用户的文字描述：</p> \
                    <p class="candidatesPTwo">\
                            <input type="text">\
                            <p style="color: red;font-size: 12px;margin-top: 5px;">合理设定转入条件，可形成流程的条件分支，但数据满足转入条件，才可转入本步骤</p>\
                     </p>\
                </li>\
                <li style="margin-top: 20px;">\
                     <p class="candidatesPone">转出条件列表</p> \
                     <p class="candidatesPTwo" style="border: none;margin-bottom: 20px;">\
                         <table>\
                          <thead>\
                                    <tr>\
                                        <th width="20%">编号</th>\
                                        <th width="60%">条件描述</th>\
                                        <th width="20%">操作</th>\
                                    </tr>\
                                </thead>\
                                <tbody>\
                                    \
                                </tbody>\
                         </table>\
                     </p>\
                      <p class="candidatesPone">转入条件公式(条件与逻辑运算符之间需空格，如[1] AND [2])</p> \
                    <p class="candidatesPTwo">\
                            <input type="text">\
                     </p>\
                      <p class="candidatesPone">不符合条件公式时，给用户的文字描述：</p> \
                    <p class="candidatesPTwo">\
                            <input type="text">\
                     </p>\
                </li>\
            </ul>\
            </div>',
                area:['800px','600px'],
                btn:['确定','关闭'],
                yes:function (index) {

                },
                btn2:function () {
                    $('.setUpThe').removeClass('active')
                },
                success:function () {
                    form.render();
                }
            })
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
                            <p class="candidatesPone"><b style="color:red;margin-right: 8px;vertical-align: middle">*</b>排序号</p> \
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
                     <div>\
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
