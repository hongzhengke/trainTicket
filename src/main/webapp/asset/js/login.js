var vm = new Vue({
    el: ".form",
    data: {
        tel: "",
        password: "",
        action: "login",
        name: "",
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
                    let ajax = getAjax("get", "/login.action", {tel,password}, );
                    ajax.then(
                        (responseText) => {
                            displayMessage("登录成功！" + responseText);
                        },
                        (responseText) =>{
                            displayMessage("登录失败！" + responseText);
                        },
                    )
                }
            }else if(vm.action === "register"){
                let tel = vm.tel.trim();
                let userName = vm.userName.trim();
                let password = vm.password.trim();
                let ajax = getAjax("get", "/login.action", {tel,name: name,password}, );
                ajax.then(
                    (responseText) => {
                        displayMessage("注册成功！" + responseText);
                        vm.action = "signin";
                    },
                    (responseText) =>{
                        displayMessage("注册失败！" + responseText);
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
