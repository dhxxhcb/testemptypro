/**
 * Created by ASUS on 2017/5/24.
 */
var user_id=''



$(function () {
    $('#propertyForm').height($('body').height());
    $('#propertyForm').css('max-height',$('body').height()+2000)

    $('.setUpThe').click(function (event) {
        $(this).next('.candidatesUl').siblings('.candidatesUl').stop().slideUp('slow');
        $(this).next('.candidatesUl').slideToggle("slow");
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
    
    $('.bottomsteps').click(function () {
        layer.open({
            type:1,
            title:'下一步骤',
            content:'<div class="bottomstepstwo">' +
            '<label><input type="checkbox">行政主管审批</label>' +
            '<label><input type="checkbox">上级主管审批</label>' +
            '<label><input type="checkbox">全选</label>' +
            '</div>',
            area:['400px','300px'],
            closeBtn:0,
            btn:['确定','关闭'],
            yes:function (index) {

            }
        })
    })

    $('.theCandidates').on('click',function () {
        user_id = $(this).parent().siblings('input').prop('id');
        var num=$(this).attr('data-num')
        if(num==1) {
            $.popWindow("../common/selectUser");
        }
    })
})