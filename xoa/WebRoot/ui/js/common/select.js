.M-box3{margin-top:10px;float:right;}
.M-box3 a{margin: 0 3px;width: 29px;height: 29px;line-height: 29px;font-size: 12px;text-decoration: none;}
.M-box3 .active{margin: 0px 3px;width: 29px;height: 29px;line-height: 29px;background: #2b7fe0;font-size: 12px;border: 1px solid #2b7fe0;}
.jump-ipt{margin: 0 3px;width: 29px;height: 29px;line-height: 29px;font-size: 12px;}
.M-box3 a:hover{background: #2b7fe0;}
@charset "UTF-8";
html, body, ul, li, ol, dl, dd, dt, p, h1, h2, h3, h4, h5, h6, form, fieldset, legend, img {
    margin: 0;
    padding: 0; /*清除元素的内外边距*/
}

fieldset, img, input, button {
    border: none;
    padding: 0;
    margin: 0;
    outline-style: none; /*外面环绕线*/
}

ul, ol {
    list-style: none;
}

/*去掉原样式中的小黑点*/
input {
    padding-top: 0;
    padding-bottom: 0;
    font-family: "SimSun", "宋体"; /*字体的自动识别*/
}

select, input {
    vertical-align: middle;
}

/*输入字居中显示*/
select, input, textarea {
    font-size: 12px;
    margin: 0;
}

/**/
textarea {
    resize: none; /*不可以随意拖动*/
}

/*防止拖动*/
img {
    border: 0;
    vertical-align: middle; /*  去掉图片底部默认的3像素空白缝隙*/
}

table {
    border-collapse: collapse; /*合并外连线*/
}

body {
    font: 12px/150% Arial, Verdana, "\5b8b\4f53"; /*unitedCode的写法，宋体的写法  */
    color: #666; /*150%基于当前字体尺寸的百分比行间距*/
    background: #fff;
}