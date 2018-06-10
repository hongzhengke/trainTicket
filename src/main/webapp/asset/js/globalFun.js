function getAjax(method, path, requestParams, requestHeader) {
  return new Promise(function(resolve, reject) {
    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function() {
      if (ajax.readyState === 4) {
        if ((ajax.status >= 200 && ajax.status < 300) || ajax.status === 304) {
          resolve(this.responseText);
        } else {
          reject(this.responseText);
        }
      }
    };
    var postData = null;
    if (method === 'get') {
      let data = '';
      for (var key in requestParams) {
        if (data === '') {
          data += key + '=' + encodeURIComponent(requestParams[key]);
        } else {
          data += '&' + key + '=' + encodeURIComponent(requestParams[key]);
        }
      }
      path += '?' + data;
    } else if (method === 'post') {
      let data = '';
      for (var key in requestParams) {
        if (data === '') {
          data += key + '=' + requestParams[key];
        } else {
          data += '&' + key + '=' + requestParams[key];
        }
      }
      postData = data;
    }
    ajax.open(method, path);
    for (var key in requestHeader) {
      ajax.setRequestHeader(key, requestHeader[key]);
    } //必须在open和send之间调用!
    ajax.send(postData);
  });
}
function displayMessage(message) {
  alert(message);
}
function displayLoading() {
  let loading = document.querySelector('.loading');
  loading.style.visibility = 'visible';
}
function cancelLoading() {
  let loading = document.querySelector('.loading');
  loading.style.visibility = 'hidden';
}
