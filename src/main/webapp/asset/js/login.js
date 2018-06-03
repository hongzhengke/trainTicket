var vm = new Vue({
    el: ".form",
    data: {
        tel: "",
        password: "",
        name: "",
        action: "login",
        login_class:{
            tab_block: true,
            chosen: true,
        },
        signin_class:{
            tab_block: true,
            chosen: false,
        },
    },
    methods:{
        switchTab(event){
            vm.action = event.target.getAttribute("name");
        },
        submit(event){
            if(vm.action === "login"){
                let tel = vm.tel.trim();
                let password = vm.password.trim();
                if(tel === ""){
                    displayMessage("电话号码不能为空");
                }else if(password === ""){
                    displayMessage("密码不能为空");
                }else{
                    let ajax = getAjax("get", "/trainTicket/login.action", {tel,password}, );
                    displayLoading();
                    ajax.then(
                        (responseText) => {
                            cancelLoading();
                            var data = JSON.parse(responseText);
                            if(data.message === "SUCCESS"){
                                location.href = "main.html";
                            }else{
                                displayMessage("登录失败！");
                            }
                        },
                        (responseText) =>{
                            cancelLoading();
                            displayMessage("登录失败！");
                        },
                    )
                }
            }else if(vm.action === "signin"){
                let tel = vm.tel.trim();
                let name = vm.name.trim();
                let password = vm.password.trim();
                let ajax = getAjax("get", "/trainTicket/register.action", {tel, name, password}, );
                displayLoading();
                ajax.then(
                    (responseText) => {
                        cancelLoading();
                        var data = JSON.parse(responseText);
                        if(data.message === "SUCCESS"){
                            displayMessage("注册成功！");
                            vm.action = "login";
                        }else{
                            displayMessage("注册失败！");
                        }
                    },
                    (responseText) =>{
                        cancelLoading();
                        console.log(responseText);
                        displayMessage("注册失败！");
                    },
                )
            }
        },
    },
    computed:{
        compute_action(){
            return this.action === "login" ? "登录" : "注册";
        },
        compute_show(){
            return this.action === "login" ? false : true;
        }
    },
    watch:{
        action(val){
            if(val === "login"){
                vm.login_class.chosen = true;
                vm.signin_class.chosen = false;
            }else if(val === "signin"){
                vm.login_class.chosen = false;
                vm.signin_class.chosen = true;
            }
        }
    }
});
