$(function() {
    var name = $("#name"),
        email = $("#email"),
        password = $("#password"),
        allFields = $( [] ).add(name).add(email).add(password),
        tips = $(".validateTips");

    function updateTips(t) {
        tips.text(t).addClass("ui-state-highlight");
        setTimeout(function() {
            tips.removeClass( "ui-state-highlight", 1500 );
        }, 500 );
    };

    function checkLength( o, n, min, max ) {
        if ( o.val().length > max || o.val().length < min ) {
            o.addClass( "ui-state-error" );
            updateTips( "" + n + " 的长度必须在 " + min + " 和 " + max + " 之间。" );
            return false;
        } else {
            return true;
        }
    };

/*
RegExp：正则表达式对象
1. 正则表达式：定义字符串的组成规则。
    1. 单个字符:[]
        如： [a] [ab] [a-zA-Z0-9_]
        * 特殊符号代表特殊含义的单个字符:
            \d:单个数字字符 [0-9]
            \w:单个单词字符[a-zA-Z0-9_]
    2. 量词符号：
        ?：表示出现0次或1次
        *：表示出现0次或多次
        +：出现1次或多次
        {m,n}:表示 m<= 数量 <= n
            * m如果缺省： {,n}:最多n次
            * n如果缺省：{m,} 最少m次
    3. 开始结束符号
        * ^:开始
        * $:结束
2. 正则对象：
    1. 创建
        1. var reg = new RegExp("正则表达式");
        2. var reg = /正则表达式/;
    2. 方法
        1. test(参数):验证指定的字符串是否符合正则定义的规范

 */
    function checkRegexp( o, regexp, n ) {
        if ( !( regexp.test( o.val() ) ) ) {
            o.addClass( "ui-state-error" );
            updateTips( n );
            return false;
        } else {
            return true;
        }
    };

    $("#dialog-form").dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true,
        buttons: {
            "修改": function() {
                var bValid = true;
                allFields.removeClass( "ui-state-error" );
                bValid = bValid && checkLength( name, "username", 3, 16 );
                bValid = bValid && checkLength( email, "email", 6, 80 );
                bValid = bValid && checkLength( password, "password", 5, 16 );
                bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "用户名必须由 a-z、0-9、下划线组成，且必须以字母开头。" );
                // From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
                bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
                bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "密码字段只允许： a-z 0-9" );

                if (bValid) {
                   updateUser();//ajax更新用户信息
                    $( this ).dialog( "close" );
                }
            },
            "取消": function() {
                $( this ).dialog( "close" );
            }
        },
        close: function() {
            allFields.val( "" ).removeClass( "ui-state-error" );
        }
    });

    $("#create-user").button().click(function() {
            $( "#dialog-form" ).dialog( "open" );
        });
});

function updateUser() {
  $.ajax({
      async : false,
      type : 'post',
      url : '/updateUser',
      data : $('#updateUserform').serialize(),
      success : function(data) {
          alert("修改成功");
      },
      error : function(data) {
          alert("修改失败");
      }
  });
};