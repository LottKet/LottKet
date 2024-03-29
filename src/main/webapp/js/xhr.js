// XMLHttpRequest 객체의 생성
var xhr = new XMLHttpRequest();
// 비동기 방식으로 Request를 오픈한다
xhr.open('GET', 'https://reco.coupang.com/recommend/widget?productIds=261192458&itemIds=&vendorItemIds=&widgetId=WIDGET_PC_SDP_001&maxCount=15&minCount=5&callback=jQuery111103938603861384664_1657949399239&_=1657949399245');
// Request를 전송한다
xhr.send();

// load 이벤트는 서버 응답이 완료된 경우에 발생한다.
xhr.onload = function (e) {
  // status는 response 상태 코드를 반환 : 200 => 정상 응답
  if(xhr.status === 200) {
    console.log(xhr.responseText);
  } else {
    console.log('Error!');
  }
};