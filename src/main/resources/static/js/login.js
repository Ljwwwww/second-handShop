//手机正则判断qqq
const app = new Vue({
    el: "#app",
    data: {
        phone: ''
    },
    methods: {
        judgePhone() {
            if (!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(this.phone))){
                layer.msg("手机号码有误，请重填")
                return false
            }
            layer.msg("验证码已发送")
        }
    }
})