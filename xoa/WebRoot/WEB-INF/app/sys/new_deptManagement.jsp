
<div class="step2" style="display: block;margin-left: 10px;">
    <!-- 中间部分 -->
    <table class="newNews">
        <div class="nav_box clearfix">
            <div class="nav_t1"><img src="../img/newsManages2_1.png"></div>
            <div class="nav_t2" class="news">新建部门/成员单位-当前节点：[北京高速波软件有限公司]</div>
        </div>
        <tbody>
        <tr>
            <td class="td_w blue_text">
                部门排序号:
            </td>
            <td>
                <input class="td_title1" id="" type="text" placeholder=""/>
                <div> 3位数字，用于同一级次部门排序，不能重复</div>

            </td>
        </tr>
        <tr>
            <td class="td_w blue_text">
                部门名称:
            </td>
            <td>
                <input class="td_title1" id="" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="td_w blue_text">
                上级部门:
            </td>
            <td>
                <input class="td_title1" id="" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">部门主管（选填）:</td>
            <td>
                <input class="td_title1  release1" id="query_toId" type="text"/>
                <%-- <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                <div class="release3">添加</div>
                <div class="release4 empty">清空</div>

            </td>
        </tr>
        <tr>
            <td class="blue_text">部门助理（选填）:</td>
            <td>
                <input class="td_title1  release1" id="query_privId" type="text"/>
                <%-- <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                <div class="release3">添加</div>
                <div class="release4 empty" onclick="empty('query_privId')">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">上级主管领导（选填）:</td>
            <td>
                <input class="td_title1  release1" id="query_userId" dataid="" type="text"/>
                <%--  <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                <div class="release3" id="query_adduser">添加</div>
                <div class="release4 empty" onclick="empty('query_userId')">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">上级分管领导（选填）:</td>
            <td>
                <input class="td_title1  release1" id="query_userId" dataid="" type="text"/>
                <%--  <img class="td_title2 release2" id="ip2" src="../img/mg2.png" alt=""/>--%>
                <div class="release3" id="query_adduser">添加</div>
                <div class="release4 empty" onclick="empty('query_userId')">清空</div>
            </td>
        </tr>
        <tr>
            <td class="blue_text">
                电话 :
            </td>
            <td>
                <input class="td_title1 time_coumon" id="" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">
                传真 :
            </td>
            <td>
                <input class="td_title1 time_coumon" id="" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">
                地址 :
            </td>
            <td>
                <input class="td_title1 time_coumon" id="" type="text" placeholder=""/>

            </td>
        </tr>
        <tr>
            <td class="blue_text">
                部门职责 :
            </td>
            <td>
                <textarea name="" cols="60" rows="5"></textarea>

            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div style="border:1px solid #dedede;height:30px;width:50px;">新建</div>
            </td>
        </tr>

        </tbody>
    </table>
</div>