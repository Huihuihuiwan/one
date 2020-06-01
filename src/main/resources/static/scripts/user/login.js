$(document).ready(function () {
    $("#form1").validate({
        rules:{  //校验规则
            userName:{
                required: true,
                minlength: 2,
                remote:{
                    url: "isUserExist",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式
                    data: {                     //要传递的数据
                        userName: function() {
                            return $("#userName").val();
                        }
                    }
                }
            },
            email:{
                required:true
            },
            password:{
                required: true,
                minlength: 5
            }
        } ,
        messages:{ //提示
            userName:{
                required: "请输入用户名",
                minlength: "用户名必需由两个字母组成",
                remote:"用户不存在"
            },
            email:{
                required:"请输入邮箱地址"
            },
            password:{
                required: "请输入密码",
                minlength: "密码长度不能小于 5 个字母"
            }
        }
    });
});

/*
* 指定为json类型，则会把获取到的数据作为一个JavaScript对象来解析，并且把构建好的对象作为结果返回。
* 默认情况下，Ajax请求使用GET方法。如果要使用POST方法，可以设定type参数值。
* 这个选项也会影响data选项中的内容如何发送到服务器。
*
* Ajax的第一个字母是asynchronous的开头字母，这意味着所有的操作都是并行的，完成的顺序没有前后关系。
* $.ajax()的async参数总是设置成true，这标志着在请求开始后，其他代码依然能够执行。
* (默认: true) 默认设置下，所有请求均为异步请求。
* 如果需要发送同步请求，请将此选项设置为 false。
* 注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
* 强烈不建议把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
*
* url:一个用来包含发送请求的URL字符串。
*
* data（Object,String） 发送到服务器的数据。将自动转换为请求字符串格式。
* GET 请求中将附加在URL后。
* 查看 processData 选项说明以禁止此自动转换。
* 必须为 Key/Value 格式。如果为数组，jQuery 将自动为不同值对应同一个名称。
* 如 {foo:["bar1", "bar2"]} 转换为 "&foo=bar1&foo=bar2"。
*
* dataType（String）预期服务器返回的数据类型。
* 如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断，比如XMLMIME类型就被识别为XML。
* 在1.4中，JSON就会生成一个JavaScript对象，而script则会执行这个脚本。
* 随后服务器端返回的数据会根据这个值解析后，传递给回调函数。
*
* 可用值:
* "xml": 返回 XML 文档，可用 jQuery 处理。
* "html": 返回纯文本 HTML 信息；包含的script标签会在插入dom时执行。
* "script": 返回纯文本 JavaScript 代码。不会自动缓存结果。
* 除非设置了"cache"参数。'''注意：'''在远程请求时(不在同一个域下)，所有POST请求都将转为GET请求。
* (因为将使用DOM的script标签来加载)
* "json": 返回 JSON 数据 。
* "jsonp": JSONP 格式。使用 JSONP 形式调用函数时，
* 如 "myurl?callback=?" jQuery 将自动替换 ? 为正确的函数名，以执行回调函数。
* "text": 返回纯文本字符串
*
* success(data, textStatus, jqXHR)    Function,Array
* 请求成功后的回调函数。
* 参数：
* 由服务器返回，并根据dataType参数进行处理后的数据；描述状态的字符串。
* 还有 jqXHR（在jQuery 1.4.x的中，XMLHttpRequest）对象。
* 在jQuery 1.5， 成功设置可以接受一个函数数组。每个函数将被依次调用。
* function (data, textStatus) {
    // data 可能是 xmlDoc, jsonObj, html, text, 等等...
    this; // 调用本次AJAX请求时传递的options参数
}

* */
function findAllDepts() {
    $.ajax({
        async : true,
        type : "post",
        url : "/getDepts",
        dataType : "json",
        /*
        * •success 当请求之后调用。传入返回后的数据，以及包含成功代码的字符串。
        * */
        success: function (data) {
          console.log(data);
          for(var i = 0; i < data.length; i++){
              console.log(data[i].deptId + " " + data[i].deptName);
          }
          /*
          * remove()：可以删除匹配的元素
          * empty():可以删除匹配的元素里面的子节点（孩子）
          * html(“”):可以删除匹配的元素里面的子节点（孩子）
          *
          * 内部添加append()
          * */
            $("select[name = 'depertmentId']").empty();
            $("select[name = 'depertmentId']").append('<option value="">——请选择——</option>');
            for(var i = 0; i < data.length; i++){
                var html ='<option value="'+ data[i].deptId+'">';
                html += data[i].deptName + '</option>';
                $("select[name='departmentId']").append(html);
            }
        },
        /*
        * error 在请求出错时调用。传入XMLHttpRequest对象，描述错误类型的字符串以及一个异常对象
        * */
        error : function (data) {
            alert(data.result);
        }
    });
};

$(document).ready(function () {
   findAllDepts();
});