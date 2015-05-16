$(document).ready(function() {  
                $('#bttn1').click(function() {  
                    //$('#dialogTest').dialog('open');  
                    createLoginDialog();  
                });  
            });  
            function createLoginDialog(){  
                var obj = $("<div></div>").attr("title","create one dialog!").attr("id","dialogTest");  
                var username = $("<lable></lable>").text("用户名:");  
                objobj = obj.append(username);  
                var userinput = $("<input type='text' name='username'>");  
                objobj = obj.append(userinput);  
                var br = $("<br>");  
                obj.append(br);  
                var password = $("<lable></lable>").text("密　码:");  
                objobj = obj.append(password);  
                var passinput = $("<input type='password' name='password'>");  
                objobj = obj.append(passinput);  
                obj.addClass('flora').dialog({  
                    width:300,  
                    height:200,  
                    resizable:'disable',  
                    buttons:{  
                        '登陆':function(){  
                            var tmpDialog = $("<div/>")  
                            tmpDialog.html("your username is :"+$(this).find("[name='username']").val())  
                            .html(tmpDialog.html()+"<br> your password is : "+$(this).find("[name='password']").val())  
                            .addClass('flora').dialog({  
                                title:'your input value',  
                                resizable:'disable'  
                            });  
                        },  
                        '取消':function(){  
                            $(this).dialog('close');  
                        }  
                    },  
                    title:'登陆',  
                });  
            }  