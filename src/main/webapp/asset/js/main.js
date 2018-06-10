Vue.use(VueRouter);
var ticket = {
  template: `
        <div class="query">
            <div class="title">余票查询</div>
            <div class="search">
                <label for="departure">出发地:</label>
                <select id="departure" v-model="departure">
                    <option>广州</option>
                    <option>揭阳</option>
                    <option>汕头</option>
                </select>
                <label for="destination">目的地:</label>
                <select id="destination" v-model="destination">
                    <option>揭阳</option>
                    <option>汕头</option>
                    <option>台山</option>
                    <option>普宁</option>
                    <option>江门</option>
                    <option>清远</option>
                    <option>河源</option>
                    <option>东莞</option>
                    <option>惠州</option>
                    <option>佛山</option>
                    <option>韶关</option>
                    <option>潮汕</option>
                    <option>深圳</option>
                    <option>珠海</option>
                    <option>湛江</option>
                </select>
                <label for="departureTime">发车时间</label>
                <select id="departureTime" v-model="departureTime">
                    <option value="00:00:00">00:00-24:00</option>
                    <option value="06:00:00">6:00-24:00</option>
                    <option value="12:00:00">12:00-24:00</option>
                    <option value="18:00:00">18:00-24:00</option>
                </select>
                <div class="dateList">
                    <div v-for="(item, index) in dateList" :class="['dateBlock', selectedIndex==index?'selected':'']" @click="select(index)">
                        {{item.month}} - {{item.date}}
                    </div>
                </div>
            </div>
            <div class="table" v-if="data.length > 0">
              <div class="table-head">
                <div v-for="(val, key) in data[0]" :key=key  v-if="key!='ID'" class="th td">{{key}}</div>
                <div class="th td">订票按钮</div>
              </div>
              <div v-for="item in data" :key="item.ID"  class="table-content">
                <div v-for="(val, key) in item" :key=key v-if="key!='ID'" class="td">{{val}}</div>
                <div class="td">
                  <div class="button" @click="buy(item.ID)">购票</div>
                </div>
              </div>
            </div>
        </div>
    `,
  data() {
    return {
      dateList: [],
      selectedIndex: 0,
      departure: '广州',
      destination: '揭阳',
      departureDate: '',
      departureTime: '00:00:00',
      data: [],
      dict: {
        departureDate: '出发日期',
        departureTime: '出发时间',
        departurePlace: '出发地',
        destinationPlace: '目的地',
        code: '编号',
        duration: '时长',
        ticketAmount: '剩余票数',
        carriageAmount: '车厢数',
      },
    };
  },
  methods: {
    select(index) {
      this.selectedIndex = index;
      this.departureDate = this.getDepartureDate();
    },
    getDepartureDate() {
      var selectedDate = this.dateList[this.selectedIndex];
      return `${selectedDate.year}-${selectedDate.month}-${selectedDate.date} 00:00:00`;
    },
    getData() {
      var query = {
        'trainInfo.departurePlace': this.departure,
        'trainInfo.destinationPlace': this.destination,
        'ticketInfo.departureDate': this.getDepartureDate(),
        'trainInfo.departureTime': `0000-00-00 ${this.departureTime}`,
      };
      displayLoading();
      getAjax('get', '/trainTicket/queryTicket.action', query).then(
        responseText => {
          var data = JSON.parse(responseText);
          if (data.message === 'SUCCESS') {
            if (data.data.length <= 0) {
              alert('搜索结果为空！');
              this.data = [];
            } else {
              var temp = [];
              var arr = data.data;
              arr.forEach(ele => {
                var object = {};
                for (var key in this.dict) {
                  if (ele.ticketInfo[key] !== undefined) {
                    object[this.dict[key]] = ele.ticketInfo[key];
                  } else if (ele.trainInfo[key] !== undefined) {
                    object[this.dict[key]] = ele.trainInfo[key];
                  }
                }

                object['出发日期'] = stringifyDate('Y-M-D', new Date(object['出发日期']));
                object['出发时间'] = stringifyDate('h:m', new Date(object['出发时间']));
                object['时长'] =
                  parseInt(object['时长'] / 3600) + '小时' + parseInt((object['时长'] / 60) % 60) + '分钟';
                object.ID = ele.ticketInfo.id;
                temp.push(object);
              });
              this.data = temp;
              console.log(this.data);
            }
          } else {
            alert('加载失败');
          }
          cancelLoading();
        },
        () => {
          cancelLoading();
        }
      );
    },
    buy(id) {
      displayLoading();
      getAjax('get', '/trainTicket/buyTicket.action', { 'ticketInfo.id': id }).then(
        responseText => {
          var data = JSON.parse(responseText).data;
          alert(`购票成功! 您的车票座位在${data.carriageNumber}号车厢${data.seatNumber}号座位`);
          cancelLoading();
          this.getData();
        },
        () => {
          alert('购票失败!');
          cancelLoading();
        }
      );
    },
  },
  created() {
    var date = new Date();
    var inc = 1000 * 60 * 60 * 24;
    for (var i = 0; i < 10; i++) {
      this.dateList.push({
        year: date.getFullYear(),
        month: date.getMonth() + 1,
        date: date.getDate(),
      });
      date.setTime(date.getTime() + inc);
    }
    this.departureDate = this.getDepartureDate();
  },
  watch: {
    loading() {
      this.getData();
    },
  },
  computed: {
    loading() {
      console.log('加载中');
      return this.departure + this.destination + this.departureDate + this.departureTime;
    },
  },
};
var order = {
  template: `
        <div class="order">
            <div class="title">我的订单</div>
            <div class="table" v-if="data.length > 0">
              <div class="table-head">
                <div v-for="(val, key) in data[0]" :key=key  v-if="key!='ID'&&key!='订单号'" class="th td">{{key}}</div>
                <div class="th td">订票按钮</div>
              </div>
              <div v-for="item in data" :key="item.ID"  class="table-content">
                <div v-for="(val, key) in item" :key=key v-if="key!='ID'&&key!='订单号'" class="td">{{val}}</div>
                <div class="td">
                  <div class="button" @click="refund(item.ID,item['订单号'])">退票</div>
                </div>
              </div>
            </div>
        </div>
    `,
  data() {
    return {
      data: [],
      dict: {
        departureDate: '出发日期',
        departureTime: '出发时间',
        departurePlace: '出发地',
        destinationPlace: '目的地',
        code: '编号',
        duration: '时长',
        orderTime: '订票时间',
        carriageNumber: '车厢号',
        seatNumber: '座位号',
      },
    };
  },
  created() {
    this.getData();
  },
  methods: {
    getData() {
      displayLoading();
      getAjax('get', '/trainTicket/queryCurrentOrder.action').then(
        responseText => {
          var data = JSON.parse(responseText);

          if (data.data.length <= 0) {
            alert('订单结果为空！');
            this.data = [];
          } else {
            var temp = [];
            var arr = data.data;
            arr.forEach(ele => {
              var object = {};
              for (var key in this.dict) {
                if (ele.ticketInfo[key] !== undefined) {
                  object[this.dict[key]] = ele.ticketInfo[key];
                } else if (ele.trainInfo[key] !== undefined) {
                  object[this.dict[key]] = ele.trainInfo[key];
                } else if (ele.orderInfo[key] !== undefined) {
                  object[this.dict[key]] = ele.orderInfo[key];
                }
              }
              object['出发日期'] = stringifyDate('Y-M-D', new Date(object['出发日期']));
              object['出发时间'] = stringifyDate('h:m', new Date(object['出发时间']));
              object['订票时间'] = stringifyDate('M-D h:m', new Date(object['订票时间']));
              object['时长'] = parseInt(object['时长'] / 3600) + '小时' + parseInt((object['时长'] / 60) % 60) + '分钟';
              object.ID = ele.ticketInfo.id;
              object['订单号'] = ele.orderInfo.id;
              temp.push(object);
            });
            this.data = temp;
          }
          cancelLoading();
        },
        () => {
          alert('查询失败!');
          cancelLoading();
        }
      );
    },
    refund(id, orderInfoId) {
      displayLoading();
      getAjax('get', '/trainTicket/refundTicket.action', {
        'ticketInfo.id': id,
        'orderInfo.id': orderInfoId,
      }).then(
        responseText => {
          alert(`退票成功! `);
          cancelLoading();
          this.getData();
        },
        () => {
          alert('退票失败!');
          cancelLoading();
        }
      );
    },
  },
};
var manage = {
  template: `
      <div class="manage">
        <div class="title">管理班次</div>
          <div class="table" v-if="data.length > 0">
            <div class="table-head">
              <div v-for="(val, key) in data[0]" :key=key  v-if="key!='id'" class="th td">{{dict[key]}}</div>
              <div class="th td">操作</div>
            </div>
            <div v-for="(item, index) in data" :key="item.id"  class="table-content">
              <div v-for="(val, key) in item" :key=key v-if="key!='id'" class="td" @click="edit(item.id, key, $event)">
                <span v-show="item.id !== editor.row || key !== editor.key">{{val}}</span>
                <input v-show="item.id === editor.row && key === editor.key" v-model.lazy="item[key]" @blur="update(index)" />
              </div>
              <div class="td">
                <div class="button" @click="remove(item.id)">删除</div>
              </div>
            </div>
            <div class="table-content">
              <div v-for="(val, key) in newItem" :key=key  class="td newTd" >
                <input v-model="newItem[key]" :placeholder="newText[key]"/>
              </div>
              <div class="td">
                <div class="addButton button" @click="add()">新增</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    `,
  data() {
    return {
      data: [],
      dict: {
        departureTime: '出发时间',
        departurePlace: '出发地',
        destinationPlace: '目的地',
        code: '编号',
        duration: '时长',
        carriageAmount: '车厢数',
        seatAmount: '座位数',
        id: 'ID',
      },
      editor: {
        row: -1,
        key: '',
      },
      newText: {
        code: '编号',
        departurePlace: '出发地',
        destinationPlace: '目的地',
        duration: '时长',
        carriageAmount: '车厢数',
        seatAmount: '座位数',
        departureTime: '出发时间',
      },
      newItem: {
        code: 'G***',
        departurePlace: '广州',
        destinationPlace: '揭阳',
        duration: '3小时0分钟',
        carriageAmount: '3',
        seatAmount: '50',
        departureTime: '8:00',
      },
    };
  },
  created() {
    this.getData();
  },
  methods: {
    getData() {
      displayLoading();
      getAjax('get', '/trainTicket/queryForAllTrainInfo.action').then(
        responseText => {
          var data = JSON.parse(responseText);
          if (data.data.length <= 0) {
            alert('车次结果为空！');
            this.data = [];
          } else {
            var arr = data.data;
            arr.forEach(ele => {
              ele['departureTime'] = stringifyDate('h:m', new Date(ele['departureTime']));
              ele['duration'] =
                parseInt(ele['duration'] / 3600) + '小时' + parseInt((ele['duration'] / 60) % 60) + '分钟';
            });
            this.data = arr;
          }
          cancelLoading();
        },
        () => {
          alert('查询失败!');
          cancelLoading();
        }
      );
    },
    update(index) {
      displayLoading();
      getAjax('get', '/trainTicket/updateTrainInfo.action', this.process(this.data[index])).then(
        responseText => {
          alert('修改信息成功!');
          cancelLoading();
          this.editor.row = -1;
        },
        () => {
          alert('修改信息失败!');
          this.editor.row = -1;
          cancelLoading();
        }
      );
    },
    process(data) {
      var match = data.duration.toString().match(/(\d*)小时(\d*)分钟/);
      var duration = (match[1] * 60 + parseInt(match[2])) * 60;
      var departureTime = `0000-00-00 ${data.departureTime}:00`;
      var object = Object.assign({}, data, {
        duration,
        departureTime,
      });
      return object;
    },
    add() {
      displayLoading();
      getAjax('get', '/trainTicket/addTrainInfo.action', this.process(this.newItem)).then(
        responseText => {
          alert('新增班次成功!');
          this.getData();
          cancelLoading();
        },
        () => {
          alert('新增班次失败!');
          cancelLoading();
        }
      );
    },
    remove(id) {
      displayLoading();
      getAjax('get', '/trainTicket/deleteTrainInfo.action', { trainInfoId: id }).then(
        responseText => {
          alert('删除班次成功!');
          this.getData();
          cancelLoading();
        },
        () => {
          alert('删除班次失败!');
          cancelLoading();
        }
      );
    },
    edit(row, key, event) {
      this.editor.row = row;
      this.editor.key = key;
      var input = event.currentTarget.querySelector('input');
      console.log(input);
      setTimeout(() => input.focus(), 0);
    },
  },
  watch: {
    data: {
      handler() {},
      deep: true,
    },
  },
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
