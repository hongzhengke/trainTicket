Vue.use(VueRouter);
var ticket = {
  template: `
        <div class="query">
            <div class="title">余票查询</div>
            <div class="search">
                <label for="departure">出发地:</label>
                <select id="departure">
                    <option>广州</option>
                    <option>揭阳</option>
                    <option>汕头</option>
                </select>
                <label for="destination">目的地:</label>
                <select id="destination">
                    <option>揭阳</option>
                    <option>广州</option>
                    <option>汕头</option>
                </select>
                <div class="dateList">
                    <div v-for="(item, index) in dateList" :class="['dateBlock', selectedIndex==index?'selected':'']" @click="select(index)">
                        {{item.month}} - {{item.date}}
                    </div>
                </div>
            </div>
        </div>
    `,
  data() {
    return {
      dateList: [],
      selectedIndex: 0,
    };
  },
  methods: {
    select(index) {
      this.selectedIndex = index;
    },
  },
  created() {
    var date = new Date();
    var inc = 1000 * 60 * 60 * 24;
    for (var i = 0; i < 15; i++) {
      this.dateList.push({
        year: date.getYear(),
        month: date.getMonth() + 1,
        date: date.getDate(),
      });
      date.setTime(date.getTime() + inc);
    }
  },
};
var order = {
  template: `
        <div class="order">
            <div class="title">我的订单</div>

            <div>{{$route.params.id}}</div>
        </div>
    `,
};
var manage = {
  template: `
        <h1>管理班次 </h1>
    `,
};
var router = new VueRouter({
  routes: [
    { path: '/ticket', component: ticket, meta: { allow_identity: ['vistor', 'user', 'manager'] } },
    { path: '/order/:id', component: order, meta: { allow_identity: ['user'] } },
    { path: '/manage', component: manage, meta: { allow_identity: ['manager'] } },
    { path: '/', redirect: '/ticket' },
  ],
});
var vm = new Vue({
  el: 'div.wrapper',
  data: {
    info: { name: '个人信息' },
    identity: 'visitor',
    time: stringifyDate('Y-M-D h:m'),
  },
  computed: {},
  methods: {
    logout() {
      getAjax('get', '/trainTicket/logout.action').then(
        responseText => {
          var data = JSON.parse(responseText);
          if (data.message !== 'SUCCESS') {
            console.log(data);
          }
          location.href = 'login.html';
        },
        () => {
          location.href = 'login.html';
        }
      );
    },
    toggle(event) {
      var more = event.currentTarget.querySelector('.more');
      var str = document.defaultView.getComputedStyle(more, null).transform;
      var matches = str.match(/matrix\(.*?,.*?,.*?,.*?,.*?,(.*?)\)/);
      if (matches && matches[1]) {
        var number = parseFloat(matches[1]);
        if (number > -1e-3) {
          more.style.transform = 'translateY(-100%)';
        } else {
          more.style.transform = 'translateY(0px)';
        }
      }
    },
    mouseenter(event) {
      var more = event.currentTarget.querySelector('.more');
      more.style.transform = '';
    },
    mouseleave(event) {
      var more = event.currentTarget.querySelector('.more');
      more.style.transform = '';
    },
  },
  created() {
    setInterval(() => (vm.time = stringifyDate('Y-M-D h:m')), 60000);
    getAjax('get', '/trainTicket/getUser.action').then(responseText => {
      var data = JSON.parse(responseText);
      if (data.message === 'SUCCESS') {
        vm.info = data.data;
        vm.identity = data.data.authority === 0 ? 'manager' : 'user';
      }
    });
  },
  router,
});
function stringifyDate(format, date = new Date()) {
  var time = {
    Y: date.getFullYear(),
    M: (date.getMonth() + 1).toString().padStart(2, '0'),
    D: date
      .getDate()
      .toString()
      .padStart(2, '0'),
    h: date
      .getHours()
      .toString()
      .padStart(2, '0'),
    m: date
      .getMinutes()
      .toString()
      .padStart(2, '0'),
  };
  return format.replace(/[YMDhms]/g, char => time[char]);
}
router.beforeEach((to, from, next) => {
  console.log(to);
  if (to.meta.allow_identity.indexOf(vm.identity) === -1) {
    next('/ticket');
  } else {
    next();
  }
});
